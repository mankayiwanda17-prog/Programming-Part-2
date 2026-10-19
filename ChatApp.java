package com.mycompany.chatapp;

/public class Login {

    private String username;
    private String password;
    private String cellphoneNumber;
    private String firstName;
    private String lastName;
    
public Login(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}
    public boolean checkUserName(String username) {
        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {

        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char character : password.toCharArray()) {

            if (Character.isUpperCase(character)) {
                hasCapital = true;
            }

            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(character)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }public boolean checkCellphoneNumber(String cellphoneNumber) {
    return cellphoneNumber != null
            && cellphoneNumber.matches("^\\+27[0-9]{9}$");
}public String registerUser(String username, String password, String cellphoneNumber) {

    if (!checkUserName(username)) {
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    if (!checkPasswordComplexity(password)) {
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    if (!checkCellphoneNumber(cellphoneNumber)) {
        return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }

    this.username = username;
    this.password = password;
    this.cellphoneNumber = cellphoneNumber;

    return "Username and password successfully captured";
}public boolean loginUser(String enteredUsername, String enteredPassword) {

    return username != null
            && password != null
            && username.equals(enteredUsername)
            && password.equals(enteredPassword);
}public String returnLoginStatus(boolean loginSuccessful) {

    if (loginSuccessful) {
        return "Welcome " + firstName + ", " + lastName
                + " it is great to see you again.";
    }

    return "Username or password incorrect, please try again.";
}
}