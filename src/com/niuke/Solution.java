package com.niuke;


import com.arigothem.MapEntry;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.bind.InternalAccessorFactory;
import com.sun.xml.internal.bind.marshaller.MinimumEscapeHandler;
import sun.reflect.generics.tree.Tree;

import java.beans.Statement;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Created by qiaojiange on 2017/3/28.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {

    public int partion(int[] nums,int start,int end){
        int key = nums[start];
        int low= start;
        int hight = end;
        while(low<hight){
            while(low<hight && nums[hight]>=key){
                hight--;
            }
            swape(nums, low, hight);
            while(low<hight && nums[low]<=key){
                low++;
            }
            swape(nums, low, hight);
        }
        return low--;
    }

    private void swape(int[] nums, int low, int hight) {
        int tmp;
        tmp = nums[hight];
        nums[hight] = nums[low];
        nums[low] = tmp;
    }

    public void quickSort(int[] nums,int start,int end){
        if(start <end){
            int mid = partion(nums,start,end);
            quickSort(nums,start,mid);
            quickSort(nums,mid+1,end);
        }

    }



    public void add(int[] in){
        in[0]++;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("$,");
            return sb.toString();
        }

        sb.append(root.val+",");
        serialize(root.left,sb);
        serialize(root.right,sb);


        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append("$,");
            return ;
        }

        sb.append(root.val+",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }
//    private int count = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        if(strs[0].equals("$")){
            return null;
        }

        int[] count = new int[]{0};
        TreeNode root = new TreeNode(Integer.parseInt(strs[count[0]++]));
        root.left = deserialize(strs,count);
        root.right = deserialize(strs,count);
        return root;
    }

    private TreeNode deserialize(String[] strs, int[] count) {
        if(strs[count[0]].equals("$") || count[0]==strs.length){
            count[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[count[0]++]));
        root.left = deserialize(strs,count);
        root.right = deserialize(strs,count);
        return root;



    }

//    private TreeNode deserialize(String[] strs) {
//        if(strs[count].equals("$") || count==strs.length){
//            count++;
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(strs[count++]));
//        root.left = deserialize(strs);
//        root.right = deserialize(strs);
//        return root;
//    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root!=null){
            return res;
        }
        q.add(root);
        int count =1;
        int nextCount = 0;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty() ){
            TreeNode head = q.poll();
            list.add(head.val);
            count--;

            if(head.left!=null){
                q.add(head.left);
                ++nextCount;
            }

            if(null != head.right){
                q.add(head.right);
                ++nextCount;
            }

            if(count == 0){
                res.add(list);
                list = new ArrayList<>();
                count = nextCount;
                nextCount = 0;
            }

        }

        return res;

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode top = s1.pop();
            s2.push(top.val);
            if(top.left!=null){
                s1.push(top.left);
            }

            if(top.right != null){
                s1.push(top.right);
            }
        }

        while(!s2.isEmpty()){
            res.add(s2.pop());
        }
        return res;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        inorderTraversal(list,root);

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                list.add(top.val);
                root = top.right;
            }

        }

        return list;
    }

    public void inorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            inorderTraversal(list, root.left);
        }

        list.add(root.val);

        if (root.right != null) {
            inorderTraversal(list, root.right);
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        preorderTraversal(list,root);
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            list.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }


        return list;
    }
//    public void preorderTraversal(List<Integer> list,TreeNode root){
//        if(root==null){
//            return;
//        }
//
//        list.add(root.val);
//        if(root.left!=null){
//            preorderTraversal(list,root.left);
//        }
//        if(root.right != null){
//            preorderTraversal(list,root.right);
//        }
//    }


    public int StrToInt(String str) {
        if ("".equals(str)) {
            System.out.println("---null");
        }
        boolean isSign = true;
        char[] chs = str.toCharArray();
        int index = 0;
        if (chs[0] == '-') {
            isSign = false;
            index++;
        }
        if (chs[0] == '+') {
            isSign = true;
            index++;
        }
        int num = 0;
        for (int i = index; i < chs.length; i++) {
            char ch = chs[i];
            if (ch > '9' || ch < '0') {
                return 0;
            } else {
                num = num * 10 + (ch - '0');
            }

        }
        if (num == 0) return 0;
        return isSign ? num : -num;
    }


    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> map = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();


    public void Insert(char ch) {
        sb.append(ch);
        if (map.get(ch) == null) {
            map.put(ch, 1);
            queue.add(ch);
        } else {
            map.put(ch, map.get(ch) + 1);
        }
    }

    public char FirstAppearingOnce() {
//        String s = sb.toString();
//        for(int i = 0;i<s.length();i++){
//            char ch = s.charAt(i);
//            if (map.get(ch) == 1){
//                return ch;
//            }
//        }
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '#';
    }


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        ListNode meet = null;
        //求出在环中的交点
        while (fast != null && slow != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        meet = fast;
        ListNode p = pHead;
        while (p != meet) {
            p = p.next;
            meet = meet.next;
        }

        return p;
    }


