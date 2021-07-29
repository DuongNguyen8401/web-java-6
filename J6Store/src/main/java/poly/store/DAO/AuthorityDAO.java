package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{
	@Query("SELECT entity FROM Authority entity WHERE id=:id")
	public Authority findById(@Param("id") String id);


}
