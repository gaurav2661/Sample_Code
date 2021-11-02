package com.example.SpringDataJpaCourse.serializer;

import Proto.sample.Generator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.boot.test.context.SpringBootTest;
import src.main.proto.Laptop;
import src.main.proto.LaptopMessage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class SerializerTest {

    @Test
    void writeBinaryFile() throws IOException {
        String binaryFile = "laptop.bin";
        LaptopMessage.Laptop laptop = new Generator().newLaptop();

        Serializer serializer =new Serializer();
        serializer.writeBinaryFile(laptop,binaryFile);

        LaptopMessage.Laptop laptop1 = serializer.readFromBinaryFile(binaryFile);

        assertEquals(laptop,laptop1);
    }
}