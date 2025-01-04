//Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.//

import java.util.Arrays;
class Solution {
    int countPairs(int arr[], int target)
    {
        Arrays.sort(arr);
        int count=0;
        int left=0;
        int right=arr.length-1;
        
        while(left<right)
        {
            if(arr[left] + arr[right] < target)
            {
                count+=right-left;
                left++;
            }
            else{
                right--;
            }
        }
            return count;
       
    }
}
