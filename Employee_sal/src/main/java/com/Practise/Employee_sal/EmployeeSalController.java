package com.Practise.Employee_sal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeSalController {

    @Autowired
    EmployeeSalRepository esrepo;

    @GetMapping("/test")
    public String test(){
        return "This Is A Test Run";
    }

    @RequestMapping("/save")
    public String save(@RequestBody EmployeeSal employee){

        esrepo.save(employee);
        return "Data Saved Into dataBase";
    }


    @RequestMapping("/all")
    public List<EmployeeSal> all(){
        return esrepo.findAll();
    }


    @RequestMapping("/{id}")
    public Optional<EmployeeSal> byid(@PathVariable int id)
    {
        return esrepo.findById(id);
    }
    @RequestMapping("/name/{name}")
    public List<EmployeeSal> byname (@PathVariable String name)
    {
        return esrepo.findByName(name);
    }

    @RequestMapping("/sal/{sal}")
    public List<EmployeeSal> byRoll (@PathVariable int sal){
        return esrepo.findBySal(sal);
    }

    @RequestMapping("/del/{id}")
    public String delete(@PathVariable int id){
        esrepo.findById(id);
        esrepo.deleteById(id);
        return "The Data Has Been Deleted";
    }

    @RequestMapping("/upd/{id}")
    public EmployeeSal update(@RequestBody EmployeeSal employeeSal,@PathVariable int id) {
        EmployeeSal s=esrepo.findById(id).get();
        s.setName(employeeSal.getName());
        s.setSal(employeeSal.getSal());
        s.setAge(employeeSal.getAge());
        return esrepo.save(s);
    }
}
