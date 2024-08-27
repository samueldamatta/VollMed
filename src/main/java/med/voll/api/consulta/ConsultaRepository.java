package med.voll.api.consulta;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotNull;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    boolean existsByPacienteIdAndDataBetween(@NotNull Long idPaciente, LocalDateTime primeiroHorario,
            LocalDateTime ultimoHorario);
}
