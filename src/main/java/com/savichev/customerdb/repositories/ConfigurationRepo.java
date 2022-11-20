package com.savichev.customerdb.repositories;

import com.savichev.customerdb.models.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends JpaRepository<Configuration, Integer> {

}
