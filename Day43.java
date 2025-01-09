//Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        int n = arr.length;
        if(n<k)
        {
            res.add(0);
            return res;
        }
        for(int i=0;i<n-k+1;i++)
        {
            int l=i;
            int r=k+i-1;
            int c=0;
            ArrayList<Integer>ch=new ArrayList<>();
            while(l<=r)
            {
                if(!ch.contains(arr[l]))
                {
                    ch.add(arr[l]);
                    c++;
                }
                l++;
            }
            res.add(c);
        }
        return res;
    }
}
