package com.example.employeemanagement.certificate.repository;

import com.example.employeemanagement.certificate.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepo extends JpaRepository<Certificate,Long> {
}
