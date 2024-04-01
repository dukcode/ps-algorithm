package com.dukcode.barkingdog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B11003 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      int num = arr[i];
      while (!dq.isEmpty() && arr[dq.peekLast()] >= num) {
        dq.pollLast();
      }

      if (!dq.isEmpty() && dq.peekFirst() < i - l + 1) {
        dq.pollFirst();
      }

      dq.offerLast(i);
      bw.write(String.valueOf(arr[dq.peekFirst()]));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

}
