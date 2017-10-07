// 沒使用prefix Version
public class Solution {

    public int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int max = 0;
        int[] level_length = new int[input.length() + 1];

        // 一次處理一行
        for (String line : input.split("\n")) {
            // 確認她在第幾層, 有幾個/t就代表在第幾層
            int level = line.lastIndexOf('\t') + 2; // 取最後一個\t字"元", 代表有幾個/t
            int cur_length = line.length() - (level - 1);
            
            // 如果是文件檔, 且cur長度>max, 更新max
            if (line.contains(".")) {
                level_length[level] = cur_length + 1;
                int cur_max = 0;
                for (int i = 1; i <= level; i++) {
                    cur_max += level_length[i];
                }
                max = Math.max(cur_max, max);
            } else {
                level_length[level] = cur_length + 1;
            }
        }
        if (max == 0) { return 0; }
        return max - 1;
    }
}

// Freq: 使用prefix
public class Solution {
    /*
    * @param input an abstract file system
    * @return return the length of the longest absolute path to file
    */
    public int lengthLongestPath(String input) {
        // Write your code here
        if (input.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] level_size = new int[input.length() + 1];

        for (String line : input.split("\n")) {
            int level = line.lastIndexOf('\t') + 2;
            int len = line.length() - (level - 1);
            if (line.contains(".")) {
                ans = Math.max(ans, level_size[level - 1] + len);
            } else {
                level_size[level] = level_size[level - 1] + len + 1;
            }
        }
        return ans;
    }
}