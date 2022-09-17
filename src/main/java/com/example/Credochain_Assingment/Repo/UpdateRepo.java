package com.example.Credochain_Assingment.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Credochain_Assingment.Modules.History;
@Repository
public interface UpdateRepo extends MongoRepository<History, Integer> {
	public List<History> findByTask(int task);

}
