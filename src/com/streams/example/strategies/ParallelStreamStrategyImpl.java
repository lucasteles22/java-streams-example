package com.streams.example.strategies;

import com.streams.example.io.Log;

import java.awt.*;
import java.util.OptionalDouble;

public final class ParallelStreamStrategyImpl extends StrategyImpl {

    private static final String LABEL = "Parallel stream";

    public ParallelStreamStrategyImpl() {
        super(LABEL);
    }

    @Override
    public void measure() {
        setStart();
        OptionalDouble maxDistance = getIntegers().parallelStream()
                .map(x -> new Point(x, x))
                .mapToDouble(y -> y.distance(0, 0))
                .max();
        setEnd();

        Log.Output(getLabel(), maxDistance.getAsDouble(), getDuration(), getMemoryUsage());
    }
}
