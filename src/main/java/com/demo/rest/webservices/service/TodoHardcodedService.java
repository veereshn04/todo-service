package com.demo.rest.webservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.rest.webservices.model.Todo;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<>();

	private static int idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "JavaHangout", "Learn to Dance2", new Date(), true));
		todos.add(new Todo(++idCounter, "JavaHangout", "Learn about Angular2", new Date(), true));
		todos.add(new Todo(++idCounter, "JavaHangout", "Learn about SpringBoot", new Date(), true));
		todos.add(new Todo(++idCounter, "JavaHangout", "Learn about Microservice", new Date(), true));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo save(Todo todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);

		} else {
			deleteById(todo.getId());
			todos.add(todo);

		}
		return todo;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;
		todos.remove(todo);
		return todo;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

}
