import java.io.Serializable;

public class Email implements Serializable {
    private String firstName;
    private String lastName;
    private String domain;
    private String password;
    private String email;

    public Email (String firstName, String lastName, String domain) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.domain = domain;
        this.password = null;
        email = generateDefaultEmail();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Email (String firstName, String lastName, String username, String domain) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.domain = domain;
        this.password = null;
        email = generateEmail(username);
    }

    private String generateDefaultEmail() {
        firstName = firstName.replaceAll("\\s+", "");
        lastName = lastName.replaceAll("\\s+", "");
        return firstName.toLowerCase() + lastName.toLowerCase() + "@" + domain;
    }

    private String generateEmail(String username) {
        return username.toLowerCase() + "@" + domain;
    }

    private String generatePassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!@#$%";
        int min = 0;
        int max = characters.length() - 1;
        String randPass = "";
        for (int i = 0; i < length; i++) {
            randPass += characters.charAt((int) Math.floor(Math.random() * (max - min + 1) + min));
        }
        return randPass;
    }

    public void setPassword(String password) {
        this.password = password; 
    }

    public void setRandomPassword(int length) {
        password = generatePassword(length);
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getInfo() {
        return "<html>Email:<br/>Name: " + getName() + "<br/>Password: " + getPassword() + "<br/>Email: " + getEmail() + "</html>";
    }
}
