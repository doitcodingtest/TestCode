public class User {
    int id;
    String pw;
    String login;
    String gender;
    int age;
    boolean isActive;

    public User(int id, String pw, String login, String gender, int age, boolean isActive) {
        this.id = id;
        this.pw = pw;
        this.login = login;
        this.gender = gender;
        this.age = age;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pw='" + pw + '\'' +
                ", login='" + login + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }
}