//    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o2-o1;
//        }
//    });
//
//    private int count = 0;
//    public void Insert(Integer num) {
//        ++count;
////        if( (count&0x01)==1){
//
////           1.先放入到最小堆
////            minHeap.add(num);
////        System.out.println("num = " +num);
//            minHeap.offer(num);
//        System.out.println("size ="+minHeap.size());
//            if(  (minHeap.size()-maxHeap.size())>1 ){
//                int temp = minHeap.poll();
//                maxHeap.add(temp);
//            }
//
//            if ( !minHeap.isEmpty() && !maxHeap.isEmpty() &&  (minHeap.peek() < maxHeap.peek()) ){
//                int temp = minHeap.poll();
//                maxHeap.add(temp);
//                temp = maxHeap.poll();
//                minHeap.add(temp);
//            }
////        }
//
//    }
//
////    1.保证两个堆之间的长度差为1；
////    2.保证最小堆和最大堆中，最大堆中的所有数据都要小于最小堆中的数据。
//    public Double GetMedian() {
//        if (count == 0) {
//            try{
//                throw new Exception("No number are available!");
//            }catch (Exception e){
//                System.out.println("Caught inside demoproc");
//
//            }
//        }
//
//        double res = 0.0;
//
//        if ( (count & 0x01) == 1){
//            if (minHeap.isEmpty() ){
//                System.out.println("count:"+count);
//                return 0.0;
//            }
//            res = minHeap.peek();
//            return res;
//        }else{
//
//            res += minHeap.peek();
//            res += maxHeap.peek();
//            return res/2;
//        }
//    }


    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        if (num.length < size) {
            return res;
        }

        for (int i = 0; i < size; ++i) {
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = size; i < num.length; ++i) {
            res.add(num[deque.peekFirst()]);
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.removeLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= (i - size)) {
                deque.removeFirst();
            }

            deque.addLast(i);
        }
        res.add(num[deque.peekFirst()]);

        return res;
    }


    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode head = new ListNode(-100);
        head.next = pHead;
        ListNode pre = head;
        ListNode curr = head.next;

        while (curr != null) {

            while (curr.next != null && curr.next.val == curr.val) {
                curr = curr.next;
            }

            if (pre.next != curr) {
                curr = curr.next;
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }

        return head.next;
    }


    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode pre = null;
        ListNode curr = pHead;
        pHead = null;
        while (curr != null) {
            ListNode post = curr.next;
            boolean needDelete = false;
            if (post != null && post.val == curr.val) {
                needDelete = true;
            }

            if (!needDelete) {
                pre = curr;
                curr = curr.next;
                if (null == pHead) {
                    pHead = pre;
                }
            } else {
                int value = curr.val;
                ListNode toBeDel = curr;
                while (toBeDel != null && toBeDel.val == value) {
                    post = toBeDel.next;
                    toBeDel = post;
                }

                if (pre == null) {
                    pre = post;
                    if (null == pHead) {
                        pHead = pre;
                    }
                } else {
                    pre.next = post;
                }
                curr = post;
            }
        }
        return pHead;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode curr = pHead;
        while (curr != null) {
            if (!map.containsKey(curr.val)) {
                map.put(curr.val, 1);
            } else {
                map.put(curr.val, map.get(curr.val) + 1);
            }
            curr = curr.next;
        }


        ListNode pre = null;
        ListNode currTemp = null;
        curr = pHead;
        pHead = null;

        while (curr != null) {
            if (map.get(curr.val) == 1) {
                currTemp = new ListNode(curr.val);
                if (pHead == null) {
                    pHead = currTemp;
                    pre = currTemp;
                } else {
                    pre.next = currTemp;
                    pre = currTemp;
                }
            }
            curr = curr.next;
        }

        return pHead;
    }

    public double getCubeRoot(double input) {
        double nextX = 0;
        double currX = input;

        double precision = 0.0;
        if (input == 0) {
            return 0;
        }
        do {

            nextX = (2 * currX + input / squa(currX)) / 3;
            precision = cube(nextX) > input ? cube(nextX) - input : input - cube(nextX);
            currX = nextX;
        } while (precision > 0.0001);

        return currX;
    }

    public double cube(double x) {
        return x * x * x;
    }

    public double squa(double x) {
        return x * x;
    }

    public double newTon(double stuff) {
        double currX, nextX;
        double cubeX;

        double squareX;
        boolean flag = false;

        double precision = 0.00001;
        currX = stuff;
        if (stuff == 0) {
            return stuff;
        } else {

            do {
                squareX = currX * currX;
                nextX = (2 * currX + stuff / squareX) / 3;
                System.out.println("nextX = " + nextX);
                cubeX = nextX * nextX * nextX;
                if ((cubeX - stuff < precision) && (cubeX - stuff > -precision)) {
                    flag = true;
                } else {
                    flag = false;
                    currX = nextX;
                }
            } while (flag == false);

        }
        return nextX;

    }

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return "";
        if (str.trim().equals("")) return str;
        char[] chs = new char[]{'a', 'b', 'c'};
        System.out.println(chs.toString());


        StringBuilder sb = new StringBuilder(str);

        String newStr = sb.reverse().toString();
        String[] strs = newStr.split(" ");
        sb = new StringBuilder();
        for (String s : strs) {
            s = reverse(s);
            sb.append(s + " ");
        }

        return sb.toString().trim();
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }


    public int GetNumberOfK(int[] array, int k) {
        if ((array == null) || (array.length == 0)) return 0;

        if (k > array[array.length - 1] || k < array[0]) {
            return 0;
        }

        int firstIndex = getFirstIndex(array, k);
        System.out.println("firstIndex:" + firstIndex);
        int lastIndex = getLastIndex(array, k);
        System.out.println("lastIndex:" + lastIndex);
        return lastIndex - firstIndex;

    }

    public int getFirstIndex(int[] array, int k) {
        System.out.println("getFirstIndex");
        int low = 0;
        int high = array.length - 1;


        while (low <= high) {
            int mid = (low + high) >> 1;
            System.out.println("mid:" + mid + " low:" + low + " high:" + high);

            if (array[mid] >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int getLastIndex(int[] array, int k) {
        System.out.println("getLastIndex");
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            System.out.println("mid:" + mid + " low:" + low + " high:" + high);

            if (array[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public ArrayList<String> Permutation(String str) {
        Set<String> set = new HashSet<>();


        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            char ch = chs[0];
            chs[0] = chs[i];
            chs[i] = ch;

            set.add(beString(chs));

            Permutation(chs, 1, set);

            ch = chs[0];
            chs[0] = chs[i];
            chs[i] = ch;
        }

        ArrayList<String> list = new ArrayList<>(set);
        return list;
    }

    private String beString(char[] chs) {
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            sb.append(ch);
        }
        return sb.toString();

    }

    private void Permutation(char[] chs, int start, Set<String> set) {
        if (start >= chs.length) {
            return;
        }

        for (int i = start + 1; i < chs.length; ++i) {
            char ch = chs[start];
            chs[start] = chs[i];
            chs[i] = ch;

            set.add(beString(chs));
            Permutation(chs, start + 1, set);

            ch = chs[start];
            chs[start] = chs[i];
            chs[i] = ch;

        }


    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return null;
        List<String> list = new ArrayList<>();
        for (int i : numbers) {
            list.add("" + i);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String strTemp1 = o1 + o2;
                String strTemp2 = o2 + o1;

                int num1 = Integer.parseInt(strTemp1);
                int num2 = Integer.parseInt(strTemp2);

                if (num1 > num2) {
                    return 1;
                } else if (num1 == num2) {
                    return 0;
                }
                return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
//        Collections.sort(list,new Comparator<String>(){
//            public int compare(String str1,String str2){
//
//            }
//        });

    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (input == null || k > input.length || k <= 0) {
            return list;
        }
        Map<Integer, Integer> map;

//        最大优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < input.length; i++) {
//            queue.add(input[i]);
            if (queue.size() < k) {
                queue.add(input[i]);
            }

            if (queue.size() == k) {

                if (queue.peek() > input[i]) {
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        for (Integer in : queue) {
            list.add(in);

        }
        return list;

    }


    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode head1;

        head1 = pHead;

        RandomListNode curr = head1;
        RandomListNode post = null;
        RandomListNode newNode = null;
        while (curr != null) {
            post = curr.next;
            newNode = new RandomListNode(curr.label);
            curr.next = newNode;
            newNode.next = post;
            curr = post;
        }

//        RandomListNode head2;
        RandomListNode curr1 = head1;
        RandomListNode head2 = curr1.next;
        RandomListNode curr2 = head2;

        while (curr1 != null) {
            if (curr1.random != null) {
                curr2.random = curr1.random.next;
            }

            if (curr1.next != null) {
                curr1 = curr1.next.next;
            }
            if (curr2.next != null) {
                curr2 = curr2.next.next;
            }
        }


        curr1 = head1;
        curr2 = head2;
        //分离
        while (curr2.next != null) {
            post = curr2.next;

            curr2.next = post.next;
            curr1.next = post;

            curr2 = curr2.next;
            curr1 = curr1.next;
        }

        curr1.next = null;

        return head2;
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);


        ListNode curr1 = pHead1;
        ListNode curr2 = pHead2;

        if (len1 > len2) {
            int k = len1 - len2;
            int count = 0;
            // curr1= pHead1;
            while (count < k) {
                curr1 = curr1.next;
                count++;
            }

        } else {
            int k = len2 - len1;
            int count = 0;
            // curr2 = pHead2;
            while (count < k) {
                curr2 = curr2.next;
                count++;
            }

        }

        while (curr1 != null && curr2 != null && curr1.val != curr2.val) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;


    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length == 1 || num1 == null || num2 == null) {
            return;
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res ^= array[i];
        }
//        System.out.println("res = "+res);
        int firstIndex = getFirst1(res);

        for (int i = 0; i < array.length; i++) {
            if (isBit1(firstIndex, array[i])) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

    private boolean isBit1(int firstIndex, int num) {
        int i = 1 << (firstIndex - 1);

        if ((num & i) == 0) {
            return false;
        } else {
            return true;
        }

    }

    //从1开始的
    private int getFirst1(int res) {
        int i = 1;
        int index = 1;
        while ((res & i) == 0) {
            i = i << 1;
            index++;
        }
        return index;
    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int strIndex = 0;
        boolean[][] flag = new boolean[rows][cols];

//        boolean isFind = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i * cols + j] == str[strIndex]) {
                    if (findRound(matrix, rows, cols, str, strIndex, flag, i, j)) return true;
                }
            }
        }

        return false;
    }

    private boolean findRound(char[] matrix, int rows, int cols, char[] str, int strIndex, boolean[][] flag, int i, int j) {
        if ((strIndex + 1) == str.length && matrix[i * cols + j] == str[strIndex] && !flag[i][j]) {
            return true;
        }

        flag[i][j] = true;
        if (hasPath(matrix, rows, cols, str, flag, i + 1, j, strIndex + 1)) {
            return true;
        }

        if (hasPath(matrix, rows, cols, str, flag, i - 1, j, strIndex + 1)) {
            return true;
        }

        if (hasPath(matrix, rows, cols, str, flag, i, j + 1, strIndex + 1)) {
            return true;
        }

        if (hasPath(matrix, rows, cols, str, flag, i, j - 1, strIndex + 1)) {
            return true;
        }

        flag[i][j] = false;
        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, char[] str, boolean[][] flag, int i, int j, int strIndex) {
//        System.out.println("----hasPath----i="+i+"---------j="+j+"------strIndex="+strIndex);
//        if (i == 1 && j==2){
//            System.out.println("---------key----");
//        }

        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }

        if ((strIndex + 1) == str.length && matrix[i * cols + j] == str[strIndex] && !flag[i][j]) {
            return true;
        }

        if (matrix[i * cols + j] == str[strIndex] && !flag[i][j]) {
            if (findRound(matrix, rows, cols, str, strIndex, flag, i, j)) return true;
        }
        return false;
    }


    public int NumberOf1(int n) {
        String str = "";
        str = String.format("---1--%x", n);
        System.out.println(str);
        if (n == 0x80000000) {
            return 1;
        }
        if (n < 0) {
            n = -n;
        }
        str = String.format("---2--%x", n);
        System.out.println(str);

        int count = 0;
        while (n > 0) {
            System.out.printf("---------%x\n", n);
            n = n & (n - 1);
            count++;
        }
        return count;
    }


    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        int end = sequence.length - 1;
        int midIndex = -1;//表示分割的中间索引
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] < sequence[end]) {
                midIndex = i;
            } else {
                break;
            }
        }


        if (midIndex == -1) {
            for (int i = 0; i < end; i++) {
                if (sequence[i] < sequence[end]) {
                    return false;
                }
            }
            return VerifySquenceOfBST(sequence, 0, end - 1);
        }

