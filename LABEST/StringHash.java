public class StringHash {

    public static long computeHash(String s) {
        long hash = 0;
        long p = 31;
        long mod = 1000000007;
        long power = 1;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash + val * power) % mod;
            power = (power * p) % mod;
        }

        return hash;
    }

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "polynomial";

        System.out.println(computeHash(str1));
        System.out.println(computeHash(str2));
    }
}