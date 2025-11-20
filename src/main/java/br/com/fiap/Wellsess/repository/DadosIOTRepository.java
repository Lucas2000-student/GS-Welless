package br.com.fiap.Wellsess.repository;

import br.com.fiap.Wellsess.entity.DadosIOT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DadosIOTRepository extends JpaRepository<DadosIOT, Long> {
    List<DadosIOT> findByCheckinId(Long checkinId);
}
