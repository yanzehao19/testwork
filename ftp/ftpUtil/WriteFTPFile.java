package ftpUtil;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;


public class WriteFTPFile {
	private Logger logger=Logger.getLogger(WriteFTPFile.class);
	  /** 
     * 本地上传文件到FTP服务器 
     *  
     * @param ftpPath 
     *            远程文件路径FTP 
     * @throws IOException 
     */ 
	public void upload(String ftpPath,String ftpUserName,String ftpPassword,String ftpHost,int ftpPort,String fileContent,String writeTempFilePath) {
		FTPClient ftpClient= null;
		logger.info("开始上传文件到FTP.");
		try {
			ftpClient=FTPUtil.getFTPClient(ftpHost, ftpPassword, ftpUserName, ftpPort);
			//设置PassiveMode传输
			ftpClient.enterLocalPassiveMode();
			// // 设置以二进制流的方式传输  
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			//对远程目录的处理  
			String remoteFileName=ftpPath;
			if(ftpPath.contains("/")) {
				remoteFileName= ftpPath.substring(ftpPath.lastIndexOf("/")+1);
			}
			 // FTPFile[] files = ftpClient.listFiles(new  
            // String(remoteFileName));  
            // 先把文件写在本地。在上传到FTP上最后在删除  
			boolean writeResult=write(remoteFileName, fileContent, writeTempFilePath);  
			if(writeResult) {
				java.io.File f=new java.io.File(writeTempFilePath+"/"+remoteFileName);
				InputStream in=new FileInputStream(f);
				ftpClient.storeFile(remoteFileName, in);
				in.close();
				logger.info("上传文件" + remoteFileName + "到FTP成功!");  
				f.delete();
			}else {
				logger.info("写文件失败!");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	 /** 
     * 把配置文件先写到本地的一个文件中取 
     *  
     * @param ftpPath 
     * @param str 
     * @return 
     */ 
	public boolean write (String fileName,String fileContext,String writeTempFilePath) {
		try {
			logger.info("开始写配置文件");
			java.io.File f=new java.io.File(writeTempFilePath+"/"+fileName);
			if(!f.exists()) {
				if(!f.createNewFile()) {
					logger.info("文件不存在，创建失败!");  
				}
			}
			BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
			bw.write(fileContext.replaceAll("\n", "\r\n"));
			bw.flush();
			bw.close();
			return true;
		} catch (Exception e) {
			logger.error("写文件没有成功");  
            e.printStackTrace();  
            return false;  
		}
	}
	
	
	
}
