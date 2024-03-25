package com.dukcode.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stk = new Stack<>();
    while (n-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "push":
          int num = Integer.parseInt(st.nextToken());
          stk.push(num);
          break;
        case "pop":
          int result = stk.isEmpty() ? -1 : stk.pop();
          bw.write(String.valueOf(result));
          bw.newLine();
          break;
        case "size":
          bw.write(String.valueOf(stk.size()));
          bw.newLine();
          break;
        case "empty":
          bw.write(String.valueOf(stk.isEmpty() ? 1 : 0));
          bw.newLine();
          break;
        case "top":
          bw.write(String.valueOf(stk.isEmpty() ? -1 : stk.peek()));
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
