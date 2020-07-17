package cn.tl.string;

public class StringEquals {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "abc";
        String str0 = new String("abc");
        String str1 = new String("abc");
        String str2 = "abc";
        String str3 = "ab" + "c";
        System.out.println(str == str1);
        System.out.println(str.equals(str1));
        // 先查询常量池中是否有"abc"，有就取，没有就创建
        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str0 == str1);

    }

}
