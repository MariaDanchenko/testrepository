package OOP;

public class User2 {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean setPassword(String password) {
        if (password.length() < 8) {
            return false;
        } else {
            this.password = password;
            return true;
        }
    }
}
