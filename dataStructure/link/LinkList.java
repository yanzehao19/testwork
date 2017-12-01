package link;

//单链表
public class LinkList {
	public Node first;// 定义一个头节点
	private int pos = 0;// 节点的位置

	public LinkList() {
		this.first = null;
	}

	// 插入一个结点
	public void addFirstNode(int data) {
		Node node = new Node(data);
		node.next = first;
		first = node;
	}

	// 删除一个头结点，并返回头结点
	public Node deleteFirstNode() {
		Node tempNode = first;
		first = tempNode.next;
		return tempNode;
	}

	// 在任意位置插入结点。在 index的后面插入
	public void add(int index, int data) {
		Node node = new Node(data);
		Node current = first;
		Node previous = first;
		while (pos != index) {
			previous = current;
			current = current.next;
			pos++;
		}
		node.next = current;
		previous.next = node;
		pos = 0;
	}

	// 删除任意位置的结点
	public Node deleteByPos(int index) {
		Node current = first;
		Node previous = first;
		while (pos != index) {
			pos++;
			previous = current;
			current = current.next;
		}
		if (current == first) {
			first = first.next;
		} else {
			pos = 0;
			previous.next = current.next;
		}
		return current;
	}

	// 根据结点的data删除结点（仅仅删除第一个）
	public Node deleteByData(int data) {
		Node current = first;
		Node previous = first;// 记住上一个结点
		while (current.data != data) {
			if (current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;

		}
		return current;
	}

	// 显示出所有结点信息
	public void displayAllNodes() {
		Node current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}

	// 根据位置查找结点信息
	public Node findByPos(int index) {
		Node current = first;
		if (pos != index) {
			current = current.next;
			pos++;
		}
		return current;
	}

	// 根据数据查找结点信息
	public Node findByData(int data) {
		Node current = first;
		while (current.data != data) {
			if (current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}
}
