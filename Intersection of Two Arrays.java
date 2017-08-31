// Version1: HashSet
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> ansSet = new HashSet<Integer>();
        
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i]) && !ansSet.contains(nums2[i])) {
                ansSet.add(nums2[i]);
            }
        }
        
        // HashSet Integer to Array int
        int[] output = new int[ansSet.size()];
        int index = 0;
        for (Integer i : ansSet) {
            output[index++] = i.intValue();
        }
       
        return output;
    }
}

// Version2 