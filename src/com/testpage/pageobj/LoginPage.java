package com.testpage.pageobj;

import com.testpage.context.Page;

public class LoginPage extends Page {
    public static final String PAGE_URL = "/login.html";
    protected LoginPage() {
        super(PAGE_URL);
    }
    public static LoginPage openLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.getBrowser().open(PAGE_URL);
        return loginPage;
    }
    private void setUserName(String userName) {
        // enter Username
        getBrowser().type("id=UserName", userName);
    }
    private void setPassword(String password) {
        // enter Password
        getBrowser().type("id=Password", password);
    }
    private void pushLoginButton() {
        // click Login button
        getBrowser().click("id=LoginButton");
    }
    protected void parsePage() {
        // page parsing
    }
    protected void init() {
        // page init, as example - check (URL):
        if(!getBrowser().getLocation().equals(PAGE_URL)) {
            throw new IllegalStateException("Invalid page is opened");
        }
        // can add some check for the necessary elements and etc.
    }
    private void loginAs(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        pushLoginButton();
    }
    public HomePage login(String userName, String password) {
        loginAs(userName, password);
        return new HomePage();
    }
    public ErrorLoginPage loginInvalid(String userName, String password) {
        loginAs(userName, password);
        return new ErrorLoginPage();
    }
}