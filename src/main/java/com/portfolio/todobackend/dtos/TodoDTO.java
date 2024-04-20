package com.portfolio.todobackend.dtos;

import lombok.Data;

@Data
public class TodoDTO {
	private Long id;
	private String title;
	private Boolean completed;

}
