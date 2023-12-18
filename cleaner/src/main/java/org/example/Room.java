package org.example;

import java.lang.ref.Cleaner;

/**
 * Created by ainacio on Dec, 2023
 */
public class Room implements AutoCloseable{
    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable{
        int numJunkPiles; //Number of junk piles in this room

        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    //The state of this room, shared with our cleanable
    private final State state;

    //Our cleanable. Cleans the room when it's eligible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles){
        System.out.println("Called constructor");
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Called close method");
        cleanable.clean();
    }
}
