package com.dukcode.ps.dfs.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2637
public class B2637 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[][] adj;
  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    adj = new int[n][n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int to = Integer.parseInt(st.nextToken()) - 1;
      int from = Integer.parseInt(st.nextToken()) - 1;
      int num = Integer.parseInt(st.nextToken());

      adj[from][to] = num;
    }

    cache = new int[n][n];
    int[] ans = dfs(n - 1);

    for (int i = 0; i < n; i++) {
      if (ans[i] == 0) {
        continue;
      }
      bw.write(String.valueOf(i + 1));
      bw.write(' ');
      bw.write(String.valueOf(ans[i]));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static int[] dfs(int here) {
    int cnt = Arrays.stream(cache[here]).sum();
    if (cnt != 0) {
      return cache[here];
    }

    int[] ret = new int[n];
    for (int before = 0; before < n; ++before) {
      if (adj[before][here] == 0) {
        continue;
      }

      int[] beforeRet = dfs(before);
      for (int i = 0; i < n; ++i) {
        ret[i] += adj[before][here] * beforeRet[i];
      }
    }

    if (Arrays.stream(ret).sum() == 0) {
      ret[here] = 1;
    }

    return cache[here] = ret;
  }

}
