package com.dukcode.ps.dfs.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/21276
public class B21276 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static String[] people;

  private static boolean[][] adj;
  private static int[] inDegrees;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    people = new String[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      people[i] = st.nextToken();
    }

    Arrays.sort(people);

    adj = new boolean[n][n];
    inDegrees = new int[n];
    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int child = Arrays.binarySearch(people, st.nextToken());
      int parent = Arrays.binarySearch(people, st.nextToken());

      adj[parent][child] = true;
      inDegrees[child]++;
    }

    List<Integer> roots = new ArrayList<>();
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (inDegrees[i] == 0) {
        roots.add(i);
        q.offer(i);
      }
    }

    List<List<Integer>> children = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      children.add(new ArrayList<>());
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int next = 0; next < n; ++next) {
        if (!adj[cur][next] || inDegrees[cur] + 1 != inDegrees[next]) {
          continue;
        }

        children.get(cur).add(next);
        q.offer(next);
      }
    }

    bw.write(String.valueOf(roots.size()));
    bw.newLine();
    for (Integer root : roots) {
      bw.write(people[root]);
      bw.write(' ');
    }
    bw.newLine();

    for (int parent = 0; parent < n; ++parent) {
      bw.write(people[parent]);
      bw.write(' ');
      bw.write(String.valueOf(children.get(parent).size()));
      bw.write(' ');
      children.get(parent).sort(Comparator.naturalOrder());
      for (Integer child : children.get(parent)) {
        bw.write(people[child]);
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }
}
