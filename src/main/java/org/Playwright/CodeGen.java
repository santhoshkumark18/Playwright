package org.Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.*;

public class CodeGen {


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://letcode.in/");
            page.locator("div").filter(new Locator.FilterOptions().setHasText("LetCode with KoushikInsights on software testing videos like Selenium, Protracto")).first().click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).fill("santhoshinreallife@gmail.com");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).press("Tab");
            page.getByPlaceholder("Enter password").fill("Santhosh@18");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Explore Workspace")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Click")).click();
            page.getByLabel("Goto Home and come back here using driver command").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign out")).click();
        }
    }
}

