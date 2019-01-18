package qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.model.MovieCat;
import qa.anita.mohan.springboot.sakila.springBootSakilaDatabaseApp.model.SakilaMovieModel;

@Repository
public interface SakilaMovieRepository extends JpaRepository<SakilaMovieModel,Long>{
	List<SakilaMovieModel> findByCategory(String category);
}
