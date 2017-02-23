package yzh.send.email.success;

/**
 * 邮件测试类 QQ邮箱的测试可以使用,其他邮箱需要改几个地方:1.邮件服务器地址2.邮件服务器端口后3.账号4.密码,不一定时登录密码可能时授权码
 * QQ邮箱过程中出现错误,如果程序之前也可以运行成功的话,可以再次生成授权码,有这个原因的。还是不可以的话就请等一会,服务器也需要时间同步。
 */
public class Sendmail {

	public static void main(String[] args) {
		{
			Mail mail = new Mail();
			mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用QQ邮箱的,自己找找看相关的
			mail.setPortNumber("465"); // 设置邮件服务器端口号,默认25
			mail.setSender("yanzehao19@163.com"); // 发送人
			mail.setName("风之谷"); // 发送人昵称
			mail.setReceiver("zhyan5726@fiberhome.com,913279139@qq.com"); // 接收人
			mail.setUsername("yanzehao19@163.com"); // 登录账号,一般都是和邮箱名一样
			mail.setPassword("Skybridge19163"); // QQ邮箱登录第三方客户端时,密码框请输入“授权码”进行验证。其他的密码具体查看邮件服务器的说明
			mail.setSubject("标题");
			mail.setMessage("<h1>内容</h1>");
			if (new MailUtil().send(mail)) {
				System.out.println("发送成功");
			} else {
				System.out.println("发送失败");
			}
		}
	}
}