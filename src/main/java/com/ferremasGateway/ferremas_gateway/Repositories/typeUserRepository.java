package com.ferremasGateway.ferremas_gateway.Repositories;

import com.ferremasGateway.ferremas_gateway.Models.typeUserModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface typeUserRepository extends JpaRepository<typeUserModel, Long> { }

