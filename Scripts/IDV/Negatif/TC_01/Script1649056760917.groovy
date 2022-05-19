import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.google.common.base.Stopwatch
import com.google.gson.Gson
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
import valiadasi.validasiApi

import org.apache.commons.lang3.time.StopWatch
import org.openqa.selenium.Keys as Keys

//StopWatch sw = Stopwatch.createStarted()
//CustomKeywords.

CustomKeywords.'valiadasi.checkVal.connectDB'('172.18.136.12', 'customer_hub', '3306', 'bigdata', 'P@ssw0rd')
statusRes =  WS.sendRequest(findTestObject('IDV/Negatif/TC 1'))
String resJson = statusRes.getResponseText()
println(resJson)
//copy
JsonSlurper js = new JsonSlurper()
//copy
Map jsonMap = js.parseText(resJson)

pathFile = RunConfiguration.getProjectDir() + '/Validasi Output/'
getTC = RunConfiguration.getExecutionSource().toString().substring(RunConfiguration.getExecutionSource().toString().lastIndexOf("\\")+1)
validasi = new File(pathFile + 'Validasi_' + getTC + '.txt')
validasi.delete()
validasi.createNewFile()


//JSON to String Text
//apiID = jsonMap.get('RESPONSE').get('DATA').get(0).get('ID') //get value
apiStatusCode = jsonMap.get('RESPONSE').get('STATUS_CODE')
apiErrorCode = jsonMap.get('RESPONSE').get('ERROR_CODE')
apiResponseCode = jsonMap.get('RESPONSE').get('RESPONSE_CODE')
apiResponseMessage= jsonMap.get('RESPONSE').get('RESPONSE_MESSAGE')
apiError = jsonMap.get('RESPONSE').get('ERRORS')
statusCode = CustomKeywords.'valiadasi.checkVal.verifStatusCode'(apiStatusCode, apiErrorCode, apiResponseCode, apiResponseMessage)
errorCode = CustomKeywords.'valiadasi.checkVal.verifErrorCode'(apiStatusCode, apiErrorCode, apiResponseCode, apiResponseMessage)
resMessage=CustomKeywords.'valiadasi.checkVal.verifResponseDescription'(apiStatusCode, apiErrorCode, apiResponseCode, apiResponseMessage)
resCode=CustomKeywords.'valiadasi.checkVal.verifResponseCode'(apiStatusCode, apiErrorCode, apiResponseCode, apiResponseMessage)
println(apiError[0])
CustomKeywords.'valiadasi.validasiApi.validasiCode'(statusRes, statusCode, errorCode, resMessage, resCode)

retValidasi = CustomKeywords.'valiadasi.validasiApi.validasiCode'(statusRes, statusCode, errorCode, resMessage, resCode)

if(retValidasi == 'suksess') {
	validasi.append('------------------------------------------\n')
	validasi.append('Erro Message= '+apiError[0]+ '\n')
	validasi.append('Erro Message= '+resMessage + '\n')
	validasi.append(resJson + '\n')
	validasi.append('------------------------------------------\n')
}else {
	validasi.append('GAGAL VALIDASI')
}