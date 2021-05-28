package com.github.protobuf;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.example.tutorial.protos.AddressBook;
import com.example.tutorial.protos.Person;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Timestamp;

public class AddressBookMain {
    public static void main(String[] args) {
        // Create phone number
        Person.PhoneNumber number = newPhoneNumber("222200044",
                Person.PhoneType.forNumber(Person.PhoneType.HOME_VALUE));

        Timestamp.Builder timestamp = Timestamp.newBuilder();
        timestamp.setNanos(1000);

        // Add phone number and type to person
        Person.Builder person = Person.newBuilder();
        person.setName("Andy")
                .setId(001)
                .setEmail("andy@a1.com")
                .addPhones(number)
                .addAllPhones(Arrays.asList(
                        newPhoneNumber("222200044",
                                Person.PhoneType.forNumber(Person.PhoneType.HOME_VALUE)),
                        newPhoneNumber("222200045",
                                Person.PhoneType.forNumber(Person.PhoneType.MOBILE_VALUE)),
                        newPhoneNumber("222200046",
                                Person.PhoneType.forNumber(Person.PhoneType.WORK_VALUE))
                ))
                .setLastUpdated(timestamp)
                .build();

        Person.Builder person2 = Person.newBuilder();
        person2.setName("Bob")
                .setId(002)
                .setEmail("bob@a1.com")
                .addPhones(number)
                .addAllPhones(Arrays.asList(
                        newPhoneNumber("222200044",
                                Person.PhoneType.forNumber(Person.PhoneType.HOME_VALUE)),
                        newPhoneNumber("222200045",
                                Person.PhoneType.forNumber(Person.PhoneType.MOBILE_VALUE)),
                        newPhoneNumber("222200046",
                                Person.PhoneType.forNumber(Person.PhoneType.WORK_VALUE))
                ))
                .setLastUpdated(timestamp)
                .build();

       // System.out.println(person);

        // create address book
        AddressBook.Builder addressbook = AddressBook.newBuilder();
        addressbook.addPeople(person);
        addressbook.addPeople(person2);
        System.out.println(addressbook);

    }

    public static Person.PhoneNumber newPhoneNumber(String number, Person.PhoneType type){
        Person.PhoneNumber.Builder builder = Person.PhoneNumber.newBuilder();
        return builder.setNumber(number)
                .setType(type)
                .build();
    }
}
