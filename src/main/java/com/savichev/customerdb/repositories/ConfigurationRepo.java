package com.savichev.customerdb.repositories;

import com.savichev.customerdb.models.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationRepo extends JpaRepository<Configuration, Integer> {
    @Query("SELECT c FROM Configuration c WHERE c.userInfo.id =:id")
    List<Configuration> findConfigurationById(int id);
}
