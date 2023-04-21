package PalindromeGame;

import java.util.Map;
import java.util.Scanner;

public class IOData {

    /**
     * Метод для ввода имени игрока
     * @return
     */
    public static String enterPlayerName() {

        Scanner in = new Scanner(System.in);
        outputMessage("Введите имя игрока: ");

        while(in.hasNextLine()){
            String name = in.nextLine();
            return name.replaceAll(" ", "");
        }
        return null;
    }

    /**
     * Метод для ввода слова или фразы
     * @return
     */
    public static String enterText() {

        Scanner in = new Scanner(System.in);
        outputMessage("Введите палиндром: ");

        while (in.hasNextLine()) {
            String text = in.nextLine();
            return text;
        }
        return null;
    }

    /**
     * Метод для вывода сообщения
     * @param text
     */
    public static void outputMessage(String text){
        System.out.println(text);
    }

    public static void outputRatingTable(){
        outputMessage("Таблица рейтинга игроков: ");
        Map<String, Integer> ratingTable = PlayerBase.ratingTable();
        for(Map.Entry<String, Integer> entry : ratingTable.entrySet()){
            outputMessage(entry.getKey() + " : " + entry.getValue());
        }
    }
}
