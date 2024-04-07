package com.dukcode.barkingdog.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B21276 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static String[] people;
  private static boolean[][] adj;
  private static int[] inDegree;
  private static List<Integer>[] children;

  private static List<Integer> roots;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    people = new String[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      people[i] = st.nextToken();
    }

    Arrays.sort(people);

    m = Integer.parseInt(br.readLine());

    adj = new boolean[n][n];
    inDegree = new int[n];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int child = Arrays.binarySearch(people, st.nextToken());
      int parent = Arrays.binarySearch(people, st.nextToken());

      adj[parent][child] = true;
      inDegree[child]++;
    }

    topologySort();

    bw.write(String.valueOf(roots.size()));
    bw.newLine();

    for (int i : roots) {
      bw.write(people[i]);
      bw.write(' ');
    }
    bw.newLine();

    for (int i = 0; i < n; ++i) {
      String name = people[i];
      bw.write(name);
      bw.write(' ');

      bw.write(String.valueOf(children[i].size()));
      bw.write(' ');

      Collections.sort(children[i]);
      for (int k : children[i]) {
        bw.write(people[k]);
        bw.write(' ');
      }

      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void topologySort() {
    roots = new ArrayList<>();
    children = new List[n];
    for (int i = 0; i < n; ++i) {
      children[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; ++i) {
      if (inDegree[i] != 0) {
        continue;
      }

      roots.add(i);
      dfs(i, 0);
    }
  }

  private static void dfs(int here, int depth) {
    depth++;

    for (int there = 0; there < n; ++there) {
      if (!adj[here][there] || inDegree[there] != depth) {
        continue;
      }
      children[here].add(there);
      dfs(there, depth);
    }

  }

}
