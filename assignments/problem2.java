import java.util.*;

public class problem2 {
    static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        if (low > high) {
            return 0;
        }

        int first = lowerBound(scores, low);
        int afterLast = lowerBound(scores, high + 1);

        return afterLast - first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}