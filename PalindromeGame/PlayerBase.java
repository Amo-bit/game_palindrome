package PalindromeGame;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerBase {

    private static Map<String, Integer> spisPlayers = new HashMap<>();

    /**
     * Метод для проверки существования игрока в базе
     * @param player - объект класса PalindromeGame.Player
     * @return
     */
    public static boolean checkPlayer(Player player){

        Iterator<String> it = spisPlayers.keySet().iterator();
        while(it.hasNext()){
            if(it.next().equals(player.getName())){
                return true;
            }
        }
        return false;
    }

    /**
     * Метод для получения игрока из базы, если игрока нет в базе, он создается
     * @param player - объект класса PalindromeGame.Player
     * @return
     */
    public static Player getPlayer(Player player){
        return Player.createPlayer(player.getName(), spisPlayers.get(player.getName()));
    }

    /**
     * Метод для обновления базы игроков
     * @param player - метод принимает объект класса PalindromeGame.Player
     * @return
     */
    public static void updateBase(Player player){
        spisPlayers.put(player.getName(), player.getScore());
    }

    /**
     * Метод для получения таблицы рейтинга, в таблице рейтинга указываются только первые 5 игроков
     * @return - результат работы метода таблица рейтинга в виде Map<String, Integer>
     */
    public static Map<String, Integer> ratingTable(){
        return spisPlayers.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
    }
}
