import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Пусть дан список сотрудников:
 * 
 * Иван Иванов, Светлана Петрова, Кристина Белова,
 * Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр
 * Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина
 * Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов
 * 
 * Написать программу, которая найдет и выведет повторяющиеся имена с
 * количеством повторений.
 * Отсортировать по убыванию популярности.
 * Для сортировки использовать TreeMap.
 */

public class task_02 {
    public static void main(String[] args) {
        ArrayList<String> staff = new ArrayList<>();
        getNamesStaffList(staff);
        System.out.println(staff);

        System.out.println(sortByValues(getTreeMapStaff(staff)));
        
        // Map<Integer, List<String>> mapStaff = getRef(getTreeMapStaff(staff));
    }

    private static Map<String, Integer> getTreeMapStaff(ArrayList<String> staff) {
        Map<String, Integer> map = new TreeMap<>();
        int count = 1;

        for (int i = 0; i < staff.size(); i++) {
            for (int j = i + 1; j < staff.size(); j++) {
                if (staff.get(i).equals(staff.get(j)))
                    count++;
            }
            if (!map.containsKey(staff.get(i)) && count > 1) {
                map.put(staff.get(i), count);
            }
            count = 1;
        }
        return map;
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;                                          // компаратор взят с overflow
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    private static void getNamesStaffList(ArrayList<String> staff) {
        String[] arrStaff = new String[] { "Иван Иванов", "Светлана Петрова",
                "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов" };
        // [Иван, Светлана, Кристина, Анна, Анна, Иван, Петр, Павел, Петр, Мария,
        // Марина, Мария, Мария, Марина, Анна, Иван, Петр, Иван]
        for (String str : arrStaff) {
            staff.add(str.split(" ")[0]);
        }
    }

    // private static Map<Integer, List<String>> getRef(Map<String, Integer> map) {
    //     Map<Integer, List<String>> mapRef = new TreeMap<>(Collections.reverseOrder());

    //     for (Map.Entry<String, Integer> entry : map.entrySet()) {
    //         mapRef.put(entry.getValue(), new ArrayList<String>());
    //     }
    //     for (Map.Entry<String, Integer> entry : map.entrySet()) {
    //         int temp = map.get()
    //         if (entry.getValue()) {
                
    //         }
    //         mapRef.put(entry.getValue(), null)
    //     }
    // }
}