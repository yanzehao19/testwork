package yzh.dataByte;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.tree.ExpandVetoException;

public class ZipCompressUtils {

	public static void main(String[] args) throws Exception {
		 //ZipFile("d:\\zip.txt", "D:\\zip.zip");
		/* ZipMultiFile("d:\\test1", "D:\\zip.zip"); */
		/*
		 * ZipOutputStream zipOutputStream = new ZipOutputStream(new
		 * FileOutputStream(new File("D:\\file.zip"))); File file = new
		 * File("d:\\test"); zip("d:\\test",file , zipOutputStream);
		 */
		compress("d:\\1.txt");
		compress("d:\\Java");
		System.out.println("压缩成功");
	}

	/**
	 * 压缩单个文件
	 */
	public static void ZipFile(String filepath, String zippath) {

		try {
			File file = new File(filepath);
			File zipfile = new File(zippath);
			InputStream inputStream = new FileInputStream(file);
			ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipfile));
			zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
			int temp = 0;
			while ((temp = inputStream.read()) != -1)
				zipOutputStream.write(temp);
			inputStream.close();
			zipOutputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 压缩多个文件，文件存放在一个文件夹中但是文件中不能再有文件夹
	 */
	public static void ZipMultiFile(String filepath, String zippath) {
		try {
			File file = new File(filepath);
			File zipFile = new File(zippath);
			InputStream inputStream = null;
			ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; ++i) {
					inputStream = new FileInputStream(files[i]);
					zipOutputStream.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
					int temp = 0;
					while ((temp = inputStream.read()) != -1) {
						zipOutputStream.write(temp);
					}
					inputStream.close();
				}
			}
			zipOutputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 递归压缩文件夹
	 * 
	 * @param srcRootDir
	 *            压缩文件夹根目录的子路径
	 * @param file
	 *            当前递归压缩的文件或目录对象
	 * @param zos
	 *            压缩文件存储对象
	 * @throws Exception
	 */
	private static void zip(String srcRootDir, File file, ZipOutputStream zos) throws Exception {
		try {
			if (file == null) {
				return;
			}

			// 如果是文件，则直接压缩该文件
			if (file.isFile()) {
				int count, bufferLen = 1024;
				byte data[] = new byte[bufferLen];

				// 获取文件相对于压缩文件夹根目录的子路径
				String subPath = file.getAbsolutePath();
				int index = subPath.indexOf(srcRootDir);
				if (index != -1) {
					subPath = subPath.substring(srcRootDir.length() + File.separator.length());
				}
				ZipEntry entry = new ZipEntry(subPath);
				zos.putNextEntry(entry);
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				while ((count = bis.read(data, 0, bufferLen)) != -1) {
					zos.write(data, 0, count);
				}
				bis.close();
				zos.closeEntry();
			}
			// 如果是目录，则压缩整个目录
			else {
				// 压缩目录中的文件或子目录
				File[] childFileList = file.listFiles();
				for (int n = 0; n < childFileList.length; n++) {
					childFileList[n].getAbsolutePath().indexOf(file.getAbsolutePath());
					zip(srcRootDir, childFileList[n], zos);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final String EXT = ".zip";
	private static final String BASE_DIR = "";

	// 符号"/"用来作为目录标识判断符
	private static final String PATH = "/";
	private static final int BUFFER = 1024;

	/**
	 * 压缩
	 * 
	 * @param srcFile
	 * @throws Exception
	 */
	public static void compress(File srcFile) throws Exception {
		String name = srcFile.getName();
		String basePath = srcFile.getParent();
		String destPath = basePath + name + EXT;
		compress(srcFile, destPath);
	}

	/**
	 * 压缩
	 * 
	 * @param srcFile
	 *            源路径
	 * @param destPath
	 *            目标路径
	 * @throws Exception
	 */
	public static void compress(File srcFile, File destFile) throws Exception {

		// 对输出文件做CRC32校验
		CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(destFile), new CRC32());

		ZipOutputStream zos = new ZipOutputStream(cos);

		compress(srcFile, zos, BASE_DIR);

		zos.flush();
		zos.close();
	}

	/**
	 * 压缩文件
	 * 
	 * @param srcFile
	 * @param destPath
	 * @throws Exception
	 */
	public static void compress(File srcFile, String destPath) throws Exception {
		compress(srcFile, new File(destPath));
	}

	/**
	 * 压缩
	 * 
	 * @param srcFile
	 *            源路径
	 * @param zos
	 *            ZipOutputStream
	 * @param basePath
	 *            压缩包内相对路径
	 * @throws Exception
	 */
	private static void compress(File srcFile, ZipOutputStream zos, String basePath) throws Exception {
		if (srcFile.isDirectory()) {
			compressDir(srcFile, zos, basePath);
		} else {
			compressFile(srcFile, zos, basePath);
		}
	}

	/**
	 * 压缩
	 * 
	 * @param srcPath
	 * @throws Exception
	 */
	public static void compress(String srcPath) throws Exception {
		File srcFile = new File(srcPath);

		compress(srcFile);
	}

	/**
	 * 文件压缩
	 * 
	 * @param srcPath
	 *            源文件路径
	 * @param destPath
	 *            目标文件路径
	 * 
	 */
	public static void compress(String srcPath, String destPath) throws Exception {
		File srcFile = new File(srcPath);

		compress(srcFile, destPath);
	}

	/**
	 * 压缩目录
	 * 
	 * @param dir
	 * @param zos
	 * @param basePath
	 * @throws Exception
	 */
	private static void compressDir(File dir, ZipOutputStream zos, String basePath) throws Exception {

		File[] files = dir.listFiles();

		// 构建空目录
		if (files.length < 1) {
			ZipEntry entry = new ZipEntry(basePath + dir.getName() + PATH);

			zos.putNextEntry(entry);
			zos.closeEntry();
		}

		for (File file : files) {

			// 递归压缩
			compress(file, zos, basePath + dir.getName() + PATH);

		}
	}

	/**
	 * 文件压缩
	 * 
	 * @param file
	 *            待压缩文件
	 * @param zos
	 *            ZipOutputStream
	 * @param dir
	 *            压缩文件中的当前路径
	 * @throws Exception
	 */
	private static void compressFile(File file, ZipOutputStream zos, String dir) throws Exception {

		/**
		 * 压缩包内文件名定义
		 * 
		 * <pre>
		 *  
		 * 如果有多级目录，那么这里就需要给出包含目录的文件名 
		 * 如果用WinRAR打开压缩包，中文名将显示为乱码
		 * </pre>
		 */
		ZipEntry entry = new ZipEntry(dir + file.getName());

		zos.putNextEntry(entry);

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

		int count;
		byte data[] = new byte[BUFFER];
		while ((count = bis.read(data, 0, BUFFER)) != -1) {
			zos.write(data, 0, count);
		}
		bis.close();

		zos.closeEntry();
	}

}
