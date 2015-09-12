package com.testpage.test;
import com.testpage.context.Context;
import com.testpage.pageobj.ErrorLoginPage;
import com.testpage.pageobj.HomePage;
import com.testpage.pageobj.LoginPage;
import junit.framework.TestCase;

public class TestLogin extends TestCase {
    public void setUp() {
        // Context init
        Context.initInstance(Context.BROWSER_IE, "http://www.testtesttestlogin.com");
    }
    public void testLoginLogout() {
        String userName = "tester";
        String password = "testPass";
        LoginPage loginPage = LoginPage.openLoginPage();
        HomePage homePage = loginPage.login(userName, password);
        assertEquals(userName, homePage.getLoggedinUserName());
        homePage.logout();
    }
    public void testInvalidLogin() {
        String userName = "$tester@#";
        String password = "********";
        String expectedMessage = "Invalid username or password";
        LoginPage loginPage = LoginPage.openLoginPage();
        ErrorLoginPage errorLoginPage = loginPage.loginInvalid(userName, password);
        assertEquals(expectedMessage, errorLoginPage.getErrorMessage());
        errorLoginPage.backToLoginPage();
    }
    protected void tearDown() throws Exception {
        // close browser
        Context.getInstance().close();
    }
}