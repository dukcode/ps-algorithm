package com.dukcode.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B1874 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    Stack<Integer> stk = new Stack<>();
    int num = 1;
    while (n-- > 0) {
      int toPop = Integer.parseInt(br.readLine());

      while (num <= toPop) {
        stk.push(num++);
        sb.append("+\n");
      }

      if (stk.peek() != toPop) {
        sb = new StringBuilder("NO");
        break;
      }

      stk.pop();
      sb.append("-\n");
    }

    bw.write(sb.toString());

    br.close();
    bw.close();

  }

}
