package com.denissmirnov.budgetcommander.dao;

import com.denissmirnov.budgetcommander.models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface BcUserRepository extends CrudRepository<ApplicationUser, Integer> {
    ApplicationUser findByUsername(String username);
}
