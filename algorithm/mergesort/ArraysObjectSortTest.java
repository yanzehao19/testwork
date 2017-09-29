package mergesort;

public class ArraysObjectSortTest {

	public static void main(String[] args) {
		Student stu1 = new Student(1001, 100.0F);
		Student stu2 = new Student(1002, 90.0F);
		Student stu3 = new Student(1003, 90.0F);
		Student stu4 = new Student(1004, 95.0F);
		Student[] stus = { stu1, stu2, stu3, stu4 };

		ArraysObject.sort(stus);
		for (int i = 0; i < stus.length; i++) {
			java.lang.System.out.println(stus[i].getId() + ":" + stus[i].getScore());
		}
	}

}

class Student implements Comparable<Student> {
	private int id;
	private float score;

	public Student() {
	}

	public Student(int id, float score) {
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(Student s) {
		return (int) (this.score - s.getScore());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}
