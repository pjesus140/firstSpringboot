package com.manchester.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manchester.entities.School;
import com.manchester.entities.Trainee;
import com.manchester.repository.SchoolRepo;
import com.manchester.repository.TraineeRepository;

@RestController
@RequestMapping("/trainee")
@CrossOrigin(origins ="http://localhost:3000")
public class TraineeController {

	@Autowired
	private TraineeRepository TRepo;
	
	@GetMapping(value ="/show/{traineeid}")
	public String showRecord(@PathVariable("traineeid") int traineeid) {
		Optional<Trainee> t = TRepo.findById(traineeid);
		if(t.isPresent()) {
			Trainee  S = t.get();
			return S.getTraineename();
		}
		return "Id doesn't exist";
	}
	@DeleteMapping(value ="/delete/{id}")
	public String DeleteRecord(@PathVariable("id") int id) {
		Optional<Trainee> t = TRepo.findById(id);
		if(t.isPresent()) {
			Trainee  S = t.get();
			TRepo.delete(S);
			return "gone";
		}else return "not gone";
		
	}
	
	@PostMapping(value ="/create1/{name}/{city}")
	public String AddRecord1(@PathVariable("name") String name,@PathVariable("city")String city) {
		Trainee tr = new Trainee();
		
		
		tr.setTraineename(name);
		tr.setTraineecity(city);
		TRepo.save(tr);
		return "yes";
		
	}
	
	@PostMapping(value ="/create2")
	public String AddRecord2(@RequestBody Trainee tr) {
		
		TRepo.save(tr);
		return  "added "+tr.getTraineename()+" who lives in "+tr.getTraineecity();
		
	}
	@PostMapping(value ="/update/{traineeid}")
	public String updateRecord(@RequestBody Trainee tr,@PathVariable("traineeid") int traineeid) {
		Optional<Trainee> t = TRepo.findById(traineeid);
		if(t.isPresent()) {
			t.get().setTraineename(tr.getTraineename());
			t.get().setTraineecity(tr.getTraineecity());
			TRepo.save(t.get());
			return "changed";
		}
		return "Id doesn't exist";
	}
	
	
	@GetMapping(value ="/showall")
	public List<Trainee> showRecord() {
		List<Trainee> t = TRepo.findAll();
			return t;
	}
	
	

	
}
