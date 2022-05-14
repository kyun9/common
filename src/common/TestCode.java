package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestCode {
	static CalCulateDate calCulateDate= new CalCulateDate();
	
	/* 날짜Format 테스트 */
	void practiceFormat() {
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
	}
	
	/* lastDayOfMonth함수 테스트 */
	void getLastDayOfMonthTest() {
		// 맞는 호출 yyyyMMdd
		System.out.println(calCulateDate.getLastDayOfMonth("20220420", "yyyyMMdd"));
		// 맞는 호출 now()형식
		System.out.println(calCulateDate.getLastDayOfMonth("2022-04-20 23:32:44", "yyyy-MM-dd"));
		// 맞는 호출 yyyyMM형식
		System.out.println(calCulateDate.getLastDayOfMonth("202204", "yyyyMMdd"));
		
		// 잘못 호출 Format형식
		System.out.println(calCulateDate.getLastDayOfMonth("2022-04-20 23:32:44", "yyyy-MM-ttdd"));
		// 잘못 호출 잘못된 파라미터
		System.out.println(calCulateDate.getLastDayOfMonth("tt","33"));
		System.out.println(calCulateDate.getLastDayOfMonth("11","yyyyMMdd"));
	}
}