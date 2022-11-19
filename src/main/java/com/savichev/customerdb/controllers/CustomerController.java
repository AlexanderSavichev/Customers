package com.savichev.customerdb.controllers;

import com.savichev.customerdb.models.UserInfo;
import com.savichev.customerdb.repositories.ConfigurationRepo;
import com.savichev.customerdb.repositories.CustomerRepo;
import com.savichev.customerdb.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/add")
    public void addUser (@RequestBody UserInfo userInfo){
        customerService.saveUser(userInfo);
    }

    @GetMapping("/findUser")
    public List<UserInfo> getAllUsers(){
        return customerService.getAllUsers();
    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser (@PathVariable("id") int id){
        customerService.deleteUser(id);
    }

}
