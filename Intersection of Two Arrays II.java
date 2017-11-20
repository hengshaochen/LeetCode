// II  Space:O(n) / Time: O(n + n + n) = O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                ans.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        
        int[] ans_arr = new int[ans.size()];
        for (int i =0; i < ans.size(); i++) {
            ans_arr[i] = ans.get(i);
        }
        
        return ans_arr;
    }
}

// Sort O(nlogn) / Space: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                // 相等
                ans.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        
        int[] ans_arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans_arr[i] = ans.get(i);
        }
        
        return ans_arr;
    }
}
