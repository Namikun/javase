package cn.tl.collection;

import cn.tl.domain.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set的底层是Map，因为Map的key也不能重复
 * HashSet -- HashMap
 * TreeMap -- TreeMap
 * 判重时，先比较两个元素的hashCode，如果hashCode相同，再通过equals方法比较，如果相同，则是同一个元素。
 */
public class SetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Student> set = new HashSet<>();
		Student p1 = new Student("lily", 18);
		Student p2 = new Student("lucy", 18);
		Student p3 = new Student("lily", 18);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p1);
		for (Iterator<Student> it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

}
