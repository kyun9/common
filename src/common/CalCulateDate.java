package common;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CalCulateDate {

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

		System.out.println(lastDayOfMonth("20220201", "yyyyMMdd"));
	}

	/**
	 * @메소드명  : CalDate
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
	 * @메소드명  : lastDayOfMonth
	 * @메소드설명 : lastDayOfMonth() 입력한 날짜(YYYYMMDD)의 마지막 날짜를 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-04-23 
	 * @파라미터 : String yyyyMmDd
	 * @파라미터 : String returnFormat
	 * @return String resultStr
	 */
	public static String lastDayOfMonth(String yyyyMmDd, String returnFormat) {
		String resultStr = "";
		if (yyyyMmDd.length() == 8) {
			try {
				int digitYYYY = Integer.parseInt(yyyyMmDd.substring(0, 4));
				int digitMM = Integer.parseInt(yyyyMmDd.substring(4, 6));
				int digitDD = Integer.parseInt(yyyyMmDd.substring(6, 8));
	
				LocalDate initial = LocalDate.of(digitYYYY, digitMM, digitDD);
				// LocalDate start = initial.withDayOfMonth(1);  첫 날짜 
				LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
					
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(returnFormat);
				String formatedLastDayOfMonth = end.format(formatter);
					
				resultStr = formatedLastDayOfMonth;
			}catch(DateTimeException e){
				resultStr = "[DateTimeException] Parameter is not match date time.  [input : String yyyyMmDd = " + yyyyMmDd + " ] -------- lastDayOfMonth";
			}catch(NumberFormatException e){
				resultStr = "[NumberFormatException] Parameter is not match.  [input : String yyyyMmDd = " + returnFormat + " ] -------- lastDayOfMonth";
			}catch(IllegalArgumentException e) {
				resultStr = "[IllegalArgumentException] Parameter is not format.  [input : String returnFormat = " + returnFormat + " ] -------- lastDayOfMonth";
			}
		} else {
			resultStr = "Parameter is not match length.  [input : yyyyMmDd length = " + yyyyMmDd.length()+ " ] -------- lastDayOfMonth";
		}

		return resultStr;
	}
}
