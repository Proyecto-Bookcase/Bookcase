package auxiliary_classes;

import java.util.Random;
import java.util.stream.IntStream;

import javax.swing.text.html.HTMLDocument.Iterator;

import classes.Bookcase;

public final class AuxMethods {

    private AuxMethods() {
    }

    public static String randomNumberString(int lenght) {

        Random random = new Random();
        StringBuilder strBuilder = new StringBuilder(lenght);
        boolean check = false;
        while (!check) {
            String intStream = random.ints(lenght, 0, 10).toArray().toString();
            check = Bookcase.getInstance().
        }

        return strBuilder.toString();
    }

}
