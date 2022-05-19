package valiadasi
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS


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
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

//String PN,NAME, IDENTITY_TYPE ,IDENTITY_NUMBER, PHONE_NUMBER, EMAIL, BIRTH_DATE

class manualAPI {
	String endpoint = "http://datahub.bri.co.id/api/staging/v1/customer-profile-probabilistic//individu"
	String requestMethod = "POST"
	String authHeader = "Basic YWRtaW46YWRtaW4="

	TestObjectProperty header1 = new TestObjectProperty("Authorization", ConditionType.EQUALS, authHeader)
	TestObjectProperty header2 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
	TestObjectProperty header3 = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json")
	ArrayList defaultHeaders = Arrays.asList(header1, header2, header3)
	/**
	 * Send request and verify status code
	 * @param request request object, must be an instance of RequestObject
	 * @param expectedStatusCode
	 * @return a boolean to indicate whether the response status code equals the expected one
	 */
	@Keyword
	public ResponseObject buildPostApiRequest1(PN, NAME, IDENTITY_TYPE ,IDENTITY_NUMBER, PHONE_NUMBER, EMAIL, BIRTH_DATE) {
		String body = '{"HEADER":{"PN":"'+PN+'"},"REQUEST":{"NAME":"'+NAME+'","IDENTITY_TYPE":"'+IDENTITY_TYPE+'","IDENTITY_NUMBER":"'+IDENTITY_NUMBER+'","PHONE_NUMBER":"'+PHONE_NUMBER+'","EMAIL":"'+EMAIL+'","BIRTH_DATE":"'+BIRTH_DATE+'"}}'
		println(body)

		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}

	@Keyword
	public getResponseText(ResponseObject resp) {
		return resp.getResponseText()
	}


}