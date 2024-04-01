package com.dukcode.barkingdog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class B5430 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    Loop:
    while (t-- > 0) {
      char[] commands = br.readLine().toCharArray();
      int n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine()
          .replace("[", "")
          .replace("]", ""), ",");

      Deque<Integer> dq = new ArrayDeque<>();
      for (int i = 0; i < n; ++i) {
        dq.offerLast(Integer.parseInt(st.nextToken()));
      }

      boolean reverse = false;
      for (char command : commands) {
        if (command == 'R') {
          reverse = !reverse;
          continue;
        }

        if (dq.isEmpty()) {
          bw.write("error");
          bw.newLine();
          continue Loop;
        }

        if (reverse) {
          dq.pollLast();
          continue;
        }

        dq.pollFirst();
      }

      Iterator<Integer> it = reverse ? dq.descendingIterator() : dq.iterator();

      StringJoiner sj = new StringJoiner(",", "[", "]");
      while (it.hasNext()) {
        sj.add(String.valueOf(it.next()));
      }

      bw.write(sj.toString());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

}
