package com.in28minutes.spring.example1;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Configuration
@ComponentScan(basePackages = { "com.in28minutes" })
class SpringContext {
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContext.class)
public class TodoBusinessTestFinal {
	
	@Autowired
	TodoBusinessServiceImpl todoBusinessServiceImpl;
	
	@Test
	public void testGetTodosAboutSpring(){
		
		List<String> todosAboutSpring = todoBusinessServiceImpl.getTodosAboutSpring();
		assertEquals(1,todosAboutSpring.size());
	}
}

@Component
class TodoBusinessServiceImpl {
	
	@Autowired
	TodoDataService todoDataServiceImpl;
	
	List<String> getTodosAboutSpring(){
		List<String> todos = todoDataServiceImpl.getTodos();
		List<String> todosAboutSpring = new ArrayList<String>();
		for(String todo:todos){
			if(todo.contains("Spring"))
				todosAboutSpring.add(todo);
		}
		return todosAboutSpring;
	}
}

interface TodoDataService {
	List<String> getTodos();
}

@Component
class TodoDataServiceStubImpl  implements TodoDataService{
	Connection jdbcConnection;
	public List<String> getTodos() {
		//make a call;
		return new ArrayList<String>();
	}
}

@Component
class TodoDataServiceRealImpl implements TodoDataService {
	Connection jdbcConnection;
	public List<String> getTodos() {
		return Arrays.asList("Learn Spring","Learn Struts");
	}
}

