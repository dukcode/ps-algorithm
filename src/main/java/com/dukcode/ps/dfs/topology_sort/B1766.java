package com.dukcode.ps.dfs.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1766
public class B1766 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<List<Integer>> adj;
  private static int[] inDegrees;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      adj.add(new ArrayList<>());
    }

    inDegrees = new int[n];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int before = Integer.parseInt(st.nextToken()) - 1;
      int after = Integer.parseInt(st.nextToken()) - 1;

      adj.get(before).add(after);
      inDegrees[after]++;
    }

    List<Integer> order = topologySort();
    for (Integer i : order) {
      bw.write(String.valueOf(i + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static List<Integer> topologySort() {
    List<Integer> order = new ArrayList<>();

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; ++i) {
      if (inDegrees[i] == 0) {
        pq.add(i);
      }
    }

    while (!pq.isEmpty()) {
      int cur = pq.poll();
      order.add(cur);
      for (Integer next : adj.get(cur)) {
        inDegrees[next]--;
        if (inDegrees[next] != 0) {
          continue;
        }

        pq.offer(next);
      }
    }

    return order;
  }
}
