package com.dukcode.barkingdog.linked_list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B1158 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    LinkedList<Integer> list = IntStream.rangeClosed(1, n).boxed()
        .collect(Collectors.toCollection(LinkedList::new));

    StringJoiner sj = new StringJoiner(", ", "<", ">");
    Iterator<Integer> it = list.iterator();
    while (!list.isEmpty()) {
      int removed = 0;
      for (int i = 0; i < k; ++i) {
        if (!it.hasNext()) {
          it = list.iterator();
        }
        removed = it.next();
      }
      sj.add(String.valueOf(removed));
      it.remove();
    }

    bw.write(sj.toString());

    br.close();
    bw.close();

  }

}
