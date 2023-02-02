package kwic.model;

import java.io.IOException;

/**
 * Group data by line, remove words from
 * start and append to the end until
 * the keyword is the first index.
 */
public class CircularShifter extends Filter {
  /**
   * Constructs a CircularShifter filter
   * @param input the input pipe
   * @param output the output pipe
   */
  public CircularShifter(Pipe input, Pipe output) {
    super(input, output);
  }

  /**
   * Shifts the given string array by
   * appending the first word to the end of the array
   * @param array The array of words to circular shift
   */
  private void leftCircularShiftInPlace(String[] array){
    String last = array[0];
    for (int i = 0; i < array.length - 1; i++)
      array[i] = array[i+1];
      array[array.length - 1] = last;
  }

  /**
   * Turns all lines received from pipe into all circular shifts of the line.
   */
  @Override
  public void run() {
    String line = input.readLine();

    while (line != null){
      String[] words = line.split("\\s+");
      for (int i = 0; i < words.length; i++){
        try {
          output.writeLine(String.join(" ", words));
        } catch (IOException e) {
          throw new RuntimeException("Could not write line into the pipe.");
        }
        leftCircularShiftInPlace(words);
      }
      line = input.readLine();
    }
    try {
      output.close();
    } catch (IOException e) {
      throw new RuntimeException("The output class could not be closed.");
    }
  }
}
