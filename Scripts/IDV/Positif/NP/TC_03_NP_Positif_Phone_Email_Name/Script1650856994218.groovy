import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.SimpleDateFormat

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable
import valiadasi.apiGetterAndSetter

import org.openqa.selenium.Keys as Keys

getter = new apiGetterAndSetter()
//setter = new Data

String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

String date = simpleDateFormat.format(new Date());
System.out.println(date);

CustomKeywords.'valiadasi.checkVal.connectDB'('172.18.136.12', 'customer_hub', '3306', 'bigdata', 'P@ssw0rd')
statusRes = WS.sendRequest(findTestObject('IDV/POSITIF/NP/TC_03'))
String resJson = statusRes.getResponseText()
println(resJson)
JsonSlurper js = new JsonSlurper()
Map jsonMap = js.parseText(resJson)

pathFile = RunConfiguration.getProjectDir() + '/Validasi Output/'
getTCDumb = RunConfiguration.getExecutionSource().toString().substring(RunConfiguration.getExecutionSource().toString().lastIndexOf("\\")+1)
getTC = getTCDumb.substring(0, getTCDumb.length() - 3)
validasi = new File(pathFile + 'Validasi_' + getTC + '.txt')
validasi.delete()
validasi.createNewFile()




apiStatusCode = jsonMap.get('RESPONSE').get('STATUS_CODE')
apiErrorCode = jsonMap.get('RESPONSE').get('ERROR_CODE')
apiResponseCode = jsonMap.get('RESPONSE').get('RESPONSE_CODE')
apiResponseMessage= jsonMap.get('RESPONSE').get('RESPONSE_MESSAGE')
String apiIDT_KTP=CustomKeywords.'valiadasi.apiGetterAndSetter.apiIDT_KTP'(resJson)
String apiID_KTP=CustomKeywords.'valiadasi.apiGetterAndSetter.apiID_KTP'(resJson)
String apiIDT_KARTU_PELAJAR=CustomKeywords.'valiadasi.apiGetterAndSetter.apiIDT_KARTU_PELAJAR'(resJson)
String apiID_KARTU_PELAJAR=CustomKeywords.'valiadasi.apiGetterAndSetter.apiID_KARTU_PELAJAR'(resJson)
String apiIDT_NPWP=CustomKeywords.'valiadasi.apiGetterAndSetter.apiIDT_NPWP'(resJson)
String apiID_NPWP=CustomKeywords.'valiadasi.apiGetterAndSetter.apiID_NPWP'(resJson)
String apiIDT_PASSPORT=CustomKeywords.'valiadasi.apiGetterAndSetter.apiIDT_PASSPORT'(resJson)
String apiID_PASSPORT=CustomKeywords.'valiadasi.apiGetterAndSetter.apiID_PASSPORT'(resJson)
String apiIDT_KARTU_IZIN_TINGGAL=CustomKeywords.'valiadasi.apiGetterAndSetter.apiIDT_KARTU_IZIN_TINGGAL'(resJson)
String apiID_KARTU_IZIN_TINGGAL=CustomKeywords.'valiadasi.apiGetterAndSetter.apiID_KARTU_IZIN_TINGGAL'(resJson)
String apiIDT_KARTU_KELUARGA=CustomKeywords.'valiadasi.apiGetterAndSetter.apiIDT_KARTU_KELUARGA'(resJson)
String apiID_KARTU_KELUARGA=CustomKeywords.'valiadasi.apiGetterAndSetter.apiID_KARTU_KELUARGA'(resJson)
String apiLAST_NAME_BY_ID=CustomKeywords.'valiadasi.apiGetterAndSetter.apiLAST_NAME_BY_ID'(resJson)
String apiLAST_NAME_FULL_NAME=CustomKeywords.'valiadasi.apiGetterAndSetter.apiLAST_NAME_FULL_NAME'(resJson)
String apiLAST_NAME_MOTHER_MAIDEN_NAME=CustomKeywords.'valiadasi.apiGetterAndSetter.apiLAST_NAME_MOTHER_MAIDEN_NAME'(resJson)
String apiPHONE_NUMBER=CustomKeywords.'valiadasi.apiGetterAndSetter.apiPHONE_NUMBER'(resJson)
String apiEMAIL=CustomKeywords.'valiadasi.apiGetterAndSetter.apiEMAIL'(resJson)
String apiBIRTH_DATE=CustomKeywords.'valiadasi.apiGetterAndSetter.apiBIRTH_DATE'(resJson)
String apiBRANCH_NAME=CustomKeywords.'valiadasi.apiGetterAndSetter.apiBRANCH_NAME'(resJson)
String apiDOMISILY_CITY=CustomKeywords.'valiadasi.apiGetterAndSetter.apiDOMISILY_CITY'(resJson)
String apiACCOUNT_NUMBER=CustomKeywords.'valiadasi.apiGetterAndSetter.apiACCOUNT_NUMBER'(resJson)


statusCode = CustomKeywords.'valiadasi.checkVal.verifStatusCode'(apiStatusCode, apiErrorCode, apiResponseCode, apiResponseMessage)
errorCode = CustomKeywords.'valiadasi.checkVal.verifErrorCode'(apiStatusCode, apiErrorCode, apiResponseCode, apiResponseMessage)
resMessage=CustomKeywords.'valiadasi.checkVal.verifResponseDescription'(apiStatusCode, apiErrorCode, apiResponseCode, apiResponseMessage)
resCode=CustomKeywords.'valiadasi.checkVal.verifResponseCode'(apiStatusCode, apiErrorCode, apiResponseCode, apiResponseMessage)
retValidasi = CustomKeywords.'valiadasi.validasiApi.validasiCode'(statusRes, statusCode, errorCode, resMessage, resCode)
hasilVal = CustomKeywords.'valiadasi.validasiApi.validasiAPI'(apiIDT_KTP, apiID_KTP, apiIDT_KARTU_PELAJAR, apiID_KARTU_PELAJAR, apiIDT_NPWP, apiID_NPWP, apiIDT_PASSPORT, apiID_PASSPORT, apiIDT_KARTU_IZIN_TINGGAL, apiID_KARTU_IZIN_TINGGAL, apiIDT_KARTU_KELUARGA, apiID_KARTU_KELUARGA, apiLAST_NAME_BY_ID, apiLAST_NAME_FULL_NAME, apiLAST_NAME_MOTHER_MAIDEN_NAME, apiPHONE_NUMBER, apiEMAIL, apiBIRTH_DATE, apiBRANCH_NAME, apiDOMISILY_CITY, apiACCOUNT_NUMBER)



validasi.append('Tanggal Running: ' + date + '\n')
validasi.append('===================================================================================\n')
validasi.append(resJson + '\n')
validasi.append('===================================================================================\n')
validasi.append('Validasi Status Code: ' +statusCode+ '\n')
validasi.append('Validasi Error Code: ' +errorCode+ '\n')
validasi.append('Validasi Message: ' +resMessage+ '\n')
validasi.append('Validasi Response Code: ' +resCode+ '\n')
validasi.append('Validasi ATTRIBUTE MANDATORY: ' + hasilVal + '\n')


