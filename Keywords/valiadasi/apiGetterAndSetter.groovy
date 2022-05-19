package valiadasi

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable

public class apiGetterAndSetter {
	public String apiIDT_KTP
	public String apiID_KTP
	public String apiIDT_KARTU_PELAJAR
	public String apiID_KARTU_PELAJAR
	public String apiIDT_NPWP
	public String apiID_NPWP
	public String apiIDT_PASSPORT
	public String apiID_PASSPORT
	private String apiIDT_KARTU_IZIN_TINGGAL
	private String apiID_KARTU_IZIN_TINGGAL
	private String apiIDT_KARTU_KELUARGA
	private String apiID_KARTU_KELUARGA
	private String apiLAST_NAME_BY_ID
	private String apiLAST_NAME_FULL_NAME
	private String apiLAST_NAME_MOTHER_MAIDEN_NAME
	private String apiPHONE_NUMBER
	private String apiEMAIL
	private String apiBIRTH_DATE
	private String apiBRANCH_NAME
	private String apiDOMISILY_CITY
	private String apiACCOUNT_NUMBER

	JsonSlurper js = new JsonSlurper()

	@Keyword
	def apiAttr(String resApi) {
		Map jsonMap = js.parseText(resApi)
		apiIDT_KTP = jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_KTP')
		apiID_KTP = jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_KTP')
		apiIDT_KARTU_PELAJAR = jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_KARTU_PELAJAR')
		apiID_KARTU_PELAJAR = jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_KARTU_PELAJAR')
		apiIDT_NPWP = jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_NPWP')
		apiID_NPWP = jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_NPWP')
		apiIDT_PASSPORT = jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_PASSPORT')
		apiID_PASSPORT = jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_PASSPORT')
		apiIDT_KARTU_IZIN_TINGGAL = jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_KARTU_IZIN_TINGGAL')
		apiID_KARTU_IZIN_TINGGAL = jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_KARTU_IZIN_TINGGAL')
		apiIDT_KARTU_KELUARGA = jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_KARTU_KELUARGA')
		apiID_KARTU_KELUARGA = jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_KARTU_KELUARGA')
		apiLAST_NAME_BY_ID = jsonMap.get('RESPONSE').get('DATA').get(0).get('LAST_NAME_BY_ID')
		apiLAST_NAME_FULL_NAME = jsonMap.get('RESPONSE').get('DATA').get(0).get('LAST_NAME_FULL_NAME')
		apiLAST_NAME_MOTHER_MAIDEN_NAME = jsonMap.get('RESPONSE').get('DATA').get(0).get('LAST_NAME_MOTHER_MAIDEN_NAME')
		apiPHONE_NUMBER = jsonMap.get('RESPONSE').get('DATA').get(0).get('PHONE_NUMBER')
		apiEMAIL = jsonMap.get('RESPONSE').get('DATA').get(0).get('EMAIL')
		apiBIRTH_DATE = jsonMap.get('RESPONSE').get('DATA').get(0).get('BIRTH_DATE')
		apiBRANCH_NAME = jsonMap.get('RESPONSE').get('DATA').get(0).get('BRANCH_NAME')
		apiDOMISILY_CITY = jsonMap.get('RESPONSE').get('DATA').get(0).get('DOMISILY_CITY')
		apiACCOUNT_NUMBER = jsonMap.get('RESPONSE').get('DATA').get(0).get('ACCOUNT_NUMBER')
		println(apiIDT_KTP)
		println(apiID_KTP)
		println(apiIDT_KARTU_PELAJAR)
		println(apiID_KARTU_PELAJAR)
		println(apiIDT_NPWP)
		println(apiID_NPWP)
		println(apiIDT_PASSPORT)
		println(apiID_PASSPORT)
		println(apiIDT_KARTU_IZIN_TINGGAL)
		println(apiID_KARTU_IZIN_TINGGAL)
		println(apiIDT_KARTU_KELUARGA)
		println(apiID_KARTU_KELUARGA)
		println(apiLAST_NAME_BY_ID)
		println(apiLAST_NAME_FULL_NAME)
		println(apiLAST_NAME_MOTHER_MAIDEN_NAME)
		println(apiPHONE_NUMBER)
		println(apiEMAIL)
		println(apiBIRTH_DATE)
		println(apiBRANCH_NAME)
		println(apiDOMISILY_CITY)
		println(apiACCOUNT_NUMBER)
	}

	@Keyword
	def  apiIDT_KTP (String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return  jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_KTP')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiID_KTP(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_KTP')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiIDT_KARTU_PELAJAR(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_KARTU_PELAJAR')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiID_KARTU_PELAJAR(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_KARTU_PELAJAR')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiIDT_NPWP(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_NPWP')
		} catch (Exception e) {
		}
	}

	@Keyword
	def apiID_NPWP(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_NPWP')
		} catch (Exception e) {
		}
	}


	@Keyword
	def apiIDT_PASSPORT(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_PASSPORT')
		} catch (Exception e) {
		}
	}

	@Keyword
	def apiID_PASSPORT(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_PASSPORT')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}
	@Keyword
	def apiIDT_KARTU_IZIN_TINGGAL(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_KARTU_IZIN_TINGGAL')
		} catch (Exception e) {
		}
	}

	@Keyword

	def apiID_KARTU_IZIN_TINGGAL(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_KARTU_IZIN_TINGGAL')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiIDT_KARTU_KELUARGA(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('IDT_KARTU_KELUARGA')
		} catch (Exception e) {
		}
	}
	@Keyword
	def apiID_KARTU_KELUARGA(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('ID_KARTU_KELUARGA')
		} catch (Exception e) {
		}
	}

	@Keyword
	def apiLAST_NAME_BY_ID(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('LAST_NAME_BY_ID')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiLAST_NAME_FULL_NAME(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('LAST_NAME_FULL_NAME')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiLAST_NAME_MOTHER_MAIDEN_NAME(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('LAST_NAME_MOTHER_MAIDEN_NAME')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}
	@Keyword
	def apiPHONE_NUMBER(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('PHONE_NUMBER')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiEMAIL(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('EMAIL')
		} catch (Exception e) {
		}
	}
	@Keyword
	def apiBIRTH_DATE(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('BIRTH_DATE')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}
	@Keyword
	def apiBRANCH_NAME(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('BRANCH_NAME')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}

	@Keyword
	def apiDOMISILY_CITY(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('DOMISILY_CITY')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}
	@Keyword
	def apiACCOUNT_NUMBER(String resApi){
		try {
			Map jsonMap = js.parseText(resApi)
			return jsonMap.get('RESPONSE').get('DATA').get(0).get('ACCOUNT_NUMBER')
		} catch (Exception e) {
			KeywordUtil.markError('error' + e)
		}
	}
}
