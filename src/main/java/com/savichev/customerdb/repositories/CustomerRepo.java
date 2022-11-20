package com.savichev.customerdb.repositories;

import com.savichev.customerdb.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<UserInfo, Integer> {
    @Query("SELECT c FROM UserInfo c WHERE c.email =:email")
    UserInfo findUserInfoByEmail(String email);
    UserInfo findUserInfoByNameAndSurname(String name, String surname);

}
