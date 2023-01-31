package kwic.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KWIC {
  public void execute(String file) throws IOException {
    Pipe inCS = new Pipe();
    Pipe csAl = new Pipe();
    Pipe alOu = new Pipe();
    FileInputStream in = new FileInputStream(file);

    Input input = new Input(in, inCS);
    CircularShifter shifter =new CircularShifter(inCS,csAl);
    Alphabetizer alpha = new Alphabetizer(csAl, alOu);
    Output output = new Output(alOu);

    input.start();
    shifter.start();
    alpha.start();
    output.start();
  }
}
