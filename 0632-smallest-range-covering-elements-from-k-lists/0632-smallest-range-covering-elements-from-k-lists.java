import java.util.*;

class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );

        int currentMax = Integer.MIN_VALUE;

        // Put first element of every list into heap
        for (int i = 0; i < nums.size(); i++) {

            int value = nums.get(i).get(0);

            minHeap.offer(new int[]{value, i, 0});

            currentMax = Math.max(currentMax, value);
        }

        int bestLeft = 0;
        int bestRight = Integer.MAX_VALUE;

        while (minHeap.size() == nums.size()) {

            int[] current = minHeap.poll();

            int currentMin = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];

            // Check current range
            if (currentMax - currentMin
                    < bestRight - bestLeft) {

                bestLeft = currentMin;
                bestRight = currentMax;
            }

            // Move forward in the same list
            if (elementIndex + 1
                    < nums.get(listIndex).size()) {

                int nextValue =
                    nums.get(listIndex).get(elementIndex + 1);

                minHeap.offer(
                    new int[]{
                        nextValue,
                        listIndex,
                        elementIndex + 1
                    }
                );

                currentMax =
                    Math.max(currentMax, nextValue);

            } else {
                // This list has no more elements
                break;
            }
        }

        return new int[]{bestLeft, bestRight};
    }
}