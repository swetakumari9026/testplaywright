package org.example;

/**
 * Hello world!
 *
 */

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://playwright.com");
            PlaywrightAssertions.assertThat(page).hasTitle("Fast and reliable end-to-end testing for modern web apps | Playwright");
            page.close();
            browser.close();
        }
    }
}