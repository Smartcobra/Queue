public class FirstNegativeIntegerEveryWindowSizeK {
/*
    Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray) of size k.
    If a window does not contain a negative integer, then print 0 for that window.

    Examples:

    Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
    Output : -8 0 -6 -6
    First negative integer for each window of size k
    {-8, 2} = -8
    {2, 3} = 0 (does not contain a negative integer)
    {3, -6} = -6
    {-6, 10} = -6

    Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
    Output : -1 -1 -7 -15 -15 0


 */
   public static void findFirstNegativeNumber(int arr[],int k){

       int length=arr.length;
       boolean flag = false;
       for(int i=0;i<length-k+1;i++){
           for(int j=0;j<k;j++){
               if(arr[i+j] <0){
                   System.out.print(arr[i+j]+" ");
                   flag=true;
                   break;
               }
           }
       }
       if(flag){
           System.out.print("0");
       }

   }

    public static void main(String[] args) {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        findFirstNegativeNumber(arr,k);

    }


}
