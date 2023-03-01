package entityLe;

import java.io.Serializable;
import java.util.List;

public class Train implements Serializable {
	private String id;
	private String name;
	private String departure;
	private StartDay startDay;
	private List<Arrival> arrivals;

	public Train(String id, String name, String departure, StartDay startDay, List<Arrival> arrivals) {
		super();
		this.id = id;
		this.name = name;
		this.departure = departure;
		this.startDay = startDay;
		this.arrivals = arrivals;
	}

	public Train() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public StartDay getStartDay() {
		return startDay;
	}

	public void setStartDay(StartDay startDay) {
		this.startDay = startDay;
	}

	public List<Arrival> getArrivals() {
		return arrivals;
	}

	public void setArrivals(List<Arrival> arrivals) {
		this.arrivals = arrivals;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", name=" + name + ", departure=" + departure + ", startDay=" + startDay
				+ ", arrivals=" + arrivals + "]";
	}

}
