package PalindromeGame;

public class Palindrome {

    private final String text;
    private final int score;

    private Palindrome(String text, int score) {
        this.text = text;
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public int getScore() {
        return score;
    }

    /**
     * Метод для создания палиндрома
     * @param text -  фраза или слово
     * @return
     */
    public static Palindrome createPalindrome(String text){

        text = text.replaceAll(" ", "");
        return new Palindrome(text, countPoints(text));
    }

    /**
     * Метод для проверки слова или фразы на полиндром
     * @param text
     * @return
     */
    public static boolean checkPalindrome(String text){

        if(text.isEmpty()) return false;
        text = text.replaceAll(" ", "");
        StringBuilder sb = new StringBuilder(text);

        if(text.equalsIgnoreCase(sb.reverse().toString())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Метод для подсчета баллов за палиндром
     * @param text
     * @return
     */
    private static int countPoints(String text){
        return text.length();
    }
}
