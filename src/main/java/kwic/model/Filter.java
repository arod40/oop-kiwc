package kwic.model;

public class Filter implements  Runnable{
  protected Pipe input;
  protected Pipe output;

  public Filter(Pipe input, Pipe output){
    this.input = input;
    this.output = output;
  }

  @Override
  public void run() {
    throw new UnsupportedOperationException();
  }
}
