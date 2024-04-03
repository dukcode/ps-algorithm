package com.dukcode.java_api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

  @Test
  public void test() {
    int n = 5;
    List<Boolean> list = new ArrayList<>(Collections.nCopies(n, false));
    assertThat(list).containsExactly(false, false, false, false, false);
  }

}
