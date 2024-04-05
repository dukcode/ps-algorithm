package com.dukcode.barkingdog.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2623 {

  // V <= 1000
  // E <= 1000C2 ~= 500_000

  // 시간 제한 1s
  // 위상 정렬 - 시간 복잡도 O(V+E) -> O(500_000) -> OK
  // 역행 검사 - 시간 복잡도 O(V&2) -> O(1_000_000) -> OK

  // 메모리 제한 128MB
  // 공간 복잡도
  // 인접 행렬 : O(V^2) = 1_000_000 byte = 10MB -> OK
  // 인접 리스트 : O(V + E) ~= 500_000byte = 500KB -> OK

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static boolean[][] adj;
  private static boolean[] visited;


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
      int from = Integer.parseInt(st.nextToken());
      while (st.hasMoreTokens()) {
        int to = Integer.parseInt(st.nextToken());
        adj[from - 1][to - 1] = true;
        from = to;
      }
    }

    List<Integer> order = topologySort();

    if (order.isEmpty()) {
      bw.write('0');
    } else {
      for (Integer i : order) {
        bw.write(String.valueOf(i + 1));
        bw.newLine();
      }
    }
    bw.newLine();

    br.close();
    bw.close();

  }

  private static List<Integer> topologySort() {
    visited = new boolean[n];
    List<Integer> order = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      if (visited[i]) {
        continue;
      }

      dfs(i, order);
    }

    Collections.reverse(order);

    for (int i = 0; i < n; ++i) {
      int first = order.get(i);
      for (int j = i + 1; j < n; ++j) {
        int second = order.get(j);
        if (adj[second][first]) {
          return Collections.emptyList();
        }
      }
    }

    return order;
  }

  private static void dfs(int here, List<Integer> order) {
    visited[here] = true;
    for (int there = 0; there < n; ++there) {
      if (visited[there] || !adj[here][there]) {
        continue;
      }

      dfs(there, order);
    }

    order.add(here);
  }

}
