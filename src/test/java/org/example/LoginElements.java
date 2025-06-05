package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginElements {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://freelance-learn-automation.vercel.app/login");
            page.getByText("New user? Signup").click();
            page.locator("#name").fill("moldova");
            page.getByPlaceholder("email").fill("moldova@outlook.com");
            page.getByPlaceholder("password").fill("moldova@1234");
            page.getByText("Selenium Grid").click();
            PlaywrightAssertions.assertThat(page.getByText("Selenium Grid")).isChecked();
            page.locator("#gender2").click();
            System.out.println("checked");
            page.locator("#state").selectOption("Goa");
            String hobbies [] = {"Swimming","Playing"};
            page.locator("#hobbies").selectOption(hobbies);
            PlaywrightAssertions.assertThat(page.locator("submit-btn")).isEnabled();
            page.close();
            browser.close();
        }
    }
}
