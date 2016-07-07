package br.com.sldv.model.repositories;

import br.com.sldv.model.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Integer> {
}
