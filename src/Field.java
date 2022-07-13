import java.util.Arrays;
import java.util.Random;

public class Field {

    private double difficultyModifier = 0.02;

    private int width;
    private int height;
    private double difficulty;
    private int[][] hiddenField;

    private int[][] visibleField;

    Field(int difficulty, int height, int width) {
        this.difficulty = difficulty * difficultyModifier;
        this.height = height;
        this.width = width;
        this.hiddenField = this.generateHiddenField();
        this.visibleField = this.createVisibleField();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getHiddenField() {
        return this.hiddenField;
    }

    private int[][] generateHiddenField() {
        this.hiddenField = new int[this.height][this.width];
        int numOfMines = getNumOfMines();
        System.out.println(numOfMines);
        while (numOfMines > 0) {
            Random random = new Random();
            int x = random.nextInt(this.height);
            int y = random.nextInt(this.width);
            System.out.print("x: " + x + " y: " + y);
            this.hiddenField[x][y] = 100;
            numOfMines--;
        }
        getFieldNumbers();
        return this.hiddenField;
    }

    private void getFieldNumbers(){
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                int mineCount = 0;
                if(this.hiddenField[y][x] != 100) {
                    if (y != 0) {
                        if (this.hiddenField[y - 1][x] == 100) mineCount++;
                        if (x != 0) {
                            if (this.hiddenField[y - 1][x - 1] == 100) mineCount++;
                        }
                    }
                    if (y != this.height - 1) {
                        if (this.hiddenField[y + 1][x] == 100) mineCount++;
                        if (x != this.width - 1) {
                            if (this.hiddenField[y + 1][x + 1] == 100) mineCount++;
                        }
                    }
                    if (x != 0) {
                        if (this.hiddenField[y][x - 1] == 100) mineCount++;
                        if (y != this.height - 1) {
                            if (this.hiddenField[y + 1][x - 1] == 100) mineCount++;
                        }
                    }
                    if (x != this.width - 1) {
                        if (this.hiddenField[y][x + 1] == 100) mineCount++;
                        if (y != 0) {
                            if (this.hiddenField[y - 1][x + 1] == 100) mineCount++;
                        }
                    }
                    this.hiddenField[y][x] = mineCount;
                }
            }
        }
    }

    private int getNumOfMines() {
        int area = this.height * this.width;
        double numOfMines = area * this.difficulty;

        return (int) numOfMines;
    }

    public int[][] getVisibleField() {
        return this.visibleField;
    }

    public void setVisibleField(int x, int y, int payload) {
        this.visibleField[y][x] = payload;
    }

    private int[][] createVisibleField() {
        this.visibleField = new int[this.height][this.width];
        return this.visibleField;
    }

    public int[][] generateVisibleField() {
        System.out.println("\t ");
        for (int i = 0; i < this.width; i++) {
            if (i == 0) {
                System.out.print("    ");
            }
            System.out.print("  " + i + " ");
        }
        System.out.print("\n");
        for (int y = 0; y < this.height; y++) {
            System.out.print(y + "\t| ");
            for (int x = 0; x < this.width; x++) {
                if (this.visibleField[y][x] == 0) {
                    System.out.print("#");
                } else if (this.visibleField[y][x] == 50) {
                    System.out.print(" ");
                } else {
                    System.out.print((this.visibleField[y][x]));
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
//        for (int i = 0; i < this.height; i++) {
//            System.out.print(Arrays.toString(this.visibleField[i]));
//        }
        return this.visibleField;
    }
}


//        for (int i = 0; i < this.height; i++) {
//        System.out.print(Arrays.toString(this.visibleField[i]));
//        }
