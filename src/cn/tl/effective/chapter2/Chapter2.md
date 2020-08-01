#### 第1条：用静态工厂方法代替构造器
创建对象，尽可能考虑使用静态工厂方法，方便使用。书里说了一堆好处及一些缺点，还是需要自己领悟。
 - 参考：Stream.of(...), String.valueOf(...)

#### 第2条：遇到多个构造器参数参数时，要考虑使用构建器
当对象参数 >= 4时，如果使用构造器，可能需要写很多构造器。此时建议使用**建造者模式**，使用时，链式调用，既方便又清晰。
- JDK中线程池类`java.util.concurrent.ThreadPoolExecutor`参数就比较多，虽然提供了静态工具类`java.util.concurrent.Executors`，但是阿里规范并不推荐使用。

建造者模式改造类的步骤：
1. 创建一个类，并编写一个`public static`内部类，使其拥有和外部类一样的参数
2. 外部类的对象创建由内部类去完成，所以外部类构造函数须设置`private`，其参数为内部类对象，从而可以把参数传递给外部类。同时，内部类也要提供一个实例化外部类的方法
3. 内部类编写setter的变种方法，返回值设置为内部类，方便链式调用
4. 外部类的成员变量的值均由内部类设置，一经初始化，便不会更改值，所以需要加`final`修饰符

```
public class Person {

    private final String name;

    private final String sex;

    private final int age;

    private final Date birthday;

    private final String hobby;

    public static class Builder {
        private String name;

        private String sex;

        private int age;

        private Date birthday;

        private String hobby;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder hobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        name = builder.name;
        sex = builder.sex;
        age = builder.age;
        birthday = builder.birthday;
        hobby = builder.hobby;
    }
    
}
```

#### 第3条：用私有构造器或者枚举类型强化 singleton 属性
一般面试都会问到的问题：单例实现方法，分为饿汉式和懒汉式
- 饿汉式
  - 直接 new 即可，
  ```
  private static final Singleton singleton = new Singleton()
  ```
  - 枚举
  ```
  public enum SingletonEnum {
  
      INSTANCE;
  }
  ```
- 懒汉式
  - 双重 if 检查，注意使用`volatile`修饰符，参考第83条慎用延迟初始化
  ```
  public class Singleton {
  
      private Singleton() {
      }
  
      private static volatile Singleton instance = null;
  
      // 读取volatile变量开销比局部变量大，此处先使用局部变量接受，可以减少volatile变量读取次数
      public static Singleton getInstance() {
          Singleton result = instance;
          if (result == null) {
              synchronized (Singleton.class) {
                  if (result == null) {
                      result = instance = new Singleton();
                  }
              }
          }
  
          return result;
      }
  }
  ```
  - 私有静态内部类，只有被第一次调用的时候才会初始化
  ```
  public class Singleton {
  
      private Singleton() {
      }
  
      public static Singleton getInstance() {
          return SingletonHolder.singleton;
      }
  
      private static class SingletonHolder {
          private static Singleton singleton = new Singleton();
      }
  }
  ```

PS：内部类相当于外部类的一个成员变量，所以外部类可以通过内部类访问其私有属性

#### 第4条：通过私有构造器强化不可实例化的能力
参考第3条：单例构造函数私有化

#### 第5条：优化考虑依赖注入来引用资源
有许多类会依赖一个或多个底层的资源，把资源作为构造函数参数传入，这种模式叫做依赖注入。

#### 第6条：避免创建不必要的对象
1. 定义字符串不要用new String(...)
2. 创建正则 Pattern 实例的成本很高，应该提取为成员变量，并设置`public static final`，以便复用
3. for循环不要使用"+"号连接字符串，应该使用 StringBuilder
4. 基本类型和其包装类型，请不要混用，避免不必要的装箱拆箱

#### 第7条：消除过期的对象引用
其目的是防止内存泄漏。比如 
1. ThreadLocal 需要调用 remove() 方法才能清除引用
2. 数组元素不再需要的时候，需要设置 arr[i] = null
3. 集合、Map等等也是如此

#### 第8条：避免使用终结方法和清除方法
finalizer 垃圾回收方法不可预测，很危险，一般情况下是不必要的。Java9中用清除方法 cleaner 代替了它，虽然没有 finalizer 方法危险，但是依旧不可预测，一般情况下也是不必要的。

#### 第9条：try-with-resources 优先于 try-finally
资源都要实现接口`java.lang.AutoCloseable`，才可以使用这个语法糖。