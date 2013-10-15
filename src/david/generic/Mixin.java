package david.generic;

import java.util.Date;
import java.util.logging.Logger;

interface IBasic {
	public void set(String name);

	public String get();
}

class BasicImp implements IBasic {
	private String name;

	@Override
	public void set(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return name;
	}

}

interface ITimeStamp {
	long getTimeStamp();
}

class TimeStampImp implements ITimeStamp {
	@Override
	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return new Date().getTime();
	}
}

interface ISeriesNumber {
	long getSeriesNumber();
}

class SeriesNumber implements ISeriesNumber {
	private static long counter = 0;
	private long id = counter++;

	@Override
	public long getSeriesNumber() {
		// TODO Auto-generated method stub
		return id;
	}

}

/*
 * ªÏ–Õ
 */
public class Mixin extends BasicImp implements ITimeStamp, ISeriesNumber {
	
	private ITimeStamp timeStamp = new TimeStampImp();
	private ISeriesNumber seriesNumber = new SeriesNumber();	
	
	@Override
	public long getSeriesNumber() {
		// TODO Auto-generated method stub
		return seriesNumber.getSeriesNumber();
	}

	@Override
	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return timeStamp.getTimeStamp();
	}
}
