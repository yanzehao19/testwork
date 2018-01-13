package minorAndOptimize;

public class TraditionalThread {

	public static void main(String[] args) {
		Thread thread =new Thread(){
			public void run(){
				while(true){
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("1:"+Thread.currentThread().getName());
				}
			}
		};
		thread.start();
		
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("2:"+Thread.currentThread().getName());
				}
			}
		});
		thread2.start();
	
	new Thread(new Runnable() {
		@Override
		public void run() {
			while(true){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("Runable"+Thread.currentThread().getName());
			}
		}
	}){
		public void run(){
			while(true){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("3:"+Thread.currentThread().getName());
			}
		}
	}.start();
}

}
