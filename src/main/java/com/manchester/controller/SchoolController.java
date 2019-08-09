package com.manchester.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manchester.entities.School;
import com.manchester.repository.SchoolRepo;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolRepo Srepo;

	@GetMapping("/show/{traineeId}")
	public String showRecord(@PathVariable("traineeId") int traineeId) {
		Optional<School> t = Srepo.findById(traineeId);
		if (t.isPresent()) {
			School S = t.get();
			return S.getName();
		}
		return "Id doesn't exist";
	}

	@GetMapping("/showall")
	public List<School> showRecord() {
		List<School> t = Srepo.findAll();
		return t;
	}

}
