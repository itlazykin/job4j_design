package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {
    /**
     * Сравнивает две коллекции и вычисляет количество добавленных, изменённых и удалённых пользователей.
     *
     * @param previous коллекция.
     * @param current коллекция.
     * @return объект Info с количеством добавленных, изменённых и удалённых пользователей.
     */
    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> prev = new HashMap<>();
        int added = 0;
        int changed = 0;
        int deleted = previous.size();
        for (User user : previous) {
            prev.put(user.getId(), user.getName());
        }
        for (User currentUser : current) {
            int id = currentUser.getId();
            if (prev.containsKey(id)) {
                deleted--;
                if (!prev.get(id).equals(currentUser.getName())) {
                    changed++;
                }
            } else {
                added++;
            }
        }
        return new Info(added, changed, deleted);
    }
}
