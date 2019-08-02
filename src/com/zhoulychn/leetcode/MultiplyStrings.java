package com.zhoulychn.leetcode;

import java.util.Arrays;

/*

给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

解：
首先需要知道一点：两个数字相乘，最后的结果的长度必然小于两者的长度之和。

竖式乘法就是采用的这种思想，相当于将结果整个采用数组的方式存储。

手画了一个简单的图，画的比较粗糙，见谅 ：） 图中结果数组中的第 k 位在哪些情况下会被修改呢？

现在我们假设 num1 当前的位置是 i ，num2 当前的位置是 j 。

那么可以看出：i + j + 1 == k 时第 k 位会被直接修改，同时也可能会进位第 k - 1 位。

具体情况如下：

结果的 第 k 位 上的值就是（原来第 k 位的值 ret[k] + 增量 num1[i] * num2[j] ）之和的余数。
结果的 第 k - 1 位，可能会得到 ret[k] + num1[i] * num2[j] 运算产生的进位。

 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] ret = new char[num1.length() + num2.length()];
        Arrays.fill(ret, '0');

        for (int i = num1.length() - 1; i >= 0; i--) {
            int num1Val = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num2Val = num2.charAt(j) - '0';
                int sum = (ret[i + j + 1] - '0') + num1Val * num2Val;
                ret[i + j + 1] = (char) (sum % 10 + '0');
                ret[i + j] += sum / 10;
            }
        }

        for (int i = 0; i < ret.length; i++) {
            if (ret[i] != '0' || i == ret.length - 1) {
                return new String(ret, i, ret.length - i);
            }
        }
        return "0";
    }
}
