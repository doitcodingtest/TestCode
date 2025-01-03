import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UserMgmtSystemTestForWorkWell3 {
    private static UserMgmtSystem userMgmtSystem;
    private static Client client;
    private static String today;
    static final String CHILDREN_BIRTHDAY = "2006-05-12";
    static int UNDER_ADULT_AGE;
    static final String ACTIVE_USER_LOGIN = "activeUser";

    @BeforeAll
    static void SetUp(){
        userMgmtSystem = new UserMgmtSystem();
        //Create mock
        client = mock(Client.class);
        // mock -> when -> then
        when(client.receiveDateFromServer()).thenReturn("2024-08-28");
        today = client.receiveDateFromServer();
        LocalDate now = LocalDate.parse(today, DateTimeFormatter.ISO_DATE);
        LocalDate since = LocalDate.parse(CHILDREN_BIRTHDAY, DateTimeFormatter.ISO_DATE);
        Period period = Period.between(since, now);
        UNDER_ADULT_AGE = period.getYears();
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

