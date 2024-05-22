package com.dukcode.ps.dfs.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.algospot.com/judge/problem/read/DICTIONARY
public class Dictionary {

  private static final int NUM_ALPHABET = 26;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static List<char[]> words;

  private static boolean[][] adj;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      n = Integer.parseInt(br.readLine());

      words = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        words.add(br.readLine().toCharArray());
      }

      adj = new boolean[NUM_ALPHABET][NUM_ALPHABET];
      visited = new boolean[NUM_ALPHABET];
      makeGraph();

      bw.write(solve());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static String solve() {
    List<Integer> order = new ArrayList<>();
    for (int alphabet = 0; alphabet < NUM_ALPHABET; alphabet++) {
      if (visited[alphabet]) {
        continue;
      }

      dfs(alphabet, order);
    }

    Collections.reverse(order);

    for (int first = 0; first < NUM_ALPHABET; first++) {
      for (int second = first + 1; second < NUM_ALPHABET; second++) {
        if (adj[order.get(second)][order.get(first)]) {
          return "INVALID HYPOTHESIS";
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Integer i : order) {
      sb.append((char) (i + 'a'));
    }

    return sb.toString();
  }

  private static void dfs(int here, List<Integer> order) {
    visited[here] = true;

    for (int next = 0; next < NUM_ALPHABET; next++) {
      if (visited[next] || !adj[here][next]) {
        continue;
      }

      dfs(next, order);
    }

    order.add(here);
  }

  private static void makeGraph() {
    for (int second = 1; second < n; ++second) {
      int first = second - 1;

      int size = Math.min(words.get(first).length, words.get(second).length);
      for (int idx = 0; idx < size; ++idx) {
        if (words.get(first)[idx] == words.get(second)[idx]) {
          continue;
        }

        adj[words.get(first)[idx] - 'a'][words.get(second)[idx] - 'a'] = true;
        break;
      }
    }
  }

}
