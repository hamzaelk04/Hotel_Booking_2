package Model;

import Model.Enum.UserRole;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String numberPhone;
    private String password;
    private UserRole role;

    public User(String name, String email,String numberPhone, String password) {
        this.name = name;
        this.email = email;
        this.numberPhone = numberPhone;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() { return role; }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
