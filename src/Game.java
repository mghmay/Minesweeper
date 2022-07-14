import java.util.*;

public class Game {
    // make move
    public static boolean makeMove(int row, int col, Field myField) {

        int[][] hiddenField = myField.getHiddenField();
        int[][] visibleField = myField.getVisibleField();

        if (visibleField[row][col] != 0) {
            System.out.print("\nIncorrect Input!");
            return true;
        }
        if (hiddenField[row][col] == 100) {
            displayHidden(myField);
            System.out.print("You stood on a mine and were blasted into a million pieces. That's what you get for stepping on minefields.");
            return false;
        } else if (hiddenField[row][col] == 0) {
            makeVisible(row, col, myField);
        } else {
            makeVisibleNeighbour(row, col, myField);
        }
        return true;
    }

    private static void makeVisible(int row, int col, Field myField) {
        myField.setVisibleField(row, col, 50);
        int[][] hiddenField = myField.getHiddenField();
        int[][] visibleField = myField.getVisibleField();
//        System.out.print("Triggered");
//        for (int i = 0; i < visibleField.length; i++) {
//            System.out.println("Visible Field:" + Arrays.toString(visibleField[i]));
//        }
//        for (int i = 0; i < visibleField.length; i++) {
//            System.out.print("Hidden Field: " + Arrays.toString(hiddenField[i]));
//        }
        if (row != 0) {
            myField.setVisibleField(row - 1, col, hiddenField[row - 1][col]);
            if (visibleField[row - 1][col] == 0) myField.setVisibleField(row - 1, col, 50);
            if (col != 0) {
                myField.setVisibleField(row - 1, col - 1, hiddenField[row - 1][col - 1]);
                if (visibleField[row - 1][col - 1] == 0)  myField.setVisibleField(row - 1, col - 1, 50);
            }
        }
        if (row != myField.getHeight() - 1) {
            myField.setVisibleField(row + 1, col,  hiddenField[row + 1][col]);
            if (visibleField[row + 1][col] == 0) myField.setVisibleField(row + 1, col, 50);
            if (col != 9) {
                myField.setVisibleField(row + 1, col + 1, hiddenField[row + 1][col + 1]);
                if (visibleField[row + 1][col + 1] == 0) myField.setVisibleField(row + 1, col + 1, 50);
            }
        }
        if (col != 0) {
            myField.setVisibleField(row, col - 1, hiddenField[row][col - 1]);
            if (visibleField[row][col - 1] == 0) myField.setVisibleField(row, col - 1, 50);
            if (col != 9) {
                myField.setVisibleField(row + 1, col - 1, hiddenField[row][col - 1]);
                if (visibleField[row + 1][col - 1] == 0) myField.setVisibleField(row + 1, col - 1, 50);
            }
        }
        if (col != myField.getWidth() - 1) {
            myField.setVisibleField( row, col + 1, hiddenField[row][col + 1]);
            if (visibleField[row][col + 1] == 0) myField.setVisibleField(row, col + 1, 50);
            if (row != 0) {
                myField.setVisibleField(row - 1, col + 1, hiddenField[row - 1][col + 1]);
                if (visibleField[row - 1][col + 1] == 0) myField.setVisibleField(row + 1, col - 1, 50);
            }
        }
    }

