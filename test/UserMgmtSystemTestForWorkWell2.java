import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserMgmtSystemTestForWorkWell2 {
    private static UserMgmtSystem userMgmtSystem;
    private static User normalUser;
    static final String ACTIVE_USER_LOGIN = "activeUser";

    @BeforeAll
    static void SetUp(){
        userMgmtSystem = new UserMgmtSystem();
        normalUser = new User(100,"1234", ACTIVE_USER_LOGIN, "M", 29, true);
        userMgmtSystem.registerUser(normalUser);
    }
    @Test
    void successUpdateUserAsInActive(){
        //Given
        User user = normalUser;
        user.setActive(false);

        //When
        User updateUser = userMgmtSystem.updateUserActiveState(user);

        //Then
        assertEquals(false, updateUser.isActive());
    }
    @Test
    void successCheckInformationForActiveUserWhenGivenLogin(){
        //Given
        String login = ACTIVE_USER_LOGIN;
        //When
        User user = userMgmtSystem.getUserByLogin(login);
        //Then
        assertEquals(true, normalUser.isActive());
    }
}

