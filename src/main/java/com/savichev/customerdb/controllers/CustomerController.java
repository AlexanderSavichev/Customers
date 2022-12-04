package com.savichev.customerdb.controllers;

import com.savichev.customerdb.models.Configuration;
import com.savichev.customerdb.models.UserInfo;
import com.savichev.customerdb.repositories.ConfigurationRepo;
import com.savichev.customerdb.repositories.CustomerRepo;
import com.savichev.customerdb.services.CustomerServiceImpl;
import com.savichev.customerdb.services.UserNotFoundException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
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

    @GetMapping("/findUserByNameAndSurname")
    @ResponseBody
    public UserInfo findUserByNameAndSurname (@RequestParam ("name") String name, @RequestParam ("surname") String surname){
        return customerService.findUserByNameAndSurname(name, surname).orElseThrow(UserNotFoundException::new);
    }

    @GetMapping("/findUserByEmail/{email}")
    @ResponseBody
    public UserInfo findUserByEmail(@PathVariable ("email") String email){
        return customerService.findUserByEmail(email).orElseThrow(UserNotFoundException::new);
    }
    @GetMapping("/findUser/{id}")
    @ResponseBody
    public UserInfo findUserById(@PathVariable("id") int id){
        return customerService.findUserById(id).orElseThrow(UserNotFoundException::new);
    }

    @GetMapping("/findConf/{id}")
    @ResponseBody
    public List<Configuration> findConfById(@PathVariable("id")int id){
        return customerService.findConfById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser (@PathVariable("id") int id){
        customerService.deleteUser(id);
    }

    @DeleteMapping ("/deleteConfig/{id}")
    public void deleteConf (@PathVariable("id") int id) {customerService.deleteConfig(id);}

}
