package selcprj;

public class Main {

	public static void main(String[] args) {
		Group gr = new Group("JavaOOP");
		Student st[] = { new Student("Pupkin0", "V", 21, 'm'),
				new Student("Pupkin1", "V", 21, 'f'),
				new Student("Pupkin2", "V", 21, 'm'),
				new Student("Pupkin3", "V", 21, 'm'),
				new Student("Pupkin4", "V", 21, 'f'),
				new Student("Pupkin5", "V", 21, 'f'),
				new Student("Pupkin6", "V", 21, 'm'),
				new Student("Pupkin7", "V", 21, 'f'),
				new Student("Pupkin8", "V", 21, 'm'),
				new Student("Pupkin9", "V", 21, 'm'),
				new Student("Pupkin-", "V", 21, 'f') };

		// В цикле добавляем студентов в группу, последний - лишний
		try {
			for (Student stud : st) {
				gr.addStudent(stud);
			}
		} catch (GroupIsFullException e) {
			System.out.println("Error: " + e);
		} catch (DuplicationException e){
			System.out.println("Error: " + e);
		}
		
		gr.listStudents();
		
		// 5-го студента исключаем
		gr.excludeStudent(st[5].getSirname());
		gr.listStudents();
		
		// Пытаемся дабавить студента, который уже есть в группе
		try {
			gr.addStudent(st[1]);
		} catch (GroupIsFullException e) {
			System.out.println("Error: " + e);
		} catch (DuplicationException e){
			System.out.println("Error: " + e);
		}
	}

}
