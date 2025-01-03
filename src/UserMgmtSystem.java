import java.util.ArrayList;

public class UserMgmtSystem {
    private static final int MINIMUM_ADULT_AGE = 19;
    ArrayList<User> users;

    public UserMgmtSystem() {
        users = new ArrayList<>();
    }

    private static void verificationUserInfo(User user) {
        if (user.login == null || user.login.isBlank() || user.pw == null || user.pw.isBlank()) {
            throw new NullPointerException("Login 또는 비밀번호 값 누락");
        }
        if (user.age < MINIMUM_ADULT_AGE) {
            throw new IllegalArgumentException(MINIMUM_ADULT_AGE+"세 미만은 가입 불가");
        }
    }

    boolean registerUser(User user) {
        verificationUserInfo(user);
        return users.add(user);
    }

    User updateUserActiveState(User user) {
        User ori = getUserByLogin(user.login);
        ori.setActive(user.isActive());
        return ori;
    }

    User getUserByLogin(String login) {
        for (User user : users) {
            if (user.login.equals(login)) return user;
        }
        return null;
    }
}
