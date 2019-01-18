package qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.exception.ResourceNotFoundException;
import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.model.sakilaDatabaseModel;
import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.repository.*;


@RestController
@RequestMapping("/api")
public class SpringBootSakilaDatabaseAppController {
	@Autowired
	PersonRepository myRepository;
	
	//Method to create a person
	@PostMapping("/person")
	public sakilaDatabaseModel createPerson(@Valid @RequestBody sakilaDatabaseModel sDM) {
		return myRepository.save(sDM);
		
	}
	
	//Method to get person
	@GetMapping("/person/{id}")
	public sakilaDatabaseModel getPersonbyID(@PathVariable(value = "id")Long personID) {
		return myRepository.findById(personID).orElseThrow(() -> new ResourceNotFoundException("sakilaDatabaseModel", "id", personID));
	}
	
	//Method to get all people
	@GetMapping("/person")
	public List<sakilaDatabaseModel> getAllPeople(){
		return myRepository.findAll();
	}
	
	// Method to update a person
	@PutMapping("/person/{id}")
	public sakilaDatabaseModel updatePerson(@PathVariable(value = "id") Long personID,
			@Valid @RequestBody sakilaDatabaseModel personDetails) {
		sakilaDatabaseModel sDM = myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("Person", "id", personID));
		sDM.setName(personDetails.getName());
		sDM.setAddress(personDetails.getAddress());
		sDM.setAge(personDetails.getAge());
		
		sakilaDatabaseModel updateData = myRepository.save(sDM);
		return updateData;
		
	}
	
	//Method to remove a person
	@DeleteMapping("/person/{id}")
	
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id")Long personID){
		sakilaDatabaseModel sDM = myRepository.findById(personID).orElseThrow(() -> new ResourceNotFoundException("Person", "id", personID));
		myRepository.delete(sDM);
		return ResponseEntity.ok().build();
	}
	
	
	

}
