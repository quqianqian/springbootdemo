package com.nd.zsp.bootdemo.module.demo.Repository;

import com.nd.zsp.bootdemo.module.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
