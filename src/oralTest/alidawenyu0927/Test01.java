package oralTest.alidawenyu0927;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Test01 {

    public int solve(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        TreeNode tempLast = root;
        TreeNode last = root;
        TreeNode temp = root;
        int cnt = 1;
        int cur = 0;
        int cntAll = 1;
        boolean change = true;
        while (!deque.isEmpty()) {
            cntAll++;
            temp = deque.pollFirst();
            if (temp.left != null) {
                deque.addLast(temp.left);
                cur++;
                tempLast = temp.left;
            }
            if (temp.right != null) {
                deque.addLast(temp.right);
                cur++;
                tempLast = temp.right;
            }
            if (temp == last) {
                last = tempLast;
                if (change && cur == cnt * 2) {
                    cnt = cur;
                    cur = 0;
                } else {
                    change = false;
                }
            }
        }
        return cntAll - cnt;
    }

    public static void main(String[] args) {

    }
}
