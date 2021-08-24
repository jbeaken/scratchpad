package org.mzuri.scratchpad;

import java.io.IOException;

import org.mzuri.scratchpad.domain.Book;
import org.mzuri.scratchpad.domain.Category;
import org.mzuri.scratchpad.domain.Views;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	Logger logger = LoggerFactory.getLogger("JacksonTest");
	
	@Test
	public void getData() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		
		Book book = new Book(45L, "War & Peace", "978567463573", new Category("Russia"));
		
		String json = mapper.writeValueAsString(book);
		
		logger.info("json default : {}", json);
		
		json = mapper.writerWithView(Views.Summary.class).writeValueAsString(book);
		
		logger.info("json with summary view : {}", json);
		
		Book newBook = mapper.readValue(json, Book.class);
		
		JsonNode node = mapper.readTree(json);
		
		logger.info("json : {}", json);
		
		logger.info("Node : {}", node);
		
		logger.info("newBook : {}", newBook);

	}


}