package com.dukcode.barkingdog.topology_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21276_1 {

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

    Queue<Integer> q = new LinkedList<>();
    roots = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      if (inDegree[i] == 0) {
        roots.add(i);
        q.offer(i);
      }
    }

    children = new List[n];
    for (int i = 0; i < n; ++i) {
      children[i] = new ArrayList<>();
    }

    while (!q.isEmpty()) {
      int parent = q.poll();
      for (int child = 0; child < n; ++child) {
        if (!adj[parent][child]) {
          continue;
        }

        if (inDegree[parent] + 1 == inDegree[child]) {
          children[parent].add(child);
          q.offer(child);
        }
      }
    }

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

      for (int k : children[i]) {
        bw.write(people[k]);
        bw.write(' ');
      }

      bw.newLine();
    }

    br.close();
    bw.close();

  }

}
