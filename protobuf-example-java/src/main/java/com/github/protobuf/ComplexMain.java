package com.github.protobuf;

import java.util.Arrays;

import example.complex.Complex.DummyMessage;
import example.complex.Complex.ComplexMessage;

public class ComplexMain {
    public static void main(String[] args) {

       DummyMessage oneDummy = newDummyMessage(50, "First dummy");

       ComplexMessage.Builder builder = ComplexMessage.newBuilder();
       //singular message field
       builder.setOneDummy(oneDummy);

       // repeated field
        builder.addMultipleDummy(newDummyMessage(60, "secondDummy"))
                .addMultipleDummy(newDummyMessage(70, "thirdDummy"))
                .addAllMultipleDummy(Arrays.asList(
                        newDummyMessage(80, "fourthDummy"),
                        newDummyMessage(90, "fifthDummy")
                ));

        ComplexMessage message = builder.build();
        System.out.println(message);

        // to get message
        System.out.println(message.getOneDummy());

    }

    public static DummyMessage newDummyMessage ( Integer id , String name){
        // Builder to create message - Dummy message
        DummyMessage.Builder dummy_builder = DummyMessage.newBuilder();
        DummyMessage message = dummy_builder.setId(id)
                .setName(name)
                .build(); // Built message
        return message;

    }

}
