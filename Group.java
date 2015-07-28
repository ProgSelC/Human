package selcprj;

public class Group {
	private static int recbookNum = 0;
	private String groupNum;
	Student[] students = new Student[10];

	public Group(String groupNum) {
		super();
		this.groupNum = groupNum;
	}
	
	public String getGroupNum(){
		return this.groupNum;
	}

	public void addStudent(Student st) throws GroupIsFullException, DuplicationException {
		boolean vacant = false;
		if (findStudent(st.getSirname()) == null) {
			for (int i = 0; i < this.students.length; i++) {
				if (this.students[i] == null) {
					this.students[i] = st;
					st.setGroup(this);
					st.setRecbookNum(++Group.recbookNum);
					vacant = true;
					break;
				}
			}
			if (!vacant) {
				throw new GroupIsFullException();
			}
		} else {
			throw new DuplicationException();
		}
	}

	public Student findStudent(String sirname) {
		Student st = null;
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] != null
					&& this.students[i].getSirname() == sirname) {
				st = this.students[i];
				break;
			}
		}
		return st;
	}

	public void excludeStudent(String sirname) {
		boolean stFound = false;
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] != null
					&& this.students[i].getSirname() == sirname) {
				this.students[i] = null;
				stFound = true;
				System.out.println("Student " + sirname + " excluded");
				break;
			}
		}
		if (!stFound) {
			System.out.println("No such student!");
		}
	}

	public void listStudents() {
		int index = 0;
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] != null) {
				System.out
						.println(++index + ") " + this.students[i].toString());
			}
		}
		System.out.println();
	}
}
