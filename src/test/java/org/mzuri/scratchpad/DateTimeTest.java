package org.mzuri.scratchpad;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DateTimeTest {

	Logger logger = LoggerFactory.getLogger("JacksonTest");
	
	@Test
	void test() throws IOException {
		
		//Create
		Date date = new Date();
		
		LocalDate localDate = LocalDate.now();
		
		
		//Convert
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		
		Date localDateTimeBack = Date.from( localDateTime.atZone(ZoneId.systemDefault()).toInstant() );
		
		Date localDateBack = Date.from( localDate.atStartOfDay(ZoneId.systemDefault()).toInstant() );
		
		//Format
				
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		logger.info("localDateTime ISO_OFFSET_DATE_TIME is {}", localDateTime.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME ));
		logger.info("localDateTime ISO_DATE_TIME is {}", localDateTime.format(DateTimeFormatter.ISO_DATE_TIME ));
		logger.info("localDate is {}", localDate.format( DateTimeFormatter.ISO_DATE ));
		
		logger.info("dateBack is {}", localDateTimeBack);
		
	}
	
	@Test
	void formatDate() {
		
		LocalDate localDate = LocalDate.of(2019, 3, 16);
		
		//Code
		String formatted =  null;
		
		//Verify
		assertThat( formatted.equals("3/16/2019") );
	}
	
	@Test
	void createDateTimeFromUtilDateAndBackAgain() {
		//Create
		Date date = new Date();
		
		//Code
		LocalDateTime ldt = null; //create from date
		
		
		assertThat(date.getHours() == ldt.getHour());
		assertThat(date.getMinutes() == ldt.getMinute());
		assertThat(date.getSeconds() == ldt.getSecond());
	}
}