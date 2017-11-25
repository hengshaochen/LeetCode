public class Solution {
public class StackArray<T> {

    private T[] arr;
    private int total;

    public StackArray() {
        arr = (T[]) new Object[2];
        total = 0;
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        tmp = Arrays.copyOf(arr, capacity);
        arr = tmp;
    }

    public StackArray<T> push(T ele) {
        if (arr.length == total) {
            resize(arr.length * 2);
        }
        arr[total++] = ele;
        return this;
    }

    public T pop() {
        if (total == 0) {
            throw new java.util.NoSuchElementException();
        }
        T ele = arr[--total];
        //arr[total] = null;  // 移除最上方的元素
        //if (total > 0 && total == arr.length / 4) resize(arr.length / 2);
        return ele;
    }
    public T peek() {
        return arr[total - 1];
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(arr);
    }

}
    public void partition2(int[] nums, int low, int high) {
        StackArray<Integer> s = new StackArray<>();
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(10);
        s.push(20);
        s.push(2);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}