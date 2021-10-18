package com.example.SpringDataJpaCourse.serializer;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import src.main.proto.Laptop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Serializer {
    public void writeBinaryFile(Laptop laptop,String fileName) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        laptop.writeTo(outputStream);
        outputStream.close();
    }
    public Laptop readFromBinaryFile(String fineName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fineName);
        Laptop laptop = Laptop.parseFrom(inputStream);
        inputStream.close();
        return laptop;
    }
    public void writeJsonFile(Laptop laptop,String fileName) throws IOException {
        JsonFormat.Printer printer = JsonFormat.printer().
                includingDefaultValueFields().preservingProtoFieldNames();
        String jsonString = printer.print(laptop);

        FileOutputStream outputStream  = new FileOutputStream(fileName);
        outputStream.write(jsonString.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }
    public static void main(String[]  args) throws IOException {
        Serializer serializer  = new Serializer();
        Laptop laptop= serializer.readFromBinaryFile("laptop.bin");
        serializer.writeJsonFile(laptop,"laptop.json");
    }
}
