public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }
        int low = 0;
        int height = nums.length - 1;
        int pivot = find_pivot(nums, low, height);
        //System.out.println(pivot);
        return Math.max(searchHelper(nums, low, pivot-1, target),
                        searchHelper(nums, pivot, height, target) );
    }
    private int find_pivot(int[] nums, int low, int height) {
        // 用binary找pivot分出左右
        while (low <= height) {
            int mid = low + (height - low) / 2;
            // 找到pivot:因為nums[mid] < nums[0], 確認是不是頭
            if (nums[mid] < nums[0]) {
                height = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return height+1;
    }
    private int searchHelper(int[] nums, int low, int height, int target) {
        if (nums == null || nums.length == 0) return -1;
        // 用binary找pivot分出左右
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (target < nums[mid]) {
                height = mid - 1;
            } else if(target > nums[mid]){
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

// Review 11/11
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) { return -1; }
        // 找轉折點
        int pivot = findPivot(nums, 0, nums.length - 1);
        // 針對轉折點前 和 後做binary search找答案
        return Math.max(binarySearch(0, pivot - 1, nums, target), binarySearch(pivot, nums.length - 1, nums, target));
        
    }
    int findPivot(int[] nums, int left, int right) {
        //  0,1,2,3,4,5,6
        // [4,5,6,7,0,1,2]
        // 
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[0]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] < nums[right]) {
            return left;
        }
        return right;
    }
    /*
    int binarySearch(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // not find
        return -1;
    }
    */
    int binarySearch(int left, int right, int[] nums, int target) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (left >= 0 && nums[left] == target) {
            return left;
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        // not find
        return -1;
    }

}