public class Leetcode_1295 {
    public static void main(String[] args) {
        int[] nums = {12,345,23,6,7896};
        System.out.println(findnumber(nums));
    }
    static int findnumber(int[] nums){
        int count=0;
        for(int num: nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    static boolean even(int num){
        int numberofDigits = digit(num);
        return numberofDigits%2==0;
    }
    static int digit(int num){
        int count=0;
        while(num>0){
            count++;
            num/=10;
        }
        return count;
    }
}
