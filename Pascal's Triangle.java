public class Solution {

    List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        if(numRows >= 1) ans.add(Arrays.asList(1));
        if(numRows >= 2) ans.add(Arrays.asList(1,1));

        for(int i = 3; i <= numRows; i++){
           List<Integer> previous = ans.get(ans.size() - 1);
           List<Integer> row = new ArrayList();
           row.add(1);
           for(int j = 1; j < previous.size(); j++){
                row.add(previous.get(j - 1) + previous.get(j));
           }
           row.add(1);
           ans.add(row);
        }

        return ans;
    }
}