
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Alert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

WebUI.openBrowser('')

WebUI.navigateToUrl('https://shop.highlandscoffee.com.vn/account/login?ReturnUrl=%2Faccount')

WebUI.setText(findTestObject('Object Repository/Page_ng nhp ti khon  Highlands Coffee CPG/input__email'), 'phambichngochy2003@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_ng nhp ti khon  Highlands Coffee CPG/input__password'), PWDN)

WebUI.click(findTestObject('Object Repository/Page_ng nhp ti khon  Highlands Coffee CPG/button_ng nhp'))

WebUI.click(findTestObject('Object Repository/Page_Trang khch hng  Highlands Coffee CPG/a_i mt khu'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Thay i mt khu  Highlands Coffee CPG/input__OldPassword'), 
    PW)

//WebUI.getAttribute(findTestObject('Page_Thay i mt khu  Highlands Coffee CPG/input__OldPassword'), 'required')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Thay i mt khu  Highlands Coffee CPG/input__Password'), PWNew)

//WebUI.getAttribute(findTestObject('Page_Thay i mt khu  Highlands Coffee CPG/input__Password'), 'required')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Thay i mt khu  Highlands Coffee CPG/input__ConfirmPassword'), 
    PWNewAgain)

//WebUI.getAttribute(findTestObject('Page_Thay i mt khu  Highlands Coffee CPG/input__ConfirmPassword'), 'required')

WebUI.click(findTestObject('Object Repository/Page_Thay i mt khu  Highlands Coffee CPG/button_t li mt khu'))


WebUI.verifyTextPresent(Result, false)

// Kiểm tra trường rỗng và lấy validationMessage nếu cần
def errorMessage = ''
if (PW.isEmpty() || PWNew.isEmpty() || PWNewAgain.isEmpty()) {
    if (PW.isEmpty()) {
        errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_Thay i mt khu  Highlands Coffee CPG/input__OldPassword'), 'validationMessage')
    } else if (PWNew.isEmpty()) {
        errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_Thay i mt khu  Highlands Coffee CPG/input__Password'), 'validationMessage')
    } else {
        errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_Thay i mt khu  Highlands Coffee CPG/input__ConfirmPassword'), 'validationMessage')
    }
}

// So sánh với kết quả mong đợi
WebUI.verifyEqual(errorMessage, ResultExpect)



WebUI.closeBrowser()

