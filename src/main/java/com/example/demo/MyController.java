package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
		@Autowired
		MyRepos repo;
		@PostMapping("/employees")
		public ResponseEntity<Employee> show(@RequestBody Employee e)
		{
			Employee er=repo.save(e);
			if(er==null)
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			else
			{
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
		}
		@GetMapping("/employees")
		public ResponseEntity<Iterable<Employee>> show()
		{
			return ResponseEntity.ok(repo.findAll());
		}
		@GetMapping("/employees/{id}")
		public ResponseEntity<Optional<Employee>> showById(@PathVariable int id)
		{
			Optional<Employee> o=repo.findById(id);
			if(o.isPresent())
			{
				return ResponseEntity.ok(o);
			}
			else
			{
				return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
			}
		}
		@PutMapping("/employees/{id}/")
		public ResponseEntity<Employee> update(@RequestBody Employee e,@PathVariable int id)
		{
			Optional<Employee> o=repo.findById(id);
			if(o.isPresent())
			{
				e.setId(id);
				Employee er=repo.save(e);
				return ResponseEntity.ok(er);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<String> deleteById(@PathVariable int id)
		{
			Optional<Employee> e=repo.findById(id);
			if(e.isPresent())
			{
				repo.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Content");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
}
