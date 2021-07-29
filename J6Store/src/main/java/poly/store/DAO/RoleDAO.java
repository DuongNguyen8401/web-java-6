package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer>{
	@Query("SELECT entity FROM OrderDetail entity WHERE id=:id")
	public Role findById(@Param("id") String id);


}
