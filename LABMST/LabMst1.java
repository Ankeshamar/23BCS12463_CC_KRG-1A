import java.util.*;

class LabMst1 {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int energy = 0;
        int current = 0;
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            if (current < minimum) {
                energy += (minimum - current);
                current = minimum;
            }
            current -= actual;
        }
        return energy;
    }
    public static void main(String[] args) {
        LabMst1 obj = new LabMst1();
        int[][] tasks = {{10,12},{10,11},{8,9},{2,4},{1,3}};
        int result = obj.minimumEffort(tasks);
        System.out.println("Output: " + result);
    }
}