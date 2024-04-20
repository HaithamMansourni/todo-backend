package com.portfolio.todobackend.mappers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.portfolio.todobackend.dtos.TodoDTO;
import com.portfolio.todobackend.entities.Todo;
import com.portfolio.todobackend.exceptions.TodoDTONotFoundException;
import com.portfolio.todobackend.services.TodoService;



public class TodoMapper {
	private static Logger logger =  LoggerFactory.getLogger(TodoService.class);
	public static TodoDTO toDto(Todo todo) {
		try {
    		if (todo == null) throw new TodoDTONotFoundException("Todo not found.");
    	} catch (Exception e) {
			logger.error(e.getMessage());
		}
        TodoDTO todoDTO = new TodoDTO();
        BeanUtils.copyProperties(todo, todoDTO);
        logger.debug("mapper une todo entity avec todoDTO : {}",todoDTO);
        return todoDTO;
    }

    public static Todo toEntity(TodoDTO todoDTO) {
    	try {
    		if (todoDTO == null) throw new TodoDTONotFoundException("Todo DTO not found.");
    	} catch (Exception e) {
			logger.error(e.getMessage());
		}
        
            
        
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDTO, todo);
        logger.debug("mapper todoDTO  avec  une todo entity: {}",todo);
        return todo;
    }


}
