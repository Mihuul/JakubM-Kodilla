package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        Invoice invoice = new Invoice("Invoice1");
        Item item = new Item(new BigDecimal(100), 1, new BigDecimal(5));
        Product product = new Product("Item1");

        item.setInvoice(invoice);
        item.setProduct(product);

        invoiceDao.save(invoice);
        productDao.save(product);
        itemDao.save(item);

        itemDao.deleteAll();
        productDao.deleteAll();
        invoiceDao.deleteAll();
    }
}
