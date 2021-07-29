package poly.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{
//	@Query("SELECT entity FROM Product entity WHERE id=:id")
	public Product findById(@Param("id") String id);
	
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	public List<Product> findByCategoryId(String cid);


}