public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        int[] order = new int[numCourses];
        
        // 計算indegree
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]] ++ ;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        // 抓起始點
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        
        // BFS
        int counter = 0;
        while (!q.isEmpty()) {
            int currentNode = q.remove();
            order[counter] = currentNode;
            counter += 1;
            // 找currentNode的鄰居, 並將該鄰居點的degree - 1
            //int neighbor = degree[currentNode]; // 錯誤, 不是找currentNode的indegree, 而是找她是幾個人的先修
            int neighbor = edges[currentNode].size();
            for (int i = 0; i < neighbor; i++) {
                //int pointer = (edges[currentNode].get(i)).intValue(); why ?
                int pointer = (int)edges[currentNode].get(i);

                degree[pointer] = degree[pointer] - 1;
                
                if (degree[pointer] == 0) {
                    q.add(pointer);
                }
            }
        }
        // 沒有環 --> 代表有完整修課路徑
        if (counter == numCourses) {
            return order;
        }
        // corner case: 當有環, 環裡面每個indegree皆>=1,
        // 但不在環內的可以做拓樸, 就會發生這種情況, 沒有每個點都走完
        return new int[0];
    }
}