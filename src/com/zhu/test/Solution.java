package com.zhu.test;

import java.util.*;

/**
 * @author shkstart
 * @create 2023-06-09 19:09
 */
public class Solution {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] prev;

    public static void main(String[] args) {

        String s = "  hello   world!  ";

        String s2 = s.trim();

        LinkedList<String> linkedList = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < s2.length(); i++){
            if (s2.charAt(i) == ' ' && s2.charAt(i - 1) != ' '){
                linkedList.add(s2.substring(start,i));
            }
            if (i > 0 && s2.charAt(i) != ' ' && s2.charAt(i - 1) == ' '){
                start = i;
            }
            if (i == s2.length() - 1){
                linkedList.add(s2.substring(start,s2.length()));
            }
        }


        String res = "";

        for(int i =linkedList.size() - 1; i >=0; i--){

            res += linkedList.get(i);
            if(i != 0){
                res += " ";
            }
        }
        System.out.println(res);
    }

    public int cargoSorting(int[] paths,int[][] cargo){

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

        visited = new boolean[paths.length];
        prev = new int[paths.length];

        int count = 0;
        for (int[] c : cargo) {
            Arrays.fill(visited, false);
            Arrays.fill(prev, -1);
            bfs(c[0]);
            if (check(c[1], c[2])) count++;
        }
        return count;
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (visited[neighbor]) continue;
                prev[neighbor] = node;
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }

    static boolean check(int end, int cross) {
        for (int node = end; node != -1; node = prev[node]) {
            if (node == cross) return true;
        }
        return false;
    }
}
