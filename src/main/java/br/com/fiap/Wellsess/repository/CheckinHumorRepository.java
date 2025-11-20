package br.com.fiap.Wellsess.repository;

import br.com.fiap.Wellsess.entity.CheckinHumor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CheckinHumorRepository extends JpaRepository<CheckinHumor, Long> {
    List<CheckinHumor> findByUsuarioId(Long usuarioId);
}
