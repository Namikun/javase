#### 第26条：请不要使用原生态类型
当类有泛型的时候，请不要省略泛型

#### 第27条：消除非受检的警告
IDE提示黄线的地方，应当予以注意

#### 第28条：列表优于数组
泛型数组是非法的，比如：`T[] t = new T[1]`是非法的

#### 第29条：优先考虑泛型
定义泛型数组虽然非法，但是可以通过强制类型转换来实现：`T[] t = (T[]) new Object[1]`

#### 第30条：优先考虑泛型方法
方法参数和返回值考虑使用泛型

#### 第31条：利用有限制通配符来提升 API 的灵活性
PECS：producer-extends，consumer-super。不要使用通配符作为返回类型。
- 生产者T，使用<? extends T>
- 消费者T，使用<? super T>
```
public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
    E result = null;
    for (E e : list) {
        // Comparable 消费者
        if (e != null && e.compareTo(result) > 0) {
            result = e;
        }
    }

    return result;
}
```

#### 第32条：谨慎并用泛型和可变参数
可变参数就是一个数组，避免和集合类并用

#### 第33条：优先考虑类型安全的异构容器
没什么好记录的:)