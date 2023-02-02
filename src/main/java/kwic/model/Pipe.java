package kwic.model;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class Pipe {
  private final PipedReader reader = new PipedReader();
  private final PipedWriter writer = new PipedWriter();
  private final Scanner scanner = new Scanner(reader);

  /**
   * Constructs a pipe and connects the read and write ends
   * @throws IOException if connection fails
   */
  public Pipe() throws IOException {
    writer.connect(reader);
  }

  /**
   * Reads a line on the pipe
   * @return line read from the pipe, if any; null if pipe is closed
   */
  public String readLine(){
    if (scanner.hasNextLine()) return scanner.nextLine();
    return null;
  }

  /**
   * Writes a line to the pipe
   * @throws IOException if the underlying PipedWriter does
   */
  public void writeLine(String line) throws IOException {
    for (char c : line.toCharArray())
      writer.write(c);
    writer.write('\n');
  }

  /**
   * Closes the pipe.
   * After that, it can only be read until buffer is emptied.
   * @throws IOException if the underlying PipedWriter does
   */
  public void close() throws IOException {
    writer.close();
  }
}
