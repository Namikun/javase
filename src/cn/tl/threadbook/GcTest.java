package cn.tl.threadbook;

public class GcTest {

    public static void main(String[] args) {
        byte[] array = new byte[200 * 1024 * 1024];
        array = null;
        System.gc();
    }
}
