package com.dukcode.barkingdog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B1021 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Deque<Integer> dq = IntStream.rangeClosed(1, n)
        .boxed()
        .collect(Collectors.toCollection(ArrayDeque::new));

    int ans = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; ++i) {
      int target = Integer.parseInt(st.nextToken());

      int moveCount = 0;
      while (!dq.isEmpty() && dq.peekFirst() != target) {
        moveLeft(dq);
        moveCount++;
      }

      ans += Math.min(moveCount, dq.size() - moveCount);
      dq.pollFirst();
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static <T> void moveLeft(Deque<T> dq) {
    dq.offerLast(dq.pollFirst());
  }
}
