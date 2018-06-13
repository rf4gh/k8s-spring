package com.dxc.appl.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = {"com.dxc.appl.demo.db.repositories"})
@EntityScan(basePackages = {"com.dxc.appl.demo.db.entities"})
@EnableTransactionManagement
public class PersistenceConfig {

}
