package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;  
        String greetings[] = { " Hello world !", " Hello World !! ",  
                " HELLO WORLD !!!" };  
        while (i < 4) {  
            try {  
                // 特别注意循环控制变量i的设计，避免造成无限循环  
            	//将会出现死循环越界时i为3
            	//System.out.println(greetings[i]);  i++;
            	//正常运行，因为[i++]越界之后，i就变成4了
            	System.out.println(greetings[i++]);  
            } catch (ArrayIndexOutOfBoundsException e) {  
                System.out.println("数组下标越界异常");  
            } finally {  
                System.out.println("--------------------------");  
            }  
        }  
	}

}
