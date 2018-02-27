package com.zhoulychn;


import com.zhoulychn.BaseBean.Tree.TreeNode;
import com.zhoulychn.LintCode.Num_7;
import com.zhoulychn.Utils.TreeUtils;

public class Application {

    public static void main(String[] args) throws Exception {
        TreeNode node = new TreeNode();
        TreeUtils.createByScan(node);
        System.out.println(Num_7.serialize(node));
    }
}
