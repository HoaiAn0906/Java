package util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import entityChan.DateOfBirth;
import entityChan.Enrolment;
import entityChan.Student;

public class mapperChan {
	public static List<Student> readFromFile(String path) {
		List<Student> students = new ArrayList<Student>();
		JsonReader reader = null;
		
		try {
			reader = Json.createReader(new FileReader(path));
			JsonArray jsonArray = reader.readArray();
				
			for(JsonValue jv:jsonArray) {
				if(jv instanceof JsonObject) {
					Student student = new Student();
					JsonObject jObjectStudent = (JsonObject) jv;
					student.setId(jObjectStudent.getInt("id"));
					student.setName(jObjectStudent.getString("name"));
					student.setEmail(jObjectStudent.getString("email"));
					JsonObject jODateOfBirth = jObjectStudent.getJsonObject("dateofbirth");
					DateOfBirth dateOfBirth = new DateOfBirth();
					dateOfBirth.setYear(jODateOfBirth.getInt("year"));
					dateOfBirth.setMonth(jODateOfBirth.getInt("month"));
					dateOfBirth.setDay(jODateOfBirth.getInt("day"));
					student.setDateOfBirth(dateOfBirth);
					JsonArray jAEnrolments = jObjectStudent.getJsonArray("enrolments");
					List<Enrolment> enrolments = new ArrayList<Enrolment>();
					for(JsonValue jAEnrolment:jAEnrolments) {
						if(jAEnrolment instanceof JsonObject) {
							JsonObject jOEnrolment = (JsonObject) jAEnrolment;
							Enrolment enrolment = new Enrolment();
							enrolment.setCourse_name(jOEnrolment.getString("course_name"));
							enrolment.setCourseCode(jOEnrolment.getString("course_code"));
							if(jOEnrolment.isNull("grade")) {
								enrolment.setGrade("null");
							} else
								enrolment.setGrade(jOEnrolment.getString("grade"));
							enrolment.setYear(jOEnrolment.getInt("year"));
							enrolment.setIs_finished(jOEnrolment.getBoolean("is_finished"));
							JsonArray jASemes = jOEnrolment.getJsonArray("semester");
							List<String> semester = new ArrayList<String>();
							for(JsonValue jASeme:jASemes) {
								semester.add(jASeme.toString());
							}
							enrolment.setSemester(semester);
							enrolments.add(enrolment);
						}
					}
					student.setEnrolments(enrolments);
					students.add(student);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return students;
	}
}
