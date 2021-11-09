package com.recantogeek.recantogeekv2.enums;

public enum RatingEnum {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    private RatingEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
