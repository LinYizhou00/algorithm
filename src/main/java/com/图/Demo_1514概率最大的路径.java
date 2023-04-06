package com.图;

import java.util.*;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/25 16:05
 */
class NodeState {
    int index;
    double res;

    public NodeState(int index, double res) {
        this.index = index;
        this.res = res;
    }
}

public class Demo_1514概率最大的路径 {

    public static void main(String[] args) {
        Demo_1514概率最大的路径 demo = new Demo_1514概率最大的路径();
        System.out.println(demo.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));

    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] res = new double[n];
        Arrays.fill(res, -1.1);
        List<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new double[]{edges[i][1], succProb[i]});
            graph[edges[i][1]].add(new double[]{edges[i][0], succProb[i]});
        }
        res[start] = 1.0;
        NodeState state = new NodeState(start, 1.0);
        Queue<NodeState> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> -o.res));
        queue.offer(state);
        while (!queue.isEmpty()) {
            NodeState poll = queue.poll();
            int index = poll.index;
            double re = poll.res;
            if (index == end) return re;

            //剪枝
            if (re < res[index]) {
                continue;
            }
            for (double[] doubles : graph[index]) {
                double newIndex = doubles[0];
                double newRes = doubles[1];
                if (res[(int) newIndex] < newRes * re) {
                    res[(int) newIndex] = newRes * re;
                    queue.offer(new NodeState((int) newIndex, newRes * re));
                }
            }
        }
        return 0.0;
    }
}
