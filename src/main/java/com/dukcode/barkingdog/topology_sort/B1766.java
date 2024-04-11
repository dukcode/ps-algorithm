package com.dukcode.barkingdog.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1766 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Integer>[] adj;
  private static int[] inDegree;

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

    inDegree = new int[n];

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;

      adj[from].add(to);
      inDegree[to]++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; ++i) {
      if (inDegree[i] != 0) {
        continue;
      }
      pq.offer(i);
    }

    List<Integer> order = new ArrayList<>();
    while (!pq.isEmpty()) {
      int here = pq.poll();
      order.add(here);

      for (int there : adj[here]) {
        inDegree[there]--;
        if (inDegree[there] != 0) {
          continue;
        }

        pq.offer(there);
      }
    }

    for (Integer num : order) {
      bw.write(String.valueOf(num + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

}
