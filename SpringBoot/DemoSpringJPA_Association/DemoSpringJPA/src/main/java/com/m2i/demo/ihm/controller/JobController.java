package com.m2i.demo.ihm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.m2i.demo.bo.Job;
import com.m2i.demo.dao.repository.JobRepository;
import com.m2i.demo.dao.repository.PersonRepository;

@Controller
public class JobController {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@GetMapping(value= {"/show-job", "/show-job/{id}"})
	public String displayJob(Model model, @PathVariable("id") Optional<Integer> id) {
		// Il n'ya pas de id
		// -- Le job vide
		Job job = new Job();
				
		// Quand il y'a un id
		if (id.isPresent()) {
			job = jobRepository.findById(id.orElse(0)).orElseGet(null);
		}

		// Envoyée dans le formulaire 
		model.addAttribute("job", job);
		model.addAttribute("personList", personRepository.findAll());
		
		return "show_job";
	}
	
	@PostMapping("/show-job-post")
	public String showJobPost(Model model, @ModelAttribute("job") Job job) {
		// Save
		Job jobEdited = jobRepository.save(job);
		
		// Redirect
		return String.format("redirect:/show-job/%d", jobEdited.getId());
	}
}
