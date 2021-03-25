package com.streams.example.io;

public final class Log {
    public static void Output(String label, double maxDistance, double time, long memoryUsage) {
        System.out.printf("Max distance: %,.4f%n", maxDistance);
        System.out.println("------ METRICS ------");
        System.out.printf("%s time (milliseconds): %,.4f%n", label, time);
        System.out.printf("Memory usage (bytes): %d%n", memoryUsage);
    }
}
