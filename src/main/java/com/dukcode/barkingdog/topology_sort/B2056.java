package com.dukcode.barkingdog.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2056 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;

  private static int[] times;

  private static List<Integer>[] adj;

  private static int[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    times = new int[n];
    cache = new int[n];
    adj = new List[n];
    for (int i = 0; i < n; ++i) {
      adj[i] = new ArrayList<>();
    }

    for (int to = 0; to < n; ++to) {
      st = new StringTokenizer(br.readLine());

      times[to] = Integer.parseInt(st.nextToken());

      int m = Integer.parseInt(st.nextToken());

      for (int idx = 0; idx < m; ++idx) {
        int from = Integer.parseInt(st.nextToken()) - 1;
        adj[from].add(to);
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {

    int ret = 0;
    for (int i = 0; i < n; ++i) {
      ret = Math.max(ret, dfs(i));
    }

    return ret;
  }

  private static int dfs(int here) {
    if (cache[here] != 0) {
      return cache[here];
    }

    int time = 0;
    for (int there : adj[here]) {
      time = Math.max(time, dfs(there));
    }

    return cache[here] = time + times[here];
  }

}
