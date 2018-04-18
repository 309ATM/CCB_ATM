package seventh.until;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/** �����ƶ��ŷ���ʵ�ֶ�����֤��
 * @author Jachin
 *
 */
public class SendCode {
	public static SendSmsResponse sendSms(String phoneNumber,String code) {
		SendSmsResponse sendSmsResponse = null;
		try{
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");//�����޸�
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");//�����޸�
	 	IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIMKj9XY36yLQz", "ez9J03CmSq7ztFtxSp8O0JBef3T4Z6");//"***"�ֱ���д�Լ���AccessKey ID��Secret
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");//�����޸�
		IAcsClient acsClient = new DefaultAcsClient(profile);//�����޸�
		SendSmsRequest request = new SendSmsRequest();//�����޸�
		request.setPhoneNumbers(phoneNumber);//****����д���շ����ֻ�����
		request.setSignName("������");//�˴���д������Ķ���ǩ��
		request.setTemplateCode("SMS_132410002");//�˴���д��õĶ���ģ��CODE
		request.setTemplateParam("{\"code\":\""+code+"\"}");//���ߵĶ���ģ������${code}, ��˴˴���Ӧ��д��֤�� 
		 sendSmsResponse = acsClient.getAcsResponse(request);//�����޸�
		}catch (Exception e) {
		}return sendSmsResponse;
	}
	public static void main(String[] args) {
		sendSms("17304025671","513354");
	}
}