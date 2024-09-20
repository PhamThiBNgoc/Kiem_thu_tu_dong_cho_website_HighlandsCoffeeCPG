import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Gọi Test Case ProductSPCart
WebUI.callTestCase(findTestCase('ProductSPCart'), [:], FailureHandling.STOP_ON_FAILURE)
//giá tiền ban đầu
String initialPrice = WebUI.getText(findTestObject('Object Repository/Page_Thng 24 Lon C Ph Sa Highlands Coffee 2_ff517d/span_970.000'))

WebUI.click(findTestObject('Object Repository/Page_Thng 24 Lon C Ph Sa Highlands Coffee 2_ff517d/input__Lines'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_Thng 24 Lon C Ph Sa Highlands Coffee 2_ff517d/input__Lines'), Keys.chord(
        Keys.CONTROL, 'a', Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/Page_Thng 24 Lon C Ph Sa Highlands Coffee 2_ff517d/input__Lines'), SL)

WebUI.sendKeys(findTestObject('Object Repository/Page_Thng 24 Lon C Ph Sa Highlands Coffee 2_ff517d/input__Lines'), Keys.chord(
        Keys.ENTER))

// Kiểm tra giá tiền sau khi cập nhật sản phẩm
// 1.Lấy giá tiền sau khi cập nhật 
String updatedPrice = WebUI.getText(findTestObject('Object Repository/Page_Thng 24 Lon C Ph Sa Highlands Coffee 2_ff517d/span_970.000'))

// 2.So sánh giá tiền mới với giá tiền ban đầu
if (!initialPrice.equals(updatedPrice)) {
    WebUI.comment('Giá tiền đã được cập nhật sau khi cập nhật số lượng.')

}
//button thanh toán
WebUI.click(findTestObject('Object Repository/Page_Thng 24 Lon C Ph Sa Highlands Coffee 2_ff517d/button_Thanh ton'))

if (SL.contains("999")) {

    // Kiểm tra nếu thông báo hết sản phẩm xuất hiện
    boolean MessagehetSp = WebUI.verifyTextPresent('Một số sản phẩm trong giỏ hàng không còn đủ số lượng để đặt hàng', false)

    if (MessagehetSp) {
        // Kiểm tra số lượng sản phẩm có thể mua
        WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/TuTao/checkSL')), SLHangCon)

        // Click tiếp tục
        WebUI.click(findTestObject('Object Repository/TuTao/TiepTucKhiHetHang'))
    }
}

WebUI.click(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/a_Quay v gi hng'))
//Kiểm tra số lượng có cập nhật đúng mong đợi hay không
// Lấy số lượng từ trang web
boolean isSLGioHangPresent = WebUI.waitForElementPresent(findTestObject('Object Repository/TuTao/SLGioHang'), 30)
if (isSLGioHangPresent) {
	String updateSL = WebUI.getAttribute(findTestObject('Object Repository/TuTao/SLGioHang'), 'value')
	// So sánh số lượng với giá trị mong đợi (ExpectSL)
	WebUI.verifyEqual(updateSL, ExpectSL)
	//kiểm tra dấu - có disable khi sl giảm xuống 1 không
	if(updateSL == "1") {
		WebUI.verifyElementHasAttribute(findTestObject('Object Repository/Page_Gi hng  Highlands Coffee CPG/button__1'), 'disabled', 10)
	}
}


//button tăng
WebUI.click(findTestObject('Object Repository/Page_Gi hng  Highlands Coffee CPG/button_'))
//kiểm tra giá tiền sau khi update
// Lấy giá tiền sau khi cập nhật số lượng
String updatedPriceCartAdd = WebUI.getText(findTestObject('Object Repository/Page_NHN TI CI THI TRANG C Ph Bt Truyn Thng_0d25b0/div_990.000'))

// So sánh giá tiền mới với giá tiền ban đầu
if (!updatedPrice.equals(updatedPriceCartAdd)) {
	WebUI.comment('Giá tiền đã được cập nhật sau khi cập nhật số lượng.')

}
else {
	WebUI.comment('Giá tiền không được cập nhật sau khi cập nhật số lượng.')
}
//button giảm
WebUI.click(findTestObject('Object Repository/Page_Gi hng  Highlands Coffee CPG/button__1'))

//kiểm tra giá tiền
String updatedPriceCartSub = WebUI.getText(findTestObject('Object Repository/Page_NHN TI CI THI TRANG C Ph Bt Truyn Thng_0d25b0/div_990.000'))

// So sánh giá tiền mới với giá tiền ban đầu
if (!updatedPriceCartAdd.equals(updatedPriceCartSub)) {
	WebUI.comment('Giá tiền đã được cập nhật sau khi cập nhật .')

}
try {
    // Kiểm tra xem phần tử có hiện diện không
    boolean isPresent = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Gi hng  Highlands Coffee CPG/a_Xa'), 30)

    if (isPresent) {
        // Nếu phần tử hiện diện, xác minh và click vào nó
        WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Gi hng  Highlands Coffee CPG/a_Xa'), 30)

        WebUI.click(findTestObject('Object Repository/Page_Gi hng  Highlands Coffee CPG/a_Xa') // Nếu phần tử không hiện diện, ghi nhận thông báo
            )
    } else {
        WebUI.comment('Phần tử \'Object Repository/Page_Gi hng  Highlands Coffee CPG/a_Xa\' không hiện diện. Có thể đã bị xóa rồi.')
    }
}
catch (Exception e) {
    WebUI.comment('Lỗi: Không thể tìm thấy phần tử \'Object Repository/Page_Gi hng  Highlands Coffee CPG/a_Xa\'.')

    throw e
} // Ghi nhận lỗi

WebUI.click(findTestObject('Object Repository/Page_Gi hng  Highlands Coffee CPG/a_Tip tc mua hng_1'))

WebUI.closeBrowser()

