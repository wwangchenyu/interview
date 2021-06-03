package leetcode;

import javax.xml.soap.SAAJResult;
import java.util.*;

/**
 * description: Leetcode <br>
 * date: 2021-05-10 17:41 <br>
 * author: wangcy <br>
 * version: 1.0 <br>
 */
public class Leetcode {

    //URL优化  https://leetcode-cn.com/problems/string-to-url-lcci/
    public static String replaceSpaces(String S, int length) {
        /**
        解法一：
        char[] chs = S.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < chs.length; i++) {
            if(i >= length) {
                break;
            }
            char ch = chs[i];
            if(ch == ' ') {
                sb.append("%20");
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();

       */

        char[] chs = S.toCharArray();

        int blank = 0;
        for(int i = 0; i < chs.length; i++) {
            if(i >= length) {
                break;
            }
            char ch = chs[i];
            if(ch == ' '){
                blank++;
            }
        }

        char[] chars = new char[length + 2 * blank];

        for(int i = 0,j = 0; i < chs.length; i++) {
            if(i >= length) {
                break;
            }
            char ch = chs[i];

            if(ch == ' '){
                chars[j] = '%';
                chars[j+1] = '2';
                chars[j+2] = '0';
                j = j + 3;
            }else {
                chars[j] = ch;
                j++;
            }
        }

        return String.valueOf(chars);
    }

    //重新排列字符串  https://leetcode-cn.com/problems/shuffle-string/
    public static String restoreString(String s, int[] indices) {
        char[] chs = s.toCharArray();
        char[] chArr = new char[indices.length];

        for(int i = 0; i < chs.length; i++) {
            int index = indices[i];
            char ch = chs[i];
            chArr[index] = ch;
        }
        return String.valueOf(chArr);
    }


    //两数相加(链表)  https://leetcode-cn.com/problems/add-two-numbers/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = new ListNode();
        ListNode currNode = firstNode;

        boolean isGt9 = false;

        while(l1 != null || l2 != null || isGt9) {

            int l1Val = 0;
            int l2Val = 0;

            if(l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val;
            if(isGt9) {
                sum = sum + 1;
            }

            if(sum >= 10) {
                sum = sum - 10;
                isGt9 = true;
            }else {
                isGt9 = false;
            }

            ListNode node = new ListNode(sum);
            currNode.next = node;
            currNode = node;

        }

        return firstNode.next;
    }

    //反转链表（链表）  https://leetcode-cn.com/problems/reverse-linked-list/
    public static ListNode reverseList(ListNode head) {
        /**
         * 解法一
         * 1、先遍历链表，得到链表长度后；
         * 2、声明数组
         * 3、再次遍历将链表数据存到数组中
         * 4、遍历数组，得到反转后的链表
         */
        int length = 0;
        ListNode currentOrig = head;
        while(currentOrig != null) {
            length++;
            currentOrig = currentOrig.next;
        }

        int[] vals = new int[length];

        currentOrig = head;
        int index = 0;

        while(currentOrig != null) {
            int val = currentOrig.val;
            vals[index] = val;
            index++;
            currentOrig = currentOrig.next;
        }

        ListNode res = new ListNode();
        ListNode resCurrent = res;
        for(int i  = vals.length - 1; i >= 0; i--){
            ListNode node = new ListNode();
            int val = vals[i];
            node.val = val;
            resCurrent.next = node;
            resCurrent = node;

        }
        return res.next;
    }

    //反转链表 https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
    //定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    public static ListNode reverseList2(ListNode head) {


        return null;
    }

    //计算器（栈）  https://leetcode-cn.com/problems/calculator-lcci/
    //定义两个栈，一个数栈，一个运算符栈
    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<Integer>();     //操作数栈

        Stack<Character> operStack = new Stack<Character>();    //运算符栈

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        char[] chs = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(char ch:chs) {
            if(ch == ' '){
                continue;
            }
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                numStack.push(Integer.valueOf(sb.toString()));
                sb.delete(0, sb.length());
                if(operStack.size() == 0){
                    operStack.push(ch);
                }else {
                    char oper = operStack.pop();
                    int n1 = map.get(ch);
                    int n2 = map.get(oper);
                    if(n1 <= n2) {
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        int res = 0;
                        if(oper == '+') {
                            res = num1 + num2;
                        }
                        if(oper == '-') {
                            res = num1 - num2;
                        }
                        if(oper == '*') {
                            res = num1 * num2;
                        }
                        if(oper == '/') {
                            res = num1 / num2;
                        }
                        operStack.push(ch);
                        numStack.push(res);
                    }else {
                        operStack.push(oper);
                        operStack.push(ch);
                    }
                }
            }else {
                sb.append(ch);
            }
        }
        if(sb.length() > 0) {
            numStack.push(Integer.valueOf(sb.toString()));
        }
        int res = 0;
        while(operStack.size() > 0) {
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            char oper = operStack.pop();
            switch (oper){
                case '+':
                    res = num1 + num2;
                    numStack.push(res);
                    break;
                case '-':
                    res = num1 - num2;
                    numStack.push(res);
                    break;
                case '*':
                    res = num1 * num2;
                    numStack.push(res);
                    break;
                case '/':
                    res = num1 / num2;
                    numStack.push(res);
                    break;
            }
        }
        return numStack.pop();
    }

    public static String compressString(String S) {

        int count = 0;
        char[] chArr = S.toCharArray();
        char curretnChar = chArr[0];
        if(chArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:chArr) {
            if(ch == curretnChar) {
                count++;
            }else {
                sb.append(curretnChar);
                sb.append(count);
                curretnChar = ch;
                count = 1;
            }
        }
        sb.append(curretnChar);
        sb.append(count);

        String compressStr = sb.toString();
        if(compressStr.length() >= S.length()){
            return S;
        }else {
            return compressStr;
        }
    }


    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode currentNode = head;
        while(currentNode != null) {
            int val = currentNode.val;

            ListNode innerCurrentNode = currentNode;
            while(innerCurrentNode != null && innerCurrentNode.next != null) {
                int innerVal = innerCurrentNode.next.val;

                if(innerVal == val) {
                    if(innerCurrentNode.next.next != null) {
                        innerCurrentNode.next = innerCurrentNode.next.next;
                        continue;
                    }else {
                        innerCurrentNode.next = null;
                    }
                }
                innerCurrentNode = innerCurrentNode.next;
            }

            currentNode = currentNode.next;
        }
        return head;
    }

    public static ListNode removeDuplicateNodes2(ListNode head) {
        ListNode currentNode = head;
        Set<Integer> list = new HashSet<Integer>();
        while (currentNode != null && currentNode.next != null) {
            int val1 = currentNode.val;
            int val2 = currentNode.next.val;
            if(list.contains(val2)) {
                currentNode.next = currentNode.next.next;
            }
            if(val1 != val2) {
                list.add(val1);
                list.add(val2);
                currentNode = currentNode.next;
            }else{
                list.add(val1);
                currentNode.next = currentNode.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
//        System.out.println(replaceSpaces("Mr John Smith     ", 13));
//
//        System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));

        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(1);
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        l11.next = l12;
        ListNode res = removeDuplicateNodes2(l8);
        while(res != null) {
            int val = res.val;
            System.out.println(val);
            res = res.next;
        }

//        addTwoNumbers(l1, l8);
//
//        System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
//
//        System.out.println(compressString(""));
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
