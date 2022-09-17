package com.example.Credochain_Assingment.Modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Update-Logs")
public class History {

	@Id
	private int id;
	private int task;
	private String log;
	
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	public History(int id, int tId, String log) {
		super();
		this.id = id;
		this.task = tId;
		this.log = log;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getTask() {
		return task;
	}

	public void setTask(int task) {
		this.task = task;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
}
