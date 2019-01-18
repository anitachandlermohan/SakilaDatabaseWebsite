package qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.exception.ResourceNotFoundException;
import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.model.MovieCat;
import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.model.SakilaMovieModel;
import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.repository.SakilaMovieRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SakilaMovieController {
	@Autowired
	SakilaMovieRepository myRepo;
	
	
	
	 //Post a movie//
	@PostMapping("/SakilaMovieModel")
	public SakilaMovieModel createMovie(@Valid @RequestBody SakilaMovieModel sMM) {
		return myRepo.save(sMM);
	}
	
	
	//return a movie by category//
	@GetMapping("/film_list/{FID}")
		public SakilaMovieModel getMoviebyId(@PathVariable(value = "FID")Long filmID) {
		return myRepo.findById(filmID).orElseThrow(()-> new ResourceNotFoundException("Film","FID", filmID));
		
	}
	
	@GetMapping("/film_list/category/{category}")
	public List<SakilaMovieModel> getMoviebyCat(@PathVariable(value = "category")String filmcategory) {
	return myRepo.findByCategory(filmcategory);
	}
	//return all movies//
	@GetMapping("/film_list")
	public List<SakilaMovieModel> getAllFilms(){
		return myRepo.findAll();
	}
	
	//update film//
	@PutMapping("/film_list/{FID}")
	public SakilaMovieModel updateMovie(@PathVariable(value = "FID")Long filmID, @Valid @RequestBody 
			SakilaMovieModel filmDetails) {
		SakilaMovieModel SMM = myRepo.findById(filmID).orElseThrow(()-> new ResourceNotFoundException("Film", "FID", filmID));
		SMM.setTitle(filmDetails.getTitle());
		SMM.setActors(filmDetails.getActors());
		SMM.setDescription(filmDetails.getDescription());
//		SMM.setCategory(filmDetails.getCategory());
		SMM.setLength(filmDetails.getLength());
		SMM.setPrice(filmDetails.getPrice());
		SMM.setRating(filmDetails.getRating());
		
		SakilaMovieModel updateData = myRepo.save(SMM);
		return updateData;

	}
	
	//remove movie//
	
	@DeleteMapping("film_list/{FID}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "FID")Long filmID){
		SakilaMovieModel SMM = myRepo.findById(filmID).orElseThrow(()-> new ResourceNotFoundException("Film", "FID", filmID));
		myRepo.delete(SMM);
		return ResponseEntity.ok().build();
	}
	
}
