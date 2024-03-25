package com.dukcode.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B10773 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int k = Integer.parseInt(br.readLine());

    Stack<Integer> stk = new Stack<>();
    int sum = 0;
    while (k-- > 0) {
      int money = Integer.parseInt(br.readLine());

      if (money == 0) {
        sum -= stk.isEmpty() ? 0 : stk.pop();
        continue;
      }

      sum += money;
      stk.push(money);
    }

    bw.write(String.valueOf(sum));

    br.close();
    bw.close();

  }

}
