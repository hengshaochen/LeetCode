class Solution {
    public String findLongestWord(String s, List<String> d) {
        
        int max_length = Integer.MIN_VALUE;
        int max_index = -1;
        // Algo: 掃一遍O(s.length)
        for (int i = 0; i < d.size(); i++) {
            // Step1: 確認當前候選答案d是合法的輸入(Two Ptr)
            int sPtr = 0;
            int dPtr = 0;
            String curD = d.get(i);
            while (sPtr < s.length()) {
                if (dPtr < curD.length() && sPtr < s.length() && s.charAt(sPtr) == curD.charAt(dPtr)) {
                    sPtr++;
                    dPtr++;
                } else {
                    sPtr++;
                }
            }
            if (dPtr != curD.length()) {
                continue;
            }

            // Step2: 確保當前候選答案為最終的答案(使用max_length存當前最長的 與 當前最長的答案在候選d中的第幾個)
            // 若新來的長度 < max_length, 不動
            // 若新來的長度 > max_length, 直接用新來的取代
            // 若新來的長度 == max_length, 依序比較
            if (curD.length() > max_length) {
                max_length = curD.length();
                max_index = i;
            } else if (curD.length() == max_length) {
                String max_string = d.get(max_index);
                // 在等長的情況下, 若挑戰者的字典順序 < 原本最大值 --> 將挑戰者變為最大值 取代原本的最大值
                if (curD.compareTo(max_string) < 0) {
                    max_index = i;
                }
            }
        }
        // 代表找不到candidate
        if (max_index == -1) {
            return "";
        }
        return d.get(max_index);
    }
}