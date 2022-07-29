package java8;

import java.util.LinkedList;
import java.util.List;

public interface UserCheck {
    boolean checkConditions(User user);

    static List<User> filterCondition(List<User> usersData, UserCheck userCheck) {
        List<User> userList = new LinkedList<>();
        for (User userInfo : usersData) {
            if (userCheck.checkConditions(userInfo)) {
                userList.add(userInfo);
            }
        }
        return userList;
    }
}
