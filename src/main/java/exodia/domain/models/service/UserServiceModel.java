package exodia.domain.models.service;

public class UserServiceModel {

    private String Id;
    private String username;
    private String password;
    private String email;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
