package kwic;

import kwic.model.KWIC;

import java.io.FileNotFoundException;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException {
        (new KWIC()).execute(args[0]);
    }

}
