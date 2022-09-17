package com.example.Credochain_Assingment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Credochain_Assingment.Modules.History;
import com.example.Credochain_Assingment.Modules.Tasks;
import com.example.Credochain_Assingment.Services.HistoryService;
import com.example.Credochain_Assingment.Services.TaskServices;

@RestController
public class TaskControl {

	@Autowired
	private TaskServices ts;
	@Autowired
	private HistoryService hs;
	
	@PostMapping("/tasks/create")
	public Tasks addTask(@RequestBody Tasks task) {
		return ts.addTasks(task);
	}
	@PutMapping("/tasks/assign")
	public Tasks assignTask(@RequestBody Tasks task) {
		return ts.assignTask(task);
	}
	@GetMapping("/tasks/search/{id}")
		public Tasks searchTaskId(@PathVariable int id) {
			return ts.searchById(id);
		}
		
	@GetMapping("/tasks/search")
	public Tasks searchTaskId(@RequestParam String title) {
		return ts.searchByTitle(title);
	}
	@PutMapping("/tasks/update")
	public Tasks Update(@RequestBody Tasks task) {
		return ts.update(task);
	}
	@GetMapping("/tasks/history/{tid}")
	public List<History> getUpdates(@PathVariable int tid){
		return hs.getByTid(tid);
	}
}
