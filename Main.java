
import java.util.Scanner;
import java.util.Random;
class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        System.out.println("Hallo en welkom bij BOTER KAAS en EIEREN");
        int row = -1;
        int col = -1;
        boolean XaanZet = rand.nextBoolean();
        BKE bke = new BKE();
        while(true) {
            if (bke.getAantalZetten() == 9) {
                System.out.println("NO WINNER ! game is a TIE!");
                break;
            } else {
                System.out.println((XaanZet ? 'X' : 'O') + " aan zet. geef row col ..");
                String inpStr = sc.nextLine();
                if (!checkInput(inpStr)) {
                    System.out.println("Wrong input. try again.");
                } else {
                    String[] inpArr = inpStr.split(" ");
                    row = Integer.parseInt(inpArr[0]) - 1;
                    col = Integer.parseInt(inpArr[1]) - 1;
                    if (bke.isEmpty(row, col)) {
                        char sp = XaanZet ? 'X' : 'O';
                        bke.zet(sp, row, col);
                        XaanZet = !XaanZet;
                        if (BKE.gameOver) {
                            System.out.println(BKE.winnaar + " heeft gewonnen!");
                            System.out.println(bke.getLog());
                            break;
                        }
                    } else {
                        System.out.println("spot " + (row + 1) + "," + (col + 1) + " is taken. try again.");
                    }
                }
            }
        }
    }

    /*
     * Check if input matches "X X"
     * Where X is 1, 2 or 3
     * return false otherwise
     */
    private static boolean checkInput(String str) {
        boolean succes = false;
        if (str.length() == 3) {
            if ((str.charAt(0) > 48 && str.charAt(0) < 52)&&(str.charAt(2) > 48 && str.charAt(2) < 52) && str.charAt(1) == ' ') succes = true;
        }
        return succes;
    }
}