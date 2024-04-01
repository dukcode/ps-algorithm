package com.dukcode.barkingdog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B10866 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Deque<Integer> dq = new ArrayDeque<>();
    while (n-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      int num = st.hasMoreElements() ? Integer.parseInt(st.nextToken()) : 0;
      switch (command) {
        case "push_front":
          dq.offerFirst(num);
          break;
        case "push_back":
          dq.offerLast(num);
          break;
        case "pop_front":
          bw.write(String.valueOf(dq.isEmpty() ? -1 : dq.pollFirst()));
          bw.newLine();
          break;
        case "pop_back":
          bw.write(String.valueOf(dq.isEmpty() ? -1 : dq.pollLast()));
          bw.newLine();
          break;
        case "size":
          bw.write(String.valueOf(dq.size()));
          bw.newLine();
          break;
        case "empty":
          bw.write(String.valueOf(dq.isEmpty() ? 1 : 0));
          bw.newLine();
          break;
        case "front":
          bw.write(String.valueOf(dq.isEmpty() ? -1 : dq.peekFirst()));
          bw.newLine();
          break;
        case "back":
          bw.write(String.valueOf(dq.isEmpty() ? -1 : dq.peekLast()));
          bw.newLine();
          break;
        default:
          break;
      }
    }

    br.close();
    bw.close();

  }

}
