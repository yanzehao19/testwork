package ftpUtil;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.eclipse.swt.internal.cairo.cairo_font_extents_t;


public class FTPUtil {
	private static Logger logger=Logger.getLogger(FTPUtil.class);
		
			
	/** 
     * 获取FTPClient对象 
     * @param ftpHost FTP主机服务器 
     * @param ftpPassword FTP 登录密码 
     * @param ftpUserName FTP登录用户名 
     * @param ftpPort FTP端口 默认为21 
     * @return 
     */ 
	public static FTPClient getFTPClient(String ftpHost,String ftpPassword,String ftpUserName,int ftpPort) {
		FTPClient ftpClient=null;
		try {
			ftpClient=new FTPClient();
			ftpClient.connect(ftpHost,ftpPort);//连接ftp服务器
			ftpClient.login(ftpUserName, ftpPassword);//登录ftp服务器
			if(!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				logger.info("未连接到ftp，用户名或者密码错误");
				ftpClient.disconnect();
			}else {
				logger.info("ftp连接成功");
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			logger.info("ftp端口错误，请正确配置");
		}
		return ftpClient;
	}
}
