package rpc;

public class Test {
	public static void main(String[] args) {
		HelloWorldService helloWorldService = (HelloWorldService) RPCProxyClient.getProxy(HelloWorldService.class);
		helloWorldService.sayHello("test");
	}
}
