package kwic.model;

import java.io.EOFException;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Pipe {
  private PipedReader reader;
  private PipedWriter writer;

  public Pipe() {
    reader = new PipedReader();
    writer = new PipedWriter();
    try {
      reader.connect(writer);
    } catch (IOException e) {
      throw new RuntimeException("Failed to connect pipes");
    }
  }

  /**
   * Reads a line on the pipe
   * @return line read from the pipe, null if none but pipe is still open
   * @throws EOFException if pipe closes
   */
  public String readLine() throws EOFException {
    return "";
  }

  public void writeLine(String poll) {

  }
}
