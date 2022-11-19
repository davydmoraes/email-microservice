package com.davyd.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davyd.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

}
