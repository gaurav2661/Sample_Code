package com.example.SpringDataJpaCourse.bootstrap;

import com.example.SpringDataJpaCourse.entity.Employee;
import com.example.SpringDataJpaCourse.entity.FullTimeEmployee;
import com.example.SpringDataJpaCourse.entity.PartTimeEmployee;
import com.example.SpringDataJpaCourse.repository.EmployeeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDataSource implements ApplicationListener<ContextRefreshedEvent> {

    private final EmployeeRepository employeeRepository;
    public EmployeeDataSource( EmployeeRepository employeeRepository) {


        this.employeeRepository = employeeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        setData();
    }

    private void setData() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new PartTimeEmployee("garry",BigDecimal.valueOf(8900));
        Employee employee1 = new FullTimeEmployee("gaurav",BigDecimal.valueOf(90000));

        employeeList.add(employee1);
        employeeList.add(employee);

        employeeRepository.saveAll(employeeList);

    }
}
