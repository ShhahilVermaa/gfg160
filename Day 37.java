//Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.//

class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        
        for(int i=0;i<n-2;i++)
        {
            int j=i+1,k=n-1;
            while(j<k)
            {
                if(arr[i] + arr[j] + arr[k]<target)j++;
                else if(arr[i]+arr[j]+arr[k]>target)k--;
                else
                {
                    if(j<k && arr[j]==arr[k])
                    {
                        int vv=k-j+1;
                        int p=(vv*(vv-1))/2;
                        count+=p;
                        break;
                    }
                    else
                    {
                        int fv=1,lv=1;
                        while(j+1<k && arr[j]==arr[j+1])
                        {
                            fv++;
                            j++;
                        }
                        while(k-1>j && arr[k]==arr[k-1])
                        {
                            lv++;
                            k--;
                        }
                        int tp = fv*lv;
                        count+=tp;
                        j++;
                        k--;
                    }
                }
            }
        }
        return count;
    }
}
