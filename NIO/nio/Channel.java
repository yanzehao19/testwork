package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel {

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("C:/Users/lenovo/Desktop/data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read" + bytesRead);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.println((char)buf.getChar());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);

		}
		aFile.close();
	}

}
