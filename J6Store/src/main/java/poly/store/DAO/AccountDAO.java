package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.store.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String>{

}
