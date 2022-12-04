package com.savichev.customerdb.services;

import com.savichev.customerdb.models.Configuration;
import com.savichev.customerdb.models.UserInfo;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerService {
    public UserInfo saveUser (UserInfo userInfo);
    public List<UserInfo> getAllUsers();
    public Optional<UserInfo> findUserByEmail(String email);
    public Optional <UserInfo> findUserById (int id);
    public Optional<UserInfo> findUserByNameAndSurname(String name, String surname);
    void deleteUser (int id);
    public List<Configuration> findConfById(int id);
    void deleteConfig (int id);
}
