package com.dukcode.ps.dfs.cut_vertex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11266
public class B11266 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int v;
  private static int e;

  private static List<Integer>[] adj;

  private static int[] discovery;
  private static boolean[] isCutVertex;

  private static int discoveryOrder;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    adj = new ArrayList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < e; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      adj[a].add(b);
      adj[b].add(a);
    }

    discovery = new int[v];
    Arrays.fill(discovery, -1);
    isCutVertex = new boolean[v];
    discoveryOrder = 0;

    for (int i = 0; i < v; ++i) {
      if (discovery[i] != -1) {
        continue;
      }
      findCutVertex(i, true);
    }

    int cntCutVertex = 0;
    StringJoiner sj = new StringJoiner(" ");
    for (int i = 0; i < v; ++i) {
      if (!isCutVertex[i]) {
        continue;
      }

      cntCutVertex++;
      sj.add(String.valueOf(i + 1));
    }

    bw.write(String.valueOf(cntCutVertex));
    bw.newLine();
    bw.write(sj.toString());
    bw.newLine();

    br.close();
    bw.close();

  }

  // 해당 서브트리에서 역방향 간선으로 갈 수 있는 정점 중
  // 가장 빨리 발견된 정점의 시점
  private static int findCutVertex(int here, boolean isRoot) {
    discovery[here] = discoveryOrder++;
    int ret = discovery[here];

    int children = 0;
    for (Integer there : adj[here]) {
      if (discovery[there] != -1) {
        ret = Math.min(ret, discovery[there]);
        continue;
      }

      ++children;
      int subtree = findCutVertex(there, false);
      if (!isRoot && subtree >= discovery[here]) {
        isCutVertex[here] = true;
      }
      ret = Math.min(ret, subtree);
    }

    if (isRoot && children >= 2) {
      isCutVertex[here] = true;
    }

    return ret;
  }
}
