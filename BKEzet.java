
import java.util.Scanner;

public class BKEzet {
    private char speler;
    private int row;
    private int col;

    public BKEzet(char s, int r, int c) {
        speler = s;
        row = r;
        col = c;
    }

    public String toString() {
        String tmp = "";
        tmp += String.format("%c : %d,%d%n",speler ,row + 1, col + 1);
        return tmp;
    }
}
