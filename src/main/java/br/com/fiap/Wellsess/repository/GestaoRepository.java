package br.com.fiap.Wellsess.repository;

import br.com.fiap.Wellsess.entity.Gestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestaoRepository extends JpaRepository<Gestao, Long> {
    boolean existsByEmail(String email);
}
