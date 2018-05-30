package com.nd.zsp.bootdemo.module.demo.Repository;

import com.nd.zsp.bootdemo.module.demo.model.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeparmentRepository extends JpaRepository<Deparment, Long> {
}