//        System.out.println("---midIndex--" + midIndex);
        for (int j = midIndex + 1; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }

        return VerifySquenceOfBST(sequence, 0, midIndex) && VerifySquenceOfBST(sequence, midIndex + 1, sequence.length - 1);

    }

    private boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }

        //进行分割
        int midIndex = -1;
        for (int i = start; i < end; i++) {
            if (sequence[i] < sequence[end]) {
                midIndex = i;
            } else {
                break;
            }
        }

//        System.out.println("---midIndex--" + midIndex);
        if (midIndex == -1) {
            for (int i = start; i < end; i++) {
                if (sequence[i] < sequence[end]) {
                    return false;
                }
            }
            return VerifySquenceOfBST(sequence, start, end - 1);
        }
        //判断后半部分
        for (int j = midIndex + 1; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }

        return VerifySquenceOfBST(sequence, start, midIndex) && VerifySquenceOfBST(sequence, midIndex + 1, end);
    }


    public void reOrderArray(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0x01) == 1) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }

        int i;
        for (i = 0; i < list1.size(); i++) {
            array[i] = list1.get(i);
        }

        for (int j = 0; j < list2.size(); j++, i++) {
            array[i] = list2.get(j);
        }
    }


    public ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0 || head == null) return null;
        if (k > getLength(head)) {
            return null;
        }

        ListNode curr = head;


        int count = 1;
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }


        ListNode fast = curr;
        curr = head;

        while (fast.next != null) {
            fast = fast.next;
            curr = curr.next;
        }

        return curr;
    }

    private int getLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();

        if (root == null) {
            return pathList;
        }
        ArrayList<TreeNode> path = new ArrayList<>();
