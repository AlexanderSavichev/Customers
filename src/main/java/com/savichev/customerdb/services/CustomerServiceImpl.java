package com.savichev.customerdb.services;

import com.savichev.customerdb.models.Configuration;
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
    public UserInfo saveUser(UserInfo savedUserInfo) {
//        try {
//            return customerRepo.save(userInfo);
//        }
//        catch (Exception e){
//            System.out.print("Error occurred while trying to save data");
//            return null;
//        }
        UserInfo userInfo = customerRepo.findUserInfoByEmail(savedUserInfo.getEmail());
        if (userInfo!=null){

            userInfo.setConfigurations(savedUserInfo.getConfigurations());
            return customerRepo.save(userInfo);
        }
        else {
            return customerRepo.save(savedUserInfo);
        }

    }

    @Override
    public List<UserInfo> getAllUsers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<UserInfo> isEmailExists(String email) {
        UserInfo userInfo = customerRepo.findUserInfoByEmail(email);
        return Optional.ofNullable(userInfo);
    }

    @Override
    public void deleteUser(int id) {
        Optional <UserInfo> userInfo = customerRepo.findById(id);
        if(userInfo.isPresent())
            customerRepo.deleteById(id);
    }
}
