package chapter3.oop.test;

import chapter3.oop.MyDate;

public class TestMyDate {
	private int year;
	private int month;
	private int day;
	
	public TestMyDate(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
//	public void getYear(int year) {
//		return year;
//	}
//	public void getMonth(int month) {
//		return month;
//	}
//	public void getDay(int day) {
//		return day;
//	}
	

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		}
		else {
			System.out.println("Month는 1~12 사이의 값만 가능합니다.");
		}
	}
	public void setDay(int day) {
		if (day >= 1 && day <= 31) {
			this.day = day;
		}
		else {
			System.out.println("Day는 1~31 사이의 값만 가능합니다.");
		}
	}
//	public static void main(String[] args) {
//		MyDate date3 = new MyDate(2013, 7, 24);
//		System.out.println(date3);
//		
//		MyDate date = new MyDate();
//		System.out.println(date.toString());
//		
////		date.year = 2013;
////		date.month = 13;
////		date.day = 31;
////		System.out.println(date.year+"-"+date.month + "-"+date.day);
//		//setter method 호출
//		date.setYear(2013);
//		date.setMonth(13);
//		date.setDay(31);
//		System.out.println(date.getYear()+"-"+date.getMonth()+"-"+date.getDay());
//		
//		MyDate date2 = new MyDate(2013,14,17);
//		System.out.println(date2.getYear()+"-"+date2.getMonth()+"-"+date2.getDay());
//		
//	}

}
