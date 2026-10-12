import java.util.*;

class Solution {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    private Map<Integer, Integer> delayed;

    private int smallSize;
    private int largeSize;

    public double[] medianSlidingWindow(int[] nums, int k) {

        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();

        delayed = new HashMap<>();

        smallSize = 0;
        largeSize = 0;

        double[] result = new double[nums.length - k + 1];

        // Build first window
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }

        result[0] = getMedian();

        // Slide window
        for (int i = k; i < nums.length; i++) {

            int entering = nums[i];
            int leaving = nums[i - k];

            addNum(entering);
            removeNum(leaving);

            result[i - k + 1] = getMedian();
        }

        return result;
    }

    private void addNum(int num) {

        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }

        balance();
    }

    private void removeNum(int num) {

        delayed.put(
            num,
            delayed.getOrDefault(num, 0) + 1
        );

        if (num <= small.peek()) {
            smallSize--;
        } else {
            largeSize--;
        }

        cleanSmall();
        cleanLarge();

        balance();
    }

    private void balance() {

        if (smallSize > largeSize + 1) {

            large.offer(small.poll());

            smallSize--;
            largeSize++;

            cleanSmall();

        } else if (smallSize < largeSize) {

            small.offer(large.poll());

            smallSize++;
            largeSize--;

            cleanLarge();
        }
    }

    private void cleanSmall() {

        while (!small.isEmpty()
                && delayed.containsKey(small.peek())) {

            int num = small.poll();

            delayed.put(
                num,
                delayed.get(num) - 1
            );

            if (delayed.get(num) == 0) {
                delayed.remove(num);
            }
        }
    }

    private void cleanLarge() {

        while (!large.isEmpty()
                && delayed.containsKey(large.peek())) {

            int num = large.poll();

            delayed.put(
                num,
                delayed.get(num) - 1
            );

            if (delayed.get(num) == 0) {
                delayed.remove(num);
            }
        }
    }

    private double getMedian() {

        if (smallSize > largeSize) {
            return small.peek();
        }

        return ((double) small.peek()
                + (double) large.peek()) / 2.0;
    }
}