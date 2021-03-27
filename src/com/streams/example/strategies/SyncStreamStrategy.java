package com.streams.example.strategies;

import com.streams.example.io.Log;

import java.awt.*;
import java.util.OptionalDouble;

public final class SyncStreamStrategy extends Strategy {

    private static final String LABEL = "Sync stream";

    public SyncStreamStrategy() {
        super(LABEL);
    }

    @Override
    public void measure() {
        setStart();
        OptionalDouble maxDistance = getIntegers().stream()
                .map(x -> new Point(x, x))
                .mapToDouble(y -> y.distance(0, 0))
                .max();
        setEnd();

        Log.Output(getLabel(), maxDistance.getAsDouble(), getDuration(), getMemoryUsage());
    }
}
