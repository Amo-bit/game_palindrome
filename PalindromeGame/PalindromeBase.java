package PalindromeGame;

import java.util.ArrayList;
import java.util.List;

public class PalindromeBase {

    private static List<String> spisPaliindrome = new ArrayList<>();

    /**
     * Метод проверки существования палиндрома в базе
     * @param newPalindrome - метод принимает объект класса PalindromeGame.Palindrome
     * @return
     */
    public static boolean checkExistencePalindromeInBase(Palindrome newPalindrome){
        for(String palindrome : spisPaliindrome){
            if(palindrome.equals(newPalindrome.getText())){
                return true;
            }
        }
        return false;
    }

    /**
     * Метод для обновления базы палиндромов игры
     * @param palindrome - метод принимает объект класса PalindromeGame.Palindrome
     * @return
     */
    public static void updateBase(Palindrome palindrome){
        spisPaliindrome.add(palindrome.getText());
    }

    /**
     * Метод для получения списка полиндромов, участвоваших в игре
     * @return
     */
    public static List<String> getSpisPaliindrome(){
        return spisPaliindrome;
    }
}
