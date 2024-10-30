/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author Ofentse
 */
public class UserManager {
    String userName;
    String password;
    String firstName;
    String surname;
    String enteredUserName;
    String enteredPassword;

    public boolean checkUsername() {
        boolean check = false;
        if (userName.length() <= 5) {
            for (int i = 0; i < userName.length(); i++) {
                if (userName.charAt(i) == '_') {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public boolean checkPasswordComplexity() {
        boolean capitalLetter = false;
        boolean number = false;
        boolean special = false;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    capitalLetter = true;
                }
                if (Character.isDigit(ch)) {
                    number = true;
                }
                if (!Character.isLetterOrDigit(ch)) {
                    special = true;
                }
            }
        }
        return capitalLetter && number && special;
    }

    public String registerUser() {
        if (checkUsername()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your Username contains an underscore and is no more than 5 characters in length.");
        }

        if (checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }

        if (checkUsername() && checkPasswordComplexity()) {
            return "The two above conditions have been met, and the user has been registered successfully.";
        } else {
            return "Failed to register user. Please ensure the username and password meet the requirements.";
        }
    }

    public boolean loginUser() {
        return userName.equals(enteredUserName) && password.equals(enteredPassword);
    }

    public String returnLoginStatus() {
        if (loginUser()) {
            return "Successful login\nWelcome " + firstName + " " + surname + ", it is great to see you again!";
        } else {
            return "A failed login\nUsername or Password incorrect, please try again.";
        }
    }
}