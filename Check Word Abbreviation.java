public class Solution {
    /**
     * @param word a non-empty string
     * @param abbr an abbreviation
     * @return true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        
        while (i < word.length() || j < abbr.length() ) {
            if (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                //Case1: 數字
                if(abbr.charAt(j) == '0') { return false; } 
                int value = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    value = value * 10 + abbr.charAt(j) - '0';
                    j += 1;
                }
                    i += value;
            } else {
                // Case2: 字母
                if ( i < word.length() && j < abbr.length() && word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i += 1;
                j += 1;
            }
        }
        if ( i == word.length() && j == abbr.length() ) {
            return true;
        }
        return false;
    }
}