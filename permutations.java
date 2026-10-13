import java.util.ArrayList;
import java.util.List;

public class permutations {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(0, nums , new ArrayList<>());
        return result;
    }

    public void helper(int idx , int[] nums , ArrayList<Integer> current) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = idx; i< nums.length; i++) {

            current.add(nums[i]);
            swap(nums, i , idx);
            helper(idx + 1 , nums , current);
            swap(nums, i , idx);

            current.remove(current.size() - 1);

        }

    }

    public void swap(int[] nums, int i , int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }

    public static void main(String[] args) {
        permutations obj = new permutations();
        int[] nums = {1,2,3};

        List<List<Integer>> result = obj.permute(nums);
        System.out.println("result: " + result);
    }
}