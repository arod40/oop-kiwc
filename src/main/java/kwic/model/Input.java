package kwic.model;

import java.io.FileInputStream;

public class Input extends Filter {
  private FileInputStream fileInput;

  public Input(FileInputStream input, Pipe output){
    super(null, output);
    this.fileInput = input;
  }

  @Override
  public void run() {

  }
}
