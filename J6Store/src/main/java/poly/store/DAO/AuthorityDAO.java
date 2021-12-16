package poly.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.Account;
import poly.store.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{
	@Query("SELECT entity FROM Authority entity WHERE id=:id")
	public Authority findById(@Param("id") String id);

	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	public List<Authority> authoritiesOf(List<Account> accounts);


}
