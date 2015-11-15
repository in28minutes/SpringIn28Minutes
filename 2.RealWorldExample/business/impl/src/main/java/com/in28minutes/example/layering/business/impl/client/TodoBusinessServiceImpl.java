package com.in28minutes.example.layering.business.impl.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.example.layering.business.api.client.TodoBusinessService;
import com.in28minutes.example.layering.data.api.client.TodoDataService;
import com.in28minutes.example.layering.model.api.client.Todo;

@Component
public class TodoBusinessServiceImpl implements TodoBusinessService {

	private static final int ONE_DAY_IN_MILLISECONDS = 24 * 60 * 1000;

	@Autowired
	TodoDataService todoDs;

	@Override
	public List<Todo> retrieveTodosForNextWeek(String user) {
		List<Todo> todos = todoDs.retrieveTodos(user);
		return filterTodosInNextWeek(todos);
	}

	// NOTE : We get everything from database and filter
	// instead of filtering in the database. Not the most efficient
	// implementation.
	private List<Todo> filterTodosInNextWeek(List<Todo> todos) {
		Date today = new Date();
		long todayMs = today.getTime();

		// Todo : This goes by time and not by date

		Date oneWeekLater = new Date(todayMs + 7 * ONE_DAY_IN_MILLISECONDS);

		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getDate().before(oneWeekLater)) {
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;
	}

}