//        path.add(root);
        FindPath(path, root, target, pathList);
        return pathList;
    }

    private boolean FindPath(ArrayList<TreeNode> path, TreeNode root, int target, ArrayList<ArrayList<Integer>> pathList) {
        if (target == root.val && root.left == null && root.right == null) {//到叶子节点
            path.add(root);
            ArrayList<Integer> list = new ArrayList<>();
            for (TreeNode e : path) {
                list.add(e.val);
            }
            pathList.add(list);
            return true;
        }
        path.add(root);
        if (root.left != null) {
            FindPath(path, root.left, target - root.val, pathList);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            FindPath(path, root.right, target - root.val, pathList);
            path.remove(path.size() - 1);
        }

        return false;
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || (matrix.length == 0 && matrix[0].length == 0)) {
            return list;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        while (rows > 2 * start && cols > 2 * start) {
            printCircle(start, rows, cols, matrix, list);
            start++;
        }
        return list;
    }

    private void printCircle(int start, int rows, int cols, int[][] matrix, ArrayList<Integer> list) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

//        从左向右
        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }

//        从上向下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }

//        从右向左,保证至少两行两列
        if (endX > start && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);
            }
        }

//从下向上，至少三行两列
        if (endX > start && start < (endY - 1)) {
            for (int i = endY - 1; i > start; i--) {
                list.add(matrix[i][start]);
            }
        }
    }


