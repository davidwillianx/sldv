package br.com.sldv.models.repositories;

import br.com.sldv.models.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Integer> {
}
