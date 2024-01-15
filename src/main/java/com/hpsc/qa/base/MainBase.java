package com.hpsc.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class MainBase {
    @Bean
    public WebDriver getWebDriver() {
    	if(System.getProperty("browserName").equalsIgnoreCase("chrome")) {
    		WebDriverManager.getInstance("chrome").setup();
            return new ChromeDriver();
    	}
    	else if(System.getProperty("browserName").equalsIgnoreCase("firefox")){
    		WebDriverManager.getInstance("firefox").setup();
    		return new FirefoxDriver();
    	}
    	else if(System.getProperty("browserName").equalsIgnoreCase("edge")){
    		WebDriverManager.getInstance("edge").setup();
    		return new EdgeDriver();
    	}
    	else {
    		return null;
    	}
        
    }
}
