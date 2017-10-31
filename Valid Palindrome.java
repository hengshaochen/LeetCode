public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // 兩個相反方向的指標, 每回合i向右移動1格, j向左移動1格, 但若遇到的是非字母/非數字,則再多移動一格
        // 問題1: 大小寫視為相同(A = 65, a = 97, 相差32) --> 全轉大寫(toUpperCase)
        // 問題2: 如何判斷是否為字母(65 ~ 122才是字母) --> isLetter
        if (s == null | s.length() == 0) { return true; }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // 確認i, j兩個指標都指向字母 or 數字 --> 不是字母and不是數字才進入if
            if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i = i + 1;
                continue;
            }
            if (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j = j - 1;
                continue;
            }
            
            // 都是字母 or 數字
            if (Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(j))
                ||  Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(j))) {
                // 轉成大寫進行比較（如果是數字也沒差, 經過upper不變)
                if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                    return false;
                } else {
                    i = i + 1;
                    j = j - 1;
                }
            } 
            // 一個指標指向數字, 一個指向字母
            else {
                return false;
            }
        }
        return true;
    }
}

// review good version!

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}