package com.dukcode.barkingdog.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2252 {

  // 2^10 * 10^6 byte -> 2^10 MiB (인접 배열 시)
  // 100_000 byte -> 100 KiB (인접 리스트 시)
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<Integer>[] adj;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new List[n];
    for (int i = 0; i < n; ++i) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken()) - 1;
      int second = Integer.parseInt(st.nextToken()) - 1;

      adj[first].add(second);
    }

    visited = new boolean[n];
    List<Integer> order = topologySort();

    for (Integer student : order) {
      bw.write(String.valueOf(student + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static List<Integer> topologySort() {
    List<Integer> order = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      if (visited[i]) {
        continue;
      }

      dfs(i, order);
    }

    Collections.reverse(order);
    return order;
  }

  private static void dfs(int here, List<Integer> order) {
    visited[here] = true;

    int size = adj[here].size();
    for (int i = 0; i < size; ++i) {
      int there = adj[here].get(i);
      if (visited[there]) {
        continue;
      }

      dfs(there, order);
    }

    order.add(here);
  }

}
