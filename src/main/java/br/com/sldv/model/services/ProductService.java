package br.com.sldv.model.services;


import br.com.sldv.model.domains.Product;
import br.com.sldv.model.repositories.ProductRespository;
import br.com.sldv.model.services.contratcts.ProductBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductBusiness{

    @Autowired
    ProductRespository productRespository;

    @Override
    public Product get(int id) {
        return productRespository.findOne(id);
    }

    @Override
    public List<Product> all() {
        return productRespository.findAll();
    }

    @Override
    public void delete(int id) {
        productRespository.delete(id);
    }
}
