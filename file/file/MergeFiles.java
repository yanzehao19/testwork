package file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 合并txt 文件要注意文件的编码格式 不然合并之后的文件出现乱码
 * 
 * @author yzh
 *
 */
public class MergeFiles {
	public static void main(String[] args) throws IOException {
		/*
		 * String code = getCharsetFile(
		 * "C:\\Users\\yzh\\Desktop\\编码不同合并\\10552100000436120171121090002.txt")
		 * ; System.out.println(code);
		 * 
		 */
		//mergeFilesByIO();
		 removeFromFile();
	}

	/**
	 * 通过nio合并文件
	 * 
	 */
	public void mergeFilesByNIO() {
		String path = "C:\\Users\\yzh\\Desktop\\编码不同合并";
		File file = new File(path);
		File[] files = file.listFiles();
		List fileList = Arrays.asList(files);
		Collections.sort(fileList, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (File file2 : files) {
			System.out.println(file2.getName());
		}
		String outPath = "C:\\Users\\yzh\\Desktop\\test.txt";
		FileChannel fileChannel;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outPath);
			FileChannel outFileChanl = fos.getChannel();
			for (File file2 : files) {
				System.out.println(file2.getName());
				fis = new FileInputStream(file2);
				fileChannel = fis.getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				while (fileChannel.read(buffer) != -1) {
					buffer.flip();
					while (buffer.hasRemaining()) {
						outFileChanl.write(buffer);
					}
					buffer.clear();
				}
			}
		} catch (Exception e) {

		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 合并多个文件用io
	 * 
	 * @throws IOException
	 */
	public static void mergeFilesByIO() throws IOException {
		String path = "C:\\Users\\yzh\\Desktop\\新建文件夹";
		File file = new File(path);
		File[] files = file.listFiles();
		List fileList = Arrays.asList(files);
		Collections.sort(fileList, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (File file2 : files) {
			System.out.println(file2.getName());
		}

		BufferedWriter writer = null;
		try {
			String outPath = "C:\\Users\\yzh\\Desktop\\test.txt";
			File outFile = new File(outPath);
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			for (File file2 : files) {
				BufferedReader bufferedReader = null;
				try {
					String code ="UTF-8";//getCharsetFile(file2);
					System.out.println(code);
					bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2), code));
					String line = null;
					while ((line = bufferedReader.readLine()) != null) {
						writer.write(line);
						writer.newLine();
					}

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					bufferedReader.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			writer.close();
		}

	}

	/**
	 * 获取文件编码格式
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String getCharsetFile(String fileName) throws IOException {
		BufferedInputStream bin = null;
		try {
			bin = new BufferedInputStream(new FileInputStream(fileName));
			int p = (bin.read() << 8) + bin.read();
			String code = null;
			switch (p) {
			case 12924:
				code = "UTF-8";
				break;
			case 0xfffe:
				code = "Unicode";
				break;
			case 0xfeff:
				code = "UTF-16BE";
				break;
			default:
				code = "GBK";
			}
			return code;
		} finally {
			bin.close();
		}

	}

	/**
	 *
	 */

	/**
	 * 剔除退款的订单生成文件
	 * 
	 * @throws IOException
	 * 
	 */
	public static void removeFromFile() throws IOException {
		ReadExcel readExcel = new ReadExcel();
		String path = "C:\\Users\\yzh\\Desktop\\对账初始化\\退费表\\总的退费订单记录.xlsx";
		// 获得退款的订单号记录list
		List<String> columnList = readExcel.readExcel(path);
		System.out.println(containsRefund("171111420006463", columnList));

		BufferedWriter writer = null;
		try {
			String outPath = "C:\\Users\\yzh\\Desktop\\test.txt";
			File outFile = new File(outPath);
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			BufferedReader bufferedReader = null;
			try {
				String code = "UTF-8";//getCharsetFile("");
				bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\yzh\\Desktop\\新建文件夹\\20170928-20180112.txt"), code));
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					// 剔除退款的订单号
					String[] strings = line.split("\\|");
					if (!containsRefund(strings[10], columnList)) {
						writer.write(line);
						writer.newLine();
					}
				}

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				bufferedReader.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			writer.close();
		}

	}

	public static boolean containsRefund(String line, List<String> lists) {
		for (String list : lists) {
			if (line.equals(list)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取文件编码格式通过File
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String getCharsetFile(File fileName) throws IOException {
		//BufferedInputStream bin = null;
		InputStream in=null;
		try {
			 in = new FileInputStream(fileName);
			byte[] b = new byte[3]; 
			in.read(b);
			String code = null;
			if(b[0]==-17&&b[1]==-69&&b[2]==-65){
				code = "UTF-8";
			}else {
				code = "GBK";
			}
			/*int p = (bin.read() << 8) + bin.read();
			
			switch (p) {
			case 12924:
				code = "UTF-8";
				break;
			case 12848:
				code = "GBK";
				break;
			case 0xfeff:
				code = "UTF-16BE";
				break;
			default:
				code = "Unicode";
			}*/
			return code;
		} finally {
			in.close();
		}

	}

}
