import java.util.Arrays;

public class ActivitySelectionProblem {
    public static void main(String[] args) {
        Activity[] arr = {
                new Activity(2, 3),
                new Activity(1, 4),
                new Activity(5, 8),
                new Activity(6, 10)
        };
        System.out.println(maxActivity(arr));
    }

    static int maxActivity(Activity[] arr) {
        Arrays.sort(arr);
        int res = 1;
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start >= arr[prev].finish) {
                res++;
                prev = i;
            }
        }
        return res;
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Activity activity) {
        return this.finish - activity.finish;
    }
}
