package com.savichev.customerdb.services;

import com.savichev.customerdb.models.UserInfo;
import com.savichev.customerdb.repositories.ConfigurationRepo;
import com.savichev.customerdb.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ConfigurationRepo configurationRepo;

    @Override
    public UserInfo saveUser(UserInfo userInfo) {
        return customerRepo.save(userInfo);
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return customerRepo.findAll();
    }

    @Override
    public void deleteUser(int id) {
        Optional <UserInfo> userInfo = customerRepo.findById(id);
        if(userInfo.isPresent())
            customerRepo.deleteById(id);
    }
}
