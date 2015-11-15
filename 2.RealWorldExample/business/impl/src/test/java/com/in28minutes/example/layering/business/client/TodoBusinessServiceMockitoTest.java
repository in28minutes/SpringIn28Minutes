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

	private static final int ONE_DAY_IN_MILLISECONDS = 24 * 60 * 1000;

	@Mock
	private TodoDataService todoDs;

	@InjectMocks
	private TodoBusinessServiceImpl todoBs;

	@Before
	public void initializeMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveTodosForNextWeek() {
		Date today = new Date();
		long todayMs = today.getTime();

		Date tomorrow = new Date(todayMs + ONE_DAY_IN_MILLISECONDS);
		Date tenDaysAfter = new Date(todayMs + 10 * ONE_DAY_IN_MILLISECONDS);

		List<Todo> todos = Arrays.asList(new Todo("Complete Spring Tutorial",
				today, false), new Todo("Complete Spring MVC Tutorial",
				tomorrow, false), new Todo("Complete All Tutorials",
				tenDaysAfter, false));

		stub(todoDs.retrieveTodos(anyString())).toReturn(todos);

		List<Todo> filteredTodos = todoBs.retrieveTodosForNextWeek("dummyUser");
		assertEquals(2, filteredTodos.size());
	}
}