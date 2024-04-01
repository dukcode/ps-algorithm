package com.dukcode.barkingdog.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18258 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int back = 0;
    Queue<Integer> q = new ArrayDeque<>();
    while (n-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "push":
          int num = Integer.parseInt(st.nextToken());
          back = num;
          q.offer(num);
          break;
        case "pop":
          if (q.isEmpty()) {
            bw.write("-1");
            bw.newLine();
            break;
          }
          bw.write(String.valueOf(q.poll()));
          bw.newLine();
          break;
        case "size":
          bw.write(String.valueOf(q.size()));
          bw.newLine();
          break;
        case "empty":
          bw.write(String.valueOf(q.isEmpty() ? 1 : 0));
          bw.newLine();
          break;
        case "front":
          bw.write(String.valueOf(q.isEmpty() ? -1 : q.peek()));
          bw.newLine();
          break;
        case "back":
          bw.write(String.valueOf(q.isEmpty() ? -1 : back));
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
