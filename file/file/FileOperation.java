package file;

import java.io.File;

public class FileOperation {

	public void getFilesUnderDir() {
		String path = "";// 路径
		File f = new File(path);

		if (!f.exists()) {
			System.out.println(path + "not exists");
			return;

		}

		File farr[] = f.listFiles();
		for (int i = 0; i < farr.length; i++) {
			File fsFile = farr[i];
			if (fsFile.isDirectory()) {
				String fileName = fsFile.getName();// 获得文件名称
				System.out.println(fsFile.getName() + "[目录]");
			} else {
				System.out.println(fsFile.getName());
			}
		}

	}
	//递归获得文件
	public void recurGetFiles(String path){
		File file =new File(path);
		if(file.exists()){
			File[] files=file.listFiles();
			if(files.length==0){
				System.out.println("文件夹是空的!");
				return ;
			}else{
				for(File file2:files){
					if(file2.isDirectory()){
						 System.out.println("文件夹:" + file2.getAbsolutePath());
						 recurGetFiles(file2.getAbsolutePath());
					}else{
						 System.out.println("文件:" + file2.getAbsolutePath());
					}
				}
			}
		}else{
			System.out.println("文件不存在!");
		}
				
	}
}
