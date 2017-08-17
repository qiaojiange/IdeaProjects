package com.niuke;

/**
 * Created by qiaojiange on 2017/3/23.
 */
class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;
    }

}


public class MainMT5 {

    public static TreeNode1 lastTreeNode = null;

    public TreeNode1 Convert(TreeNode1 pRootOfTree) {
        if (pRootOfTree == null) return null;
        //   TreeNode1 lastTreeNode = null;
        ConvertEx(pRootOfTree);

        while (lastTreeNode != null && lastTreeNode.left != null) {
            lastTreeNode = lastTreeNode.left;
        }
        return lastTreeNode;

    }

    private void ConvertEx(TreeNode1 pRootOfTree) {
//        System.out.println("------------pRootOfTree=" + pRootOfTree.val);
        if (pRootOfTree == null) {
            return;
        }

        TreeNode1 pCurrent = pRootOfTree;

//        转换左子树
        if (pCurrent.left != null) {
            ConvertEx(pCurrent.left);
        }

        pCurrent.left = lastTreeNode;
        if (lastTreeNode != null) {
            lastTreeNode.right = pCurrent;
        }
        lastTreeNode = pCurrent;

        if (pCurrent.right != null) {
            ConvertEx(pCurrent.right);
        }

    }


    public static class Test {
        public static void main(String[] args) {
            TreeNode1 node1 = new TreeNode1(10);
            TreeNode1 node2 = new TreeNode1(6);
            TreeNode1 node3 = new TreeNode1(14);
            TreeNode1 node4 = new TreeNode1(4);
            TreeNode1 node5 = new TreeNode1(8);

            TreeNode1 node6 = new TreeNode1(12);
            TreeNode1 node7 = new TreeNode1(16);

            node1.left = node2;
            node1.right = node3;

            node2.left = node4;
            node2.right = node5;

            node3.left = node6;
            node3.right = node7;


            MainMT5 mainMT5 = new MainMT5();
            TreeNode1 head = mainMT5.Convert(node1);

            while (head != null) {
                System.out.println(head.val);
                head = head.right;
            }

        }

    }

}
