package cn.tl.datetime;

import java.time.Clock;

public class ClockTest {

    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
    }
}
