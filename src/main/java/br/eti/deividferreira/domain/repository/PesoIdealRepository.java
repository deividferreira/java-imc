package br.eti.deividferreira.domain.repository;

import br.eti.deividferreira.domain.entities.PesoIdeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PesoIdealRepository extends JpaRepository<PesoIdeal, Long> {


    Optional<PesoIdeal> findByCpf(String cpf);
}
