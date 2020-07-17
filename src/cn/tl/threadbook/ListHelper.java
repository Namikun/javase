package cn.tl.threadbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//ThreadSafe
//同步封装器类的文档中指出，通过使用Vector或封装器容器的内置锁来支持客户端加锁
public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E e) {
        synchronized (list) {
            boolean absent = !list.contains(e);
            if (absent) {
                list.add(e);
            }
            return absent;
        }
    }
}
