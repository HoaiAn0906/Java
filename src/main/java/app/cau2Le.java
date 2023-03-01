package app;

import java.io.FileNotFoundException;

import entityLe.Train;
import util.mapperLe;

public class cau2Le {
	public static void main(String[] args) throws FileNotFoundException {
		Train train = new Train();
		train = mapperLe.readFromFile("data/dataLe.json");
		System.out.println(train);
	}
}
