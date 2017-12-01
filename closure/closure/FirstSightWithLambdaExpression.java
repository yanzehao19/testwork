package closure;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class FirstSightWithLambdaExpression {

	public static void main(String[] args) {
		List list =  Arrays.asList((Callable) () -> "callable 1", (Callable) () -> "callable 2",
				(Callable) () -> "callable 3");

		ExecutorService e = Executors.newFixedThreadPool(2);
		List futures = null;
		try {
			futures = e.invokeAll(list);
			new FirstSightWithLambdaExpression().dumpList(futures);

		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
		e.shutdown();
	}

	public void dumpList(List list) throws InterruptedException, ExecutionException {
		for (Future future : list) {
			System.out.println(future.get());
		}
	}

}
