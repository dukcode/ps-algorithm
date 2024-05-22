package com.dukcode.ps.dfs.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://www.algospot.com/judge/problem/read/DICTIONARY
public class Dictionary2 {

  private static final int NUM_ALPHABET = 26;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static List<char[]> words;

  private static boolean[][] adj;
  private static int[] inDegrees;

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
      inDegrees = new int[NUM_ALPHABET];
      makeGraph();

      bw.write(solve());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static String solve() {
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < NUM_ALPHABET; i++) {
      if (inDegrees[i] == 0) {
        q.offer(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      int here = q.poll();
      sb.append((char) (here + 'a'));
      for (int next = 0; next < NUM_ALPHABET; next++) {
        if (!adj[here][next]) {
          continue;
        }

        inDegrees[next]--;
        if (inDegrees[next] == 0) {
          q.offer(next);
        }
      }
    }

    for (int i = 0; i < NUM_ALPHABET; i++) {
      if (inDegrees[i] != 0) {
        return "INVALID HYPOTHESIS";
      }
    }

    return sb.toString();
  }

  private static void makeGraph() {
    for (int second = 1; second < n; second++) {
      int first = second - 1;

      int size = Math.min(words.get(first).length, words.get(second).length);

      for (int i = 0; i < size; ++i) {
        if (words.get(first)[i] == words.get(second)[i]) {
          continue;
        }

        adj[words.get(first)[i] - 'a'][words.get(second)[i] - 'a'] = true;
        break;
      }
    }

    for (int from = 0; from < NUM_ALPHABET; ++from) {
      for (int to = 0; to < NUM_ALPHABET; ++to) {
        if (adj[from][to]) {
          inDegrees[to]++;
        }
      }
    }

  }

}
