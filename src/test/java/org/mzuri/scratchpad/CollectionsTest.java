package org.mzuri.scratchpad;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
public class CollectionsTest {
	
	int counter = 0;

	
	@Test
	//WHAT?? why two 0
	public void testPutCounter() {
		
			
			Map map = new HashMap();
			
			for(int i = 0; i < 10; i++) {
				map.compute("counter", (k, v) -> v == null ? counter : counter++);
				System.out.println( map.get("counter") );
			}
	}
}
