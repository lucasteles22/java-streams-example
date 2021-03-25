package com.streams.example.io;

public final class Log {
    public static void Output(String label, double maxDistance, double time, long memoryUsage) {
        System.out.println(String.format("Max distance: %,.4f", maxDistance));
        System.out.println("------ METRICS ------");
        System.out.println(String.format("%s time (milliseconds): %,.4f", label, time));
        System.out.println(String.format("Memory usage (bytes): %d", memoryUsage));
    }
}
