
import java.util.ArrayList;
public class BKE {
    private static final int DIMROW = 3;
    private static final int DIMCOL = 3;
    private ArrayList<BKEzet> zetten;
    private int aantalZetten;
    public static boolean gameOver;
    public static char winnaar;
    private char[][] raster;

    public BKE() {
        raster = new char[DIMROW][DIMCOL];
        initRaster();
        zetten = new ArrayList<>();
        aantalZetten = 0;
        gameOver = false;
        printRaster();
    }

    public int getAantalZetten () {
        return this.aantalZetten;
    }

    public String getLog() {
        return returnLogData();
    }

    public boolean isEmpty(int row, int col){
        return checkEmpty(row, col);
    }

    private boolean checkEmpty(int row, int col){
        if (raster[row][col] == ' ') return true;
        else return false;
    }

    private String returnLogData() {
        if (zetten.size() == 0) return "";
        else {
            StringBuilder sb = new StringBuilder();
            for (BKEzet b : zetten) {
                sb.append(b.toString());
            }
            return sb.toString();
        }
    }

    public boolean zet(char speler, int row, int col) {
        if (raster[row][col] != ' ') return false;
        else {
            raster[row][col] = speler;
            voegZetToeLog(speler, row, col);
            checkWinnaar();
            aantalZetten++;
            printRaster();
            return true;
        }
    }

    private void voegZetToeLog(char spelerAanZet, int row, int col) {
        zetten.add(new BKEzet(spelerAanZet, row, col));
    }

    private void printRaster(){
        System.out.printf("   1   2   3%n");
        System.out.printf(" +---|---|---+%n");
        for (int i=0;i<DIMROW;i++){
            System.out.printf("%d|",i+1);
            for (int j=0;j<DIMCOL;j++){
                System.out.printf(" %s |",raster[i][j]);
            }
            System.out.printf("%n");
            System.out.printf(" +---|---|---+%n");
        }
    }

    private void initRaster() {
        for(int i = 0; i < DIMROW; i++){
            for(int j = 0; j < DIMCOL; j++){
                raster[i][j] = ' ';
            }
        }
    }

    private boolean checkWinnaar() {
        boolean win = false;
        for(int i = 0; i < DIMROW; i++){
            if(raster[i][0] == 'O' && raster[i][1] == 'O' && raster[i][2]== 'O') {
                winnaar = 'O';
                gameOver = true;
                win = true;
            }
            if (raster[0][i]=='O' && raster[1][i]=='O'&&raster[2][i]=='O'){
                gameOver = true;
                winnaar = 'O';
                win = true;
            }
            if(raster[i][0] == 'X' && raster[i][1] == 'X' && raster[i][2]== 'X') {
                winnaar = 'X';
                gameOver = true;
                win = true;
            }
            if (raster[0][i]=='X' && raster[1][i]=='X'&&raster[2][i]=='X'){
                gameOver = true;
                winnaar = 'X';
                win = true;
            }
        }
        if ((raster[0][0] == 'O' && raster[1][1] == 'O' && raster[2][2] == 'O') || (raster[2][0] == 'O' && raster[1][1] == 'O' && raster[2][0] == 'O')) {
            gameOver = true;
            winnaar = 'O';
            win = true;
        }
        if ((raster[0][0] == 'X' && raster[1][1] == 'X' && raster[2][2] == 'X') || (raster[2][0] == 'X' && raster[1][1] == 'X' && raster[2][0] == 'X')) {
            gameOver = true;
            winnaar = 'X';
            win = true;
        }
        return win;
    }

}