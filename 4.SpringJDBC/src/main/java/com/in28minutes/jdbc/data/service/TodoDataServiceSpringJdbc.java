package com.in28minutes.jdbc.data.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.in28minutes.jdbc.hsql.HsqlDatabase;
import com.in28minutes.jdbc.model.Todo;

public class TodoDataServiceSpringJdbc {

	private static final String SELECT_ALL_TODOS = "SELECT * FROM TODO";

	private static final String INSERT_TODO_QUERY = "INSERT INTO TODO(DESCRIPTION,IS_DONE) VALUES(?, ?)";

	private static final String DELETE_TODO_QUERY = "DELETE FROM TODO WHERE ID=?";

	HsqlDatabase db = new HsqlDatabase();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(
			new SingleConnectionDataSource(db.conn, false));

	public static Logger logger = LogManager
			.getLogger(TodoDataServiceSpringJdbc.class);

	public void insertTodos(List<Todo> todos) {
		for (Todo todo : todos) {
			insertTodo(todo);
		}
	}

	private void insertTodo(Todo todo) {
		jdbcTemplate.update(INSERT_TODO_QUERY, todo.getDescription(),
				todo.isDone());
	}

	public void deleteTodo(int id) {
		jdbcTemplate.update(DELETE_TODO_QUERY, id);
	}

	public List<Todo> retrieveAllTodos() throws SQLException {
		return jdbcTemplate.query(SELECT_ALL_TODOS,
				new BeanPropertyRowMapper<Todo>(Todo.class));
	}

	/*
	 * class TodoMapper implements RowMapper<Todo> { public Todo
	 * mapRow(ResultSet rs, int rowNum) { Todo todo = new Todo(); return todo; }
	 * }
	 */

	public static void main(String[] args) throws SQLException {

		TodoDataServiceSpringJdbc dataservice = new TodoDataServiceSpringJdbc();

		dataservice.insertTodos(Arrays.asList(new Todo(0,
				"New Todo Spring JDBC", false)));

		dataservice.deleteTodo(1);

		List<Todo> todos = dataservice.retrieveAllTodos();
		logger.info(todos);

		dataservice.db.closeConnection();
	}
}