package filesoperation;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import exception.UserException;
import testerror.TestError;

public class DateAndTimeOperation {
	private LocalDate gettime(long inputMillis) {
		Instant news = Instant.ofEpochMilli(inputMillis) ;
		ZoneId zone = ZoneId.systemDefault();
		LocalDate local=news.atZone(zone).toLocalDate();
		return local;
	}
	public String getCurrentTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		return myDateObj.format(myFormatObj);

	}
	public long getCurrentMillis() {


		Clock clock = Clock.systemDefaultZone();
		long milliseconds = clock.millis();
		long it = Instant.now().toEpochMilli();
		System.out.println(milliseconds);
		System.out.println(it);
		return System.currentTimeMillis();//swami-i found two choice

	}

	public String getTimeWithTimeZone(String zoneName) throws UserException {
		TestError.nullCheck(zoneName);
		ZoneId zone=ZoneId.of(zoneName);
		LocalTime local=LocalTime.now(zone);
		DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm:SS");
		String formattedDate=local.format(format);
		return formattedDate;

	}
	public DayOfWeek getDateOfDay(long inputMillis)  {

		LocalDate local=gettime(inputMillis);
		DayOfWeek day1=DayOfWeek.from(local);
		return day1;
	}
	public Month getMonth(long inputMillis) {
		LocalDate local=gettime(inputMillis);
		Month currentMonth = local.getMonth();
		return currentMonth;
	}
	public int getYear(long inputMillis ) {
		LocalDate local=gettime(inputMillis);
		int currentYear = local.getYear();
		return currentYear;
	}
}
