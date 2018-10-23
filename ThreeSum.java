import java.util.*;

class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int complement = 0 - nums[i];
        int lo = i + 1;
        int hi = nums.length - 1;
        while (lo < hi) {
          if (nums[lo] + nums[hi] == complement) {
            result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
            while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
            while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
            lo++;
            hi--;
          } else if (nums[lo] + nums[hi] < complement) {
            lo++;
          } else {
            hi--;
          }
        }
      }
    }
    return result;
  }

}