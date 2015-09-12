package com.testpage.pageobj;

import com.testpage.context.Page;

public class ErrorLoginPage extends Page {
    public static final String PAGE_URL = "/loginError.html";
    private String errorMessage;
    protected ErrorLoginPage() {
        super(PAGE_URL);
    }
    protected void init() {
    }
    protected void parsePage() {
        this.errorMessage = getBrowser().getText("id=ErrorMessage");
    }
    public String getErrorMessage() {
        return this.errorMessage;
    }
    public LoginPage backToLoginPage() {
        getBrowser().click("id=BackLink");
        return new LoginPage();
    }
}