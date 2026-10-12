
import java.util.Arrays;

public class problem5 {

    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;

        if (n == 0) {
            return nums;
        }

        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = rotateArray(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
