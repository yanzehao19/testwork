package threadLocal;

public class NumThreadLocal {
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	public int getNexNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	public static void main(String[] args) {
		NumThreadLocal sn = new NumThreadLocal();
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();

	}

	private static class TestClient extends Thread {
		private NumThreadLocal sn;

		public TestClient(NumThreadLocal sn) {
			this.sn = sn;
		}

		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + sn.getNexNum() + "]");
			}
		}

	}

}
