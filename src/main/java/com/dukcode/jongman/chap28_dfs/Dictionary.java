package com.dukcode.jongman.chap28_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      int n = Integer.parseInt(br.readLine());

      List<int[]> words = new ArrayList<>();
      for (int i = 0; i < n; ++i) {
        words.add(br.readLine().chars().toArray());
      }

      List<Integer> ret = solve(words);

      if (ret.isEmpty()) {
        bw.write("INVALID HYPOTHESIS");
        bw.newLine();
        continue;
      }

      for (Integer i : ret) {
        bw.write(i + 'a');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static List<Integer> solve(List<int[]> words) {
    boolean[][] adj = makeGraph(words);
    boolean[] visited = new boolean[26];
    List<Integer> order = dfsAll(adj, visited);

    Collections.reverse(order);

    for (int i = 0; i < 26; ++i) {
      for (int j = i + 1; j < 26; ++j) {
        if (adj[order.get(j)][order.get(i)]) {
          return Collections.emptyList();
        }
      }
    }

    return order;
  }

  private static List<Integer> dfsAll(boolean[][] adj, boolean[] visited) {
    List<Integer> reverseOrder = new ArrayList<>();
    for (int idx = 0; idx < 26; ++idx) {
      if (visited[idx]) {
        continue;
      }

      dfs(adj, visited, reverseOrder, idx);
    }

    return reverseOrder;
  }

  private static void dfs(boolean[][] adj, boolean[] visited,
      List<Integer> reverseOrder, int here) {
    visited[here] = true;
    for (int there = 0; there < 26; ++there) {
      if (visited[there] || !adj[here][there]) {
        continue;
      }

      dfs(adj, visited, reverseOrder, there);
    }

    reverseOrder.add(here);
  }

  private static boolean[][] makeGraph(List<int[]> words) {
    boolean[][] adj = new boolean[26][26];

    int n = words.size();
    for (int second = 1; second < n; ++second) {
      int first = second - 1;
      int len = Math.min(words.get(first).length, words.get(second).length);

      for (int i = 0; i < len; ++i) {
        int a = words.get(first)[i];
        int b = words.get(second)[i];

        if (a != b) {
          adj[a - 'a'][b - 'a'] = true;
          break;
        }
      }
    }

    return adj;
  }

}
