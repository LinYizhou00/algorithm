package com.图;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/25 11:01
 */
class State {
    int node;
    int distFromStart;

    public State(int node, int distFromStart) {
        this.node = node;
        this.distFromStart = distFromStart;
    }
}

public class Demo_743网络延迟时间 {
    public static void main(String[] args) {
        Demo_743网络延迟时间 demo = new Demo_743网络延迟时间();
        System.out.println(demo.networkDelayTime(new int[][]{
                {1,2,1}, {2,3,1}, {1,3,3}
        }, 3, 1));

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] startToIndexLen = new int[n + 1];
        Arrays.fill(startToIndexLen, Integer.MAX_VALUE);
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            graph[time[0]].add(time);
        }
        Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(o ->  o.distFromStart));
        startToIndexLen[k] = 0;
        queue.offer(new State(k, 0));
        while (!queue.isEmpty()) {
            State state = queue.poll();
            int node = state.node;
            int distFromStart = state.distFromStart;

            //if (node==n){
            //    System.out.println(Arrays.toString(startToIndexLen));
            //    return distFromStart;
            //}

            if (distFromStart > startToIndexLen[node]) {
                continue;
            }
            for (int[] ints : graph[node]) {
                int newNode = ints[1];
                int newDis = ints[2];
                if (newDis + distFromStart < startToIndexLen[newNode]) {
                    queue.offer(new State(newNode, newDis + distFromStart));
                    startToIndexLen[newNode] = newDis + distFromStart;
                }
            }
        }
        int max = -1;
        //System.out.println(Arrays.toString(startToIndexLen));
        for (int i = 1; i < startToIndexLen.length; i++) {
            max = Math.max(max, startToIndexLen[i]);
            if (max == Integer.MAX_VALUE) return -1;
        }
        return max;


    }
}