//    private void printCircle(int start, int rows, int cols, int[][] matrix, ArrayList<Integer> list) {
//        int endColIndex = start;
//        int endRowIndex = start;
////        从左到右
//        for (endColIndex = start; endColIndex < cols-start; endColIndex++) {
//            list.add(matrix[start][endColIndex]);
//        }
////        从上到下
//        if (rows > start) {
//            endColIndex--;
//
//            for (endRowIndex = start + 1; endRowIndex < rows-start; endRowIndex++) {
//                list.add(matrix[endRowIndex][endColIndex]);
//            }
//            endRowIndex--;
//        }
//
////        从右向左,至少两行两列
//        if (rows > start && cols > start) {
//            endColIndex--;
//            for (; endColIndex >= start; endColIndex--) {
//                list.add(matrix[endRowIndex][endColIndex]);
//            }
//        }
//
////        从下向上打印
//        if (rows > 2 && cols > start) {
////          endColIndex = start;
//            endRowIndex--;
//            for (; endRowIndex > start; endRowIndex--) {
//                list.add(matrix[endRowIndex][start]);
//            }
//        }
//
//    }


//    public ArrayList<Integer> printMatrix(int[][] matrix) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        if (matrix == null || matrix.length == 0) {
//            return list;
//        }
//
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//        if (rowLen==1 && colLen==1){
//            list.add(matrix[0][0]);
//        }else if (rowLen == 1 || colLen == 1) {
//            if (rowLen == 1) {
//                for (int i = 0; i < colLen; i++) {
//                    list.add(matrix[0][i]);
//                }
//            }
//            if (colLen == 1) {
//                for (int i = 0; i < rowLen; i++) {
//                    list.add(matrix[i][0]);
//                }
//            }
//
//        } else {
////            int maxLen = rowLen>colLen?rowLen:colLen;
//
//            for (int i = 0; i < rowLen / 2; i++) {
////            for(int j = 0;j<colLen/2;j++){
//////                printCircle(i,j,len,list,matrix);
////            }
//
//                printCircle(i, i, rowLen, colLen, list, matrix);
//            }
//        }
//        return list;
//    }
//
//    private void printCircle(int rowIndex, int colIndex, int rowLen, int colLen, ArrayList<Integer> list, int[][] matrix) {
////        从左向右打印
//        for (int i = colIndex; i < (colLen - 1 - colIndex); i++) {
//            list.add(matrix[rowIndex][i]);
//        }
//
////       从上到下遍历
//        for (int i = rowIndex; i < (rowLen - 1 - rowIndex); i++) {
//            list.add(matrix[i][colLen - 1 - rowIndex]);
//        }
//
////        从右到左遍历
//        for (int i = colLen - 1 - rowIndex; i > rowIndex; i--) {
//            list.add(matrix[rowLen - 1 - rowIndex][i]);
//        }
//
////        从下到上遍历
//        for (int i = rowLen - 1 - colIndex; i > rowIndex; i--) {
//            list.add(matrix[i][colIndex]);
//        }
//
//    }


