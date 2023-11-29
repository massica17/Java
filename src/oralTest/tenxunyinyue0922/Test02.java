package oralTest.tenxunyinyue0922;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test02 {
    public long maxDepthCount(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null) return 0;
        deque.add(root);
        TreeNode last = root;
        TreeNode cur = root;
        int cnt = 0;
        while(!deque.isEmpty()){
            TreeNode temp = deque.pollFirst();
            if(temp.left != null){
                deque.addLast(temp.left);
                cnt++;
                cur = temp.left;
            }
            if(temp.right != null){
                deque.addLast(temp.right);
                cnt++;
                cur = temp.right;
            }
            if(temp == last && !deque.isEmpty()){
                last = cur;
                cnt = 0;
            }
        }
        return cnt;
    }

    public long solve(TreeNode[] treeNodes){
        long mod = (long) (7 + 1e9);
        int n = treeNodes.length;
        long[] cnt = new long[n];
        for(int i = 0; i < n; i++){
            cnt[i] = maxDepthCount(treeNodes[i]);
        }
        long total = 1;
        for(int i = 0; i < n; i++){
            total = (total * 2 * cnt[i]) % mod;
        }
        long mutli = 1L;
        for(int i = 1; i <= n - 1; i++){
            mutli = (mutli * i) % mod;
        }
        mutli = mutli * total % mod;
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += (mutli / cnt[i]);
            ans %= mod;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
