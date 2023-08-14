package org.Playwright;

import com.microsoft.playwright.*;

public class InteractWithInputs {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.letcode.in/edit");
        //Locator
        page.locator("#fullName").type("Santhosh Kumar");
        Locator locator = page.locator("#join");
        locator.press("End");
        locator.type("Man");
        locator.press("Tab");
        System.out.println(page.locator("id=getMe").getAttribute("value"));


       /* page.close();
        browser.close();
        playwright.close();*/
    }
}
