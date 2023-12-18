package org.example;

/**
 * Created by ainacio on Dec, 2023
 */
public class Adult {

    public static void main(String[] args) throws Exception {
        try(Room myRoom = new Room(7)){
            System.out.println("Goodbye");
        }
    }
}
