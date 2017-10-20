// 看影片
public class ValidWordAbbr {
    Map<String, Integer> dict = new HashMap<>();
    Map<String, Integer> abbr = new HashMap<>();

    // @param dictionary a list of word
    public ValidWordAbbr(String[] dictionary) {
        // Write your code here
        for (String d : dictionary) {
            dict.put(d, dict.getOrDefault(d, 0) + 1);
            String a = getAbbr(d);
            abbr.put(a, abbr.getOrDefault(a, 0) + 1);
        }
    }
    /**
     * @param word a string
     * @return true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // Write your code here
        String a = getAbbr(word);
        return dict.get(word) == abbr.get(a);
    }

    String getAbbr(String str) {
        if (str.length() <= 2) {
            return str;
        }
        return "" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1);
    }
}