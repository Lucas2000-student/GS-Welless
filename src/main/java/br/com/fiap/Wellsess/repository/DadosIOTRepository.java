package br.com.fiap.Wellsess.repository;

import br.com.fiap.Wellsess.entity.DadosIOT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DadosIOTRepository extends JpaRepository<DadosIOT, Long> {
    List<DadosIOT> findByCheckinId(Long checkinId);

    @Modifying
    @Transactional
    @Query(value = "CALL sp_inserir_dados_iot(:id, :dataColeta, :temperatura, :localSensor, :checkinId)", nativeQuery = true)
    void inserirDadosIOT(@Param("id") Long id,
                         @Param("dataColeta") java.sql.Date dataColeta,
                         @Param("temperatura") String temperatura,
                         @Param("localSensor") String localSensor,
                         @Param("checkinId") Long checkinId);
}
