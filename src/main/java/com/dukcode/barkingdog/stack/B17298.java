package com.dukcode.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {

  private static final int MX = 123_456_789;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(st.nextToken());
      arr[i] = num;
    }
    arr[n] = MX;

    Stack<Integer> stk = new Stack<>();
    int[] ans = new int[n];
    for (int i = 0; i <= n; ++i) {
      while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
        int idx = stk.pop();
        ans[idx] = i == n ? -1 : arr[i];
      }

      stk.push(i);
    }

    for (int i = 0; i < n; ++i) {
      bw.write(String.valueOf(ans[i]));
      bw.write(' ');
    }
    bw.newLine();

    br.close();
    bw.close();

  }

}
