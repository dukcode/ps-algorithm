package com.dukcode.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B14888 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] nums;
  private static int[] ops; // +, -, * , /
  private static List<Integer> order;

  private static long minAns;
  private static long maxAns;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    nums = new int[n];
    for (int i = 0; i < n; ++i) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    ops = new int[4];
    for (int i = 0; i < 4; ++i) {
      ops[i] = Integer.parseInt(st.nextToken());
    }

    minAns = Long.MAX_VALUE;
    maxAns = Long.MIN_VALUE;

    order = new ArrayList<>();
    solve(0);

    bw.write(String.valueOf(maxAns));
    bw.newLine();
    bw.write(String.valueOf(minAns));

    br.close();
    bw.close();

  }

  private static void solve(int cnt) {
    if (cnt == n - 1) {
      calcAns();
      return;
    }

    for (int i = 0; i < 4; ++i) {
      if (ops[i] == 0) {
        continue;
      }

      ops[i]--;
      order.add(i);

      solve(cnt + 1);

      ops[i]++;
      order.remove(order.size() - 1);
    }
  }

  private static void calcAns() {
    int ret = nums[0];
    for (int i = 0; i < n - 1; ++i) {
      int num = nums[i + 1];

      int op = order.get(i);
      switch (op) {
        case 0:
          ret += num;
          break;
        case 1:
          ret -= num;
          break;
        case 2:
          ret *= num;
          break;
        case 3:
          ret /= num;
          break;
        default:
          break;
      }
    }

    maxAns = Math.max(maxAns, ret);
    minAns = Math.min(minAns, ret);

  }

}
