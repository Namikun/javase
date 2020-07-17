package cn.tl.datetime;

import cn.tl.domain.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class SimpleDateFormmatTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new InnerClass()).start();
        }
    }

    static class InnerClass implements Runnable {

        static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
        static SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_PATTERN);

        @Override
        public void run() {
            Date date = null;
            try {
                date = getSDFInstance().parse("2018-06-10");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date);
        }

        public SimpleDateFormat getSDFInstance() {
            return Optional.ofNullable(threadLocal.get()).orElseGet(() -> {
                SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_PATTERN);
                threadLocal.set(sdf);
                return sdf;
            });
        }
    }
}
