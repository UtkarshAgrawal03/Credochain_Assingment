package com.example.Credochain_Assingment.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Credochain_Assingment.Modules.Tasks;
import com.example.Credochain_Assingment.Repo.TaskRepo;

@Service
public class TaskServices {

	@Autowired
	private TaskRepo tr;
	@Autowired
	private HistoryService hs;
	
	public Tasks addTasks(Tasks task) {
		return tr.save(task);
	}
	public Tasks assignTask(Tasks task) {
		
		Tasks toTask=tr.findByTaskId(task.getTaskId());
		String s="Owner Changed from "+toTask.getAssignedTo()+" to "+task.getAssignedTo();
		hs.addLogs(task.getTaskId(), s);
		toTask.setAssignedTo(task.getAssignedTo());
		return tr.save(toTask);
		
	}
	public Tasks searchById(int id) {
		return tr.findByTaskId(id);
	}
	public Tasks searchByTitle(String title) {
		return tr.findByTitle(title);
	}
	public Tasks update(Tasks task) {
		Tasks toTask=tr.findByTaskId(task.getTaskId());
		if(task.getTitle()!=null) {
			String s="Title Changed from "+toTask.getTitle()+" to "+task.getTitle();
			hs.addLogs(task.getTaskId(), s);
			toTask.setTitle(task.getTitle());}
	    if(task.getDescription()!=null) {
	    	String s="Description Changed from "+toTask.getDescription()+" to "+task.getDescription();
			hs.addLogs(task.getTaskId(), s);
			toTask.setDescription(task.getDescription());}
		if(task.getStatus()!=null) {
			String s="Status Changed from "+toTask.getStatus()+" to "+task.getStatus();
			hs.addLogs(task.getTaskId(), s);
			toTask.setStatus(task.getStatus());}
		return tr.save(toTask);
	}
}
