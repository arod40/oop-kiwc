package kwic.model;

/**
 * Sort a set of all lines based on the first word (keyword)
 * in alphabetic order.
 */
public class Alphabetizer extends Filter {
  public Alphabetizer(Pipe input, Pipe output) {
    super(input, output);
  }

  @Override
  public void run() {
    /*
    create a sorted buffer
    while input pipe not empty
    {
       put line into buffer
    }

    while buffer not empty
       getNext()

     */
  }
}
