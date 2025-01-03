import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMgmtSystemTestForWorkWell {
    private static UserMgmtSystem userMgmtSystem;
    private static User normalUser;
    static final String ACTIVE_USER_LOGIN = "activeUser";

    @BeforeAll
    static void SetUp(){
        userMgmtSystem = new UserMgmtSystem();
    }

@Test
void successCheckInformationForActiveUserWhenGivenLogin(){
    //Given
    String login = ACTIVE_USER_LOGIN;
    //When
    User user = userMgmtSystem.getUserByLogin(login);
    //Then
    assertNotEquals(null, user);
}

@Test
void successRegisterUserWhenGivenAllParam(){
    //Given
    normalUser = new User(100,"1234", ACTIVE_USER_LOGIN, "M", 29, true);
    //When
    boolean result = userMgmtSystem.registerUser(normalUser);
    //Then
    assertEquals(true, result);
}
}