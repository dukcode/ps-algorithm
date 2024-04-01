package com.dukcode.jongman.chap18_linear_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ites {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());

      long ans = solve(k, n);

      bw.write(String.valueOf(ans));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static long solve(int k, int n) {
    long ans = 0;
    Queue<Integer> q = new ArrayDeque<>();

    SignGenerator generator = new SignGenerator();
    long pSum = 0L;
    for (int i = 0; i < n; ++i) {
      int num = generator.next();
      q.offer(num);
      pSum += num;

      while (!q.isEmpty() && pSum > k) {
        pSum -= q.poll();
      }

      if (pSum == k) {
        ans++;
      }
    }

    return ans;
  }

  private static class SignGenerator {

    private long seed = 1983;

    public int next() {
      long ret = seed % 10000 + 1;
      seed = (seed * 214_013L + 2_531_011L) % (1L << 32);
      return (int) ret;
    }
  }

}
