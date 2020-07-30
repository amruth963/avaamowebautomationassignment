package com.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.utils.BrowserUtils;
import com.common.utils.Log;

public class HomePage extends BrowserUtils{
	
	@FindBy(css = "img[class$='animated']")
	private WebElement chatBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickOnChatBtn(){
		boolean flag = true;
		try {
			webDriverWait(chatBtn);
			chatBtn.isDisplayed();
			chatBtn.click();
			Log.info("Clicked on chat button successfully");
		}catch (StaleElementReferenceException e) {
			Log.error("Unable to locate element due to "+e.getMessage());
		}
		return flag;
	}

}
