package br.com.sldv.models.services.contratcts;


import br.com.sldv.models.domains.Product;

import java.util.List;

public interface ProductBusiness {
    Product get(int id);
    List<Product> all();
    void delete(int id);
}
