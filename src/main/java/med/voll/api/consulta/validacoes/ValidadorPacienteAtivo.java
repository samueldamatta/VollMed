package med.voll.api.consulta.validacoes;

import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.consulta.ValidacaoException;
import med.voll.api.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com um paciente excluído");
        }
    }
}
