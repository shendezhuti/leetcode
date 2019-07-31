package com.DynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BesTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int sold=0;
        int rest=0;
        int hold=Integer.MIN_VALUE;
        for(int price:prices){
            int prev_sold=sold;
            sold=hold+price;
            hold=Math.max(hold,rest-price);
            rest=Math.max(rest,prev_sold);
        }
        return Math.max(sold,rest);
    }

    public int maxProfitII(int []prices){
        int []canbuy=new int[prices.length];
        int []cansell=new int [prices.length];
        int []onlyrest=new int [prices.length];
        canbuy[0]=0;
        cansell[0]=-prices[0];
        onlyrest[0]=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            canbuy[i]=Math.max(canbuy[i-1],onlyrest[i-1]);
            cansell[i]=Math.max(cansell[i-1],canbuy[i-1]-prices[i]);
            onlyrest[i]=cansell[i-1]+prices[i];
        }
        return Math.max(canbuy[prices.length-1],onlyrest[prices.length-1]);
    }
}
