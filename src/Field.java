import java.util.Arrays;
import java.util.Random;

public class Field {
    private double difficultyModifier = 0.02;
    private int width;
    private int height;
    private double difficulty;
    private int[][] hiddenField;
    private int[][] visibleField;

    Field(double difficulty, int height, int width) {
        this.difficulty = difficulty * difficultyModifier;
        this.height = height;
        this.width = width;
        this.hiddenField = new int[this.height][this.width];
        this.visibleField = new int[this.height][this.width];

        generateHiddenField(this.height, this.width);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int[][] getVisibleField() {
        return this.visibleField;
    }
    public void setVisibleField(int y, int x, int payload) {
        this.visibleField[y][x] = payload;
    }
    public int[][] getHiddenField() {
        return this.hiddenField;
    }
    public void setHiddenField(int y, int x, int payload) {
        this.hiddenField[y][x] = payload;
    }

    private int[][] generateHiddenField(int height, int width) {
        int[][] hiddenField = new int[height][width];
        int numOfMines = generateNumOfMines();
        System.out.println(numOfMines);
        while (numOfMines > 0) {
            Random random = new Random();
            int x = random.nextInt(this.width);
            int y = random.nextInt(this.height);
            System.out.print("x: " + x + " y: " + y);
            setHiddenField(y, x,  100);
            numOfMines--;
        }
        generateFieldNumbers();
        return hiddenField;
    }
    private void generateFieldNumbers() {
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
    private int generateNumOfMines() {
        int area = this.height * this.width;
        double numOfMines = area * this.difficulty;

        return (int) numOfMines;
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
