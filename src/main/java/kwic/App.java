package kwic;

import kwic.model.KWIC;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        (new KWIC()).execute(args[1]);
    }

}
