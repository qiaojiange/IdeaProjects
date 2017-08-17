package com.niuke;

import org.junit.Test;

import java.util.*;

import static com.niuke.Util.*;

import static org.junit.Assert.*;

/**
 * Created by qiaojiange on 2017/3/28.
 */
public class SolutionTest {
    public static Solution s = new Solution();








    public void deserializeTest(){
        TreeNode root = s.deserialize("1,2,4,$,$,5,$,$,3,6,$,$,7,$,$,");
        List<Integer> list =  printLevelBinaryTree(root);
//        for (Integer i :list){
//            print(i);
//        }
//        println("-=---list.size="+list.size());
//        for(int i = 0;i<(list.size()-3);i++){
//            println(list.get(i));
//        }

//        print("------------");

    }
    public void serializeTest(){
        TreeNode root = creatBinaryTree("1,2,3,4,5,6,7");
        String str = s.serialize(root);
        print(str);
    }


    public void postorderTraversalTest(){
        TreeNode root = creatBinaryTree("1,2,3,4,5,6,7");
        List<Integer> list = s.postorderTraversal(root);
        for(Integer in : list){
            print(in);
        }

    }

    public void inorderTraversalTest(){
        TreeNode root = creatBinaryTree("1,2,3,4,5,6,7");
        List<Integer> list = s.inorderTraversal(root);
        for(Integer in : list){
            print(in);
        }

    }


    public void preorderTraversalTest(){
        TreeNode root = creatBinaryTree("1,2,3,4,5,6,7");
        List<Integer> list = s.preorderTraversal(root);
        for(Integer in :list){
            print(in);
        }
    }

