package com.github.protobuf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import example.simple.Simple.SimpleMessage;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello World !");

        // creates a builder
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        // simple fields
        builder.setId(11)
                .setName("Using Builder")
                .setIsSimple(true);

        // repeated fields
        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4,5,6));

        // clears list
        //builder.clearSampleList();

        // Adding value 42 at index 3
        //builder.setSampleList(3, 42);

        System.out.println(builder.toString());

        //Now to get the message and fetch values
        SimpleMessage message = builder.build();
        message.getId();
        message.getName();
        message.getIsSimple();

        // write the proto buf binary to file
        try {
            FileOutputStream outputStream = new FileOutputStream("simple.message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        // To send the saved binary to network
        // Send as byte array
        byte[] bytes = message.toByteArray();

        // TO read from save binary file
        try {
            FileInputStream inputStream = new FileInputStream("simple.message.bin");
            SimpleMessage messageFrommFile = SimpleMessage.parseFrom(inputStream);
            System.out.println("Reading from file");
            System.out.println(messageFrommFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
