package com.portfolio.todobackend.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.todobackend.dtos.TodoDTO;
import com.portfolio.todobackend.services.TodoService;



@RestController
@CrossOrigin("*")
@RequestMapping("/todos")
public class TodoController {
	private Logger logger =  LoggerFactory.getLogger(TodoService.class);
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public List<TodoDTO> getTodos() {
		logger.info("reception d'une requete pour recuperer une liste de toutes les todos");
		return todoService.findAllTodos();
	}

	@GetMapping("/{todoId}")
	public Optional<TodoDTO> getTodo(@PathVariable("todoId") Long todoId) {
		logger.info("reception d'une requete pour recuperer une todo par ID {}",todoId);
		return todoService.findTodoById(todoId);
	}

	@PostMapping
	public TodoDTO newTodo(@RequestBody TodoDTO todoDTO) {
		logger.info("reception d'une requete pour creer une nouvelle todo");
		return todoService.saveTodo(todoDTO);
	}

	@PutMapping
	public TodoDTO updateTodo(@RequestBody TodoDTO updateTodoDTO) {
		logger.info("reception d'une requete pour mettre Ã  jour une todo {}",updateTodoDTO.getTitle());
		return todoService.saveTodo(updateTodoDTO);
	}

	@DeleteMapping("/{todoId}")
	public void deleteTodo(@PathVariable("todoId") Long todoId) {
		logger.info("reception d'une requete pour supprimer une todo par ID");
		todoService.deleteTodoById(todoId);
	}


}
