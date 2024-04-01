package com.dukcode.jongman.chap18_linear_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Fence {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      int n = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      int[] fences = new int[n + 1];
      for (int idx = 0; idx < n; ++idx) {
        fences[idx] = Integer.parseInt(st.nextToken());
      }

      Stack<Integer> stk = new Stack<>();
      int ans = 0;
      for (int idx = 0; idx <= n; ++idx) {
        while (!stk.isEmpty() && fences[stk.peek()] >= fences[idx]) {
          int h = fences[stk.pop()];
          int w = stk.isEmpty() ? idx : idx - stk.peek() - 1;

          ans = Math.max(ans, h * w);
        }

        stk.push(idx);
      }

      bw.write(String.valueOf(ans));
      bw.newLine();
    }

    br.close();
    bw.close();

  }
}
