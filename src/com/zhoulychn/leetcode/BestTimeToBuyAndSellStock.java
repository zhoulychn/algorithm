package com.zhoulychn.leetcode;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 */
public class BestTimeToBuyAndSellStock {


    // 每确定一个最低点，然后向上爬，找到这个最低点的最大利益，有更低点就改为这个更低点
    public int maxProfit(int[] prices) {

        // 记录收益和最小价格
        int profit = 0, min = Integer.MAX_VALUE;

        for (int price : prices) {
            // 重置最小价格
            if (price < min) min = price;

            // 如果最小价格没有变化，说明收益可能增加，判断一下
            else if (price - min > profit) profit = price - min;
        }
        return profit;
    }

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4, 0, 7});
    }
}
