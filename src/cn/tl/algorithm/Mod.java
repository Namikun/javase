package cn.tl.algorithm;

/**
 * 快速幂求余
 * (ab) mod c = ((a mod c)(b mod c)) mod c
 */
public class Mod {

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(mod1(2, 3000000, 3));
        System.out.println("mod1: " + (System.currentTimeMillis() - s));

        s = System.currentTimeMillis();
        System.out.println(mod(2, 3000000, 3));
        System.out.println("mod: " + (System.currentTimeMillis() - s));

        s = System.currentTimeMillis();
        System.out.println(mod2(2, 3000000, 3));
        System.out.println("mod2: " + (System.currentTimeMillis() - s));
    }

    //O(n) a^b%c
    public static int mod1(int a, int b, int c) {
        int r = 1;
        while (b > 0) {
            r = ((r % c) * (a % c)) % c;
            b--;
        }
        return r;
    }

    //O(logn)
    public static int mod(int a, int b, int c) {
        int r = 1;
        a = a % c;
        while (b != 0) {
            if ((b & 1) == 1) {
                r = r * a % c;
            }
            a = a * a % c;
            b = b << 1;
        }

        return r;
    }

    // 递归
    public static int mod2(int a, int b, int c) {
        a = a % c;
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        int r = mod2(a * a, b >> 1, c);
        if ((b & 1) == 1) {
            return r * a % c;
        } else {
            return r;
        }
    }
}
