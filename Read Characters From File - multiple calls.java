/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    char[] buffer = new char[4];
    int head = 0, tail = 0;
    public int read(char[] buf, int n) {
        int cur = 0; // 當前掃到第幾個
        while (cur < n) {
            // 如果陣列為空, 讀資料進來
            if (head == tail) {
                head = 0;
                tail = read4(buffer);
                // 已經沒東西好讀了 --> 後面也沒得讀 --> 結束
                if (tail == 0) {
                    break;
                }
            }
            
            // 如果陣列不為空, deQueue
            // cur < n --> 例如這次Queue有4個, 可是只要讀2個
            while (head < tail && cur < n) {
                buf[cur++] = buffer[head++];
            }
        }
        return cur;
    }
}