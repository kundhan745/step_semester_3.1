import java.util.*;

public class problem3 {
    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] result = new String[n];

        k = k % n;

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        int k = sc.nextInt();

        String[] result = rotateRoster(names, k);

        System.out.println(Arrays.toString(result));
        sc.close();
    }
}