package com.streams.example.strategies;

import com.streams.example.io.Log;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class SequentialStrategyImpl extends StrategyImpl {

    private static final String LABEL = "Without stream";

    public SequentialStrategyImpl() {
        super(LABEL);
    }

    @Override
    public void measure() {
        setStart();
        List<Point> points = new ArrayList<Point>();
        for (Integer i : getIntegers()) {
            points.add(new Point(i, i));
            }
        double maxDistance = Double.MIN_VALUE;
        for (Point p : points) {
            maxDistance = Math.max(p.distance(0, 0), maxDistance);
        }
        setEnd();

        Log.Output(getLabel(), maxDistance, getDuration(), getMemoryUsage());
    }
}
