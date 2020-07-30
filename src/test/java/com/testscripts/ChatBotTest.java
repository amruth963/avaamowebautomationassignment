package com.testscripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.common.utils.BrowserUtils;
import com.pages.ChatPage;
import com.pages.HomePage;

public class ChatBotTest extends BrowserUtils {

	public HomePage homePage;
	public ChatPage chatPage;

	@Test(description = "Launch URL and naviagte to chat screen")
	public void naviagateToChatScreen() {
		homePage = new HomePage();
		chatPage = new ChatPage();
		launchUrl();
		homePage.clickOnChatBtn();
		Assert.assertEquals(chatPage.clickOnGetStartedBtn(), true);
	}

}
