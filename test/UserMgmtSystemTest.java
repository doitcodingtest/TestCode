import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMgmtSystemTest {
    private static UserMgmtSystem userMgmtSystem;
    private static User normalUser;
    private static User inactiveUser;

    static final String INACTIVE_USER_LOGIN = "inactiveUser";
    static final String ACTIVE_USER_LOGIN = "activeUser";
    static final int UNDER_ADULT_AGE = 18;


    @BeforeAll
    static void SetUp(){
        userMgmtSystem = new UserMgmtSystem();
        normalUser = new User(100,"1234", ACTIVE_USER_LOGIN, "M", 29, true);
        inactiveUser = new User(101,"1234", INACTIVE_USER_LOGIN, "M", 29, false);
        userMgmtSystem.registerUser(normalUser);
        userMgmtSystem.registerUser(inactiveUser);
    }

    @Test
    void userTest(){
        User user = new User(1,"test", "Kim", "M", 29, true);
        boolean result = userMgmtSystem.registerUser(user);
        assertEquals(true, result);
    }

    @Test
    void successRegisterUserWhenGivenAllParam(){
        User user = new User(1,"test", "Kim", "M", 29, true);
        boolean result = userMgmtSystem.registerUser(user);
        assertEquals(true, result);
    }

//    @Test
//    void successRegisterInactiveUserWhenGivenAllParam(){
//        User user = new User(1,"test", "Kim", "M", 29, false);
//        boolean result = userMgmtSystem.registerUser(user);
//        assertEquals(true, result);
//    }

    @Test
    void successRegisterInactiveUserWhenGivenAllParam(){
        //Given
        User user = normalUser;
        user.setActive(false);

        //When
        boolean result = userMgmtSystem.registerUser(user);

        //Then
        assertEquals(true, result);
    }
    
/*    @Test
    void successCheckInformationForInactiveUserWhenGivenLogin(){
        //Given
        User user = normalUser;

        //When
        normalUser.setActive(false);
        boolean result = userMgmtSystem.registerUser(user);

        //Then
        assertEquals(true, result);

        if(result){  //Given
            //When
            User newRegisterUser = userMgmtSystem.getUserByLogin(user.login);
            //Then
            assertEquals(newRegisterUser.isActive(), false);
            assertEquals(newRegisterUser.getLogin(), user.login);
        }
    }*/

    @Test
    void successCheckInformationForInactiveUserWhenGivenLogin(){
        //Given
        String login = INACTIVE_USER_LOGIN;
        //When
        User newRegisterUser = userMgmtSystem.getUserByLogin(login);
        //Then
        assertEquals(newRegisterUser, inactiveUser);
    }

@Test
    void 실패_계정생성_ID값이없는경우() {
        //Given
        User user = new User(100,"1234", null, "M", 29, true);

        //When & Then
        Exception exception = assertThrows(Exception.class, () -> {
            userMgmtSystem.registerUser(user);
        });
        System.out.println(exception.getMessage());
    }

    @Test
    void 실패_계정생성_PW가없는경우(){
        //Given
        User user = new User(100, null, ACTIVE_USER_LOGIN, "M", 29, true);

        //When & Then
        Exception exception = assertThrows(Exception.class, () -> {
            userMgmtSystem.registerUser(user);
        });
        System.out.println(exception.getMessage());
    }


    @Test
    void 실패_계정생성_19세미만인경우(){
        //Given
        User user = new User(100, "1234", ACTIVE_USER_LOGIN, "M", UNDER_ADULT_AGE, true);

        //When & Then
        Exception exception = assertThrows(Exception.class, () -> {
            userMgmtSystem.registerUser(user);
        });
        System.out.println(exception.getMessage());
    }

}