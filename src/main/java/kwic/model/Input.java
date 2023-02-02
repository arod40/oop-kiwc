package kwic.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Input extends Filter {
  private final FileInputStream fileInput;

  /**
   * Constructs input filter with the given FileInputStream
   * @param input the input file stream
   * @param output the output pipe
   * @throws NullPointerException if fileInput is null
   */
  public Input(FileInputStream input, Pipe output){
    super(null, output);
    this.fileInput = Objects.requireNonNull(input);
  }

  /**
   * Runs the thread, reads all lines of the input file and writes
   * to the pipe line-by-line
   */
  @Override
  public void run() {
    Scanner scanner = new Scanner(this.fileInput);
    while (scanner.hasNextLine()){
      try {
        output.writeLine(scanner.nextLine());
      } catch (IOException e) {
        throw new RuntimeException("Error while reading from input file");
      }
    }
  }
}
