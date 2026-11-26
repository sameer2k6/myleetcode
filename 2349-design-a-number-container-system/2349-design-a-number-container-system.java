import java.util.*;

class NumberContainers {

    // index -> number
    HashMap<Integer, Integer> map;

    // number -> min heap of indices
    HashMap<Integer, PriorityQueue<Integer>> heaps;

    public NumberContainers() {
        map = new HashMap<>();
        heaps = new HashMap<>();
    }

    public void change(int index, int number) {

        // Update index -> number
        map.put(index, number);

        // Create heap if number doesn't exist
        heaps.putIfAbsent(number, new PriorityQueue<>());

        // Add index to that number's heap
        heaps.get(number).add(index);
    }

    public int find(int number) {

        if (!heaps.containsKey(number)) {
            return -1;
        }

        PriorityQueue<Integer> pq = heaps.get(number);

        // Remove outdated indices
        while (!pq.isEmpty() &&
               map.get(pq.peek()) != number) {
            pq.poll();
        }

        if (pq.isEmpty()) {
            return -1;
        }

        return pq.peek();
    }
}