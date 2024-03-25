package com.dukcode.jongman.chap18_linear_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Josephus {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      LinkedList<Integer> list = IntStream.rangeClosed(1, n)
          .boxed()
          .collect(Collectors.toCollection(LinkedList::new));

      ListIterator<Integer> it = list.listIterator();
      it.next();
      while (list.size() != 2) {
        it.remove();
        for (int i = 0; i < k; ++i) {
          if (!it.hasNext()) {
            it = list.listIterator();
          }
          it.next();
        }
      }

      for (int soldier : list) {
        bw.write(String.valueOf(soldier));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }

}
