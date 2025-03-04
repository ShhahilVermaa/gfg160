/*Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element*/
class Solution {
    static int lis(int arr[]) {
        ArrayList<Integer> lis = new ArrayList<>();
        for(int num : arr){
            int pos = Collections.binarySearch(lis , num);
            if(pos < 0) pos = -(pos + 1);
            if(pos < lis.size()){
                lis.set(pos , num);
            }else{
                lis.add(num);
            }
        }
        return lis.size();
    }
}
