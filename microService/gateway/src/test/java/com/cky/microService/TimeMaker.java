package com.cky.microService;

import java.time.ZonedDateTime;

public class TimeMaker {
    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}
