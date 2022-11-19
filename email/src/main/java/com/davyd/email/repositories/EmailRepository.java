package com.davyd.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davyd.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
