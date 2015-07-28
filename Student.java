package selcprj;

public class Student extends Human {
	private Group group;

	public Student(String name, String sirname, int age, char gender) {
		super(name, sirname, age, gender);
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getGroup() {
		return group.groupNum;
	}

	@Override
	public String toString() {
		String grNum = (group == null) ? "No group" : group.groupNum;
		return super.toString() + " group:" + grNum;
	}

}
