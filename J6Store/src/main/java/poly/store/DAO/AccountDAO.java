package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.Account;

public interface AccountDAO extends JpaRepository<Account, Integer>{
	@Query("SELECT entity FROM Account entity WHERE id=:id")
	public Account findById(@Param("id") String id);


}
