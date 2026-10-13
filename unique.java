import java.util.*;


public class unique {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        helper(0,nums, new ArrayList<>());
        

        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }

    public void helper(int idx , int[] nums , ArrayList<Integer> current) {
        if(current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            if(i> idx && nums[i] == nums[idx]) continue;


            current.add(nums[i]);
            swap(nums, i , idx);

            helper(idx + 1, nums, current);
            swap(nums , i , idx);
            current.remove(current.size() - 1);
        } 
    }

    public void swap(int[] nums, int i, int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }

    public static void main(String[] args) {
        unique obj = new unique();
        int[] nums = {1,1,2};

        List<List<Integer>> result = obj.permuteUnique(nums);
        System.out.println("result: " + result);
    }
}