package poly.store.service;

import java.util.List;
import java.util.Optional;

import poly.store.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	

}
