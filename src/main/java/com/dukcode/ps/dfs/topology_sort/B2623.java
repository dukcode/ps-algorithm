package com.dukcode.ps.dfs.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2623
public class B2623 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static boolean[][] adj;
  private static boolean[] vis;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new boolean[n][n];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int before = Integer.parseInt(st.nextToken()) - 1;
      for (int j = 1; j < num; ++j) {
        int after = Integer.parseInt(st.nextToken()) - 1;
        adj[before][after] = true;
        before = after;
      }
    }

    vis = new boolean[n];
    List<Integer> order = topologySort();

    if (order.isEmpty()) {
      bw.write(String.valueOf(0));
    } else {
      for (Integer singer : order) {
        bw.write(String.valueOf(singer + 1));
        bw.newLine();
      }
    }

    br.close();
    bw.close();

  }

  private static List<Integer> topologySort() {
    List<Integer> order = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      if (vis[i]) {
        continue;
      }

      dfs(i, order);
    }

    Collections.reverse(order);

    for (int from = 0; from < n; from++) {
      for (int to = from + 1; to < n; to++) {
        if (adj[order.get(to)][order.get(from)]) {
          return Collections.emptyList();
        }
      }
    }

    return order;
  }

  private static void dfs(int here, List<Integer> order) {
    vis[here] = true;

    for (int next = 0; next < n; ++next) {
      if (!adj[here][next] || vis[next]) {
        continue;
      }

      dfs(next, order);
    }

    order.add(here);
  }

}
