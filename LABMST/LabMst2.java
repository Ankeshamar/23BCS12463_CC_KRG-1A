import java.util.*;
class LabMst2 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            int bitmask = 0;
            for (char c : words[i].toCharArray()) {
                bitmask |= 1 << (c - 'a');
            }
            mask[i] = bitmask;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    max = Math.max(max, product);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        LabMst2 obj = new LabMst2();
        // String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String[] words={"abs","abs"};
        int result = obj.maxProduct(words);
        System.out.println("Output: " + result);
    }
}