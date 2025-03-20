/*In daily share trading, a trader buys shares and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.

You are given an array prices[] representing stock prices throughout the day. Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).*/
class Solution {
    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE , sell1 = 0;
        int buy2 = Integer.MIN_VALUE , sell2 = 0;
        
        for(int price : prices){
            buy1 = Math.max(buy1 , -price);
            sell1 = Math.max(sell1 , buy1 + price);
            buy2 = Math.max(buy2 , sell1 - price);
            sell2 = Math.max(sell2 , buy2 + price);
        }
        return sell2;
    }
}
