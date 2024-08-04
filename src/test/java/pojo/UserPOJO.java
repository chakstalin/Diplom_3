package pojo;

public class UserPOJO {
    private String email;
    private String password;
    private String name;

    public UserPOJO(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserPOJO() {
    }

    public UserPOJO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
