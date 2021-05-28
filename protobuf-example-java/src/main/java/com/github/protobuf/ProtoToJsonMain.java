package com.github.protobuf;

import java.util.Arrays;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

public class ProtoToJsonMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {

        // creates a builder
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        // simple fields
        builder.setId(11)
                .setName("Using Builder")
                .setIsSimple(true);

        // repeated fields
        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4,5,6));

        // proto to JSON
        String jsonString = JsonFormat.printer()
                .includingDefaultValueFields()
                .print(builder);
        System.out.println(jsonString);

        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
        // JSON back to proto
        JsonFormat.parser().ignoringUnknownFields().merge(jsonString,builder2);
        System.out.println(builder2);
    }
}
