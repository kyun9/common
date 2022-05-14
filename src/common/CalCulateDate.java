package common;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import constant.Constant;


public class CalCulateDate {
	private static final Logger LOG = Logger.getGlobal();

	/**
	 * @메소드명 : calCulateDayInFormat
	 * @메소드설명 : calCulateDayInFormat() 입력한 날짜를 포멧형식에 맞추어 일자계산값(문자열)을 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-05-14
	 * @수정일 : 2022-05-14
	 * @접근제어 : public 
	 * @파라미터 : String baseDate (yyyyMM, yyyyMMdd)
	 * @파라미터 : String optType
	 * @파라미터 : String optDateVal
	 * @파라미터 : String returnFormat
	 * @return String resultStr
	 * @throws Exception 
	 */
	public  String calCulateDayInFormat(String baseDate, String optType, String optDateVal, String returnFormat) {
		String resultStr = "";
		
		try {
			LocalDate initial = convertDateFormat(baseDate);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(returnFormat);
			String formatedDate = calCulateDateForEachOper(initial, optType, optDateVal).format(formatter);

			resultStr = formatedDate;
		} catch (StringIndexOutOfBoundsException e) {
			LOG.warning("[ calCulateDayInFormat() ] Parameter is not match date time.  'baseDate' must be at least 6 characters long.  [ERROR input : String baseDate = " + baseDate + " ]");
			e.printStackTrace();
		} catch (DateTimeException e) {
			LOG.warning("[ calCulateDayInFormat() ] Parameter is not match Date time type.  [ERROR input : String baseDate = " + baseDate + " ]");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			LOG.warning("[ calCulateDayInFormat() ] Parameter is not match.  [ERROR input : String baseDate = " + returnFormat + " ]");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			LOG.warning("[ calCulateDayInFormat() ] Parameter is not format.  [ERROR input : String returnFormat = " + returnFormat + " ]");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultStr;
	}

	/**
	 * @메소드명 : getFirstDayOfMonth
	 * @메소드설명 : getFirstDayOfMonth() 입력한 날짜를 포멧형식에 맞추어 첫날짜(문자열)를 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-05-14
	 * @수정일 : 2022-05-14
	 * @접근제어 : public 
	 * @파라미터 : String baseDate (yyyyMM, yyyyMMdd)
	 * @파라미터 : String returnFormat
	 * @return String resultStr
	 * @throws Exception 
	 */
	public String getFirstDayOfMonth(String baseDate, String returnFormat) {
		String resultStr = "";

		try {
			LocalDate initial = convertDateFormat(baseDate);
			
			LocalDate start = initial.withDayOfMonth(1); //첫 날짜

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(returnFormat);
			String formatedFirstDayOfMonth = start.format(formatter);

			resultStr = formatedFirstDayOfMonth;
		} catch (StringIndexOutOfBoundsException e) {
			LOG.warning("[ getFirstDayOfMonth() ] Parameter is not match date time.  'baseDate' must be at least 6 characters long.  [ERROR input : String baseDate = " + baseDate + " ]");
			e.printStackTrace();
		} catch (DateTimeException e) {
			LOG.warning("[ getFirstDayOfMonth() ] Parameter is not match Date time type.  [ERROR input : String baseDate = " + baseDate + " ]");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			LOG.warning("[ getFirstDayOfMonth() ] Parameter is not match.  [ERROR input : String baseDate = " + returnFormat + " ]");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			LOG.warning("[ getFirstDayOfMonth() ] Parameter is not format.  [ERROR input : String returnFormat = " + returnFormat + " ]");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return resultStr;
	}
	
	/**
	 * @메소드명 : getLastDayOfMonth
	 * @메소드설명 : getLastDayOfMonth() 입력한 날짜를 포멧형식에 맞추어 마지막 날짜(문자열)를 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-04-23
	 * @수정일 : 2022-05-14
	 * @접근제어 : public 
	 * @파라미터 : String baseDate (yyyyMM, yyyyMMdd)
	 * @파라미터 : String returnFormat
	 * @return String resultStr
	 * @throws Exception 
	 */
	public String getLastDayOfMonth(String baseDate, String returnFormat) {
		String resultStr = "";

		try {
			LocalDate initial = convertDateFormat(baseDate);
			
			LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth()); //마지막 날짜

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(returnFormat);
			String formatedLastDayOfMonth = end.format(formatter);

			resultStr = formatedLastDayOfMonth;
		} catch (StringIndexOutOfBoundsException e) {
			LOG.warning("[ getLastDayOfMonth() ] Parameter is not match date time.  'baseDate' must be at least 6 characters long.  [ERROR input : String baseDate = " + baseDate + " ]");
			e.printStackTrace();
		} catch (DateTimeException e) {
			LOG.warning("[ getLastDayOfMonth() ] Parameter is not match Date time type.  [ERROR input : String baseDate = " + baseDate + " ]");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			LOG.warning("[ getLastDayOfMonth() ] Parameter is not match.  [ERROR input : String baseDate = " + returnFormat + " ]");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			LOG.warning("[ getLastDayOfMonth() ] Parameter is not format.  [ERROR input : String returnFormat = " + returnFormat + " ]");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return resultStr;
	}
	
	/**
	 * @메소드명 : calCulateDateForEachOper
	 * @메소드설명 :  일자를 연산자마다 다르게 계산한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-05-14
	 * @수정일 : 2022-05-14
	 * @접근제어 : private 
	 * @파라미터 : LocalDate baseDate
	 * @파라미터 : String optType
	 * @파라미터 : String optDateVal
	 * @return LocalDate
	 * @throws Exception 
	 */
	private LocalDate calCulateDateForEachOper(LocalDate baseDate, String optType, String optDateVal) throws Exception{	
		LocalDate resultDate = null;
		
		switch(optType) {
			case "+" :  resultDate = baseDate.plusDays(Long.parseLong(optDateVal));
				break;
			case "-" : resultDate = baseDate.minusDays(Long.parseLong(optDateVal));
				break;
			default :break;
		}
		
		if(resultDate == null) {
			LOG.warning("[calCulateDateForEachOper()] Parameter is not format.  [ERROR input : String optType = " + optType + " ]. Only '+' and '-' are allowed.");
			throw new NullPointerException();
		}
		
		return resultDate;
	}
	
	/**
	 * @메소드명 : convertDateFormat
	 * @메소드설명 :  String타입 날짜를 LocalDate 객체로 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-05-14
	 * @수정일 : 2022-05-14
	 * @접근제어 : private 
	 * @파라미터 : String date
	 * @return LocalDate
	 * @throws Exception 
	 */
	private LocalDate convertDateFormat(String baseDate) throws Exception{	
		if(baseDate == null || "".equals(baseDate)) {
			LOG.warning("[convertDateFormat()] Parameter is not format.  [ERROR input : baseDate is either Null or \"\" ]");
			throw new Exception();
		}
		Map<String, Integer> convertDivideBaseDate = convertBaseDate(baseDate);
		return  LocalDate.of(convertDivideBaseDate.get(Constant.DIGIT_YYYY), convertDivideBaseDate.get(Constant.DIGIT_MM), convertDivideBaseDate.get(Constant.DIGIT_DD));
	}
	
	/**
	 * @메소드명 : convertBaseDate
	 * @메소드설명 :  입력한 날짜를 공백 및 특수문자 제거한 후, Map객체로 반환한다.
	 * @작성자 : 경현
	 * @작성자github : https://github.com/kyun9
	 * @작성일 : 2022-05-14
	 * @수정일 : 2022-05-14
	 * @접근제어 : private 
	 * @파라미터 : String date
	 * @return Map<String, Integer> divideDate 
	 * @throws Exception 
	 */
	private Map<String, Integer> convertBaseDate(String baseDate) throws Exception{	
		return divideDate(baseDate.replace(" ", "").replace("-", "").replace(":", ""));
	}
	
	/**
	 * @메소드명 : divideDate
	 * @메소드설명 :  년월일 각각나누어 Map 객체로 반환한다.
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

		if (convertBaseDate.length() >= Constant.DIVIDEDATE_LAST_INDEX) {
			map.put(Constant.DIGIT_YYYY, Integer.parseInt(convertBaseDate.substring(Constant.DIVIDEDATE_FIRST_INDEX, Constant.DIVIDEDATE_SECONDE_INDEX)));
			map.put(Constant.DIGIT_MM, Integer.parseInt(convertBaseDate.substring(Constant.DIVIDEDATE_SECONDE_INDEX, Constant.DIVIDEDATE_THIRD_INDEX)));
			map.put(Constant.DIGIT_DD, Integer.parseInt(convertBaseDate.substring(Constant.DIVIDEDATE_THIRD_INDEX, Constant.DIVIDEDATE_LAST_INDEX)));
		} else if (convertBaseDate.length() == Constant.DIVIDEDATE_THIRD_INDEX) {
			map.put(Constant.DIGIT_YYYY, Integer.parseInt(convertBaseDate.substring(Constant.DIVIDEDATE_FIRST_INDEX, Constant.DIVIDEDATE_SECONDE_INDEX)));
			map.put(Constant.DIGIT_MM, Integer.parseInt(convertBaseDate.substring(Constant.DIVIDEDATE_SECONDE_INDEX, Constant.DIVIDEDATE_THIRD_INDEX)));
			map.put(Constant.DIGIT_DD, 1);
		}else {
			LOG.warning("[divideDate()] Parameter is not format.  [ERROR input : String convertBaseDate = " + convertBaseDate + " ]");
			throw new Exception();
		}
		
		return map;
	}
}
