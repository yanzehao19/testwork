package yzh.SendingEmail;

import java.util.Properties;


//需要用户名密码邮件发送实例
//文件名 SendEmail2.java
//本实例以QQ邮箱为例，你需要在qq后台设置
public class SendEmail2 {
	public static void main(String [] args)
	   {
		  // 收件人电子邮箱
	      String to = "455969646@qq.com";
	 
	      // 发件人电子邮箱
	      String from = "91327919@qq.com";
	 
	      // 指定发送邮件的主机为 smtp.qq.com
	      String host = "smtp.qq.com";  //QQ 邮件服务器
	 
	      // 获取系统属性
	      Properties properties = System.getProperties();
	 
	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);
	 
	      properties.put("mail.smtp.auth", "true");
	      // 获取默认session对象
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	         return new PasswordAuthentication("风之谷", "rwaobsfpigvabcaj"); //发件人邮件用户名、密码
	        }
	       });
	 
	      try{
	         // 创建默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: 头部头字段
	         message.setFrom(new InternetAddress(from));
	 
	         // Set To: 头部头字段
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	 
	         // Set Subject: 头部头字段
	         message.setSubject("This is the Subject Line!");
	 
	         // 设置消息体
	         message.setText("This is actual message");
	 
	         // 发送消息
	         Transport.send(message);
	         System.out.println("Sent message successfully....from w3cschool.cc");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	}