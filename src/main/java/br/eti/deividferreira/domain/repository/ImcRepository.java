package br.eti.deividferreira.domain.repository;

import br.eti.deividferreira.domain.entities.Imc;
import br.eti.deividferreira.domain.entities.Individuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImcRepository extends JpaRepository<Imc, Long> {

    Optional<Imc> findByPesoAndAlturaAndIndividuo(Double peso, Double altura, Individuo individuo);
}
