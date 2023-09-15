package com.datmt.ocp17;

import java.util.HashMap;
import java.util.Hashtable;

public class ThrowAway {


    public static void main(String[] args) {
        //demonstrate the differences between HashMap and HashTable regarding synchronization
        var myMap = new HashMap<String, Integer>();
        myMap.put("key1", 1);

        //spawn 10 threads to modify the value of "key1"
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                myMap.put("key1", myMap.get("key1") + 1);
            }).start();
        }

        //wait for all threads to finish
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(myMap.get("key1"));


        //Now let's try with HashTable
        var myTable = new Hashtable<String, Integer>();
        myTable.put("key1", 1);

        //spawn 100 threads to modify the value of "key1"
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                myTable.put("key1", myTable.get("key1") + 1);
            }).start();
        }

        //wait for all threads to finish
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Result using HashTable: " + myTable.get("key1"));


        myMap.put(null, null);


    }
}

class   MapvsTable{
    public static void main(String[] args) {
        var myMap= new HashMap<String, Integer>();
        var myTable = new Hashtable<String, Integer>();

        myMap.put("Key1", 100);
        myMap.put("Key2", 200);

        myTable.put("Key1", 100);
        myTable.put("Key2", 200);

        //Iterate over the map
        for (var entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        myMap.values();
        //myMap.keys(); //this will not compile

        //Iterate over the table
        for (var entry : myTable.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        myTable.keys();
        myTable.values();

    }
}
