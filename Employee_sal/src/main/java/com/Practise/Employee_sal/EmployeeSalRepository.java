package com.Practise.Employee_sal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSalRepository extends JpaRepository<EmployeeSal,Integer> {


    List<EmployeeSal> findByName(String name);

    List<EmployeeSal> findBySal(int sal);
}
