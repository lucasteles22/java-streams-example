package com.streams.example;

import com.streams.example.strategies.IStrategy;
import com.streams.example.strategies.ParallelStreamStrategy;
import com.streams.example.strategies.SequentialStrategy;
import com.streams.example.strategies.SyncStreamStrategy;

public class Main {
    public static void main(String[] args) {
        IStrategy strategy;

        var conditional = 1;
        switch (conditional) {
            case 1:
                strategy = new SequentialStrategy();
                break;
            case 2:
                strategy = new SyncStreamStrategy();
                break;
            default:
                strategy = new ParallelStreamStrategy();
                break;
        }

        strategy.measure();
    }

}
