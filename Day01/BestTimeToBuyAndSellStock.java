package Day01;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a
// different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
public class BestTimeToBuyAndSellStock {
    static int maxProfit(int[] prices){
        int lsf = Integer.MAX_VALUE; // Initialize max so far with the initial value of max Integer
        int op = 0; // overall profit initially equals to zero
        int pist = 0; // price if sold today

        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<lsf){
                lsf = prices[i];
            }
            pist = prices[i]-lsf;
            if (pist>op){
                op = pist;
            }
        }
        return op;
    }
}
