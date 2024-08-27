package med.voll.api.consulta.validacoes;

import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.consulta.ValidacaoException;
import med.voll.api.medico.MedicoRepository;

public class ValidadorMedicoAtivo {
    
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        //escolha médico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode seer agendada com médico excluído");
        }
    }
}
