class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder aExtend = new StringBuilder();
        int ans = 0;
        
        while (aExtend.length() < B.length()) {
            aExtend.append(A);
            ans++;
        }
        
        if (aExtend.toString().contains(B)) {
            return ans;
        }
        if (aExtend.append(A).toString().contains(B)) {
            return ans + 1;
        }
        
        // Can not find the substring contains in A that can construct B
        return -1;
    }
}

// 快速版本：
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        int i = 0;
        for (int j = 0; j < B.length(); j++) {
            if (A.charAt(i) != B.charAt(j)) {
                if (count > 1) {       // already second time: no way to make B from A
                    return -1;
                }
                j = -1;    // try to match j's starting character with next i
            }

            i++;
            if (i == A.length()) {        // one more time of A
                if (j == B.length() - 1) {
                    break;
                }
                count++;
                i = 0;
            }
        }
        return count;
    }
}