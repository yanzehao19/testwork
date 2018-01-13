package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeFiles {
	public static void main(String[] args) {
		String path = "C:\\Users\\yzh\\Desktop\\对账文件\\download";
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
}
