package com.api.security.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    public Categoria findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
