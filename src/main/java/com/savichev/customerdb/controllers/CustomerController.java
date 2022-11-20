package com.savichev.customerdb.controllers;

import com.savichev.customerdb.models.UserInfo;
import com.savichev.customerdb.repositories.ConfigurationRepo;
import com.savichev.customerdb.repositories.CustomerRepo;
import com.savichev.customerdb.services.CustomerServiceImpl;
import com.savichev.customerdb.services.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerRepo customerRepo; //Repository added for a future needs

    @PostMapping("/add")
    @Transactional
    public void addUser (@Valid @RequestBody UserInfo userInfo){
        customerService.saveUser(userInfo); }

    @GetMapping("/findUser")
    public List<UserInfo> getAllUsers(){
        return customerService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser (@PathVariable("id") int id){
        customerService.deleteUser(id);
    }

    @GetMapping("/findUserByEmail/{email}")
    @ResponseBody
    public UserInfo findUserByEmail(@PathVariable ("email") String email){
        return customerService.findUserByEmail(email).orElseThrow(UserNotFoundException::new);
    }

}
