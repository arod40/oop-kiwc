package kwic.model;

public class Output extends Filter {
  /**
   * Constructs the output filter
   * @param input Input pipe
   */
  public Output(Pipe input) {
    super(input, null);
  }

  /**
   * Runs the thread, printing output to the screen when received
   */
  @Override
  public void run() {
    String line;
    while ((line = input.readLine()) != null) {
      System.out.println(line);
    }
  }

}
