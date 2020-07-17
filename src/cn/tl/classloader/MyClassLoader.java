package cn.tl.classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    /**
     * @param name 类的全路径，比如cn.tl.domain.Employee
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("MyClassLoader findClass execute...");

        String filePath = path + name.replace('.', File.separatorChar) + ".class";
        try (
                FileInputStream fis = new FileInputStream(filePath);
                ByteArrayOutputStream bos = new ByteArrayOutputStream()
        ) {
            int len;
            while ((len = fis.read()) != -1) {
                bos.write(len);
            }
            byte[] bytes = bos.toByteArray();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }
}
