package br.com.sldv.model.services.contratcts;


import br.com.sldv.model.domains.Product;

import java.util.List;

public interface ProductBusiness {
    Product get(int id);
    List<Product> all();
    void delete(int id);
}
