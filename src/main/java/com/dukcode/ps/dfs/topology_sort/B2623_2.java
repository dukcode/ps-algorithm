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

// https://www.acmicpc.net/problem/2623
public class B2623_2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static boolean[][] adj;
  private static int[] inDegrees;

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

    inDegrees = new int[n];
    for (int from = 0; from < n; from++) {
      for (int to = 0; to < n; to++) {
        if (adj[from][to]) {
          inDegrees[to]++;
        }
      }
    }

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
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      if (inDegrees[i] == 0) {
        q.offer(i);
      }
    }

    List<Integer> ans = new ArrayList<>();
    while (!q.isEmpty()) {
      int cur = q.poll();
      ans.add(cur);
      for (int next = 0; next < n; ++next) {
        if (!adj[cur][next]) {
          continue;
        }

        inDegrees[next]--;
        if (inDegrees[next] == 0) {
          q.offer(next);
        }
      }
    }

    return ans;
  }


}
