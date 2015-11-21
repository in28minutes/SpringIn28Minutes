package com.in28minutes.example.layering.business.client;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.stub;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.example.layering.business.impl.client.TodoBusinessServiceImpl;
import com.in28minutes.example.layering.data.api.client.TodoDataService;
import com.in28minutes.example.layering.model.api.client.Todo;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessServiceMockitoTest {

	@Mock
	private TodoDataService todoDs;

	@InjectMocks
	private TodoBusinessServiceImpl todoBs;

	@Before
	public void initializeMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveTodosRelatedToSpring() {

		List<Todo> todos = Arrays.asList(new Todo("Complete Spring Tutorial",
				new Date(), false), new Todo("Complete Spring MVC Tutorial",
				new Date(), false), new Todo("Complete All Tutorials",
				new Date(), false));

		stub(todoDs.retrieveTodos(anyString())).toReturn(todos);

		List<Todo> filteredTodos = todoBs
				.retrieveTodosRelatedToSpring("dummyUser");

		assertEquals(2, filteredTodos.size());
	}
}