//    private void printCircle(int i, int rowIndex, int colIndex, int len, ArrayList<Integer> list, int[][] matrix) {
////        从左往右
//        for(int i = colIndex;i<(len-1-colIndex);i++){
//            list.add(matrix[rowIndex][i]);
//        }
//
////        从上到下
//        for(int i = rowIndex;i<(len-1-rowIndex);i++){
//            list.add(matrix[i][len-1-rowIndex]);
//        }
//
////        从右向左
//        for(int i = len-1-rowIndex;i>rowIndex;i--){
//            list.add(matrix[len-1-rowIndex][i]);
//        }
//
////        从下向上
//        for(int i = len-1-rowIndex;i>rowIndex;i--){
//            list.add(matrix[i][rowIndex]);
//        }
//
//    }




    //    这种写法是最容易掌握的，记住每次交换高低
    private int partition1(int[] array, int start, int end) {
        int low = start;
        int high = end;

        int key = array[start];

        while (low < high) {
//          这块没有注释过的是标准写法，比较容易记，
//          只需记住两点：
//              1.将low,high交换两次，
//              2.先从high开始交换
            while (low < high && array[high] >= key) {//先从high开始
                high--;
            }
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;

            while (low < high && array[low] <= key) {
                low++;
            }
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;

//            while (low <high && array[low]<=key){
//                low++;
//            }
//
//            int temp = array[low];
//            array[low] = array[high];
//            array[high] = temp;
//            这种不可以的原因是，不能将key的值调到中间，可能会出现high == low的情况。
//            while (low<high && array[high]>=key){
//                high--;
//            }
//
//            temp = array[high];
//            array[high] = array[low];
//            array[low] = temp;
        }
        return low;
    }

    private int partition(int[] array, int start, int end) {
        int low = start;
        int high = end;
        int key = array[start];//作为标记

        while (low < high) {
//            是< 还是<= 一定要注意，必须认真分析
            while (low < high && array[low] <= key) {
                low++;
            }
//            swap
            int temp = array[low];
            array[low] = array[start];
            array[start] = temp;

            while (low < high && array[high] >= key) {
                high--;
            }

//            swap
            temp = array[high];
            array[high] = array[start];
            array[start] = temp;


        }

        return low - 1;
    }


    //end:最后的一个元素的下标
    public void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {
//        1. 定义两个新数组L, R，分别将两段数据复制进去
//        2. 将L, R, 开始从小到大逐一比较并开始合并到原始数组上
//        3. 步骤二执行完毕，就剩下L或R中有一个没有合并完的，将剩余的合并到原始数组上

        int n1 = mid - start + 1;
        int n2 = end - mid;//这个地方要计算个数，是个坑，得注意
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < L.length; i++) {
            L[i] = array[start + i];
        }

        for (int i = 0; i < R.length; i++) {
            R[i] = array[mid + 1 + i];//这个地方也是一个较坑的地方，一定是mid+1+i;
        }
