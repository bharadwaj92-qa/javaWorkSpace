package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Base;

public class FirstPage extends Base{

	
	@FindBy(id = "search-box")
	private WebElement searchBox;
	
	
	public void enterTheData(String data){
		
	searchBox.sendKeys(data);
	System.out.println("typed from Page object");
		
	}

//	@FindBy(id = "memberAdmitted1")
//	private WebElement memberAdmittedNo;
//
//	@FindBy(xpath = ".//*[@id='preQualificationForm']/fieldset/fieldset[1]/div[4]/img")
//	private WebElement admitCalendar;
//
//	@FindBy(xpath = ".//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[1]/a")
//	private WebElement calendarDatetoSelect;
	
	
	
}
