package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeExample {

	public static void main(String[] args) throws IOException {
		Pipe pipe= Pipe.open();
		Pipe.SinkChannel sinkChannel= pipe.sink();
		//write data
		String newData= "New Thing"+System.currentTimeMillis();
		ByteBuffer buffer= ByteBuffer.allocate(48);
		buffer.clear();
		buffer.put(newData.getBytes());
		buffer.flip();
		while(buffer.hasRemaining()){
			sinkChannel.write(buffer);
		}
		
		//read data
		Pipe.SourceChannel sourceChannel= pipe.source();
		ByteBuffer buffer2 = ByteBuffer .allocate(48);
		int bytesRead=sourceChannel.read(buffer2);
		
	}

}
