package CA.utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			
			//extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extentReport_IdentityProfileInformationPage.html",true,DisplayOrder.OLDEST_FIRST);

			extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\ExtentReport_for_IdentityLiteAccountPages.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\CA\\extentconfig\\ReportsConfig.xml"));

			
		}
		
		return extent;
		
	}

}
