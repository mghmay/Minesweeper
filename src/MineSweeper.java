import java.util.Arrays;

public class MineSweeper {
    public void startGame() {
        int hwGreaterThan = 10;
        int hwLessThan = 50;

        System.out.println("Welcome to Minesweeper \n");

//        System.out.println("Pick a grid height");
//        int height = Display.validateInteger(hwGreaterThan, hwLessThan);
//
//        System.out.println("Pick a grid width");
//        int width = Display.validateInteger(hwGreaterThan, hwLessThan);
//
//        System.out.println("Pick a difficulty");
//        int difficulty = Display.validateInteger(1, 10);

        Game myGame = new Game();
        Field myField = new Field(5, 10, 10);

        boolean playing = true;
        while (playing) {
            myField.generateVisibleField();
            int[][] hiddenField = myField.getHiddenField();
            for (int i = 0; i < 9; i++) {
                System.out.print(Arrays.toString(hiddenField[i]));
            }
            myField.getHiddenField();
            System.out.println("\nRow");
            int row = Display.validateInteger(0, 10);

            System.out.println("Column");
            int col = Display.validateInteger(0, 10);

            playing = myGame.makeMove(row, col, myField);
            if (myGame.checkWin(myField)) {
                myGame.displayHidden(myField);
                System.out.print("You win!");
            }
        }
    }
}
