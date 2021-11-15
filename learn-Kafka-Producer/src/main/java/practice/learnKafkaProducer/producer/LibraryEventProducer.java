package practice.learnKafkaProducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import practice.learnKafkaProducer.domain.LibraryEvent;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class LibraryEventProducer {
    @Autowired
    KafkaTemplate<Integer,String > kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;

    String topic = "library-event";

    public void sendLibraryEvent(LibraryEvent libraryEvent)
            throws JsonProcessingException {

        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);

        ListenableFuture<SendResult<Integer,String>> listenableFuture = kafkaTemplate.sendDefault(key,value);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key,value,ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key,value,result);
            }
        });
    }
    public void sendLibraryEvent_approach2(LibraryEvent libraryEvent)
            throws JsonProcessingException {

        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);
        
        ProducerRecord<Integer,String > producerRecord =  buildProducerRecord(key,value,topic);
        
        
       // ListenableFuture<SendResult<Integer,String>> listenableFuture = kafkaTemplate.send(topic,key,value);

         ListenableFuture<SendResult<Integer,String>> listenableFuture = kafkaTemplate.send(producerRecord);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key,value,ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key,value,result);
            }
        });
    }

    private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {
        List<Header> recordHeaders = List.of(new RecordHeader("event source","scanner".getBytes()),
                new RecordHeader("aaaa","bbbb".getBytes()));
        return new ProducerRecord<>(topic,null,key,value,recordHeaders);
    }


    private void handleFailure(Integer key, String value, Throwable ex) {
        log.error("Error sending the message and the exception is : {}",ex.getMessage());
        try {
            throw ex;
        } catch (Throwable e) {
            log.error("Error on failure: {}",e.getMessage());
        }
    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        log.info("Message sent successfully for the key: {} and the value is: {} and partition is: {}"
                ,key,value,result.getRecordMetadata().partition());
    }

    public SendResult<Integer, String> libraryEvent_synchronous(LibraryEvent libraryEvent)
            throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {

        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);

        SendResult<Integer,String> stringSendResult = null;

        try {

          stringSendResult =   kafkaTemplate.sendDefault(key,value).get(1, TimeUnit.SECONDS);

        } catch (InterruptedException | ExecutionException e) {

            log.error("InterruptedException / ExecutionException in sending the message and the exception is : {}"
                    ,e.getMessage());
            throw e;

        } catch (Exception e) {
            log.error(" Exception in sending the message and the exception is : {}"
                    ,e.getMessage());
            throw e;
        }

        //get method will make it wait until the future is resolved to success or failure
        return stringSendResult;


    }
}
