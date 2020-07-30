package com.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.utils.BrowserUtils;
import com.common.utils.Log;

public class ChatPage extends BrowserUtils {
	
	@FindBy(css = "a.get-started-link")
	private WebElement getStartedBtn;
	
	public ChatPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickOnGetStartedBtn(){
		boolean flag = true;
		try {
			webDriverWait(getStartedBtn);
			getStartedBtn.isDisplayed();
			getStartedBtn.click();
			Log.info("Clicked on get started button successfully");
		}catch (StaleElementReferenceException e) {
			Log.error("Unable to locate element due to "+e.getMessage());
		}
		return flag;
	}

}
