package com.intrbiz.util;

public interface Optioned
{
    void option(Option<String> option, String value);

    void option(Option<Integer> option, int value);

    void option(Option<Long> option, long value);

    void option(Option<Float> option, float value);

    void option(Option<Double> option, double value);

    void option(Option<Boolean> option, boolean value);
}
