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
С���õ���һ����������Ҫ������ż���ڵ�ϲ����ýڵ�ǰ��������ڵ������ڵ���(�½ڵ�ȨֵΪ�����ڵ�Ȩֵ֮��)��ֱ��ʣ��Ľڵ��޷��ϲ�Ϊֹ�����ܰ������?

ʾ��1

����

{2,3,4,1,2,2,3}

���

{2,7,5,3}

˵��

��������2->3->4->1->2->2->3���Ƚ�4�ϲ���3���棬�γ�2->7->1->2->2->3��Ȼ��2�ϲ���1���棬�γ�2->7->3->2->3�����2�ϲ���3���棬�γ�2->7->5->3����ʱ�޷��ϲ����ϲ�������

˼·�����

��ѭ���У�����������ǰ�ڵ�ͺ���������ż��ֵ�ڵ㣬ֱ���ҵ�һ������ֵ�ڵ�򵽴�����ĩβ��
 */