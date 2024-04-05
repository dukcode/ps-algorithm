package com.dukcode.jongman.chap28_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class WordChain {

  private static final int NUM_ALPHA = 26;
  private static final String IMPOSSIBLE = "IMPOSSIBLE";

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static String[] words;

  private static int[][] adj;
  private static List<String>[][] graph;
  private static int[] inDegree;
  private static int[] outDegree;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      getInput(); // n, words
      String ret = solve();

      bw.write(ret);
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static String solve() {
    makeGraph(); // adj, graph, inDegree, outDegree

    if (!canBeEuler()) {
      return IMPOSSIBLE;
    }

    List<Integer> ret = getEulerTrailOrCircuit();

    if (ret.isEmpty() || ret.size() != n + 1) {
      return IMPOSSIBLE;
    }

    Collections.reverse(ret);
    StringJoiner sj = new StringJoiner(" ");
    for (int i = 1; i < ret.size(); ++i) {
      int start = ret.get(i - 1);
      int end = ret.get(i);

      sj.add(graph[start][end].remove(graph[start][end].size() - 1));
    }
    return sj.toString();
  }

  private static void getEulerCircuit(int here, List<Integer> circuit) {
    for (int there = 0; there < NUM_ALPHA; ++there) {
      while (adj[here][there] > 0) {
        adj[here][there]--;
        getEulerCircuit(there, circuit);
      }
    }
    circuit.add(here);
  }

  private static List<Integer> getEulerTrailOrCircuit() {
    List<Integer> circuit = new ArrayList<>();

    for (int i = 0; i < NUM_ALPHA; ++i) {
      if (outDegree[i] == inDegree[i] + 1) {
        getEulerCircuit(i, circuit);
        return circuit;
      }
    }

    for (int i = 0; i < NUM_ALPHA; ++i) {
      if (outDegree[i] != 0) {
        getEulerCircuit(i, circuit);
        return circuit;
      }
    }

    return circuit;
  }

  private static boolean canBeEuler() {
    int plus1 = 0;
    int minus1 = 0;
    for (int i = 0; i < NUM_ALPHA; ++i) {
      int delta = outDegree[i] - inDegree[i];

      if (delta < -1 || delta > 1) {
        return false;
      }

      if (delta == 1) {
        plus1++;
      }

      if (delta == -1) {
        minus1++;
      }
    }

    return (plus1 == 1 && minus1 == 1) || (plus1 == 0 || minus1 == 0);
  }

  private static void makeGraph() {
    adj = new int[NUM_ALPHA][NUM_ALPHA];
    graph = new ArrayList[NUM_ALPHA][NUM_ALPHA];
    for (int y = 0; y < NUM_ALPHA; ++y) {
      for (int x = 0; x < NUM_ALPHA; ++x) {
        graph[y][x] = new ArrayList<>();
      }
    }

    inDegree = new int[NUM_ALPHA];
    outDegree = new int[NUM_ALPHA];

    for (int i = 0; i < n; ++i) {
      String word = words[i];

      char startChar = word.charAt(0);
      char endChar = word.charAt(word.length() - 1);

      adj[startChar - 'a'][endChar - 'a']++;
      graph[startChar - 'a'][endChar - 'a'].add(word);

      outDegree[startChar - 'a']++;
      inDegree[endChar - 'a']++;
    }
  }

  private static void getInput() throws IOException {
    n = Integer.parseInt(br.readLine());
    words = new String[n];

    for (int i = 0; i < n; ++i) {
      String word = br.readLine();

      words[i] = word;
    }
  }


}
