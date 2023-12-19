package dental_clinic.dental.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Getter
    private String userName;
    @Getter
    private String password;
    @Getter
    private String roleUser;

    public Users() {
    }

    public Users(String userName, String password, String roleUser) {
        this.userName = userName;
        this.password = password;
        this.roleUser = roleUser;
    }

    public int getUserID() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return roleUser;
    }

    public void setRole(String roleUser) {
        this.roleUser = roleUser;
    }
}
