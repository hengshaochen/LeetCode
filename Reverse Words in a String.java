// BUG : ab     d --> d     ab  應該要d ab
class Main {
    public static void main(String[] args) {
        String s = "   ";
        String ans = "";
        
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() -1 && s.charAt(i) == ' ' && s.charAt(i + 1) == ' ')              {
                continue;
            }
            
            if (s.charAt(i) == ' ') {
                ans = s.substring(start, i) + ' ' + ans;
                start = i + 1;
            } else if (i == s.length() - 1) {
                // 處理最後一個
                ans = s.substring(start, i + 1) + ' ' + ans;
            }
        }
        // 去掉最後面的空格
        System.out.println(ans.substring(0, ans.length() - 1));
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