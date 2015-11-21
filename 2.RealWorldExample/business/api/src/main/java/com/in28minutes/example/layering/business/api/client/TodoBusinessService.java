package com.in28minutes.example.layering.business.api.client;

import java.util.List;

import com.in28minutes.example.layering.model.api.client.Todo;

public interface TodoBusinessService {
	List<Todo> retrieveTodosRelatedToSpring(String user);
}
