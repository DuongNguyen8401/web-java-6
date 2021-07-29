package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.store.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer>{
	@Query("SELECT entity FROM OrderDetail entity WHERE id=:id")
	public OrderDetail findById(@Param("id") String id);


}
