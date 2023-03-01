package entityChan;

import java.io.Serializable;
import java.util.List;

public class Enrolment implements Serializable{
	private String courseCode;
	private String course_name;
	private List<String> semester;
	private int year;
	private String grade;
	private boolean is_finished;

	public Enrolment(String courseCode, String course_name, List<String> semester, int year, String grade,
			boolean is_finished) {
		super();
		this.courseCode = courseCode;
		this.course_name = course_name;
		this.semester = semester;
		this.year = year;
		this.grade = grade;
		this.is_finished = is_finished;
	}

	public Enrolment() {
		super();
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public List<String> getSemester() {
		return semester;
	}

	public void setSemester(List<String> semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public boolean isIs_finished() {
		return is_finished;
	}

	public void setIs_finished(boolean is_finished) {
		this.is_finished = is_finished;
	}

	@Override
	public String toString() {
		return "Enrolment [courseCode=" + courseCode + ", course_name=" + course_name + ", semester=" + semester
				+ ", year=" + year + ", grade=" + grade + ", is_finished=" + is_finished + "]";
	}

}
