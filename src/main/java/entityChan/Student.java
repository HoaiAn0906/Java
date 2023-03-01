package entityChan;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
	private int id;
	private String name;
	private String email;
	private DateOfBirth dateOfBirth;
	private List<Enrolment> enrolments;

	public Student(int id, String name, String email, DateOfBirth dateOfBirth, List<Enrolment> enrolments) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.enrolments = enrolments;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DateOfBirth getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(DateOfBirth dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", enrolments=" + enrolments + "]";
	}

}
