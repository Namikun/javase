package cn.tl.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyPicture {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (
                BufferedInputStream fis = new BufferedInputStream(new FileInputStream("C:\\Users\\Tanlang\\Pictures\\Slam.PNG"));
                BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("f:\\copy_Slam.PNG"))
        ) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (Exception e) {

        }

    }

}
