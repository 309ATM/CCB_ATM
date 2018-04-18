package seventh.until;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/** 阿里云短信服务实现短信验证码
 * @author Jachin
 *
 */
public class SendCode {
	public static SendSmsResponse sendSms(String phoneNumber,String code) {
		SendSmsResponse sendSmsResponse = null;
		try{
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");//不必修改
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");//不必修改
	 	IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIMKj9XY36yLQz", "ez9J03CmSq7ztFtxSp8O0JBef3T4Z6");//"***"分别填写自己的AccessKey ID和Secret
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");//不必修改
		IAcsClient acsClient = new DefaultAcsClient(profile);//不必修改
		SendSmsRequest request = new SendSmsRequest();//不必修改
		request.setPhoneNumbers(phoneNumber);//****处填写接收方的手机号码
		request.setSignName("殷智深");//此处填写已申请的短信签名
		request.setTemplateCode("SMS_132410002");//此处填写获得的短信模版CODE
		request.setTemplateParam("{\"code\":\""+code+"\"}");//笔者的短信模版中有${code}, 因此此处对应填写验证码 
		 sendSmsResponse = acsClient.getAcsResponse(request);//不必修改
		}catch (Exception e) {
		}return sendSmsResponse;
	}
	public static void main(String[] args) {
		sendSms("17304025671","513354");
	}
}