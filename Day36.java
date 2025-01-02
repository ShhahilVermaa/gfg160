//Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.//

class Solution {
    public long subarrayXor(int arr[], int k) 
    {
      HashMap<Integer,Integer> xorMap = new HashMap<>();
      int xorSum=0;
      long count=0;
      
      for(int num:arr)
      {
          xorSum^=num;
          
          if(xorSum==k)
          {
              count++;
          }
          
          if(xorMap.containsKey(xorSum ^ k))
          {
              count+=xorMap.get(xorSum ^ k);
          }
          
          xorMap.put(xorSum,xorMap.getOrDefault(xorSum,0)+1);
      }
        return count;
    }
}