    public void StrToInt(){
        String s = null;
        if ("".equals(s)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    public void EntryNodeOfLoop(){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(7);
        ListNode p8 = new ListNode(8);
        ListNode p9 = new ListNode(9);


        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        p8.next = p9;
        p9.next = p4;

        ListNode res = s.EntryNodeOfLoop(p1);
        System.out.println(res);
    }

//    public void getMiddleNum(){
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            int num = random.nextInt(100);
//            s.Insert(num);
//            System.out.println("num :"+s.GetMedian());
//        }
//    }

    public void maxInWindows(){
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        int size = 3;
//        s.maxInWindows()
        List<Integer> list = s.maxInWindows(num,size);
        for(Integer i:list){
            print(i);
        }
    }

    public void deleteDuplication(){
//        ListNode pHead = Util.creatList("1,2,3,3,3,5,5,6,6,7");
//        ListNode pHead = Util.creatList("1,1,1,2,2,2,3,3,3,5,5,6,6,7");
        ListNode pHead = Util.creatList("1,1,1,2,2,2,3,3,3,4,5,5,6,6,7");
        ListNode pHead1 =  s.deleteDuplication2(pHead);
        Util.printList(pHead1);
    }

    public void getCubeRoot(){
        System.out.println(s.getCubeRoot(27));
    }

    public void newTon(){
        System.out.println(s.newTon(216));
    }

    public void ReverseSentence(){
        String str = "student. a am I";

        char[] chs = new char[]{'a','b','c'};

        StringBuilder sb = new StringBuilder(str);
        String res = s.ReverseSentence(str);
        System.out.println(res);
    }

    public void GetNumberOfK(){
        int[] nums = new int[]{1,2,3,3,3,3,5};
//        int k = 3;
//        int k = 4;
        int k = 2;
        System.out.println(s.GetNumberOfK(nums,k));

    }

    public void Permutation(){
        String  str = "abc";
        ArrayList<String> list = s.Permutation(str);
        for(String s:list){
            System.out.println(s);
        }

    }

    public void PrintMinNumber(){
//        int[] nums = new int[]{3,32,321};
//        int[] nums = new int[]{1,2,5,6,11,34};
        int[] nums = new int[]{7,6,9,12,4,200,54};

        //Arrays.sort(nums);
        List<Integer> list= new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        Collections.sort(list,new Comparator<Integer>(){
           public int compare(Integer o1 ,Integer o2){
               if(o1 > o2){
                   return 1;
               }else if(o1 == o2){
                   return 0;
               }
               return -1;
           }
        });

        for(int i :list){
            System.out.println(i);
        }

       // System.out.println(s.PrintMinNumber(nums));
    }

    public void GetLeastNumbers_Solution(){
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = s.GetLeastNumbers_Solution(input,4);
        for(Integer in:list){
            println(in);
        }

    }


    public void Clone(){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node2.random = node4;

        RandomListNode head1 = s.Clone(node1);
        RandomListNode curr = head1;
        while (curr!=null){
            println(curr.label);
            curr = curr.next;
        }

    }

    public void FindNumsAppearOnce(){
        int[] array = new int[]{5,7,7,4,4,6};
        int[] nums1 = new int[1];
        int[] nums2 = new int[1];
        s.FindNumsAppearOnce(array,nums1,nums2);
        System.out.println(nums1[0]);
        System.out.println(nums2[0]);
    }

    public void FindFirstCommonNode(){
//        ListNode head1 = creatList("1,2,3,4,5,6");
//        ListNode head2 = creatList("1,2,3");
//        ListNode curr = head1;
//        curr = curr.next;
//        curr = curr.next;

    }

    public void hasPath(){
//        char[] matrix = "ABCESFCSADEE".toCharArray();
//        char[] str = "ABCCED".toCharArray();

//        char[] matrix = "ABCESFCSADEE".toCharArray();
//        char[] str = "ABCB".toCharArray();

 char[] matrix = "A".toCharArray();
        char[] str = "A".toCharArray();
        println(s.hasPath(matrix,3,4,str));
    }

    public void NumberOf1(){
//        println(s.NumberOf1(-2147483648));
//        println(s.NumberOf1(-214748365));
//        println(s.NumberOf1(-5));
        println(s.NumberOf1(-1));
    }

    public void VerifySquenceOfBST(){
//        int[] array = new int[]{2,4,4,6,9,8,5};
//        int[] array = new int[]{4,6,9,8,5};
//        int[] array = new int[]{6,6,9,8,5};
//        int[] array = new int[]{6,6,6,6,5};
        int[] array = new int[]{6,4,3,6,5};
        println(s.VerifySquenceOfBST(array));
    }

    public void reOrderArray() {
        int[] array = new int[]{1,2,3,4,5,6,7};
        s.reOrderArray(array);

        println(array);
    }

    public void FindKthToTail(){
        ListNode head = creatList("1,2,3,4,5,6");
        ListNode node = s.FindKthToTail(head,3);
        if(node!=null){
            println(node.val);
        }


    }


    public void FindPath(){
//        TreeNode root = creatBinaryTree("1,2,3,4,5,3,7");
//        ArrayList<ArrayList<Integer>> pathList = s.FindPath(root,7);

        TreeNode root = creatBinaryTree("1");
        ArrayList<ArrayList<Integer>> pathList = s.FindPath(root,1);
        for (ArrayList<Integer> path:pathList){
            for(Integer in:path){
                print(in+" ");
            }
            println();
        }

    }

    public void printMatrix(){
        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix= new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
//        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8}};
//        int[][] matrix= new int[][]{{1}};
//        int[][] matrix= new int[][]{{1,2,3,4,5}};
//        int[][] matrix= new int[][]{{1},{2},{3},{4},{5}};

        ArrayList<Integer> list = s.printMatrix(matrix);

        for(Integer in:list){
            println(in+" ");
        }
    }


    @Test
    public void printMatrix1(){
//        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8}};
//        int[][] matrix= new int[][]{{1}};
//        int[][] matrix= new int[][]{{1,2,3,4,5}};
//        int[][] matrix= new int[][]{{1},{2},{3},{4},{5}};

        ArrayList<Integer> list = s.printMatrix(matrix);

        for(Integer in:list){
            println(in+" ");
        }
    }

    @Test
    public void printMatrix2(){
//        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8}};
//        int[][] matrix= new int[][]{{1}};
        int[][] matrix= new int[][]{{1,2,3,4,5}};
//        int[][] matrix= new int[][]{{1},{2},{3},{4},{5}};

        ArrayList<Integer> list = s.printMatrix(matrix);

        for(Integer in:list){
            println(in+" ");
        }

    }

    @Test
    public void printMatrix3(){
//        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8}};
        int[][] matrix= new int[][]{{1}};
//        int[][] matrix= new int[][]{{1,2,3,4,5}};
//        int[][] matrix= new int[][]{{1},{2},{3},{4},{5}};

        ArrayList<Integer> list = s.printMatrix(matrix);

        for(Integer in:list){
            println(in+" ");
        }
    }

    @Test
    public void printMatrix4(){

//        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix= new int[][]{{1,2,3,4},{5,6,7,8}};
//        int[][] matrix= new int[][]{{1}};
//        int[][] matrix= new int[][]{{1,2,3,4,5}};

        int[][] matrix= new int[][]{{1},{2},{3},{4},{5}};

        ArrayList<Integer> list = s.printMatrix(matrix);

        for(Integer in:list){
            println(in+" ");
        }

    }

    @Test
    public void quickSort(){
        int[] array = new int[]{2,3,4,2,4,1};
//        int[] array = new int[]{5,2,2,3,10,7,13,6,7,0};
        s.quickSort(array,0,array.length-1);
        println(array);
    }

    public void InversePairs() {
//        int[] array = new int[]{1,2,3,4,5,6,7,0};
        int[] array = new int[]{5,2,2,3,10,7,13,6,7,0};

        s.mergeSort(array,0,array.length-1);
        println(array);

//        int[] array = new int[]{1,0,5,4,2,7,3};
//        int[] array = new int[]{1,0};
////        int res = s.InversePairs(array);
//        printArray(array);
//        println(res);
    }

    public void TreeDepth() {
//        TreeNode root = creatBinaryTree("1,2,3,null,null,4");
        TreeNode root = creatBinaryTree("1,2,null,3");
        println(s.TreeDepth(root));
    }

    public void GetNext() {

        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);

        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;
        t2.next = root;

        t3.left = t6;
        t3.next = root;


        t4.next = t2;
        t5.next = t2;

        t6.next = t3;

        println(t3);


    }

    public void HasSubtree() {
        TreeNode root1 = creatBinaryTree("1,2,3,4,5");
        TreeNode root2 = creatBinaryTree("2,null,5");
//        TreeNode root2 = creatBinaryTree("2,4");
//        TreeNode root2 = creatBinaryTree("1,2");
        println(s.HasSubtree(root1, root2));

    }

    public void Merge() {
        ListNode list1 = creatList("1,4,6,8");
        ListNode list2 = creatList("1,2,3,5,10");

        ListNode head = s.Merge(list1, list2);
        ListNode curr = head;
        while (curr != null) {
            println(curr.val);
            curr = curr.next;
        }
    }

    public void getLastCommonParent() throws Exception {
        TreeNode root = creatBinaryTree("1,2,3,4,5,null,null,6,7,8,9");

        TreeNode node1 = getTreeNode(root, 7);
        println(node1);
        TreeNode node2 = getTreeNode(root, 1);
        println(node2);

        TreeNode node3 = s.getLastCommonParent(root, node1, node2);
        println(node3);
    }

}