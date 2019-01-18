package qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "film_list")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)

public class SakilaMovieModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FID;
	
	@NotBlank
	private String title;
	
	private String description;
	
	
	private String category;
	
	private float price;
	
	private Integer length;
	
	private String rating;
	
	private String actors;
	
	
	
	
	
	
	public Long getFID() {
		return FID;
	}
	
	public void setFID(Long FID) {
		this.FID = FID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Integer getLength() {
		return length;
	}
	
	public void setLength(Integer length){
		this.length = length;
		
	}
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getActors() {
		return actors;
	}
	
	public void setActors(String actors) {
		this.actors = actors;
	}
	
	public String getCategory() {
		return category;
	}
}
