import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeIntegerEveryWindowSizeK_Queue {

    public static void printFirstNegativeInteger(int arr[], int k) {

        Deque<Integer> dq = new LinkedList<Integer>();
        int length = arr.length;
        int i = 0;
        for (i = 0; i < k; i++) {
            if (arr[i] < 0) {
                dq.add(i);
            }
        }
    //    System.out.println("----"+dq.peek());
        for (; i < length; i++) {
            if (!dq.isEmpty()) {
                System.out.println(arr[dq.peek()] + " ");
            } else {
                System.out.println("0");
            }
            while (!dq.isEmpty() && dq.peek()<i-k+1) {
                dq.remove();

            }
            if (arr[i] < 0) {
                dq.add(i);
            }

        }
        if (!dq.isEmpty()) {
            System.out.print(arr[dq.peek()] + " ");
        } else {
            System.out.print("0" + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        printFirstNegativeInteger(arr, k);
    }
}

