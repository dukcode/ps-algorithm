package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class ProblemSolvingTest {

  private int failureTimeout;
  private PrintStream stdOut;
  private OutputStream captor;

  public ProblemSolvingTest(int failureTimeout) {
    this.failureTimeout = failureTimeout;
  }

  @BeforeEach
  protected final void init() {
    this.stdOut = System.out;
    this.captor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(this.captor));
  }

  @ParameterizedTest
  @MethodSource("setData")
  void test(String input, String expected) {
    Assertions.assertTimeout(failureTimeout, () -> {
      run(input);
      org.assertj.core.api.Assertions.assertThat(output().trim()).isEqualTo(expected.trim());
    });
  }

  protected final void run(String input) throws Exception {
    try {
      this.loadInput(input);
      this.runMain();
    } finally {
      Console.close();
    }
  }

  private void loadInput(String input) {
    byte[] buf = input.getBytes();
    System.setIn(new ByteArrayInputStream(buf));
  }

  @AfterEach
  protected final void printOutput() {
    System.setOut(this.stdOut);
    System.out.println(output());
  }

  protected final String output() {
    return this.captor.toString().trim();
  }

  protected abstract void runMain() throws Exception;

}
