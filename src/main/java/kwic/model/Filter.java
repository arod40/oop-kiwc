package kwic.model;

public class Filter implements Runnable {
  protected Pipe input;
  protected Pipe output;

  public Filter(Pipe input, Pipe output){
    this.input = input;
    this.output = output;
  }

  public void start() {
    Thread t = new Thread(this);
    t.start();
  }

  @Override
  public void run() {
    throw new UnsupportedOperationException("Calling Filter run");
  }


}
