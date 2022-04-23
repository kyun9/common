package common;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class CalCulateDate {

	private final static Logger LOG = Logger.getGlobal();

	public static void main(String[] args) {

		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
		LocalDateTime now = LocalDateTime.now();

		System.out.println(now);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyyMMdd a HH:mm ss");

		System.out.println(formatter1);
		System.out.println(formatter2);
		System.out.println(formatter3);
		System.out.println(formatter4);

		String formatedNow1 = now.format(formatter1);
		String formatedNow2 = now.format(formatter2);
		String formatedNow3 = now.format(formatter3);
		String formatedNow4 = now.format(formatter4);

		System.out.println(formatedNow1);
		System.out.println(formatedNow2);
		System.out.println(formatedNow3);
		System.out.println(formatedNow4);

		System.out.println(lastDayOfMonth("20220420", "yyyyMMdd"));
		// now()일때
		System.out.println("now()");
		System.out.println(lastDayOfMonth("2022-04-20 23:32:44", "yyyy-MM-ttdd"));
		System.out.println("6글자");
		System.out.println(lastDayOfMonth("202204", "yyyyMMdd"));
	
	}

	/**
	 * @메소드명 : CalDate
	 * @메소드설명 :
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 :
	 * @파라미터 :
	 * @파라미터 :
	 * @return
	 */
	public static String CalDate(String baseDate, String optType, String targetDate, String returnFormat) {

		return "";
	}

	/**
	 * @메소드명 : lastDayOfMonth
	 * @메소드설명 : lastDayOfMonth() 입력한 날짜(YYYYMMDD)의 마지막 날짜를 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-04-23
	 * @파라미터 : String baseDate
	 * @파라미터 : String returnFormat
	 * @return String resultStr
	 */
	public static String lastDayOfMonth(String baseDate, String returnFormat) {
		String resultStr = "";

		try {
			String convertBaseDate = baseDate.replace(" ", "").replace("-", "").replace(":", "");

			int digitYYYY = 0;
			int digitMM = 0;
			int digitDD = 0;

			if (convertBaseDate.length() >= 8) {
				digitYYYY = Integer.parseInt(convertBaseDate.substring(0, 4));
				digitMM = Integer.parseInt(convertBaseDate.substring(4, 6));
				digitDD = Integer.parseInt(convertBaseDate.substring(6, 8));
			} else if (convertBaseDate.length() == 6) {
				digitYYYY = Integer.parseInt(convertBaseDate.substring(0, 4));
				digitMM = Integer.parseInt(convertBaseDate.substring(4, 6));
				digitDD = 1;
			}

			LocalDate initial = LocalDate.of(digitYYYY, digitMM, digitDD);
			// LocalDate start = initial.withDayOfMonth(1); 첫 날짜
			LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(returnFormat);
			String formatedLastDayOfMonth = end.format(formatter);

			resultStr = formatedLastDayOfMonth;
		} catch (StringIndexOutOfBoundsException e) {
			LOG.warning("[StringIndexOutOfBoundsException] Parameter is not match date time.  'baseDate' must be at least 6 characters long.  [ERROR input : String baseDate = " + baseDate + " ] -------- lastDayOfMonth");
			e.printStackTrace();
			throw e;
		} catch (DateTimeException e) {
			LOG.warning("[DateTimeException] Parameter is not match Date time type.  [ERROR input : String baseDate = " + baseDate + " ] -------- lastDayOfMonth");
			e.printStackTrace();
			throw e;
		} catch (NumberFormatException e) {
			LOG.warning("[NumberFormatException] Parameter is not match.  [ERROR input : String baseDate = " + returnFormat + " ] -------- lastDayOfMonth");
			e.printStackTrace();
			throw e;
		} catch (IllegalArgumentException e) {
			LOG.warning("[IllegalArgumentException] Parameter is not format.  [ERROR input : String returnFormat = " + returnFormat + " ] -------- lastDayOfMonth");
			e.printStackTrace();
			throw e;
		}

		return resultStr;
	}
}
