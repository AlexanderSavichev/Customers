package com.savichev.customerdb.repositories;

import com.savichev.customerdb.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<UserInfo, Integer> {

}
