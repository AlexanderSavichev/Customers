package com.savichev.customerdb.services;

import com.savichev.customerdb.models.Configuration;
import com.savichev.customerdb.models.UserInfo;
import com.savichev.customerdb.repositories.ConfigurationRepo;
import com.savichev.customerdb.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ConfigurationRepo configurationRepo; //Repository added for a future needs

    @Override
    @Transactional
    public UserInfo saveUser(UserInfo savedUserInfo) {
        try{
        UserInfo userInfo = customerRepo.findUserInfoByEmail(savedUserInfo.getEmail());
        if (userInfo!=null){
            userInfo.getConfigurations().clear();
            savedUserInfo.getConfigurations().forEach(configuration -> configuration.setUserInfo(userInfo));
            userInfo.setConfigurations(savedUserInfo.getConfigurations());
            return customerRepo.save(userInfo);
        }
        else {
            return customerRepo.save(savedUserInfo);
        }}
        catch (Exception e){
            System.out.print("Error occurred while trying to save data");
            return null;
        }
    }

    @Override
    public List<UserInfo> getAllUsers() {
        try{
        return customerRepo.findAll();}
        catch (Exception e){
            System.out.print("Error occurred while trying to load data");
            return null;
        }
    }

    @Override
    public Optional<UserInfo> findUserByEmail(String email) {
        UserInfo userInfo = customerRepo.findUserInfoByEmail(email);
        return Optional.ofNullable(userInfo);
    }

    @Override
    public Optional<UserInfo> findUserById(int id) {
        UserInfo userInfo = customerRepo.findUserInfoById(id);
        return Optional.ofNullable(userInfo);
    }

    @Override
    public Optional<UserInfo> findUserByNameAndSurname(String name, String surname) {
        UserInfo userInfo = customerRepo.findUserInfoByNameAndSurname(name, surname);
        return Optional.ofNullable(userInfo);
    }

    @Override
    public void deleteUser(int id) {
        Optional <UserInfo> userInfo = customerRepo.findById(id);
        if(userInfo.isPresent())
            customerRepo.deleteById(id);
    }

    @Override
    public List<Configuration> findConfById(int id) {
        List<Configuration> configuration = configurationRepo.findConfigurationById(id);
        return configuration;
    }

    @Override
    public void deleteConfig(int id) {
        Optional<Configuration> configuration = configurationRepo.findById(id);
        if(configuration.isPresent())
            configurationRepo.deleteById(id);
    }
}
