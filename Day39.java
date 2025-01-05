//Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.//
class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer> ans = new ArrayList<>();
        if(arr.length==1)return ans;
        Arrays.sort(arr);
        int a=-1,b=-1;
        int closest=Integer.MAX_VALUE;
        int maxAbs = Integer.MIN_VALUE;
        int l=0;
        int r=arr.length-1;
        while(l<r)
        {
            int sum=arr[l]+arr[r];
            int absDiffWithPair=Math.abs(arr[l]-arr[r]);
            int absDiffWithTarget=Math.abs(target-sum);
            if(absDiffWithTarget<closest || absDiffWithTarget==closest && absDiffWithPair>maxAbs) 
            {
                closest=absDiffWithTarget;
                maxAbs=absDiffWithPair;
                a=arr[l];
                b=arr[r];
            }
            if(sum<target) l++;
            else r--;
        }
        ans.add(a);
        ans.add(b);
        return ans;
    }
}
