//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package MazeOfItay;

public class Player {
    private String Name;
    private int score = 0;
    private int x;
    private int y;
    private boolean isPlayerCanPlay = true;
    public static final String TEXT_RESET = "\u001B[0m";


    public Player(String name) {
        name = name.substring(0, 5);
        this.Name = name;
    }

    public int getScore() {
        return this.score;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getName() {
        return TEXT_RESET+this.Name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPlayerCanPlay() {
        return this.isPlayerCanPlay;
    }

    public void setPlayerCanPlay(boolean playerCanPlay) {
        this.isPlayerCanPlay = playerCanPlay;
    }
}
