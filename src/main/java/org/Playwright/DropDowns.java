package org.Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class DropDowns {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.letcode.in/dropdowns");
        /*page.selectOption("#fruits","1");*/
        Locator locator = page.locator("#fruits");
        /*locator.selectOption("2");*/
        /*locator.selectOption(new SelectOption().setLabel("Banana"));*/
        locator.selectOption(new SelectOption().setIndex(3));
        System.out.println(page.locator("//div[@class=\"notification is-success\"]//p").textContent());

        //Multiple
        Locator hero = page.locator("id=superheros");
        hero.selectOption(new String[]{"aq", "bt", "cm"});

        //Last Options
        Locator language = page.locator("#lang");
        Locator options = language.locator("option");
        System.out.println(options.count());
        /*for(Locator ltr : options.all()) {
            System.out.println(ltr.textContent());
        }*/
        System.out.println(options.allTextContents());
        language.selectOption(new SelectOption().setIndex(options.count()-1));
    }
}
