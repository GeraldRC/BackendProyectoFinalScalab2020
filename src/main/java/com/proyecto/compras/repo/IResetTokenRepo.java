package com.proyecto.compras.repo;

import com.proyecto.compras.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {

    ResetToken findByToken(String token);
}
