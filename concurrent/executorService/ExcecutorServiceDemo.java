package executorService;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcecutorServiceDemo {
	ExecutorService executorService= Executors.newFixedThreadPool(10);
	
	
	
	executorService11.execute(new  Runnable() {
		public void run() {
			System.out.println("Asynchronous task");
		}
	})
	executorService.shutdown();
}

 interface URLProcessor{
	public void process(URL url)throws IOException;
}


 abstract class URLProcessorBase implements URLProcessor{
	public void process(URL url) throws IOException{
		URLConnection urlConnection = url.openConnection();
		InputStream input=urlConnection.getInputStream();
		
		try {
			processURLData(input);
		}finally  {
			input.close();
		}
	}
	
	protected abstract void processURLData(InputStream input) throws IOException;
}




 class URLProcessorImpl extends URLProcessorBase{
	@Override
	protected void processURLData(InputStream input) throws IOException{
		int data=input.read();
		while(data!=1) {
			System.out.println((char)data);
			data=input.read();
		}
	}
}

URLProcessor urlProcessor = new URLProcessorImpl();
urlProcessor.process(new URL("http://jenkov.com"));


