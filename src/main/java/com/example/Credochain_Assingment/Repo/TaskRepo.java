package com.example.Credochain_Assingment.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Credochain_Assingment.Modules.Tasks;
@Repository
public interface TaskRepo extends MongoRepository<Tasks, Integer> {

	public Tasks findByTaskId(int id);
	public Tasks findByTitle(String title);
}
