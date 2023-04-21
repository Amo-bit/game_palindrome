package PalindromeGame;

public class GamePalindrome {

    private static String name;
    private static String text;
    private static Player player;
    private static Palindrome palindrome;

    public static void startGame(){

        IOData.outputMessage("ИГРА ПАЛИНДРОМ");

        while(true) {
            createPlayer();                 //создаем игрока
            enterText();                    //получаем слово или фразу от игрока
            if (checkText()) {              //проверяем слова или фразу на полиндром и использовались ли уже в игре ранее
                updateScorePlayer();        //обновляем счет игрока
            }
            outputRatingTable();            //выводим таблицу результатов
        }
    }

    /**
     * Метод для создания игрока
     * @return
     */
    private static void createPlayer(){

        name = IOData.enterPlayerName();                       //вводим имя игрока
        player = Player.createPlayer(name, 0);           //создаем игрока
        if(PlayerBase.checkPlayer(player)){                    //проверяем есть ли игрок в базе, если есть то получаем его счет из базы
            player = PlayerBase.getPlayer(player);
        }
    }

    /**
     * Метод получения слова или фразу от игрока
     */
    private static void enterText(){
        text = IOData.enterText();
    }

    /**
    * Метод для проверки слова или фразы на полиндром и использовались ли уже в игре ранее
    */
    private static boolean  checkText(){
        if(Palindrome.checkPalindrome(text)){                                    //проверяем является ли слово или фраза полиндромом
            palindrome = Palindrome.createPalindrome(text);                     //создаем палиндром и считаем баллы за него
            if(PalindromeBase.checkExistencePalindromeInBase(palindrome)){      //проверяем есть ли палиндром в базе
                IOData.outputMessage("Слово или фраза ранее использовались в игре!");
                return false;
            }else{
                IOData.outputMessage("Слово или фраза является палиндромом и ранее не использовались в игре!");
                return true;
            }
        }else{
            IOData.outputMessage("Слово или фраза не является палиндромом! \nБаллы не начисляются!");
            PlayerBase.updateBase(player); // добавлляем игрока в базу даже если оон предложил неверный палиндром
            IOData.outputMessage("Попробуйте еще раз!");
            return false;
        }
    }

    /**
     * Метод для обновления результата игрока
     */
    private static void updateScorePlayer(){
        player.setScore(player.getScore() + palindrome.getScore());     //обновляем счет игрока
        PlayerBase.updateBase(player);                                  //обновляем результаты игрока
        PalindromeBase.updateBase(palindrome);                          //добавляем палиндром в базу
        IOData.outputMessage("Начислено " + palindrome.getScore()
                + "\nОбщий счет игрока " + player.getName() + " " + player.getScore());
    }

    /**
     * Метод для вывода таблицы результатов 5 лучших игроков
     */
    private static void outputRatingTable(){
        IOData.outputRatingTable();
    }
}
