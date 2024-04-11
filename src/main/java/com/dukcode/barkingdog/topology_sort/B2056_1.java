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

public class B2056_1 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;

  private static int[] times;

  private static List<Integer>[] adj;

  private static int[] inDegree;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    times = new int[n];
    inDegree = new int[n];
    adj = new List[n];
    for (int i = 0; i < n; ++i) {
      adj[i] = new ArrayList<>();
    }

    for (int to = 0; to < n; ++to) {
      st = new StringTokenizer(br.readLine());

      times[to] = Integer.parseInt(st.nextToken());

      int m = Integer.parseInt(st.nextToken());

      inDegree[to] = m;

      for (int idx = 0; idx < m; ++idx) {
        int from = Integer.parseInt(st.nextToken()) - 1;
        adj[from].add(to);
      }
    }

    int[] res = new int[n];
    int ans = 0;
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
      res[i] = times[i];
      ans = Math.max(ans, res[i]);
      if (inDegree[i] == 0) {
        q.offer(i);
      }
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int next : adj[cur]) {
        inDegree[next]--;
        res[next] = Math.max(res[next], res[cur] + times[next]);
        ans = Math.max(ans, res[next]);
        if (inDegree[next] == 0) {
          q.offer(next);
        }
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

}
