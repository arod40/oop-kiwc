package kwic.model;

/**
 * Group data by line, remove words from
 * start and append to the end until
 * the keyword is the first index.
 */
public class CircularShifter extends Filter {
  public CircularShifter(Pipe input, Pipe output) {
    super(input, output);
  }

  /** Question -> are we searching for only keywords in the title, or doing a full concordance listing
   *  Every instance of every word? Every instance of the word in the title? etc */
  @Override
  public void run() {
    /*
    while input pipe not empty
    {
       permute through line
       if keyword at index 0 -> push to output pipe
       if full circle -> trash line
    }
     */
  }
}
