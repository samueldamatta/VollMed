package med.voll.api.consulta.validacoes;

import java.time.DayOfWeek;
import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.consulta.ValidacaoException;

public class ValidadorHorarioFuncionamentoClinica {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica!");
        }
    }
}
