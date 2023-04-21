package PalindromeGame;

public class Player {

    private final String name;
    private int score;

    private Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Метод для создания игрока
     * @param name - имя игрока
     * @return
     */
    public static Player createPlayer(String name, int score){
        return new Player(name.toUpperCase(), score);
    }
}
