package com.savichev.customerdb.services;

import com.savichev.customerdb.models.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerService {
    public UserInfo saveUser (UserInfo userInfo);
    public List<UserInfo> getAllUsers();
    void deleteUser (int id);
}