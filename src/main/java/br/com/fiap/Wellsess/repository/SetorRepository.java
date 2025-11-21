package br.com.fiap.Wellsess.repository;

import br.com.fiap.Wellsess.entity.Setor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL sp_inserir_setor(:id, :nome, :quantidadeFunc, :gestorId, :usuarioId)", nativeQuery = true)
    void inserirSetor(@Param("id") Long id,
                      @Param("nome") String nome,
                      @Param("quantidadeFunc") Integer quantidadeFunc,
                      @Param("gestorId") Long gestorId,
                      @Param("usuarioId") Long usuarioId);
}
