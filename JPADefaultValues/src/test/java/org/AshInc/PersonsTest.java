package org.AshInc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PersonsTest {

    @Autowired
    private CustomerRepository customerRepository;
    @Test
    public void createCustomer(){
        Customer customer = new Customer();
        customer = customerRepository.save(customer);
        System.out.println(customer.toString());
        assertEquals(customer.getFirstName(),"John");
        assertNull(customer.getPhoneNumber());
    }

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
