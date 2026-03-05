import java.util.*;
public class Ankesh_Question {
    static boolean check(String query, HashSet<String> set) {
        for (int i = 0; i < query.length(); i++) {
            char original = query.charAt(i);
            for (char ch : new char[]{'a','b','c'}) {
                if (ch == original) continue;
                char[] arr = query.toCharArray();
                arr[i] = ch;
                String modified = new String(arr);
                if (set.contains(modified)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }
        for (int i = 0; i < m; i++) {
            String query = sc.next();
            if (check(query, set)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}