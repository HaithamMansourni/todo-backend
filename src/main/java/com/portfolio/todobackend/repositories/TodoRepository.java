package com.portfolio.todobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.todobackend.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