    public static void makeVisibleNeighbour(int row, int col, Field myField) {
        Random random = new Random();
        int rand = random.nextInt(4) ;

        int[][] hiddenField = myField.getHiddenField();
        int[][] visibleField = myField.getVisibleField();

        myField.setVisibleField(row, col, hiddenField[row][col]);

        if (rand == 0) {
            if (row != 0) {
                if (hiddenField[row - 1][col] != 100) {
                    myField.setVisibleField(row - 1, col, hiddenField[row - 1][col]);
                    if(visibleField[row-1][col]==0)  myField.setVisibleField(row-1, col, 50);
                }
            } if (col != 0) {
                if (hiddenField[row][col-1] != 100) {
                    myField.setVisibleField(row, col-1, hiddenField[row][col-1]);
                    if(visibleField[row][col-1]==0) myField.setVisibleField(row, col-1, 50);
                }
            } if (row !=0 && col!=0) {
                if (hiddenField[row-1][col-1] != 100) {
                    myField.setVisibleField(row-1, col-1, hiddenField[row-1][col-1]);
                    if(visibleField[row][col-1]==0) myField.setVisibleField(row-1, col-1, 50);
                }
            }
        } else if (rand==1) {
            if (row != 0) {
                if (hiddenField[row - 1][col] != 100) {
                    myField.setVisibleField(row - 1, col,  hiddenField[row - 1][col]);
                    if(visibleField[row-1][col]==0)  myField.setVisibleField(row-1, col, 50);
                }
            } if (col != myField.getHeight() - 1) {
                if (hiddenField[row][col] != 100) {
                    myField.setVisibleField(row, col+1, hiddenField[row][col+1]);
                    if(visibleField[row][col+1]==0)  myField.setVisibleField(row, col+1, 50);
                }
            } if (row!=0 && col!=myField.getHeight() - 1) {
                if (hiddenField[row-1][col+1] != 100) {
                    myField.setVisibleField(row-1, col+1, hiddenField[row-1][col+1]);
                    if(visibleField[row-1][col+1]==0) myField.setVisibleField(row-1,col-1, 50);
                }
            }
        } else if (rand == 2) {
            if(row!=myField.getWidth() - 1)
            {
                if(hiddenField[row+1][col]!=100)
                {
                    myField.setVisibleField(row+1, col, hiddenField[row+1][col]);
                    if(visibleField[row+1][col]==0)  myField.setVisibleField(row+1, col, 50);
                }
            }
            if(col!= myField.getHeight() - 1)
            {
                if(hiddenField[row][col+1]!=100)
                {
                    myField.setVisibleField(row, col+1, hiddenField[row][col+1]);
                    if(visibleField[row][col+1]==0)  myField.setVisibleField(row, col+1, 50);
                }

            }
            if(row!=myField.getWidth() - 1 && col!=myField.getHeight() - 1)
            {
                if(hiddenField[row+1][col+1]!=100)
                {
                    myField.setVisibleField(row+1, col+1, hiddenField[row+1][col+1]);
                    if(visibleField[row+1][col+1]==0)  myField.setVisibleField(row+1, col+1, 50);
                }
            }
        }
        else {
            if(row!=myField.getWidth() - 1) {
                if(hiddenField[row+1][col]!=100) {
                    myField.setVisibleField(row+1, col, hiddenField[row+1][col]);
                    if(visibleField[row+1][col]==0)  myField.setVisibleField(row+1, col, 50);
                }
            } if(col!=0) {
                if(hiddenField[row][col-1]!=100) {
                    myField.setVisibleField(row, col-1, hiddenField[row][col-1]);
                    if(visibleField[row][col-1]==0)  myField.setVisibleField(row, col-1, 50);
                }

            } if(row!=myField.getWidth() - 1 && col!=0) {
                if(hiddenField[row+1][col-1]!=100) {
                    myField.setVisibleField(row+1, col-1, hiddenField[row+1][col-1]);
                    if(visibleField[row+1][col-1]==0)  myField.setVisibleField(row+1, col-1, 50);
                }
            }
        }
    }

    public static void displayHidden(Field myField) {
        int[][] hiddenField = myField.getHiddenField();
        int width = myField.getWidth();
        int height = myField.getHeight();

        System.out.print("\t ");
        for(int i=0; i<width; i++)
        {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<height; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<width; j++)
            {
                if(hiddenField[i][j]==0)
                {
                    System.out.print(" ");
                }
                else if(hiddenField[i][j]==100)
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print(hiddenField[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }

    public boolean checkWin(Field myField) {
        int width = myField.getWidth();
        int height = myField.getHeight();
        int[][] visibleField = myField.getVisibleField();
        int[][] hiddenFiled = myField.getHiddenField();

        for (int i = 0; i < height; i++) {
            for (int j = 0; i < width; j++) {
                if (visibleField[i][j] == 0) {
                    if (hiddenFiled[i][j] != 100) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}