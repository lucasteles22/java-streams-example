package com.streams.example;

import com.streams.example.io.Greeting;
import com.streams.example.strategies.Strategy;
import com.streams.example.strategies.ParallelStreamStrategyImpl;
import com.streams.example.strategies.SequentialStrategyImpl;
import com.streams.example.strategies.SyncStreamStrategyImpl;

public class Main {

    public static void main(String[] args) {
        Strategy strategy;

        var conditional = Greeting.input();
        switch (conditional) {
            case 1:
                strategy = new SequentialStrategyImpl();
                break;
            case 2:
                strategy = new SyncStreamStrategyImpl();
                break;
            default:
                strategy = new ParallelStreamStrategyImpl();
                break;
        }

        strategy.measure();
    }
}
