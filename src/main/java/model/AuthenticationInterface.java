package model;

/**
 * model interface
 * Follows dependency inversion principle
 */
public interface AuthenticationInterface {
    public abstract boolean isLoginValid(String userName, String password);
}
