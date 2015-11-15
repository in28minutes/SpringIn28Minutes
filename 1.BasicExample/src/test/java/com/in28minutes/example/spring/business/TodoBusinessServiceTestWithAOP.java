package com.in28minutes.example.spring.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.example.spring.model.Todo;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.in28minutes.example" })
class SpringContextAOP {
}

@Aspect
@Component
class MyAspect {

	final static Logger logger = Logger.getLogger(MyAspect.class);

	@Before("execution(* com.in28minutes.example.spring.business.TodoBusinessServiceImpl.*(..))")
	public void doLog() {
		logger.info("method is gettting executed");
	}

}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextAOP.class)
public class TodoBusinessServiceTestWithAOP {

	@Autowired
	private TodoBusinessService todoBusinessService;

	@Test
	public void testClientProductSum() {
		List<Todo> todos = todoBusinessService
				.retrieveTodosForNextWeek("dummyUser");
		assertEquals(2, todos.size());
	}

}
