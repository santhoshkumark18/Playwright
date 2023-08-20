package org.Playwright;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Context {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Videos/")).setRecordVideoSize(1280,720));
        Page page = context.newPage();
        page.navigate("https://bookcart.azurewebsites.net/");
      page.click("(//span[@class=\"mat-button-wrapper\"])[3]");
        page.locator("mat-input-0").fill("ortoni");
        page.locator("mat-input-1").fill("Pass1234$");
        page.click("(//span[@class=\"mat-button-wrapper\"])[8]");
        System.out.println(page.title());
        BrowserContext context1 = browser.newContext();
        Page page1 = context1.newPage();
        page1.navigate("https://www.letcode.in");
        System.out.println(page1.title());
        //TODO
        //To close the video
        context.close();


        playwright.close();
    }
}
