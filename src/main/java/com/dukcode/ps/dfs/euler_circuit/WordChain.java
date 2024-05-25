package com.dukcode.ps.dfs.euler_circuit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.algospot.com/judge/problem/read/WORDCHAIN
public class WordChain {

  private static final int NUM_ALPHABET = 26;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;

  private static List<String>[][] graph;

  private static int[][] adj;
  private static int[] inDegrees;
  private static int[] outDegrees;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      n = Integer.parseInt(br.readLine());

      graph = new List[NUM_ALPHABET][NUM_ALPHABET];
      for (int y = 0; y < NUM_ALPHABET; y++) {
        for (int x = 0; x < NUM_ALPHABET; x++) {
          graph[y][x] = new ArrayList<>();
        }
      }

      adj = new int[NUM_ALPHABET][NUM_ALPHABET];
      inDegrees = new int[NUM_ALPHABET];
      outDegrees = new int[NUM_ALPHABET];
      for (int i = 0; i < n; ++i) {
        String word = br.readLine();
        int from = word.charAt(0) - 'a';
        int to = word.charAt(word.length() - 1) - 'a';

        outDegrees[from]++;
        inDegrees[to]++;
        adj[from][to]++;
        graph[from][to].add(word);
      }

      if (!canBeEuler()) {
        bw.write("IMPOSSIBLE");
        bw.newLine();
        continue;
      }

      List<Integer> circuit = getEulerCircuitOrTrail();
      for (int i = 1; i < circuit.size(); ++i) {
        int st = circuit.get(i - 1);
        int en = circuit.get(i);

        bw.write(graph[st][en].remove(graph[st][en].size() - 1));
        bw.write(' ');
      }
      bw.newLine();

    }

    br.close();
    bw.close();

  }

  private static void getEulerCircuit(int here, List<Integer> circuit) {
    for (int there = 0; there < NUM_ALPHABET; ++there) {
      if (adj[here][there] == 0) {
        continue;
      }

      adj[here][there]--;
      getEulerCircuit(there, circuit);
    }

    circuit.add(here);
  }

  private static List<Integer> getEulerCircuitOrTrail() {
    List<Integer> circuit = new ArrayList<>();

    for (int i = 0; i < NUM_ALPHABET; ++i) {
      if (inDegrees[i] + 1 != outDegrees[i]) {
        continue;
      }

      getEulerCircuit(i, circuit);
      Collections.reverse(circuit);
      return circuit;
    }

    for (int i = 0; i < NUM_ALPHABET; i++) {
      if (outDegrees[i] == 0) {
        continue;
      }

      getEulerCircuit(i, circuit);
      Collections.reverse(circuit);
      return circuit;
    }

    return Collections.emptyList();
  }

  private static boolean canBeEuler() {
    int plus1 = 0;
    int minus1 = 0;

    for (int i = 0; i < NUM_ALPHABET; i++) {
      int delta = inDegrees[i] - outDegrees[i];

      if (delta < -1 || delta > 1) {
        return false;
      }

      if (delta == -1) {
        minus1++;
      }

      if (delta == 1) {
        plus1++;
      }
    }

    return (plus1 == 0 && minus1 == 0) || (plus1 == 1 || minus1 == 1);
  }
}
