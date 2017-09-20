/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> ans = new HashMap<Integer, Double>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < results.length; i++) {
            // 如果是第一次遇到, 則幫此student id建立PriorityQueue
            if (!map.containsKey(results[i].id)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(5, new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b; // min-heap
                    } 
                });
                map.put(results[i].id, pq);
            }
            PriorityQueue<Integer> pq = map.get(results[i].id);
            if (pq.size() < 5) {
                pq.add(results[i].score);
            } else {
                int cur = pq.poll();
                if (results[i].score > cur) {
                    pq.add(results[i].score);
                } else {
                    pq.add(cur);
                }
            }
        }
        
        // 算每位學生的平均並輸出到map中
        for (Integer i : map.keySet()) {
            double avg = 0;
            for (int j = 0; j < 5; j++) {
                avg = avg + map.get(i).poll();
            }
            avg = avg / 5;
            ans.put(i, avg);
        }
        return ans;
    }
}