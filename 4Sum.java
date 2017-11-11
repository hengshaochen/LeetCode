public class Solution {
    /*
     * @param numbers: Give an ay
     * @param target: An integer
     * @return: Find all unique quadruplets in the numbersay which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // a + b + c + d = s
        Arrays.sort(numbers);
        List<List<Integer>> ans = new ArrayList<>();
        
        //   i j l r
        // 0 1 2 3 4
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
          for (int j = i + 1; j < numbers.length - 2; j++) {
              if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                continue;
            }
            int left = j + 1;
            int right = numbers.length - 1;
            while (left < right) {
              int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
              if (sum == target) {
                List<Integer> cur = new ArrayList<>();
                cur.add(numbers[i]);
                cur.add(numbers[j]);
                cur.add(numbers[left]);
                cur.add(numbers[right]);
                ans.add(cur);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
              } else if (sum > target) {
                right--;
              } else {
                left++;
              }
            }
            
          }
        }
        return ans;
    }
}

// one solution version (mock interview)
import java.io.*;
import java.util.*;

class Solution {
  
  /*
  static List<List<Integer>> findArrayQuadruplet(int[] arr, int s) {
    // a + b + c + d = s
    Arrays.sort(arr);
    List<List<Integer>> ans = new ArrayList<>();
    
    //   i j l r
    // 0 1 2 3 4
    for (int i = 0; i < arr.length - 3; i++) {
      for (int j = i + 1; j < arr.length - 2; j++) {
        int left = j + 1;
        int right = arr.length - 1;
        while (left < right) {
          int sum = arr[i] + arr[j] + arr[left] + arr[right];
          if (sum == s) {
            List<Integer> cur = new ArrayList<>();
            cur.add(arr[i]);
            cur.add(arr[j]);
            cur.add(arr[left]);
            cur.add(arr[right]);
            ans.add(cur);
            left++;
            right--;
          } else if (sum > s) {
            right--;
          } else {
            left++;
          }
        }
        
      }
    }
    return ans;
  }
  */
  static int[] findArrayQuadruplet(int[] arr, int s) {
    // a + b + c + d = s
    Arrays.sort(arr);
    int[] ans = new int[4];
    //   i j l r
    // 0 1 2 3 4
    for (int i = 0; i < arr.length - 3; i++) {
      for (int j = i + 1; j < arr.length - 2; j++) {
        int left = j + 1;
        int right = arr.length - 1;
        while (left < right) {
          int sum = arr[i] + arr[j] + arr[left] + arr[right];
          if (sum == s) {
            ans[0] = arr[i];
            ans[1] = arr[j];
            ans[2] = arr[left];
            ans[3] = arr[right];
            return ans;
          } else if (sum > s) {
            right--;
          } else {
            left++;
          }
        }
        
      }
    }
    if (ans[0] == 0 && ans[1] == 0 && ans[2] == 0 && ans[3] == 0) {
      int[] empty = {};
      return empty;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] input = {2,7,4,0,9,5,1,3};
    int target = 20;
    int[] output = findArrayQuadruplet(input, target);
    
    for (int i = 0; i < 4; i++) {
      System.out.print(output[i] + " ");
    }
  }

}