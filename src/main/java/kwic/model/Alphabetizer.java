package kwic.model;

import java.io.EOFException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Sort a set of all lines based on the first word (keyword)
 * in alphabetic order.
 */
public class Alphabetizer extends Filter {
  private static final int INITIAL_CAPACITY = 11;

  public Alphabetizer(Pipe input, Pipe output) {
    super(input, output);
  }

  @Override
  public void run() {
    // Creates an automatically sorted buffer that sorts based on the first word in each string
    Queue<String> buffer = new PriorityQueue<>(INITIAL_CAPACITY, String.CASE_INSENSITIVE_ORDER);

    while (true) {
      try {
        String line = input.readLine();
        buffer.add(line);
      } catch (EOFException e) {
        break;
      }
    }

    while (!buffer.isEmpty()) {
      output.writeLine(buffer.poll());
    }
  }
}