//        开始合并,这种合并方式是：从左到右开始合并

        int i = 0;//指向L,
        int j = 0;//指向R
        int k = start;//指向array中的start
        for (; i < n1 && j < n2; k++) {
            if (L[i] > R[j]) {
                array[k] = R[j];
                j++;
            } else {
                array[k] = L[i];
                i++;
            }
        }

        for (; i < n1; k++) {
            array[k] = L[i];
            i++;
        }

        for (; j < n2; k++) {
            array[k] = R[j];
            j++;
        }
    }

//    public int InversePairs(int[] array) {
//        if (array == null || array.length <= 1) {
//            return 0;
//        }
//        int res = mergeSort(array, 0, array.length - 1);
//        return res;
//    }
//
//    //包含end
//    private int mergeSort(int[] array, int start, int end) {
//        if (start < end) {
//            int mid = (start + end) / 2;
//            int lRes = mergeSort(array, start, mid);
//            int rRes = mergeSort(array, mid + 1, end);
//            int res = merge1(array, start, mid, end);
//            return lRes + rRes + res;
//        }
//        return 0;
//    }
//
//    private int merge1(int[] array, int start, int mid, int end) {
//        int n1 = mid - start + 1;
//        int n2 = end - mid;
//
//        int[] L = new int[n1];
//        int[] R = new int[n2];
////        复制到新的数组中
//        for (int i = 0; i < n1; i++) {
//            L[i] = array[start + i];
//        }
//
//        for (int i = 0; i < n2; i++) {
//            R[i] = array[mid + 1 + i];
//        }
//
////      使用两个指针指向L,R的尾部，从后向前遍历，将大的数据复制到array中，同时逆序对的个数等于R中剩余的个数
////        这个地方算是对归并排序的灵活应用，因为常见的情况是从前向后的
//        int i = L.length - 1;
//        int j = R.length - 1;
//        int k = end;//array数组中的最后一个下标
//        int count = 0;//统计逆序对的个数
//        for (; j > -1 && i > -1; ) {
//            if (L[i] > R[j]) {
//                count += j + 1;
//                if (count >= 1000000007){
//                    count %= 1000000007;
//                }
//                array[k] = L[i];
//                i--;
//                k--;
//            } else {
//                array[k] = R[j];
//                j--;
//                k--;
//            }
//        }
//
//        //没有拷贝完，将剩余的拷贝了
//        while (i > -1) {
//            array[k] = L[i];
//            k--;
//            i--;
//        }
//
//        while (j > -1) {
//            array[k] = R[j];
//            k--;
//            j--;
////            count++;
//        }
//
//        return count;
//    }
//
//    private int merge(int[] array, int start, int mid, int end) {
//        int[] L = new int[mid - start + 1];
//        int[] R = new int[end - mid];
//
//        int n1 = L.length;
//        int n2 = R.length;
//
//        for (int i = 0; i < L.length; i++) {
//            L[i] = array[start + i];
//        }
//
//        for (int i = 0; i < R.length; i++) {
//            R[i] = array[mid + 1 + i];
//        }
//        int count = 0;
//        int k = start;
//        int i, j;
//        for (i = 0, j = 0; i < n1 && j < n2; ) {
//            if (L[i] > R[j]) {
//                array[k++] = R[j];
//                count++;
//                j++;
//            } else {
//                array[k++] = L[i];
//                i++;
//            }
//        }
//        //有剩余的直接复制
//        if (i < n1) {
//            for (; i < n1; i++) {
//                count++;
//                array[k++] = L[i];
//            }
//        }
//
//        if (j < n2) {
//            for (; j < n2; j++) {
//                array[k++] = R[j];
//            }
//        }
//        return count;
//    }


    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int lLength = 0;
        int rLength = 0;
        if (root.left != null) {
            lLength = TreeDepth(root.left) + 1;
        }

        if (root.right != null) {
            rLength = TreeDepth(root.right) + 1;
        }

        return lLength > rLength ? lLength : rLength;
    }


    private ListNode head = null;


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
//        1.有右结点，找到该节点的最左叶子节点
//        2.无右结点，且该节点是父节点的右孩子
//        3.无右结点，且该节点是父节点的左孩子，返回父节点
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            TreeLinkNode curr = pNode.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        } else {
            //右结点为空，从父节点开始，找到一个节点是其父节点的左孩子节点的节点
            TreeLinkNode parent = pNode.next;
            TreeLinkNode curr = pNode;
            while (parent != null && curr == parent.right) {
                curr = parent;
                parent = parent.next;
            }
            return parent;

        }
    }


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean isFound = false;
        if (root1.val == root2.val) {
            isFound = isSubtree(root1, root2);
            if (isFound == true) return true;
        }

        if (root1.left != null && !isFound) {
            isFound = HasSubtree(root1.left, root2);
        }
        if (root1.right != null && !isFound) {
            isFound = HasSubtree(root1.right, root2);
        }

        return isFound;
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 == null) || (root1 != null && root2 == null)) {
            return true;
        }
        if (root1 == null && null != root2) {
            return false;
        }

        if (root1.val == root2.val) {
            return isSubtree(root1.right, root2.right) && isSubtree(root1.left, root2.left);
        }

        return false;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
