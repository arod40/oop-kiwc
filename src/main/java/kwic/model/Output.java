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
      printHighlighted(line);
    }
  }

  private static void printHighlighted(String line) {
    String ANSI_START = "\033[31;1m";
    String ANSI_END = "\033[0m";
    System.out.println(ANSI_START + line.substring(0, line.indexOf(' ')) + ANSI_END
            + line.substring(line.indexOf(' ')));
  }

}
