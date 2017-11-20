public class Solution {
    /*
    * @param k: An integer
    */
    PriorityQueue<Integer> min_heap;
    int k;
    public Solution(int k) {
        // do intialization if necessary
        // Use a Min Heap, and the size of heap is k.
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        };
        min_heap = new PriorityQueue<>(k, cmp);
        this.k = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        // minheap size < k --> add directly
        // minheap size >= k --> if num > root --> delete root and add nums to heap
        if (min_heap.size() < k) {
            min_heap.offer(num);
        } else {
            if (num > min_heap.peek()) {
                min_heap.poll();
                min_heap.offer(num);
            }
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        // get the heap element in reverse order
        // and store back
        List<Integer> top = new ArrayList<>();
        
        int ori_heap_size = min_heap.size();
        
        for (int i = 0; i < ori_heap_size ; i++) {
            top.add(min_heap.poll());
        }
        
        for (int i = 0; i < top.size(); i++) {
            min_heap.offer(top.get(i));
        }
        
        Collections.sort(top, Collections.reverseOrder());
        return top;
    }
}

// 用迭代器, 不需要刪除heap再重新放回去
    public List<Integer> topk() {
        // write your code here
        // get the heap element in reverse order
        // and store back
        List<Integer> top = new ArrayList<>();
        Iterator it = min_heap.iterator();
        
        while (it.hasNext()) {
            top.add((Integer) it.next());
        }
        
        Collections.sort(top, Collections.reverseOrder());
        return top;
    }