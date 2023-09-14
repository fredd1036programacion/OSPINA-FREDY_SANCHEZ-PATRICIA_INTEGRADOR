package com.proyectoIntegrador.dentalClinic.repository;


import com.proyectoIntegrador.dentalClinic.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
