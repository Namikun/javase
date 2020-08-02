#### 第10条：覆盖 equals 时请遵守通用约定
依靠 IDE 自动生成

#### 第11条：覆盖 equals 时总要覆盖 hashCode
判断两个对象是否相等，先比较 hashCode
- 如果不等，则两个对象不相等
- 如果相等，再调用 equals 方法，根据返回值判断两个对象是否相等

#### 第12条：始终要覆盖 toString
覆盖 toString 方法，方便打印对象具体参数。阿里Java规范也建议覆盖该方法

#### 第13条：谨慎地覆盖 clone
clone 方法是浅拷贝，对象里面的对象引用指向同一个对象。
具体请看：[Object类中的clone()方法是深拷贝还是浅拷贝？](https://www.jianshu.com/p/5701f03a93fc)

#### 第14条：考虑实现 Comparable 接口
当需要元素排序时，考虑实现该接口