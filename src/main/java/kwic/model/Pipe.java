package kwic.model;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Arrays;
import java.util.List;

public class Pipe {
  private PipedReader reader;
  private PipedWriter writer;

  public Pipe() throws IOException {
    this.reader = new PipedReader();
    this.writer = new PipedWriter();

    this.writer.connect(this.reader);
  }

  public String readLine() throws IOException {
    StringBuilder stringBuilder = new StringBuilder();

    Character current = (char) reader.read();
    while(current != '\n') {
      stringBuilder.append(current);
      current = (char) reader.read();
    }

    return stringBuilder.toString();
  }

  public void writeLine(String line) throws IOException {
    for (char c : line.toCharArray())
      writer.write(c);
    writer.write('\n');
  }
}
