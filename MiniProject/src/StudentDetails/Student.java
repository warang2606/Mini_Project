package StudentDetails;

import java.util.*;

public class Student {
	int sno;
	String snm;
	String syear;
	int sadyear;
	String dept;

	@Override
	public String toString() {
		return "Student [student Roll No.=" + sno + ", Student Name=" + snm + ", Academic year=" + syear + ",Admission year=" + sadyear
				+ ", Department=" + dept + "]";
	}

	public Student(int sno, String snm, String syear, int sadyear, String dept) {
		this.sno = sno;
		this.snm = snm;
		this.syear = syear;
		this.sadyear = sadyear;
		this.dept = dept;
	}

	public int getsno() {
		return sno;
	}

	public String getsnm() {
		return snm;
	}

	public String getsyear() {
		return syear;
	}

	public int getsadyear() {
		return sadyear;
	}

	public String getdept() {
		return dept;
	}
	public void setsno( int sno) {
		this.sno = sno;
	}
	public void setsnm(String snm) {
		this.snm = snm;
	}

	public void setsyear(String syear) {
		this.syear = syear;	
	}

	public void setsadyear(int sadyear) {
		this.sadyear = sadyear;
	}

	public void setdept(String dept) {
		this.dept = dept;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("-------------STUDENT MANAGEMENT SYSTEM---------------");
		System.out.println("Please enter details  login system");
		System.out.println("enter ID");
		int id;
		id = sc.nextInt();
		System.out.println("enter password");
		String password;
		password = sc.next();
		int flag = 0;
		ArrayList<Student> al = new ArrayList<>();

		if (id == 123 && password.equals("admin")) // here we use equals method of string because string that we define
													// and string that user give are store in different location in
													// memory so it will only check that both strings are same or not
													// but not give the proper output
		{

			System.out.println("login successfull");
			System.out.println("----------------------------------");
			System.out.println("Operations List");
			System.out.println("----------------------------------");
			while (flag != 1) {

				System.out.println("1: Enter Student Details");
				System.out.println("2: Show the Student Details");
				System.out.println("3: Search the student by Roll No.");
				System.out.println("4: Search the student by Admission year");
				System.out.println("5: Search the student by Department");
				System.out.println("6: Update Student Record");
				System.out.println("7: Delete Student Record");
				System.out.println("8: Exit");
				System.out.println("----------------------------------");
				System.out.println("select your operation");
				int ch;
				ch = sc.nextInt();
				switch (ch) {
				case 1:

					Student s = new Student(0, " ", " ", 0, " "); // every time case 1 execute or run it will set to
																	// this value and then the values accordingly
					System.out.println("enter Student Roll no");
					s.sno = sc.nextInt();
					System.out.println("enter Student name");
					s.snm = sc.next();
					System.out.println("enter Student Acadamic Year");
					s.syear = sc.next();
					System.out.println("enter Student Admission Year");
					s.sadyear = sc.nextInt();
					System.out.println("enter Student Department");
					s.dept = sc.next();
					al.add(new Student(s.sno, s.snm, s.syear, s.sadyear, s.dept));

					System.out.println("Record Inserted Sucessfully");
					System.out.println("----------------------------------");
					break;

				case 2:
					System.out.println("Student Information:--");
					Iterator<Student> i = al.iterator();
					while (i.hasNext()) {
						Student s1 = i.next();
						System.out.println(s1);
						
					}
					System.out.println("----------------------------------");
					break;
				case 3:
					boolean found = false;
					System.out.println("Enter the Student Roll No. to search");
					int r = sc.nextInt();
					i = al.iterator();
					while (i.hasNext()) {
						Student s1 = i.next();
						if (s1.getsno() == r) {
							System.out.println(s1);
							found = true;
							System.out.println("----------------------------------");
						}
					}
					if (!found) {
						System.out.println("record not found");
						System.out.println("----------------------------------");
					}
					break;
				case 4:
					boolean found1 = false;
					System.out.println("Enter the Admission year to sort the students");
					int y = sc.nextInt();
					i = al.iterator();
					System.out.println("students from year " +y+ " are :");
					while (i.hasNext()) {
						Student s1 = i.next();
						if (s1.getsadyear() == y) {
							System.out.println(s1);
							found1 = true;
							System.out.println("----------------------------------");
						}
					}
					if (!found1) {
						System.out.println("record not found");
						System.out.println("----------------------------------");
					}
					break;
				case 5:
					boolean found2 = false;
					System.out.println("Enter the Department to sort the students");
					String d = sc.next();
					i = al.iterator();
					System.out.println("students from " +d+ " department are :");
					while (i.hasNext()) {
						Student s1 = i.next();
						if (s1.getdept().equalsIgnoreCase(d)) {           //Compares this String to another String, ignoring case considerations.(capital and small)
							
							System.out.println(s1);
							found2 = true;
							System.out.println("----------------------------------");
						}

					}
					if (!found2) {
						System.out.println("record not found");
						System.out.println("----------------------------------");
					}
					break;
				case 6:
					found = false;
					System.out.print("Enter Student rollno to Update : ");
					int sno = sc.nextInt();
					ListIterator<Student> li = al.listIterator();
					while (li.hasNext()) {
						Student s1 = li.next();
						if (s1.getsno() == sno) {
							System.out.println("enter new academic year");
							String syear = sc.next();
							s1.setsyear(syear);
							System.out.println("enter new department");
							String dept = sc.next();
							s1.setdept(dept);
							found = true;
							System.out.println("record updated successfully");
							System.out.println("----------------------------------");
						}
					}
					if (!found) {
						System.out.println("record not found");
						System.out.println("----------------------------------");
					}
					break;
				case 7:
					boolean found3 = false;
					System.out.println("enter the element to delete the record");
					int g = sc.nextInt();
					i = al.iterator();
					while(i.hasNext())
					{
						Student s1 = i.next();
						if(s1.getsno() == g)
						{
							 i.remove();
							 found3 = true;
							 System.out.println("record deleted successfully");
							 System.out.println("----------------------------------");
						}
					}
					if(!found3)
					   {
						   System.out.println("record not found");
						   System.out.println("----------------------------------");
					   }
					
					break;
				case 8:
					System.out.println("application end");
					System.exit(0);
					break;
				default:
					System.out.println("invalid choice");
				}
				}

		}
		System.out.println("please enter correct details");

	} // if(id==123)

}
