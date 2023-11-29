package oralTest.jianxinjinke1104;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Test01 {
    public ListNode mergeNode(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        if (head == null) return null;
        deque.add(head);
        ListNode temp = head.next;
        while (temp != null) {
            ListNode tempNext = temp.next;
            deque.add(temp);
            while ((deque.peekLast().val & 2) == 0) {
                ListNode top1 = deque.pollLast();
                if(deque.isEmpty()) break;
                deque.peekLast().val += top1.val;
            }
            temp = tempNext;
        }
        head = deque.pollFirst();
        temp = head;
        while (!deque.isEmpty()){
            ListNode next = deque.pollFirst();
            temp.next = next;
            temp = next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}

/*
小红拿到了一个链表，她需要把所有偶数节点合并到该节点前面和它相邻的奇数节点上(新节点权值为两个节点权值之和)，直到剩余的节点无法合并为止。你能帮帮她吗?

示例1

输入

{2,3,4,1,2,2,3}

输出

{2,7,5,3}

说明

对于链表2->3->4->1->2->2->3，先将4合并到3上面，形成2->7->1->2->2->3，然后将2合并到1上面，形成2->7->3->2->3，最后将2合并到3上面，形成2->7->5->3。此时无法合并，合并结束。

思路与代码

在循环中，首先跳过当前节点和后续的所有偶数值节点，直到找到一个奇数值节点或到达链表末尾。
 */