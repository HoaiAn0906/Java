package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import entityChan.Student;
import entityLe.Arrival;
import entityLe.StartDay;
import entityLe.Train;

public class mapperLe {
	public static Train readFromFile(String path) throws FileNotFoundException {
		JsonParser parser = Json.createParser(new FileReader(path));
		String keyName = "";

		Train train = null;
		StartDay startDay = null;
		List<Arrival> arrivals = null;

		while (parser.hasNext()) {
			Event event = parser.next();
			switch (event) {
			case START_OBJECT:
				if (keyName.equals("start_day")) {
					startDay = new StartDay();
					break;
				} else {
					train = new Train();
					break;
				}
			case START_ARRAY:
				if (keyName.equals("arrivals")) {
					JsonArray jaArr = parser.getArray();
					if(jaArr != null) {
						arrivals = new ArrayList<Arrival>();
					}
					for (JsonValue jsonValue : jaArr) {
						arrivals.add(toArrivals(jsonValue.toString()));
					}					
					break;
				}
				break;
			case KEY_NAME:
				keyName = parser.getString();
				break;
			case VALUE_STRING:
				setValueString(train, startDay, keyName, parser.getString());
				break;
			case VALUE_NUMBER:
				setValueNumber(train, startDay, keyName, parser.getInt());
				break;
			case VALUE_TRUE:

				break;
			case VALUE_FALSE:

				break;
			default:
				break;
			}
		}
		train.setArrivals(arrivals);
		train.setStartDay(startDay);
		return train;
	}

	private static void setValueNumber(Train train, StartDay startDay, String keyName, int value) {
		switch (keyName) {
		case "year":
			startDay.setYear(value);
			break;
		case "month":
			startDay.setMonth(value);
			break;
		case "day":
			startDay.setDay(value);
			break;
		default:
			break;
		}

	}

	private static void setValueString(Train train, StartDay startDay, String keyName, String string) {
		switch (keyName) {
		case "id":
			train.setId(string);
			break;
		case "name":
			train.setName(string);
			break;
		case "departure":
			train.setDeparture(string);
			break;
		default:
			break;
		}
	}
	
	private static Arrival toArrivals(String string) {
		StringReader st=new StringReader(string);
		JsonParser parser=Json.createParser(st);
		String keyName="";
		
		Arrival arrival = null;
		while(parser.hasNext()) {
			Event event = parser.next();
			switch (event) {
			case START_OBJECT:
				arrival = new Arrival();
				break;
			case KEY_NAME:
				keyName = parser.getString();
				break;
			case VALUE_NUMBER:
				if(keyName.equals("price")) {
					arrival.setPrice(parser.getLong());
				} else if (keyName.equals("seat_empty")) {
					arrival.setSeat_empty(parser.getInt());
				}
				break;
			case VALUE_STRING:
				if(keyName.equals("name")) {
					arrival.setName(parser.getString());
				} else if(keyName.equals("id")) {
					arrival.setId(parser.getString());
				} else if(keyName.equals("time")) {
					arrival.setTime(parser.getString());
				}
				break;
			case VALUE_FALSE:
				arrival.setStop_over(false);
				break;
			case VALUE_TRUE:
				arrival.setStop_over(true);
				break;
			default:
				break;
			}

		}
		return arrival;
	}
}
