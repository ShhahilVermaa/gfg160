//Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
class Solution {
    public int maxWater(int arr[]) 
    {
     if(arr == null || arr.length == 0) return 0;
     
     int left = 0 , right = arr.length - 1;
     int leftMax = arr[left] , rightMax = arr[right];
     int waterTrapped = 0;
     
     while(left < right)
     {
         if(leftMax < rightMax)
         {
             left++;
             leftMax = Math.max(leftMax , arr[left]);
             waterTrapped += leftMax - arr[left];
         }
         else{
             right--;
             rightMax = Math.max(rightMax , arr[right]);
             waterTrapped += rightMax - arr[right];
         }
     }
     return waterTrapped;
    }
}
