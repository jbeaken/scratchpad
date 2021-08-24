package org.mzuri.scratchpad;

import java.io.IOException;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericTest {

	Logger logger = LoggerFactory.getLogger("GenericTest");
	
	@Test
	public void test() throws IOException {
		
		int sum = IntStream.of(1, 2, 3).sum();

//		assertThat(sum)
		
	}


}