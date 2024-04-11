package com.dukcode.barkingdog.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2623_1 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static boolean[][] adj;
  private static int[] inDegree;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new boolean[n][n];
    inDegree = new int[n];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());

      int from = Integer.parseInt(st.nextToken()) - 1;
      for (int idx = 1; idx < num; ++idx) {
        int to = Integer.parseInt(st.nextToken()) - 1;
        if (!adj[from][to]) {
          adj[from][to] = true;
          inDegree[to]++;
        }
        from = to;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
      if (inDegree[i] != 0) {
        continue;
      }

      q.offer(i);
    }

    List<Integer> order = new ArrayList<>();
    while (!q.isEmpty()) {
      int here = q.poll();
      order.add(here);

      for (int there = 0; there < n; ++there) {
        if (!adj[here][there]) {
          continue;
        }

        inDegree[there]--;
        if (inDegree[there] != 0) {
          continue;
        }

        q.offer(there);
      }
    }

    if (order.size() == n) {
      for (Integer i : order) {
        bw.write(String.valueOf(i + 1));
        bw.newLine();
      }
    } else {
      bw.write('0');
    }

    br.close();
    bw.close();

  }

}
