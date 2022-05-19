package valiadasi
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
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

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

class validasiApi {
	String apiIDT_KTP, apiID_KTP, apiIDT_KARTU_PELAJAR, apiID_KARTU_PELAJAR, apiIDT_NPWP, apiID_NPWP, apiIDT_PASSPORT, apiID_PASSPORT, apiIDT_KARTU_IZIN_TINGGAL, apiID_KARTU_IZIN_TINGGAL, apiIDT_KARTU_KELUARGA, apiID_KARTU_KELUARGA, apiLAST_NAME_BY_ID, apiLAST_NAME_FULL_NAME, apiLAST_NAME_MOTHER_MAIDEN_NAME, apiPHONE_NUMBER, apiEMAIL, apiBIRTH_DATE, apiBRANCH_NAME, apiDOMISILY_CITY, apiACCOUNT_NUMBER
	private static Connection connection = null;
	ResultSet rs
	PreparedStatement pst
	String hasil
	def con = new checkVal()

	//	pathFile = RunConfiguration.getProjectDir() + '/Validasi Output/'
	//	getTC = RunConfiguration.getExecutionSource().toString().substring(RunConfiguration.getExecutionSource().toString().lastIndexOf("\\")+1)
	//	validasi = new File(pathFile + 'Validasi_' + getTC + '.txt')
	//	validasi.delete()
	//	validasi.createNewFile()

	/**
	 * Send request and verify status code
	 * @param request request object, must be an instance of RequestObject
	 * @param expectedStatusCode
	 * @return a boolean to indicate whether the response status code equals the expected one
	 */


	@Keyword
	def validasiAPI(String apiIDT_KTP,String apiID_KTP,String apiIDT_KARTU_PELAJAR,String apiID_KARTU_PELAJAR,String apiIDT_NPWP,String apiID_NPWP,String apiIDT_PASSPORT,String apiID_PASSPORT,String apiIDT_KARTU_IZIN_TINGGAL,String apiID_KARTU_IZIN_TINGGAL,String apiIDT_KARTU_KELUARGA,String apiID_KARTU_KELUARGA,String apiLAST_NAME_BY_ID,String apiLAST_NAME_FULL_NAME,String apiLAST_NAME_MOTHER_MAIDEN_NAME,String apiPHONE_NUMBER,String apiEMAIL,String apiBIRTH_DATE,String apiBRANCH_NAME,String apiDOMISILY_CITY,String apiACCOUNT_NUMBER) {
		if((apiIDT_KTP == '' || apiIDT_KTP != '') && (apiID_KTP == '' || apiID_KTP != '') && (apiIDT_KARTU_PELAJAR == '' || apiIDT_KARTU_PELAJAR != '') && (apiID_KARTU_PELAJAR == '' || apiID_KARTU_PELAJAR != '') && (apiIDT_NPWP == '' || apiIDT_NPWP != '') && (apiIDT_PASSPORT == '' || apiIDT_PASSPORT != '') && (apiID_PASSPORT == '' || apiID_PASSPORT != '') && (apiIDT_KARTU_IZIN_TINGGAL == '' || apiIDT_KARTU_IZIN_TINGGAL != '') && (apiID_KARTU_IZIN_TINGGAL == '' || apiID_KARTU_IZIN_TINGGAL != '') && (apiIDT_KARTU_KELUARGA == '' || apiIDT_KARTU_KELUARGA != '') && (apiID_KARTU_KELUARGA == '' || apiID_KARTU_KELUARGA != '') && (apiID_KARTU_KELUARGA == '' || apiID_KARTU_KELUARGA != '') && (apiLAST_NAME_BY_ID == '' || apiLAST_NAME_BY_ID != '') && (apiLAST_NAME_MOTHER_MAIDEN_NAME == '' || apiLAST_NAME_MOTHER_MAIDEN_NAME != '') && (apiPHONE_NUMBER == '' || apiPHONE_NUMBER != '') && (apiEMAIL == ''|| apiEMAIL != '') && (apiBIRTH_DATE == '' || apiBIRTH_DATE != '') && (apiBRANCH_NAME == '' || apiBRANCH_NAME != '') && (apiDOMISILY_CITY == '' || apiDOMISILY_CITY != '') && (apiACCOUNT_NUMBER == '' || apiACCOUNT_NUMBER != '')) {
			return 'Validasi Attribut Sudah Sesuai'
		} else {
			return 'Validasi Attribut Tidak Sesuai'
		}
		//		try {
		//
		//		} catch (Exception e) {
		//			KeywordUtil.markFailed('error' + e)
		//		}
	}

	@Keyword
	def validasiCode (statusRes,String statusCode,String errorCode,String resMessage,String resCode) {
		try {
			WS.verifyElementPropertyValue(statusRes, 'RESPONSE.STATUS_CODE', statusCode)
			WS.verifyElementPropertyValue(statusRes, 'RESPONSE.ERROR_CODE', errorCode)
			WS.verifyElementPropertyValue(statusRes, 'RESPONSE.RESPONSE_MESSAGE', resMessage)
			WS.verifyElementPropertyValue(statusRes, 'RESPONSE.RESPONSE_CODE', resCode)
			println(statusCode)
			println(errorCode)
			println(resMessage)
			println(resCode)
			return hasil = "Suksess"
		} catch (Exception e) {
			KeywordUtil.markFailed('error' + e)
			KeywordUtil.markError('error' + e)
			return e
		}
	}

	//	@Keyword
	//	def textValidasi(resJson) {
	//		String pathFile = RunConfiguration.getProjectDir() + '/Validasi Output/'
	//		String getTC = RunConfiguration.getExecutionSource().toString().substring(RunConfiguration.getExecutionSource().toString().lastIndexOf("\\")+1)
	//		String validasi = new File(pathFile + 'Validasi_' + getTC + '.txt')
	//		validasi.delete()
	//		validasi.createNewFile()
	//		validasi.append('------------------------------------------\n')
	//		validasi.append('Erro Message= '+resMessage + '\n')
	//		validasi.append(resJson)
	//		validasi.append('------------------------------------------\n')
	//	}



}