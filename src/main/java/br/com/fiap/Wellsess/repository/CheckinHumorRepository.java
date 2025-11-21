package br.com.fiap.Wellsess.repository;

import br.com.fiap.Wellsess.entity.CheckinHumor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CheckinHumorRepository extends JpaRepository<CheckinHumor, Long> {
    List<CheckinHumor> findByUsuarioId(Long usuarioId);

    @Modifying
    @Transactional
    @Query(value = "CALL sp_inserir_checkin_humor(:id, :dataCheckin, :nivelHumor, :comentario, :usuarioId)", nativeQuery = true)
    void inserirCheckinHumor(@Param("id") Long id,
                             @Param("dataCheckin") java.sql.Date dataCheckin,
                             @Param("nivelHumor") Integer nivelHumor,
                             @Param("comentario") String comentario,
                             @Param("usuarioId") Long usuarioId);
}
