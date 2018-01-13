package concurrentSafe;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 该Servlet中定义了一个实例变量output，在service方法将其赋值为用户的输出。
 * 当一个用户访问该Servlet时，程序会正常的运行，但当多个用户并发访问时，就可能会出现其它用户的信息显示在另外一些用户的浏览器上的问题。
 * 这是一个严重的问题
 * 
 * 解决方法：所以在实际的开发中也应避免或最小化 Servlet 中的同步代码；
 * 在Serlet中避免使用实例变量是保证Servlet线程安全的最佳选择。
 * 
 * 不要在Servlet中创建自己的线程来完成某个功能。
Servlet本身就是多线程的，在Servlet中再创建线程，将导致执行情况复杂化，出现多线程安全问题
 * @author lenovo
 *
 */
public class ConcurrentTest {
	PrintWriter output;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username;
		response.setContentType("text/html; charset=gb2312");
		username = request.getParameter("username");
		output = response.getWriter();
		try {
			Thread.sleep(5000); // 为了突出并发问题，在这设置一个延时
		} catch (InterruptedException e) {
		}
		output.println("用户名:" + username + "<BR>");
	}

}
