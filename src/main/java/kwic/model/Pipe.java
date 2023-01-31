package kwic.model;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class Pipe {
  private PipedReader reader = new PipedReader();
  private PipedWriter writer = new PipedWriter();
  private Scanner scanner = new Scanner(reader);

  public Pipe() throws IOException {
    writer.connect(reader);
  }

  public String readLine(){
    if (scanner.hasNextLine()) return scanner.nextLine();
    return null;
  }

  public void writeLine(String line) throws IOException {
    for (char c : line.toCharArray())
      writer.write(c);
    writer.write('\n');
  }

  public void close() throws IOException {
    writer.close();
  }
}
