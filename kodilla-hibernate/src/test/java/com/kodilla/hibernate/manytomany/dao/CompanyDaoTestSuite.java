package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private  EmployeeDao employeeDao;

    @Test
    void testCompanyNamedQueries() {
        Company microMachine = new Company("microMachine");
        Company microsoft = new Company("microsoft");
        Company dataHouse = new Company("dataHouse");

        Employee employee = new Employee("Jan", "Kovalsky");
        Employee employee1 = new Employee("Roberto", "Kovalsky");
        Employee employee2 = new Employee("Noriaki", "Kasai");

        microMachine.getEmployees().add(employee);
        microsoft.getEmployees().add(employee1);
        microsoft.getEmployees().add(employee);
        dataHouse.getEmployees().add(employee2);

        employee.getCompanies().add(microMachine);
        employee.getCompanies().add(microsoft);
        employee1.getCompanies().add(microsoft);
        employee2.getCompanies().add(dataHouse);


        companyDao.save(microMachine);
        companyDao.save(microsoft);
        companyDao.save(dataHouse);

        List<Company> firstThree = companyDao.retrieveFirstThreeLetters("mic");

        try{
            assertEquals(2, firstThree.size());

        } finally {
            companyDao.deleteAll();
        }
    }

    @Test
    void testEmployeeNamedQuery(){
        Company microMachine = new Company("microMachine");
        Company microsoft = new Company("microsoft");
        Company dataHouse = new Company("dataHouse");

        Employee employee = new Employee("Jan", "Kovalsky");
        Employee employee1 = new Employee("Roberto", "Kovalsky");
        Employee employee2 = new Employee("Noriaki", "Kasai");

        microMachine.getEmployees().add(employee);
        microsoft.getEmployees().add(employee1);
        microsoft.getEmployees().add(employee);
        dataHouse.getEmployees().add(employee2);

        employee.getCompanies().add(microMachine);
        employee.getCompanies().add(microsoft);
        employee1.getCompanies().add(microsoft);
        employee2.getCompanies().add(dataHouse);


        companyDao.save(microMachine);
        companyDao.save(microsoft);
        companyDao.save(dataHouse);

        List<Employee> lastnameList = employeeDao.retrieveByLastname("Kovalsky");

        try{
            assertEquals(2,lastnameList.size());
        } finally {
            companyDao.deleteAll();
        }
    }
}
