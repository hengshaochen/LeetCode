class Solution {
    public String reverseVowels(String s) {
        char[] rev = s.toCharArray();
        HashSet<Character> hash = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        int i = 0, j = rev.length - 1;
        while (i < j) {
            while (i <= rev.length - 1 && !hash.contains(rev[i])) {
                i++;
            }
            while (j >= 0 && !hash.contains(rev[j])) {
                j--;
            }
            
            if (i <= rev.length - 1 && j >= 0 && i < j) {
                char temp = rev[i];
                rev[i] = rev[j];
                rev[j] = temp;
                i++;
                j--;
            }
        }
        
        return new String(rev);
    }
}