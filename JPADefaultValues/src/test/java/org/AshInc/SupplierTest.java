package org.AshInc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
public class SupplierTest {

    @Autowired
    private SupplierRepository supplierRepository;
    @Test
    public void createSupplier(){
        Supplier supplier = new Supplier();
        supplier = supplierRepository.save(supplier);
        System.out.println(supplier.toString());
        assertEquals(supplier.getFirstName(),"John");
        assertNull(supplier.getPhoneNumber());
    }
}
