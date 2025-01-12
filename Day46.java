//Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.

Note: In the case of a single vertical line it will not be able to hold water.
class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        int n = arr.length;
        if(n<2) return 0;
        
        int left = 0 , right = n-1;
        int maxWater = 0;
        
        while(left < right)
        {
            int width = right - left;
            int height = Math.min(arr[left],arr[right]);
            int currentWater = width * height;
            maxWater = Math.max(maxWater,currentWater);
            
            if(arr[left] < arr[right])
            {
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}
