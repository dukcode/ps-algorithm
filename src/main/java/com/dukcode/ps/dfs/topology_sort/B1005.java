package com.dukcode.ps.dfs.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1005
public class B1005 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] times;
  private static int w;

  private static boolean[][] adj;
  private static long[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      input();
      cache = new long[n];
      Arrays.fill(cache, -1L);
      bw.write(String.valueOf(dfs(w)));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static long dfs(int here) {
    if (cache[here] != -1) {
      return cache[here];
    }
    long ret = times[here];
    for (int before = 0; before < n; before++) {
      if (!adj[before][here]) {
        continue;
      }

      ret = Math.max(ret, times[here] + dfs(before));
    }

    return cache[here] = ret;
  }

  private static void input() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    times = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      times[i] = Integer.parseInt(st.nextToken());
    }

    adj = new boolean[n][n];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;

      adj[from][to] = true;
    }

    w = Integer.parseInt(br.readLine()) - 1;
  }

}
