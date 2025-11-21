package br.com.fiap.Wellsess.repository;

import br.com.fiap.Wellsess.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);

    Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Usuario> findByEmailContainingIgnoreCase(String email, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "CALL sp_inserir_usuario(:id, :nome, :email, :senha, :dataCadastro)", nativeQuery = true)
    void inserirUsuario(@Param("id") Long id,
                        @Param("nome") String nome,
                        @Param("email") String email,
                        @Param("senha") String senha,
                        @Param("dataCadastro") java.sql.Date dataCadastro);
}