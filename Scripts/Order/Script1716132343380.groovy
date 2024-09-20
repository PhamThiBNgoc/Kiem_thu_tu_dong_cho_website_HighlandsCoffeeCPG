import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




// Gọi Test Case ProductSPCart
WebUI.callTestCase(findTestCase('ProductSPCart'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_Highlands Coffee CPG  Highlands Coffee CPG/button_Thanh ton'))

WebUI.setText(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_Email (ty chn)_email'), Email)
WebUI.setText(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_H v tn_billingName'), Name)
WebUI.setText(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_S in thoi_billingPhone'), Phone)
WebUI.setText(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_a ch_billingAddress'), Address)
//Kiểm tra quận huyện có bị vô hiệu hoá hay không

WebUI.verifyElementHasAttribute(findTestObject('Object Repository/TuTao/huyen1'), 'aria-disabled', 10)

WebUI.click(findTestObject('TuTao/tinh'))
WebUI.click(findTestObject('TuTao/HN'))
WebUI.verifyElementHasAttribute(findTestObject('Object Repository/TuTao/xa1'), 'aria-disabled', 10)
WebUI.click(findTestObject('TuTao/huyen'))
WebUI.click(findTestObject('TuTao/ST'))
WebUI.click(findTestObject('TuTao/Xa'))
WebUI.click(findTestObject('TuTao/LeLoi'))
// Lấy giá trị của dropdown tỉnh thành
String selectedText = WebUI.getText(findTestObject('TuTao/tinh'))

// Điều kiện kiểm tra nếu tỉnh thành được chọn thì hiển thị giá vận chuyển
if (selectedText != '' ||  selectedText != '---') {
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/TuTao/hienVC'), 10)

} else {
	// Hiển thị thông báo 
	WebUI.verifyElementPresent(findTestObject('Object Repository/TuTao/NotVC'), 10)
}
//Kiểm tra khi chọn phương thức thanh toán 
//WebUI.click(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_Thanh ton qua V in t MoMo_paymentMethod'))
WebUI.click(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_Thanh ton_paymentMethod'))

//Kiểm tra có xuất hiện thông báo khi chọn phương thức thanh toán trả tiền khi nhận hàn không
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/div_Bn ch phi thanh ton khi nhn c hng'), 10)
WebUI.setText(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_Nhp m gim gi_reductionCode'), Sale)
WebUI.click(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/button_p dng'))
WebUI.click(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/button_T HNG'))
WebUI.verifyTextPresent(Notification1, false)

def MessageVal = ''
// Kiểm tra xem email có chứa dấu cách hoặc thiếu ký tự @
if (Email.contains(" ") || (!Email.contains("@")&& Email.contains(".") )) {
    if (Email.contains(" ")) {
        MessageVal = WebUI.getAttribute(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_Email (ty chn)_email'), 'validationMessage')
    } else if (!Email.contains("@")&& Email.contains(".") ) {
        MessageVal = WebUI.getAttribute(findTestObject('Object Repository/Page_Highlands Coffee CPG - Thanh ton n hng/input_Email (ty chn)_email'), 'validationMessage')
    }
	
}
WebUI.verifyEqual(MessageVal, Notification2)
WebUI.closeBrowser()
