package com.zhu.test;

import java.util.*;

/**
 * @author shkstart
 * @create 2022-10-22 14:06
 */


public class Main {
    static List<Integer>[] graph;
    static int[][] dist;

    public static void main(String[] args) {
        int[] paths = {-1, 0, 0, 1, 2, 2, 3, 0, 2};
        int[][] cargo = {{5, 7, 1}, {2, 4, 0}, {0, 6, 3}};

        graph = new ArrayList[paths.length];
        for (int i = 0; i < paths.length; i++) {
            if (paths[i] == -1) continue;
            if (graph[i] == null) {
                graph[i] = new ArrayList<>();
            }
            if (graph[paths[i]] == null) {
                graph[paths[i]] = new ArrayList<>();
            }
            graph[i].add(paths[i]);
            graph[paths[i]].add(i);
        }

        dist = new int[paths.length][paths.length];
        for (int i = 0; i < paths.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < paths.length; i++) {
            bfs(i);
        }

        int count = 0;
        for (int[] c : cargo) {
            if (dist[c[0]][c[1]] == dist[c[0]][c[2]] + dist[c[2]][c[1]]) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (dist[start][node[0]] <= node[1]) continue;
            dist[start][node[0]] = node[1];
            for (int neighbor : graph[node[0]]) {
                queue.offer(new int[]{neighbor, node[1] + 1});
            }
        }
    }

}



