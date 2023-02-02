package kwic.model;

public class Filter implements Runnable {
  protected Pipe input;
  protected Pipe output;

  /**
   * Constructs a filter object with input and output pipes.
   * @param input Input pipe
   * @param output Output pipe
   */
  public Filter(Pipe input, Pipe output){
    this.input = input;
    this.output = output;
  }

  /**
   * Starts the given thread.
   */
  public void start() {
    Thread t = new Thread(this);
    t.start();
  }

  /**
   * This should be overridden by child classes, not called directly
   * @throws UnsupportedOperationException this should not be called directly
   */
  @Override
  public void run() {
    throw new UnsupportedOperationException("Calling Filter run directly");
  }


}
