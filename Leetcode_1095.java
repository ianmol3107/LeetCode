public class Leetcode_1095 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        int target = 3;
        Leetcode_1095 find = new Leetcode_1095();
        System.out.println(find.findInMountainArray(target,arr));
    }
     int findInMountainArray(int target, int[] mountainArr) {
        int peak = findPeakElement(mountainArr);
        int len = mountainArr.length;
        if(mountainArr[peak]==target){
            return peak;
        }
        int first = OrderAgnostic(mountainArr,target,0,peak);
        if(first!=-1){
            return first;
        }
        return OrderAgnostic(mountainArr,target,peak+1,len-1);
    }

    int findPeakElement(int[] mountainArr) {
        int start=0;
        int end =mountainArr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mountainArr[mid]<mountainArr[mid+1]){
                start=mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
    int OrderAgnostic(int[] mountainArr, int target, int start,int end){
        boolean isAscending = mountainArr[start] < mountainArr[end];
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mountainArr[mid]==target) {
                return mid;
            }
            if(isAscending){
                if(target>mountainArr[mid]){
                    start = mid+1;
                }
                else{
                    end = mid - 1;
                }
            }else{
                if(target<mountainArr[mid]){
                    start = mid+1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
