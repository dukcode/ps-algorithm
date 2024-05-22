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

// https://www.acmicpc.net/problem/2252
public class B2252 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<List<Integer>> adj;
  private static boolean[] vis;

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

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int before = Integer.parseInt(st.nextToken()) - 1;
      int after = Integer.parseInt(st.nextToken()) - 1;

      adj.get(before).add(after);
    }

    List<Integer> order = dfsAll();
    for (Integer i : order) {
      bw.write(String.valueOf(i + 1));
      bw.write(' ');
    }
    bw.newLine();

    br.close();
    bw.close();

  }

  private static List<Integer> dfsAll() {
    vis = new boolean[n];

    List<Integer> order = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      if (vis[i]) {
        continue;
      }
      dfs(i, order);
    }

    Collections.reverse(order);
    return order;
  }

  private static void dfs(int here, List<Integer> order) {
    vis[here] = true;

    for (int next : adj.get(here)) {
      if (vis[next]) {
        continue;
      }

      dfs(next, order);

    }

    order.add(here);
  }
}
