import java.util.*;
public class Ankesh_Question {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }
        List<Integer>[] adj = new ArrayList[26];
        for (int i = 0; i < 26; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[26];
        for (int i = 0; i < n - 1; i++) {
            String s1 = names[i];
            String s2 = names[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean found = false;
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';
                    adj[u].add(v);
                    indegree[v]++;
                    found = true;
                    break;
                }
            }
            if (!found && s1.length() > s2.length()) {
                System.out.println("Impossible");
                return;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            result.append((char)(u + 'a'));
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        if (result.length() != 26) {
            System.out.println("Impossible");
        } else {
            System.out.println(result.toString());
        }
    }
}