package cn.tl.algorithm;

/**
 * 二进制相加，结果仍然显示二进制
 */
public class BinaryAdd {

    public static void main(String[] args) {
        String r = cal("11", "11");
        System.out.println(r);
    }

    public static String cal(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = c;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum & 1);
            c = sum >> 1;
        }
        if (c == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
