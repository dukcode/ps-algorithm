package com.dukcode.ps.dfs.scc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B4196 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int v;
  private static int e;

  private static List<List<Integer>> adj;

  private static int[] sccId;
  private static int[] discovered;

  private static int sccIdCounter;
  private static int discoveredCounter;

  private static Stack<Integer> stk;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      v = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());

      adj = new ArrayList<>();
      for (int i = 0; i < v; ++i) {
        adj.add(new ArrayList<>());
      }

      for (int i = 0; i < e; ++i) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken()) - 1;
        int to = Integer.parseInt(st.nextToken()) - 1;
        adj.get(from).add(to);
      }

      tarjanScc();

      int[] inDegrees = new int[sccIdCounter];
      for (int from = 0; from < v; ++from) {
        for (int to : adj.get(from)) {
          if (sccId[from] != sccId[to]) {
            inDegrees[sccId[to]]++;
          }
        }
      }

      long ans = Arrays.stream(inDegrees).filter(i -> i == 0).count();
      bw.write(String.valueOf(ans));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void tarjanScc() {
    sccId = new int[v];
    Arrays.fill(sccId, -1);
    discovered = new int[v];
    Arrays.fill(discovered, -1);

    discoveredCounter = 0;
    sccIdCounter = 0;

    stk = new Stack<>();

    for (int i = 0; i < v; ++i) {
      if (discovered[i] != -1) {
        continue;
      }

      scc(i);
    }
  }

  private static int scc(int here) {
    discovered[here] = discoveredCounter++;
    int ret = discovered[here];
    stk.push(here);

    for (int there : adj.get(here)) {
      if (discovered[there] == -1) {
        ret = Integer.min(ret, scc(there));
        continue;
      }

      if (sccId[there] == -1) {
        ret = Integer.min(ret, discovered[there]);
      }
    }

    if (ret == discovered[here]) {
      while (true) {
        int top = stk.pop();
        sccId[top] = sccIdCounter;
        if (top == here) {
          break;
        }
      }
      sccIdCounter++;
    }

    return ret;
  }

}
