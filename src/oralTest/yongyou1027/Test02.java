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
ʹ�ù�����������㷨(BFS) �����������޻�ͼ (DAG) ������������Ľڵ��˳��

����Ľڵ�˳��Ҫ���ȶ�����Ҫ����ʹ�����˳�򣬵�����֤ʧ�ܡ�

����ͼ��ʾ��������:��A->B��,"A->C,D��,"C->E��,"E->F��,"D->G��,"G->E"(ע��:->��ǰ��Ŀո�Ĵ����ǲ�ȷ����,KeyҲ���ܳ��ֶ��)

BFS���Ϊ:��A��,"B��,"C��,"D��,"E��,"G","F��(ע��: �����Ҫ�ȶ�����Ҫ���մ����� ������˳�򹹽�ͼ)

����:

1.���Ƚ���ԭʼ����Ϊͼ�Ľڵ�ṹ������ö����ڲ���ķ�ʽ: 2.��Ҫע�⹹���ṹʱ����Ҫ��©��B��"F����ֻ����ȣ�û�г��ȵĽڵ�

ʾ��1

����

["A->B","A->C,D","C->E","E->F","D->G","G->E"],"A"

���

"A B,C,D.E.G,F"

˵��

��������ʽ��ʱ����Ҫ�ж���Ŀո񣬷������Աȿ���ʧ��

˼·�����

����ʵ���˶������޻�ͼ�Ĺ������������BFS����������������������ַ�����ʽ���ء��ñ�����ָ������ʼ�ڵ㿪ʼ�����չ�����ȵ�˳�����ͼ�еĽڵ㣬��������������ն��ŷָ�����ʽ���ء�
 */