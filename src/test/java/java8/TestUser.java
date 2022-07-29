package java8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestUser {
    User user1 = new User("Vova", 23, 76, "Driver", true);
    User user2 = new User("Roma", 59, 56, "Policeman", true);
    User user3 = new User("Sveta", 76, 87, "Fireman", false);
    User user4 = new User("Grisha", 98, 71, "Cook", true);
    User user5 = new User("Marfa", 34, 73, "Street cleaner", false);
    User user6 = new User("Pety", 54, 56, "carrier", true);
    User user7 = new User("Jora", 67, 66, "sailor", true);
    User user8 = new User("Kely", 27, 86, "cashier", false);
    User user9 = new User("Riki", 58, 26, "groom", true);
    User user10 = new User("Roki", 85, 96, "doctor", true);
    User user11 = new User("Vera", 29, 55, "blogger", false);
    User user12 = new User("Djeki", 43, 44, "model", true);
    User user13 = new User("Bobina", 83, 100, "stuntman", false);
    User user14 = new User("Robin", 22, 120, "builder", true);
    User user15 = new User("Veronica", 58, 54, "QA", false);

    List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12, user13, user14, user15);

    @Test
    public void checkFiltrationAge() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.age == 54;
            }
        });

        for (User user : result) {
            assertThat(user.age).isEqualTo(54);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationName() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.name == "Sveta";
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.name, "Sveta");
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationWeight() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.weight == 55;
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.weight, 55);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationSpeciality() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.speciality == "sailor";
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.speciality, "sailor");
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationSex() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.sex;
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.sex, true);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationUserAllInfo() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.name == "Riki" && user.age == 58 && user.weight == 26 && user.speciality == "groom" && user.sex == true;
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.name, "Riki");
            Assert.assertEquals(user.age, 58);
            Assert.assertEquals(user.weight, 26);
            Assert.assertEquals(user.speciality, "groom");
            Assert.assertEquals(user.sex, true);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationUserOnWeightAndSpecialiti() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.weight == 120 && user.speciality == "builder";
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.weight, 120);
            Assert.assertEquals(user.speciality, "builder");
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationUserOnAgeAndSex() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.age == 29 && user.sex;
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.age, 29);
            Assert.assertEquals(user.sex, false);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationUserOnlyMan() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.sex == true;
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.sex, true);
            System.out.println(user);
        }
    }

    @Test
    public void checkFiltrationUserOnlyWomen() {
        List<User> result = UserCheck.filterCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.sex == false;
            }
        });

        for (User user : result) {
            Assert.assertEquals(user.sex, false);
            System.out.println(user);
        }
    }
}
