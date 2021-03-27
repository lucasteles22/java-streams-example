package com.streams.example.strategies;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class StrategyImpl implements Strategy {

    private Instant start;
    private Instant end;
    private final String label;
    private static final int SIZE_INTEGERS_LIST = 10000000;

    protected StrategyImpl(String label) {
        if (label == null) throw new NullPointerException("Label may not be null");
        this.label = label;
    }

    protected List<Integer> getIntegers() {
        return IntStream.rangeClosed(0, SIZE_INTEGERS_LIST).boxed().collect(Collectors.toList());
    }

    protected String getLabel() {
        return this.label;
    }

    protected void setStart() {
        this.start = Instant.now();
    }

    protected void setEnd() {
        this.end = Instant.now();
    }

    protected final double getDuration() {
        return Duration.between(this.start, this.end).toMillis();
    }

    protected long getMemoryUsage() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
