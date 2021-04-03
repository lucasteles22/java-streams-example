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

    /*
    Creates a List with values following this pattern:
    1. Integer's values.
    2. From 0 until SIZE_INTEGERS_LIST
    For example, if SIZE_INTEGERS_LIST is equal to 10, the List has the values:
    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }
     */
    protected final List<Integer> getIntegers() {
        return IntStream.rangeClosed(0, SIZE_INTEGERS_LIST).boxed().collect(Collectors.toList());
    }

    protected final double getDuration() {
        return Duration.between(this.start, this.end).toMillis();
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

    protected long getMemoryUsage() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
