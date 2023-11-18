public class Leetcode_744 {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(nextGreaterLetter(arr,target));
    }
    static char nextGreaterLetter(char[] letters, char target){
        int starting=0;
        int ending = letters.length-1;
        while(starting<=ending){
            int mid = starting+(ending-starting)/2;
            if(letters[mid]>target){
                ending = mid-1;
            }
            else{
                starting = mid+1;
            }
        }
        starting = ending+1;
        return letters[starting%letters.length];
    }
}
