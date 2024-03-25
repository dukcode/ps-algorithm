package com.dukcode.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] heights = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> stk = new Stack<>();
    for (int idx = 0; idx < n; ++idx) {
      int h = heights[idx];

      while (!stk.isEmpty() && heights[stk.peek()] <= h) {
        stk.pop();
      }

      bw.write(String.valueOf(stk.isEmpty() ? 0 : (stk.peek() + 1)));
      bw.write(' ');
      stk.push(idx);
    }
    bw.newLine();

    br.close();
    bw.close();

  }

}
