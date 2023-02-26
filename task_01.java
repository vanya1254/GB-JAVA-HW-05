import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
 * человек может иметь несколько телефонов.
 * 
 * {id={phone=["name", "comment"],
 *      phone2=["name", "comment2"]},                   выбрал такую структуру и заполнил ее автоматизировано
 *  id={phone=["name", "comment"],
 * }
 */

public class task_01 {
    public static void main(String[] args) {
        Map<Integer, Map<Integer, List<String>>> mapId = new HashMap<>();
        int countId = 10;
        String[] names = new String[] { "Иванов", "Сидоров", "Петров",
                                        "Михайлов", "Лешкин", "Ляпкин",
                                        "Язов", "Петров", "Иванов", "Сидоров" };
        String[] comments = new String[] { "Личный", "Рабочий", "Домашний" };

        getIdsForMap(mapId, countId);

        getRndPhoneNumbersForMap(mapId);

        pushNamesComments(mapId, names, comments);

        printMapId(mapId);
    }

    private static void printMapId(Map<Integer, Map<Integer, List<String>>> map) {
        for (Entry<Integer, Map<Integer, List<String>>> entry : map.entrySet()) {
            System.out.printf("\n%s =>",entry.getKey());
            for (Entry<Integer, List<String>> entry2 : entry.getValue().entrySet()) {
                System.out.printf("\t%s", entry2);                                // выведет в терминал в приемлимом виде для глаз
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void pushNamesComments(Map<Integer, Map<Integer, List<String>>> map, String[] names, String[] comments) {
        Random rnd = new Random();
        for (Entry<Integer, Map<Integer, List<String>>> entry : map.entrySet()) {
            for (Entry<Integer, List<String>> entry2 : entry.getValue().entrySet()) {
                for (int i = 0; i < names.length; i++) {
                    if (entry.getKey() == i) {
                        entry2.getValue().add(names[i]);
                        entry2.getValue().add(comments[rnd.nextInt(comments.length)]);
                        break;                                                            // добавит имена по порядку из переданного массива и случайные комменты из массива
                    }
                }
            }
        }
    }

    private static void getRndPhoneNumbersForMap(Map<Integer, Map<Integer, List<String>>> mapId) {
        Random rnd = new Random();
        for (Entry<Integer, Map<Integer, List<String>>> entry : mapId.entrySet()) {       // сконструирует arraylist`ы и заполнит ключами(номера телофонов) вложенные hashmap`ы
            for (int i = 0; i < rnd.nextInt(1, 3); i++) {
                entry.getValue().put(rnd.nextInt(111111111, 999999999), new ArrayList<String>());
            }
        }
    }

    private static void getIdsForMap(Map<Integer, Map<Integer, List<String>>> map, int count) {
        for (int i = 0; i < count; i++) {
            map.put(i, new HashMap<Integer, List<String>>());                             // сконструирует вложенные hashmap`ы и заполнит ключами(id персон) внешний hashmap
        }
    }
}