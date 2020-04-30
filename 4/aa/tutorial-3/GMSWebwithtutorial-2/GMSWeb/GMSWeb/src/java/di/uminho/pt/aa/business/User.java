package di.uminho.pt.aa.business;

import di.uminho.pt.aa.data.Checksum;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    private String username;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Game> games;

    public User(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = Checksum.getFileChecksum(password.getBytes(), MessageDigest.getInstance("SHA-256"));
    }

    public Collection<Game> getGames() {
        return games;
    }

    public void setGames(Collection<Game> games) {
        this.games = games;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", games=" + games +
                '}';
    }
}
