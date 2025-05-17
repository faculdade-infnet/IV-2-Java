package org;

public class PlanoSaudeStub implements PlanoSaude {
    private int percentualCobertura;

    public PlanoSaudeStub() {
        this.percentualCobertura = 50;
    }

    public PlanoSaudeStub(int percentualCobertura) {
        this.percentualCobertura = percentualCobertura;
    }

    @Override
    public double getPercentualCobertura(double percentualCobertura) {
        return percentualCobertura / 100;
    }

    public double getPercentualCobertura() {
        return this.percentualCobertura / 100;
    }
}