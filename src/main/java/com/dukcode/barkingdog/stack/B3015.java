package com.dukcode.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B3015 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    long ans = 0;
    Stack<Person> stk = new Stack<>();
    for (int i = 0; i < n; ++i) {
      int h = Integer.parseInt(br.readLine());
      int d = 1;

      Person lastPopped = new Person(0, 0);
      while (!stk.isEmpty() && stk.peek().h <= h) {
        ans += stk.peek().d;
        lastPopped = stk.pop();
      }

      if (lastPopped.h == h) {
        d += lastPopped.d;
      }

      ans += stk.isEmpty() ? 0 : 1;
      stk.push(new Person(h, d));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static class Person {

    public int h;
    public int d;

    public Person(int h, int d) {
      this.h = h;
      this.d = d;
    }
  }

}
