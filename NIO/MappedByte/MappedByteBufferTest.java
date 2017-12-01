package ftpUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {
	public static void method4() {
		RandomAccessFile aFile = null;
		FileChannel fc = null;
		try {
			aFile = new RandomAccessFile("src/1.ppt", "rw");
			fc = aFile.getChannel();

			long timeBegin = System.currentTimeMillis();
			ByteBuffer buff = ByteBuffer.allocate((int) aFile.length());
			buff.clear();
			fc.read(buff);

			long timeEnd = System.currentTimeMillis();
			System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (aFile != null) {
					aFile.close();
				}
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void method3() {
		RandomAccessFile aFile = null;
		FileChannel fc = null;
		try {
			aFile = new RandomAccessFile("src/1.ppt", "rw");
			fc = aFile.getChannel();
			long timeBegin = System.currentTimeMillis();
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, aFile.length());
			long timeEnd = System.currentTimeMillis();
			System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (aFile != null) {
					aFile.close();
				}
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		method3();
		System.out.println("=============");
		method4();
	}
}
