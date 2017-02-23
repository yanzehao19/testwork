package yzh.send.message;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsgWebChinese {

	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		/*PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");*/
		PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid", "yanzehao19"), // 注册的用户名
				new NameValuePair("Key", "a2165138dd02bdc2a333"), // 注册成功后，登录网站后得到的密钥
				new NameValuePair("smsMob", "15207110036"), // 手机号码
				new NameValuePair("smsText", "这是专用于测试的信息，能否正常发短信呢？") };// 短信内容
		post.setRequestBody(data);
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode" + statusCode);
		for (Header h : headers) {
			System.out.println("---" + h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
		System.out.println(result);
	}
}
