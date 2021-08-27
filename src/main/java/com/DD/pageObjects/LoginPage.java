package com.DD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DD.utilities.ElementUtils;

public class LoginPage 
{
	public WebDriver driver;
	ElementUtils elementUtils ;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver; 
		PageFactory.initElements(driver, this);  //(argument driver,this)
		elementUtils = new ElementUtils(driver);
	}

	//Login EMail TextBox
	@FindBy(id="inputLoginUsername")
	private WebElement wbEmailTxtBox;	
	
	//Login Password TextBox
	@FindBy(id="inputLoginPassword")
	private WebElement wbPwdTxtBox;	
	
	//Signin Button
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/div[5]/div/div/div/div[2]/div/div[1]/div/div/div[4]/button")
	private WebElement wbSigninBtn;	
	
	//Alert Text(label) Displayed
	@FindBy(xpath="//*[@id='aspnetForm']/div[5]/div/div/div/div[1]/div/div/div/div/div[2]") 
	private WebElement wbAlertLbl;
		
	//Xmark in AlertBox
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/div[5]/div/div/div/div[1]/div/div/div/a")
	private WebElement wbAlertX;	
	
	//Forgot Email or Password Link
	@FindBy(linkText="Forgot your email address or password?")
	private WebElement wbForgotlink;	
	
	//Create Account Button
	@FindBy(linkText="CREATE ACCOUNT")
	private WebElement wbCreateAcctBtn;
	
	//Clears email textbox
	public void clearEmailTxt() //clears EMail TextBox webelement
	{
		elementUtils.clearText(wbEmailTxtBox);           //		wbEmailTxtBox.clear();
	}	
	
	//Clear and Enter text in EMail textbox
	public void setEmailTxt(String email) //clears and enters text value to  EMail TextBox webelement
	{
		elementUtils.enterText(wbEmailTxtBox, email);    //		wbEmailTxtBox.sendKeys(email);
	}	
	
	//Clear Password textbox
	public void clearPwdTxt()
	{
		elementUtils.clearText(wbPwdTxtBox);
	}	
	
	//Clear and Enter text in Password textbox
	public void setPwdTxt(String pwd)
	{
		elementUtils.enterText(wbPwdTxtBox, pwd);
	}	
	
	//returns a String true if field has the attribute 'required' , else returns null
	public String checkRequiredEmail()
	{
		return elementUtils.getElementAttribute(wbEmailTxtBox, "required");
	}	
	
	//returns a String true if field has the attribute 'required' , else returns null
	public String checkRequiredPwd()
	{
		return elementUtils.getElementAttribute(wbPwdTxtBox, "required");
	}	
	
	//Click Sign in Button
	public void clickSignInBtn()
	{
		elementUtils.performElementClickReturn(wbSigninBtn);           //		wbSigninBtn.sendKeys(Keys.RETURN);
	}	
	
	//get the text of the Alert box that displays error message when user enters a invalid email/password combination
	public String getAlertTxt()
	{
		return elementUtils.getElementText(wbAlertLbl);
	}
	
	//Close the Alert box that displays error message when user enters a invalid email/password combination
	public void clickAlertX()
	{
		elementUtils.performElementClick(wbAlertX);
	}	
	
	//Click Forgot youremail or password Link
	public void clickForgotLink()
	{
		elementUtils.performElementClick(wbForgotlink);
	}	
	
	//Click Create Account button
	public void clickCreateAcctBtn()
	{
		elementUtils.performElementClick(wbCreateAcctBtn);
	}	

}
