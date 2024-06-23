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

public class B2150 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int v;
  private static int e;

  private static List<List<Integer>> adj;

  private static int[] sccId;
  private static int[] discovered;

  private static int counterVertex;
  private static int counterSccId;

  private static Stack<Integer> stk;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    adj = new ArrayList<>();
    for (int i = 0; i < v; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < e; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;
      adj.get(from).add(to);
    }

    tarjanScc();

    bw.write(String.valueOf(counterSccId));
    bw.newLine();

    boolean[] taken = new boolean[v];
    for (int i = 0; i < v; ++i) {
      if (taken[i]) {
        continue;
      }

      int pivot = sccId[i];
      for (int j = i; j < v; ++j) {
        if (taken[j] || sccId[j] != pivot) {
          continue;
        }

        taken[j] = true;
        bw.write(String.valueOf(j + 1));
        bw.write(' ');
      }
      bw.write(String.valueOf(-1));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void tarjanScc() {
    counterSccId = 0;
    counterVertex = 0;

    discovered = new int[v];
    sccId = new int[v];
    Arrays.fill(discovered, -1);
    Arrays.fill(sccId, -1);

    stk = new Stack<>();

    for (int i = 0; i < v; ++i) {
      if (discovered[i] != -1) {
        continue;
      }
      scc(i);
    }
  }

  private static int scc(int here) {
    discovered[here] = counterVertex++;
    int ret = discovered[here];
    stk.push(here);

    for (int there : adj.get(here)) {
      if (discovered[there] == -1) {
        ret = Math.min(ret, scc(there));
        continue;
      }

      if (sccId[there] == -1) {
        ret = Math.min(ret, discovered[there]);
      }
    }

    if (discovered[here] == ret) {
      while (true) {
        int t = stk.pop();
        sccId[t] = counterSccId;
        if (t == here) {
          break;
        }
      }
      counterSccId++;
    }

    return ret;
  }

}
