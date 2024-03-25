package com.dukcode.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B6549 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());

      if (n == 0) {
        break;
      }

      long[] heights = new long[n + 1];
      for (int idx = 0; idx < n; ++idx) {
        long h = Long.parseLong(st.nextToken());
        heights[idx] = h;
      }

      long ans = 0L;
      Stack<Integer> idxStk = new Stack<>();
      for (int idx = 0; idx <= n; ++idx) {
        while (!idxStk.isEmpty() && heights[idxStk.peek()] >= heights[idx]) {
          long h = heights[idxStk.pop()];
          int w = idxStk.isEmpty() ? idx : (idx - idxStk.peek() - 1);
          ans = Math.max(ans, h * w);
        }

        idxStk.push(idx);
      }

      bw.write(String.valueOf(ans));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

}
