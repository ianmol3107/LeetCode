public class Leetcode_33 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(FindPivot(arr));
    }
    static int search(int[] nums, int target){
        int pivot = FindPivot(nums);
        // if did not find pivot then normal do binary search
        if(pivot==-1){
            return BinSearch(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        if (nums[0] <= target) {
            return BinSearch(nums,target,0,pivot-1);
        }
        else{
            return BinSearch(nums,target,pivot+1,nums.length-1);
        }
    }

    static int BinSearch(int[] arr, int target,int starting,int ending){
        while(starting<=ending){
            int mid = starting+(ending-starting)/2;
            if(target>arr[mid]){
                starting = mid+1;
            }
            else if(target<arr[mid]){
                ending = mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    static int FindPivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            // 4 Conditions
            // 1st Condition :- if the (mid) element is greater then (mid+1) element
            if(arr[mid]>arr[mid+1]){
                return mid;
            }
            // 2nd condition:- if the (mid) element is less then (mid-1) element
            if(arr[mid]<arr[mid-1]){
                return mid-1;
            }
            // 3rd condition:- if the (mid) element is less then (start) element
            else if (arr[mid]<=arr[start]) {
                end = mid-1;
            }
            // 4th condition:- if the (mid) element is greater then (start) element
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
