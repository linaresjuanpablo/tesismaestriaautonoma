package com.datos.data.Repository;

import com.datos.data.model.Proponentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProponentesRepository extends JpaRepository<Proponentes, Long> {
}
