package productmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import productmt.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	Optional<Product> findByProductCode(String productCode);
}
