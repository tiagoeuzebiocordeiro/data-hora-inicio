package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Program {

	public static void main(String[] args) {
		
		
		/*
		 * Data-hora Java OOP UDEMY Aula 111
		 * */
		
		LocalDate d01 = LocalDate.now(); // data local
		LocalDateTime d02 = LocalDateTime.now(); // Data-hora local
		Instant d03 = Instant.now(); // Data-hora com fuso horario GMT(Londres)
		
		System.out.println("d01 = " + d01);
		System.out.println("d02 = " + d02);
		System.out.println("d03 = " + d03);
		
		// Texto ISO 8601 
		LocalDate d04 = LocalDate.parse("2022-07-20");
		System.out.println("d04 = " + d04);
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		System.out.println("d05 = " + d05);
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
		System.out.println("d06 Londres = " + d06);
		Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");
		System.out.println("d07 gmt-3 = " + d07); // d06 - BR, d07 - gmt
		
		
		// Ref: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
		LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
		System.out.println("FMT1 d08 = " + d08);
		
		// Creating fmt2 with hours and min
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		System.out.println("D09=" + d09);
		
		LocalDate d10 = LocalDate.of(2022, 7, 20);
		System.out.println("D10 local date of = "+d10);
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);
		System.out.println("d11 (d10 v2 with hour and min): " + d11);
		
		/*--------------------------------------------*/
		
		
		System.out.println("d04 = " + d04.format(fmt1));
		System.out.println("2nd method: " + fmt1.format(d04));
		System.out.println("3th method (d05)[with hours and min info]: " + d05.format(fmt2));
		
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		System.out.println("d06 with formatter BR-zoneId: " + fmt3.format(d06));
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
		System.out.println("d06 with Iso formatter : " + fmt4.format(d06));
		
		
	}

}
