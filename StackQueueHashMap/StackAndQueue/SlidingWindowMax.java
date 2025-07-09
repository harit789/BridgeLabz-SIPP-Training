package StackQueueHashMap.StackAndQueue;

import java.util.*;

public class SlidingWindowMax {
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> result = maxSlidingWindow(nums, k);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
