/*Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

There are two cases for median on the basis of data set size.

1. If the data set has an odd number then the middle one will be consider as median.
2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.*/
class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> medians = new ArrayList<>();
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        PriorityQueue<Integer> right = new PriorityQueue<>(); // Min heap

        for (int num : arr) {
            // Insert into correct heap
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            // Balance heaps
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (right.size() > left.size()) {
                left.offer(right.poll());
            }

            // Compute median
            if (left.size() > right.size()) {
                medians.add((double) left.peek());
            } else {
                medians.add((left.peek() + right.peek()) / 2.0);
            }
        }
        return medians;
    }
