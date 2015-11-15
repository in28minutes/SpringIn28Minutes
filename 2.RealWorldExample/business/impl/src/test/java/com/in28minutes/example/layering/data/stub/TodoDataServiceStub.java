package com.in28minutes.example.layering.data.stub;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.example.layering.data.api.client.TodoDataService;
import com.in28minutes.example.layering.model.api.client.Todo;

@Component
public class TodoDataServiceStub implements TodoDataService {
	private static final int ONE_DAY_IN_MILLISECONDS = 24 * 60 * 1000;

	@Override
	public List<Todo> retrieveTodos(String userName) {

		Date today = new Date();
		long todayMs = today.getTime();

		Date tomorrow = new Date(todayMs + ONE_DAY_IN_MILLISECONDS);
		Date tenDaysAfter = new Date(todayMs + 10 * ONE_DAY_IN_MILLISECONDS);

		List<Todo> todos = Arrays.asList(new Todo("Complete Spring Tutorial",
				today, false), new Todo("Complete Spring MVC Tutorial",
				tomorrow, false), new Todo("Complete All Tutorials",
				tenDaysAfter, false));

		return todos;
	}
}
