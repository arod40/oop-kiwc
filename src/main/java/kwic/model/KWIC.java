package kwic.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class KWIC {
  public void execute(String file) throws FileNotFoundException {
    Pipe inCS = new Pipe();
    Pipe csAl = new Pipe();
    Pipe alOu = new Pipe();
    FileInputStream in = new FileInputStream(file);
    Input input = new Input(in, inCS);
    CircularShifter shifter =new CircularShifter(inCS,csAl);
    Alphabetizer alpha = new Alphabetizer(csAl, alOu);
    Output output = new Output(alOu);
    input.run();shifter.run();
    alpha.run();output.run();
  }
}
