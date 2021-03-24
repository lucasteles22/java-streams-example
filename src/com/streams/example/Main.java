package com.streams.example;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> ints = getIntegers();

        // Without stream
        testWithoutStream(ints);

        // Parallel stream
        testWithParallelStream(ints);

        // Sync stream
        testWithSyncStream(ints);
//        printMemoryUsage();
    }

    public static List<Integer> getIntegers() {
        return IntStream.rangeClosed(0, 100).boxed().collect(Collectors.toList());
    }

    public static void testWithoutStream(List<Integer> ints) {
        Instant start = Instant.now();
        List<Point> points = new ArrayList<Point>();
        for (Integer i : ints) {
            points.add(new Point(i, i));
        }
        double maxDistance = Double.MIN_VALUE;
        for (Point p : points) {
            maxDistance = Math.max(p.distance(0, 0), maxDistance);
        }
        Instant end = Instant.now();
        System.out.println("Without stream:" + " " + Duration.between(start, end).toMillis());
        System.out.println("Max distance 1:" + " " + maxDistance);
    }

    public static void testWithSyncStream(List<Integer> ints) {
         Instant start2 = Instant.now();
        OptionalDouble maxDistance2 = ints.stream()
                .map(x -> new Point(x, x))
                .mapToDouble(y -> y.distance(0, 0))
                .max();
        Instant end2 = Instant.now();
        System.out.println("Using stream (sync):" + " " + Duration.between(start2, end2).toMillis());
        System.out.println("Max distance 2:" + " " + maxDistance2.getAsDouble());
    }

    public static void testWithParallelStream(List<Integer> ints) {
        Instant start3 = Instant.now();
        OptionalDouble maxDistance3 = ints.parallelStream()
                .map(x -> new Point(x, x))
                .mapToDouble(y -> y.distance(0, 0))
                .max();
        Instant end3 = Instant.now();
        System.out.println("Using stream (parallel):" + " " + Duration.between(start3,  end3).toMillis());
        System.out.println("Max distance 3:" + " " + maxDistance3.getAsDouble());
    }

    private static void printMemoryUsage() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
    }
}
