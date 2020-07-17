package cn.tl.datetime;

import java.time.Instant;

public class InstantTest {

    public static void main(String[] args) {
        System.out.println(Instant.parse("2011-12-03T10:15:30Z").getEpochSecond());
        System.out.println(Instant.now().toEpochMilli());
    }
}
