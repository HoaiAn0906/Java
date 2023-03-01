package entityLe;

public class Arrival {
	private String name;
	private String id;
	private String time;
	private double price;
	private int seat_empty;
	private boolean stop_over;

	public Arrival(String name, String id, String time, double price, int seat_empty, boolean stop_over) {
		super();
		this.name = name;
		this.id = id;
		this.time = time;
		this.price = price;
		this.seat_empty = seat_empty;
		this.stop_over = stop_over;
	}

	public Arrival() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeat_empty() {
		return seat_empty;
	}

	public void setSeat_empty(int seat_empty) {
		this.seat_empty = seat_empty;
	}

	public boolean isStop_over() {
		return stop_over;
	}

	public void setStop_over(boolean stop_over) {
		this.stop_over = stop_over;
	}

	@Override
	public String toString() {
		return "Arrival [name=" + name + ", id=" + id + ", time=" + time + ", price=" + price + ", seat_empty="
				+ seat_empty + ", stop_over=" + stop_over + "]";
	}

}
