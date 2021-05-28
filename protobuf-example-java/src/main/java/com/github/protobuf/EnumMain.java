package com.github.protobuf;

import example.enumeration.EnumEx;
import example.enumeration.EnumEx.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {
        EnumMessage.Builder builder = EnumMessage.newBuilder();
        builder.setDay(200)
                .setDayOfWeek(EnumEx.DayOfWeek.FRIDAY);

        // to get the message
        EnumMessage message = builder.build();
        System.out.println(message);

    }
}
