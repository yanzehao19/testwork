package nio;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorExample {

	public static void main(String[] args) throws IOException {
		// create selector
		Selector selector = Selector.open();
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.configureBlocking(false);
		// register channel to selector
		SelectionKey key = channel.register(selector, SelectionKey.OP_READ);

		int interestSet1 = key.interestOps();

		int readySet = key.readyOps();

		SelectableChannel channle2 = key.channel();
		Selector selector2 = key.selector();

		Set selectedKeys = selector.selectedKeys();
		java.util.Iterator keyIterator11 = selectedKeys.iterator();
		while (keyIterator11.hasNext()) {
			SelectionKey key2 = (SelectionKey) keyIterator11.next();
			if (key2.isAcceptable()) {

			}
		}

		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0)
				continue;
			Set selectedkeys2 = selector.selectedKeys();
			Iterator keyIterator = selectedkeys2.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey key2 = (SelectionKey) keyIterator.next();
				if (key.isAcceptable()) {

				}
			}
		}

	}

}
