package com.in28minutes.example.spring.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.example.spring.model.Todo;

@Configuration
@ComponentScan(basePackages = { "com.in28minutes.example"})
class SpringContext {
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContext.class)
public class TodoBusinessServiceTest {

	@Autowired
	private TodoBusinessService todoBusinessService;

	@Test
	public void testClientProductSum() {
		List<Todo> todos = todoBusinessService
				.retrieveTodosForNextWeek("dummyUser");
		assertEquals(2, todos.size());
	}

}
