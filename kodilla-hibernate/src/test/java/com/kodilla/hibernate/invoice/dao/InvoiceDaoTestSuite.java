package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Invoice invoice = new Invoice("Invoice1");
        Product product1 = new Product("product1");
        Product product2 = new Product("Product2");
        Item item1 = new Item(new BigDecimal(100),10,new BigDecimal(99));
        Item item2 = new Item(new BigDecimal(100),1,new BigDecimal(40));
        Item item3 = new Item(new BigDecimal(10),50,new BigDecimal(150));

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);

        //When

        productDao.save(product1);
        int pro1Id = product1.getId();
        productDao.save(product2);
        int pro2Id = product2.getId();
        invoiceDao.save(invoice);
        int invId = invoice.getId();
        itemDao.save(item1);
        int itm1Id = item1.getId();
        itemDao.save(item2);
        int itm2Id = item2.getId();
        itemDao.save(item3);
        int itm3Id = item3.getId();

        //Then
        assertNotEquals(0,pro1Id);
        assertNotEquals(0,pro2Id);
        assertNotEquals(0,invId);
        assertNotEquals(0,itm1Id);
        assertNotEquals(0,itm2Id);
        assertNotEquals(0,itm3Id);

        //CleanUp
        productDao.deleteAll();
        itemDao.deleteAll();
        invoiceDao.deleteAll();
    }
}
