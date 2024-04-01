package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class ProblemSolvingTest {

  private final double failureTimeout;
  private PrintStream stdOut;
  private OutputStream captor;

  public ProblemSolvingTest(double failureTimeout) {
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
      org.assertj.core.api.Assertions.assertThat(output().trim())
          .isEqualTo(cleanEachLine(expected).trim());
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
    return cleanEachLine(this.captor.toString());
  }

  private String cleanEachLine(String source) {
    List<String> lines = Arrays.stream(source.split("\n")).map(String::stripTrailing)
        .toList();
    StringJoiner lineJoiner = new StringJoiner("\n");
    for (String line : lines) {
      lineJoiner.add(line);
    }

    return lineJoiner.toString();
  }

  protected abstract void runMain() throws Exception;

}
