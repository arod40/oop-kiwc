package kwic.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Input extends Filter {
  private FileInputStream fileInput;

  public Input(FileInputStream input, Pipe output){
    super(null, output);
    this.fileInput = input;
  }

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
