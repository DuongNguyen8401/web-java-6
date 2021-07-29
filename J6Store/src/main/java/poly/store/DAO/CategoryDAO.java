package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
	@Query("SELECT entity FROM Category entity WHERE id=:id")
	public Category findById(@Param("id") String id);


}