//        Hashtable
//        ConcurrentHashMap
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;
        if (p1.val < p2.val) {
            ListNode post = p1.next;
            p1.next = Merge(post, p2);
            if (head == null) {
                head = p1;
            }
            return p1;

        } else {
            ListNode post = p2.next;
            p2.next = Merge(post, p1);
            if (head == null) {
                head = p2;
            }
            return p2;
        }

    }


    public TreeNode getLastCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        List<TreeNode> path1 = new ArrayList<>();
        getNodePath(root, node1, path1);

        List<TreeNode> path2 = new ArrayList<>();
        getNodePath(root, node2, path2);

        TreeNode parent = getLastCommonNode(path1, path2);
        return parent;
    }

    private TreeNode getLastCommonNode(List<TreeNode> path1, List<TreeNode> path2) {
        int len = path1.size() > path2.size() ? path2.size() : path1.size();

        TreeNode root = null;
        for (int i = 0; i < len; i++) {
            if (path1.get(i) == path2.get(i)) {
                root = path1.get(i);
            } else {
                break;
            }
        }
        return root;
    }

    private boolean getNodePath(TreeNode root, TreeNode node1, List<TreeNode> path1) {
        if (root == null)
            return false;
        path1.add(root);
        if (root.val == node1.val) {
            return true;
        } else {
            if (root.left != null) {
                if (getNodePath(root.left, node1, path1)) {
                    return true;
                }
            }
            if (root.right != null) {
                if (getNodePath(root.right, node1, path1)) {
                    return true;
                }
            }
            path1.remove(root);
        }
        return false;

    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {

            ListNode temp = ReverseList(head.next);
            head.next.next = head;
            head.next = null;
            return temp;
        }


//        //迭代法
//        ListNode pre = null;
//        ListNode curr = head;
//        ListNode post = null;
//        while (curr!=null){
//            post = curr.next;
//            curr.next= pre;
//            pre = curr;
//            curr = post;
//
//        }
//        return pre;


    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ListNode curr = listNode;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int mid = list.size() / 2;

        Integer[] array = list.toArray(new Integer[0]);
        for (int i = 0; i < mid; i++) {
            Integer temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        list.clear();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        return list;
    }

}
