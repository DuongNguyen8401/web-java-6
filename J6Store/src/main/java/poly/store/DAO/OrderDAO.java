package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{
	@Query("SELECT entity FROM Order entity WHERE id=:id")
	public Order findById(@Param("id") String id);


}
