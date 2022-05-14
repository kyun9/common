package common;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CalCulateDate {

	private final static Logger LOG = Logger.getGlobal();
	static TestCode testCode= new TestCode();
	
	public static void main(String[] args) {	
//		testCode.practiceFormat(); 		                    /* 날짜Format 테스트 */
		testCode.getLastDayOfMonthTest();  		/* lastDayOfMonth함수 테스트 */
		
		/* calCulateDayInFormat함수 테스트 */
		
	}

	
	/**
	 * @메소드명 : calCulateDayInFormat
	 * @메소드설명 : 
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 :
	 * @수정일 : 
	 * @접근제어 : public 
	 * @파라미터 : String baseDate
	 * @파라미터 : String optType
	 * @파라미터 : String optType
	 * @파라미터 : String optType
	 * @파라미터 : String optType
	 * @파라미터 : String optType
	 * @파라미터 : String optType
	 * @return String resultStr
	 * @throws Exception 
	 */
	public  String calCulateDayInFormat(String baseDate, String optType, String optDateVal, String returnFormat) {
		String resultStr = "";
		
		try {
			String convertBaseDate = baseDate.replace(" ", "").replace("-", "").replace(":", "");
			
			
		}catch(Exception e) {
			
		}
		
		return resultStr;
	}

	/**
	 * @메소드명 : getLastDayOfMonth
	 * @메소드설명 : getLastDayOfMonth() 입력한 날짜(YYYYMMDD)의 마지막 날짜를 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-04-23
	 * @수정일 : 2022-05-14
	 * @접근제어 : public 
	 * @파라미터 : String baseDate
	 * @파라미터 : String returnFormat
	 * @return String resultStr
	 * @throws Exception 
	 */
	public String getLastDayOfMonth(String baseDate, String returnFormat) {
		String resultStr = "";

		try {
			Map<String, Integer> convertDivideBaseDate = convertBaseDate(baseDate);

			LocalDate initial = LocalDate.of(convertDivideBaseDate.get("digitYYYY"), convertDivideBaseDate.get("digitMM"), convertDivideBaseDate.get("digitDD"));
			
			// LocalDate start = initial.withDayOfMonth(1); 첫 날짜
			LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(returnFormat);
			String formatedLastDayOfMonth = end.format(formatter);

			resultStr = formatedLastDayOfMonth;
		} catch (StringIndexOutOfBoundsException e) {
			LOG.warning("[getLastDayOfMonth()] Parameter is not match date time.  'baseDate' must be at least 6 characters long.  [ERROR input : String baseDate = " + baseDate + " ] -------- getLastDayOfMonth");
			e.printStackTrace();
		} catch (DateTimeException e) {
			LOG.warning("[getLastDayOfMonth()] Parameter is not match Date time type.  [ERROR input : String baseDate = " + baseDate + " ] -------- getLastDayOfMonth");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			LOG.warning("[getLastDayOfMonth()] Parameter is not match.  [ERROR input : String baseDate = " + returnFormat + " ] -------- getLastDayOfMonth");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			LOG.warning("[IllegalArgumentException] Parameter is not format.  [ERROR input : String returnFormat = " + returnFormat + " ] -------- getLastDayOfMonth");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return resultStr;
	}
	
	/**
	 * @메소드명 : convertBaseDate
	 * @메소드설명 :  입력한 날짜를 (YYYYMMDD)로 변환 후,  나누어 (YY,MM,DD)  반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-05-14
	 * @수정일 : 2022-05-14
	 * @접근제어 : private 
	 * @파라미터 : String date
	 * @return Map<String, Integer> divideDate 
	 * @throws Exception 
	 */
	private Map<String, Integer> convertBaseDate(String date) throws Exception{	
		return divideDate(date.replace(" ", "").replace("-", "").replace(":", ""));
	}
	
	/**
	 * @메소드명 : divideDate
	 * @메소드설명 :  입력한 날짜(YYYYMMDD)를 나누어(YY,MM,DD) 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-05-14
	 * @수정일 : 2022-05-14
	 * @접근제어 : private 
	 * @파라미터 : String convertBaseDate
	 * @return Map<String, Integer> map 
	 * @throws Exception 
	 */
	private Map<String, Integer> divideDate(String convertBaseDate) throws Exception{		
		Map<String, Integer> map = new HashMap<>();

		if (convertBaseDate.length() >= 8) {
			map.put("digitYYYY", Integer.parseInt(convertBaseDate.substring(0, 4)));
			map.put("digitMM", Integer.parseInt(convertBaseDate.substring(4, 6)));
			map.put("digitDD", Integer.parseInt(convertBaseDate.substring(6, 8)));
		} else if (convertBaseDate.length() == 6) {
			map.put("digitYYYY", Integer.parseInt(convertBaseDate.substring(0, 4)));
			map.put("digitMM", Integer.parseInt(convertBaseDate.substring(4, 6)));
			map.put("digitDD", 1);
		}else {
			LOG.warning("[divideDate()] Parameter is not format.  [ERROR input : String convertBaseDate = " + convertBaseDate + " ]");
			throw new Exception();
		}
		
		return map;
	}
}
