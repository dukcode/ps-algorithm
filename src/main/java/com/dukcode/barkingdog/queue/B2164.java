package com.dukcode.barkingdog.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B2164 {

  private static BufferedReader br;
  private static BufferedWriter bw;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Queue<Integer> q = IntStream.rangeClosed(1, n)
        .boxed()
        .collect(Collectors.toCollection(ArrayDeque::new));

    while (q.size() != 1) {
      q.poll();
      q.offer(q.poll());
    }

    bw.write(String.valueOf(q.peek()));

    br.close();
    bw.close();

  }

}
