package kwic.model;

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

  public String readLine() {
    return "";
  }

  public void writeLine() {

  }
}
