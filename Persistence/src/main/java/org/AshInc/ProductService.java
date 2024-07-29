package org.AshInc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    public Product findById(Long id){
        return productRepo.findById(id).orElse(null);
    }

//    @PostConstruct
//    public void init() {
//
//        productRepo.save
//                (new Product(1L,
//                        "BY12345",
//                        "Apple",
//                        "Описание",
//                        new BigDecimal(1.12),
//                        1.1,
//                        "data:image/png;base64,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".getBytes(),
//                        Product.Category.FRUITS,Product.Brand.NESTLE,
//                        new Date(2024-1900, Calendar.JULY,29)));
//    }



}
