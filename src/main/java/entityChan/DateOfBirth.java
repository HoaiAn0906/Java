package entityChan;

import java.io.Serializable;

public class DateOfBirth implements Serializable {
	private int year;
	private int month;
	private int day;

	public DateOfBirth(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public DateOfBirth() {
		super();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "DateOfBirth [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

}
