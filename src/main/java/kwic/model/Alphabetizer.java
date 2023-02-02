package kwic.model;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Sort a set of all lines based on the first word (keyword)
 * in alphabetic order.
 */
public class Alphabetizer extends Filter {
  private static final int INITIAL_CAPACITY = 11;   // Initial buffer size

  /**
   * Alphabetizer filter
   * @param input the input pipe
   * @param output the output pipe
   */
  public Alphabetizer(Pipe input, Pipe output) {
    super(input, output);
  }

  /**
   * Takes all lines from the input pipe and stores in a sorted buffer,
   * writing to the output only once there is no more input.
   */
  @Override
  public void run() {
    // Creates an automatically sorted buffer that sorts based on the first word in each string
    Queue<String> buffer = new PriorityQueue<>(INITIAL_CAPACITY, String.CASE_INSENSITIVE_ORDER);
    String line;

    while ((line = input.readLine()) != null) {
      buffer.add(line);
    }

    try {
      while (!buffer.isEmpty()) {
        output.writeLine(buffer.poll());
      }
    } catch (IOException e) {
      throw new RuntimeException("Unexpectedly failed to write line", e);
    }

  }
}
