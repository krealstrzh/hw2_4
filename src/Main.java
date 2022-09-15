public class Main {

    public static void checkLogin (String login) throws WrongLoginException {
        if (!login.matches("\\w+")) {
            throw new WrongLoginException("Illegal symbols in login");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Long login is too looooooong");
        } else if (login.isBlank()) {
            throw new WrongLoginException("Login cannot be blank");
        }
    }

    public static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords are different");
        } else if (!password.matches("\\w+")) {
            throw new WrongPasswordException("Illegal symbols in password");
        } else if (password.length() > 20) {
            throw new WrongPasswordException("Long password is too looooooong");
        } else if (password.isBlank()) {
        throw new WrongPasswordException("Password cannot be blank");
        } else if (!confirmPassword.matches("\\w+")) {
            throw new WrongPasswordException("Illegal symbols in password");
        } else if (confirmPassword.isBlank()) {
            throw new WrongPasswordException("Password cannot be blank");
        } else if (confirmPassword.length() > 20) {
            throw new WrongPasswordException("Long password is too looooooong");
        }
    }
    public static boolean loginAndPassword (String login, String password, String confirmPassword) {
        boolean result = true;
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
            return result;
        } catch (WrongLoginException e) {
            System.out.println("Something is wrong with login");
            result = false;
            return result;
        } catch (WrongPasswordException e) {
            System.out.println("Something is wrong with password");
            result = false;
            return result;
        } finally {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        loginAndPassword("логин", "qwerty89", "qwerty89");
    }
}