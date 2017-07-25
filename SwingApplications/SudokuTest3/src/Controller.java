
import javax.swing.JTextField;


public class Controller {
    public static boolean isValidRow(int r, int c, JTextField[][] tfCells)
    {
        String[] requiredNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String number : requiredNumbers) {
            if(tfCells[r][c].getText().contains(number))
                return true;
        }
        return false;
    }
    
    public static boolean checkColumn(int r,int c, JTextField[][] tfCells)
    {
        for (int i = 0; i < 9; i++) {
            if(game.tfCells[i][c] != tfCells[r][c] && game.tfCells[i][c].getText().contentEquals(tfCells[r][c].getText()))
                return false;
        }
        return true;
    }
    
    public static boolean checkRow(int r, int c, JTextField[][] tfCells)
    {
        for (int i = 0; i < 9; i++) {
            if(game.tfCells[r][i] != tfCells[r][c] && game.tfCells[r][i].getText().contentEquals(tfCells[r][c].getText()))
                return false;
        }
        return true;
    }
    
    public static boolean checkSquare(int r, int c, JTextField[][] tfCells)
    {
        String temp = "";
        for (int i = 0; i < 9; i++) {
            temp += tfCells[i][c].getText();//horizontal
            temp += tfCells[r][i].getText();//verical
            temp += tfCells[(r/3)*3+i/3][(c/3)*3+i%3].getText();//square
        }
        int count=0, idx=0;
        while ((idx=temp.indexOf(tfCells[r][c].getText(), idx))!=-1)
        {idx++; count++;}
        return count==3;
    }
}
