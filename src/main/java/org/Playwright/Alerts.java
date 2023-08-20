package org.Playwright;

import com.microsoft.playwright.*;

import java.util.function.Consumer;

public class Alerts {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.letcode.in/alert");
/*        page.onceDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept();
            *//*dialog.accept("santhosh kumar");*//*
            //dialog.dismiss();
        });
        page.locator("#accept").click();
//listeners

        page.onceDialog(dialog -> {
            System.out.println(dialog.message());
            *//*dialog.accept();*//*
            dialog.accept("santhosh kumar");
            //dialog.dismiss();
        });
        page.locator("#prompt").click();
        System.out.println(page.locator("#myName").textContent());

        //Short form for listeners
        *//*page.onceDialog(alert -> alert.accept());*/

        Consumer<Dialog> alert = a -> {
            System.out.println(a.message());
            a.accept();
        };
        page.onDialog(alert);
        page.locator("#accept").click();
    }
}
