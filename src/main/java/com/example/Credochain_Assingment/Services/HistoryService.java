package com.example.Credochain_Assingment.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Credochain_Assingment.Modules.History;
import com.example.Credochain_Assingment.Repo.UpdateRepo;
@Service
public class HistoryService {
	@Autowired
	private UpdateRepo ur;
	public List<History> getByTid(int tid){
		return ur.findByTask(tid);
	}
	public void addLogs(int tid,String s) {
		History h=new History();
		h.setId((int)ur.count()+1);
		h.setTask(tid);
		h.setLog(s);
		ur.save(h);
	}

}
