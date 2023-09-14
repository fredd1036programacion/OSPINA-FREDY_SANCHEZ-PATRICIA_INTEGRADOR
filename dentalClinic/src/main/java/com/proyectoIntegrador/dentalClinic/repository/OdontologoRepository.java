package com.proyectoIntegrador.dentalClinic.repository;


import com.proyectoIntegrador.dentalClinic.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
