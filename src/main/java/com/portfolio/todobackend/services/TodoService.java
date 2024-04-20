package com.portfolio.todobackend.services;

import org.springframework.stereotype.Service;

import com.portfolio.todobackend.dtos.TodoDTO;
import com.portfolio.todobackend.entities.Todo;
import com.portfolio.todobackend.mappers.TodoMapper;
import com.portfolio.todobackend.repositories.TodoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class TodoService {

	private Logger logger =  LoggerFactory.getLogger(TodoService.class);
	private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> findAllTodos() {
    	logger.info("rÃ©cupÃ©ration de toutes les todos");
        return todoRepository.findAll().stream().map(TodoMapper::toDto).collect(Collectors.toList());
    }

    public Optional<TodoDTO> findTodoById(Long id) {
    	logger.info("chercher un todo par ID {}",id);
        return todoRepository.findById(id).map(TodoMapper::toDto);
    }

    public TodoDTO saveTodo(TodoDTO todoDTO) {
    	logger.info("sauvegarder une nouvelle todo {}",todoDTO.getTitle());
        Todo todo = TodoMapper.toEntity(todoDTO);
        return TodoMapper.toDto(todoRepository.save(todo));
    }

    public void deleteTodoById(Long id) {
    	logger.info("supprimer une todo par ID {}",id);
        todoRepository.deleteById(id);
    }

}

