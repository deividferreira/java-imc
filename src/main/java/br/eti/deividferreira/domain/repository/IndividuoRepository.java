package br.eti.deividferreira.domain.repository;

import br.eti.deividferreira.domain.entities.Individuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndividuoRepository extends JpaRepository<Individuo, Long> {


    Optional<Individuo> findByCpf(String cpf);
}
