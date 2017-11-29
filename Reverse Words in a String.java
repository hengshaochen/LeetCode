// 面試用這個版本**
public class Solution {
    public String reverseWords(String s) {
        String[] sp = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--) {
            if (!sp[i].equals("")) {
                ans.append(sp[i] + " ");
            }
        }
        if (ans.length() == 0) {
            return "";
        }
        // 去除最後一個多得空格
        return ans.substring(0, ans.length() - 1);
    }
}

// correct
public class Solution {
    public String reverseWords(String s) {
        String ans = "";
        
        String[] sp = s.split(" ");
        for (int i = sp.length - 1; i >= 0; i--) {
            if (!sp[i].equals("")) {
                ans = ans + ' ' + sp[i];
            }
        }
        
        if (ans.length() == 0) { 
            return ans; 
        }
        return ans.substring(1, ans.length());
    }
}

// 下面這種方法正確要基於 詞根詞之間只有一個空格
public class Solution {
    public String reverseWords(String s) {
        char[] rev = s.toCharArray();
        // 先整個翻轉 facebook offer heng --> gneh reffo koobecaf
        reverse(0, rev.length - 1, rev);
        // 個別一個字母一個字母翻轉
        int start = 0;
        int end = 0;
        while (end < rev.length) {
            // start確認不為空, end找空格的位置
            while (start < rev.length && rev[start] == ' ') {
                start++;
            }
            end = start;
            
            while (end < rev.length && rev[end] != ' ') {
                end++;
            }
            reverse(start, end - 1, rev);
            start = end + 1;
        }
        return new String(rev);
    }
    
    void reverse(int start, int end, char[] input) {
        while (start < end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }
}

// 變形題 III

public class Solution {
    public String reverseWords(String s) {
        String ans = "";
        
        String[] sp = s.split(" ");
        for (int i = 0; i <= sp.length - 1; i++) {
            if (!sp[i].equals("")) {
                ans = ans + ' ' + reverse(sp[i]);
            }
        }
        
        if (ans.length() == 0) { 
            return ans; 
        }
        return ans.substring(1, ans.length());
    }
    
    String reverse(String input) {
        String output = "";
        
        for (int i = input.length() - 1; i >= 0 ; i--) {
            output = output + input.charAt(i);
        }
        
        return output;
    }
}