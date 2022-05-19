package valiadasi
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class checkVal {
	private String getAcctno
	private String getActype
	private String getErrorMessage
	private static Connection connection = null;
	ResultSet rs
	PreparedStatement pst

	@Keyword
	def static connectDB(String url, String dbname, String port, String username, String password){
		//Load driver class for your specific database type

		String conn = "jdbc:mysql://" + url + ":" + port + "/" + dbname

		//Class.forName("org.sqlite.JDBC")

		//String connectionString = "jdbc:sqlite:" + dataFile

		if(connection != null && !connection.isClosed()){
			connection.close()
			println("NOT CONNECT")
		}
		connection = DriverManager.getConnection(conn, username, password)
		println("Connect")
		return connection
	}

	@BeforeTestCase
	def getTC(TestCaseContext testCaseContext) {
		String testCaseId = testCaseContext.getTestCaseId()
		return testCaseId
	}


	/**
	 * Send request and verify status code
	 * @param request request object, must be an instance of RequestObject
	 * @param expectedStatusCode
	 * @return a boolean to indicate whether the response status code equals the expected one
	 */
	//	ESPONSE":{
	//	"STATUS_CODE":400,
	//	"ERROR_CODE":"010",
	//	"RESPONSE_CODE":"01",
	//	"RESPONSE_MESSAGE":"Invalid Body Request",

	@Keyword
	def verifStatusCode(int statusCode,String errorCode, String resCode, String resMessage) {
		try {
			String checkDb = "SELECT statusCode,errorCode,responseCode,responseDescription,keterangan FROM mdmProb.statusCode sc WHERE errorCode = '" +errorCode+ "' and responseCode ='" +resCode+ "' and statusCode = '"+statusCode+"'"
			println(checkDb)
			Statement st = connection.createStatement()
			rs = st.executeQuery(checkDb);
			rs.next()
			return rs.getString("statusCode")
		} catch (Exception e) {
			KeywordUtil.markFailed('Error Mark : ' + e)
		}
	}



	@Keyword
	def verifErrorCode(int statusCode,String errorCode, String resCode, String resMessage) {
		try {
			String checkDb = "SELECT errorCode,responseCode,responseDescription,keterangan FROM mdmProb.statusCode sc WHERE errorCode = '" +errorCode+ "' and responseCode ='" +resCode+ "' and statusCode = '"+statusCode+"'"
			Statement st = connection.createStatement()
			rs = st.executeQuery(checkDb);
			rs.next()
			return rs.getString("errorCode")
		} catch (Exception e) {
			KeywordUtil.markFailed('Error Mark : ' + e)
		}
	}


	@Keyword
	def verifResponseCode(int statusCode,String errorCode, String resCode, String resMessage) {
		try {
			String checkDb = "SELECT errorCode,responseCode,responseDescription,keterangan FROM mdmProb.statusCode sc WHERE errorCode = '" +errorCode+ "' and responseCode ='" +resCode+ "'and statusCode = '"+statusCode+"'"
			Statement st = connection.createStatement()
			rs = st.executeQuery(checkDb);
			rs.next()
			return rs.getString("responseCode")
		} catch (Exception e) {
			KeywordUtil.markFailed('Error Mark : ' + e)
		}
	}



	@Keyword
	def verifResponseDescription(int statusCode,String errorCode, String resCode, String resMessage) {
		try {
			String checkDb = "SELECT errorCode,responseCode,responseDescription,keterangan FROM mdmProb.statusCode sc WHERE errorCode = '" +errorCode+ "' and responseCode ='" +resCode+ "' and statusCode = '"+statusCode+"'"
			Statement st = connection.createStatement()
			rs = st.executeQuery(checkDb);
			rs.next()
			return rs.getString("responseDescription")
		} catch (Exception e) {
			KeywordUtil.markFailed('Error Mark : ' + e)
		}
	}






	@Keyword
	def verifApiVsDoc (String resApi,String docApi) {
		if (resApi == docApi) {

		} else {

		}
	}
}