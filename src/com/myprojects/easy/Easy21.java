package com.myprojects.easy;

import java.util.List;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Easy21 {
    public static ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        ListNode preHead=new ListNode(-1);
        ListNode temp=preHead;
        while(l1!=null && l2!=null){
            if (l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        temp.next=l1==null?l2:l1;
        return preHead.next;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null){
            return null;
        }
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode head=null;
        if (l1.val<=l2.val){
            head=l1;
            head.next=mergeTwoLists(l1.next,l2);
        }else{
            head=l2;
            head.next=mergeTwoLists(l1,l2.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(5);
        l1.next.next=new ListNode(7);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(10);
        ListNode listNode=mergeTwoLists2(l1,l2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}