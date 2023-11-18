import java.util.Arrays;

public class Leetcode_34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Leetcode_34 SearchRange = new Leetcode_34();
        System.out.println(Arrays.toString(SearchRange.searchRange(nums, target)));

    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = Searching(nums,target,true);
        int end = Searching(nums,target,false);
        ans[0]=start;
        ans[1]=end;
        return ans;

    }
    int Searching(int[] arr, int target, boolean FindIndex){
        int ans = -1;
        int starting,ending;
        starting=0;
        ending = arr.length-1;
        while(starting<=ending){
            int mid = starting+(ending-starting)/2;
            if(arr[mid]>target){
                ending = mid-1;
            }
            else if(arr[mid]<target){
                starting = mid+1;
            }
            else {
                ans =  mid;
                if (FindIndex) {
                    ending = mid-1;
                }
                else{
                    starting = mid+1;
                }
            }
        }
        return ans;
    }
}
