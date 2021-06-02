//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package MazeOfItay;

class Cell {
    private int prize;
    private boolean Left_Wall;
    private boolean Right_Wall;
    private boolean Up_Wall;
    private boolean Down_Wall;
    private boolean Empty = false;
    private boolean Intrnal = false;
    public static final String ANSI_YELLOW = "\u001B[33m";

    public Cell() {
        this.Down_Wall = false;
        this.Up_Wall = false;
        this.Right_Wall = false;
        this.Left_Wall = false;
    }

    public Cell(boolean L, boolean R, boolean U, boolean D, boolean door) {
        this.Down_Wall = D;
        this.Up_Wall = U;
        this.Right_Wall = R;
        this.Left_Wall = L;
    }

    public int getPrize() {
        return this.prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public boolean isLeft_Wall() {
        return this.Left_Wall;
    }

    public void setLeft_Wall(boolean left_Wall) {
        this.Left_Wall = left_Wall;
    }

    public boolean isRight_Wall() {
        return this.Right_Wall;
    }

    public void setRight_Wall(boolean right_Wall) {
        this.Right_Wall = right_Wall;
    }

    public boolean isUp_Wall() {
        return this.Up_Wall;
    }

    public void setUp_Wall(boolean up_Wall) {
        this.Up_Wall = up_Wall;
    }

    public boolean isDown_Wall() { return this.Down_Wall; }

    public void setDown_Wall(boolean down_Wall) {
        this.Down_Wall = down_Wall;
    }

    public boolean isEmpty() {
        return this.Empty;
    }

    public void setEmpty(boolean empty) {
        this.Empty = empty;
    }

    public boolean isInternal() {
        return this.Intrnal;
    }

    public void setIntrnal(boolean internal) {
        this.Intrnal = internal;
    }
}
