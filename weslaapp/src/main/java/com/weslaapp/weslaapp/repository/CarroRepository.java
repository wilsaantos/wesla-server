package com.weslaapp.weslaapp.repository;

import com.weslaapp.weslaapp.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    Carro findById(long id);

}
