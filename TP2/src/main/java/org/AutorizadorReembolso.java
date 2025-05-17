package org;

public interface AutorizadorReembolso {
    boolean autorizar(Consulta consulta, Paciente paciente);
}
