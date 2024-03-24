package com.dukcode.java_api;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

  @Test
  public void addTest() {
    LinkedList<Integer> list = new LinkedList<>();

    list.add(1); // 맨 끝에 element 추가
    System.out.println(list); // 1

    list.add(1, 2); // 2를 1번 인덱스에 추가
    System.out.println(list); // 1 2

    list.add(1, 3); // 3을 1번 인덱스에 추가, 해당 자리의 element는 뒤로 밀려남
    System.out.println(list); // 1 3 2

    list.add(2, 4); // 4을 2번 인덱스에 추가, 해당 자리의 element는 뒤로 밀려남
    System.out.println(list); // 1 3 4 2

    // 존재하지 않는 인덱스에 삽입 시 예외 발생
    assertThatThrownBy(() -> list.add(100, 0))
        .isInstanceOf(IndexOutOfBoundsException.class);
  }

  @Test
  public void iteratorTest() {
    LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5));

    Iterator<Integer> it = list.iterator();

    // 바로 remove를 호출하면 예외가 발생한다.
    assertThatThrownBy(it::remove)
        .isInstanceOf(IllegalStateException.class);

    // remove는 마지막으로 반환 받은 element를 삭제시킨다.
    it.next(); // 1
    it.remove(); // 2 3 4 5
    System.out.println(list);

    it.next(); // 2
    it.next(); // 3
    it.remove(); // 2 4 5
    System.out.println(list);
  }

  @Test
  public void listIteratorTest() {

    LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5));

    // 3번 인덱스의 값인 4 앞에 커서가 위치
    ListIterator<Integer> it = list.listIterator(3);

    System.out.println(list);

    it.previous(); // 3
    it.remove(); // 마지막으로 호출된 element 삭제 -> 1 2 | 4 5
    System.out.println(list);

    // add로 element추가 후 커서는 추가된 element 뒤에 온다.
    it.add(6); // 1 2 6 | 4 5
    System.out.println(list);
    System.out.println(it.next()); // 4 (1 2 6 4 | 5)
  }

}
