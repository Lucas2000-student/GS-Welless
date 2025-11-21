package br.com.fiap.Wellsess.repository;

import br.com.fiap.Wellsess.entity.Gestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GestaoRepository extends JpaRepository<Gestao, Long> {
    boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "CALL sp_inserir_gestor(:id, :nome, :email, :senha, :usuarioId)", nativeQuery = true)
    void inserirGestor(@Param("id") Long id,
                       @Param("nome") String nome,
                       @Param("email") String email,
                       @Param("senha") String senha,
                       @Param("usuarioId") Long usuarioId);
}
