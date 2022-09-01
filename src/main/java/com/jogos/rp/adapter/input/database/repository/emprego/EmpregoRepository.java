package com.jogos.rp.adapter.input.database.repository.emprego;

import com.jogos.rp.adapter.input.database.entity.emprego.EmpregoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpregoRepository extends JpaRepository<EmpregoEntity, Integer> {
}
