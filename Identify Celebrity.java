/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // 思路：每次呼叫knows一定會刪除一個, 如果true代表當前不是名人, 如果false
        int cur = 0;
        for (int i = 1; i < n; i++) {
            if (knows(cur, i)) {
                cur = i;
            }
        }
        
        // 檢驗是不是完全沒有名人, ex: 0,1都不是名人
        for (int i = 0; i < n; i++) {
            if (i != cur && knows(cur, i)) {
                return -1;
            }
            if (i != cur && !knows(i, cur)) { 
                return -1;
            }
            
        }
        
        return cur;
    }
}