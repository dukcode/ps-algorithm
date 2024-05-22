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
import java.util.StringTokenizer;

public class B2056 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] times;

  private static List<Integer>[] adj;
  private static int[] inDegrees;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    times = new int[n + 1];

    adj = new List[n];
    for (int i = 0; i < n; ++i) {
      adj[i] = new ArrayList<>();
    }

    inDegrees = new int[n];
    for (int to = 0; to < n; ++to) {
      st = new StringTokenizer(br.readLine());
      times[to] = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      inDegrees[to] = m;
      for (int idx = 0; idx < m; ++idx) {
        int from = Integer.parseInt(st.nextToken()) - 1;
        adj[from].add(to);
      }
    }

    int ans = topologySort();
    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int topologySort() {
    int[] ans = new int[n];
    int ret = 0;
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      if (inDegrees[i] != 0) {
        continue;
      }
      ans[i] = times[i];
      ret = Math.max(ret, ans[i]);
      q.offer(i);
    }

    while (!q.isEmpty()) {
      int here = q.poll();
      for (int next : adj[here]) {
        inDegrees[next]--;
        ans[next] = Math.max(ans[here] + times[next], ans[next]);
        ret = Math.max(ret, ans[next]);
        if (inDegrees[next] == 0) {
          q.offer(next);
        }
      }
    }

    return ret;
  }


}
