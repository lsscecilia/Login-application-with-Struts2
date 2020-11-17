package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.Authentication;
import model.AuthenticationInterface;

/**
 * action class
 */
public class LoginAction extends ActionSupport {

    /**
     * the serialVersionUID is a unique identifier for Serializable classes.
     */
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;

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

    /**
     * login action
     */
    @Override
    public String execute() throws Exception {
        AuthenticationInterface authentication = new Authentication();
        return authentication.isLoginValid(userName, password) ? SUCCESS : INPUT;
    }

}
