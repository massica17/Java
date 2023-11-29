package oralTest.yongyou1027;

import java.util.*;

public class Test02 {
    public static String dagBfsTraversal (String[] nodes, String startNode) {
        int len = nodes.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String node = nodes[i];
            String[] s1 = node.split("->");
            String f = s1[0].trim();
            String[] s2 = s1[1].split(",");
            String[] ts = new String[s2.length];
            for (int j = 0; j < s2.length; j++) {
                ts[j] = s2[j].trim();
            }
            List<String> ls = map.getOrDefault(f, new ArrayList<>());
            for (String t : ts) {
                ls.add(t);
            }
            map.put(f, ls);
        }
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        res.add(startNode);
        set.add(startNode);
        q.add(startNode);
        while (!q.isEmpty()) {
            String cur = q.poll();
            List<String> neighbors = map.getOrDefault(cur,new ArrayList<>());
            for (String neighbor : neighbors) {
                if (set.add(neighbor)){
                    res.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append(s).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

/*
使用广度优先搜索算法(BFS) ，遍历有向无环图 (DAG) ，并输出遍历的节点的顺序。

输出的节点顺序要求稳定，需要避免使用随机顺序，导致验证失败。

如上图所示，当输入:“A->B”,"A->C,D”,"C->E”,"E->F”,"D->G”,"G->E"(注意:->和前后的空格的存在是不确定的,Key也可能出现多次)

BFS输出为:“A”,"B”,"C”,"D”,"E”,"G","F”(注意: 输出需要稳定，需要按照传入字 符串的顺序构建图)

建议:

1.优先解析原始数据为图的节点结构，如采用定义内部类的方式: 2.需要注意构建结构时，不要遗漏“B’"F这种只有入度，没有出度的节点

示例1

输入

["A->B","A->C,D","C->E","E->F","D->G","G->E"],"A"

输出

"A B,C,D.E.G,F"

说明

输出结果格式化时，不要有多余的空格，否则结果对比可能失败

思路与代码

代码实现了对有向无环图的广度优先搜索（BFS）遍历，并将遍历结果以字符串形式返回。该遍历从指定的起始节点开始，按照广度优先的顺序遍历图中的节点，并将遍历结果按照逗号分隔的形式返回。
 */