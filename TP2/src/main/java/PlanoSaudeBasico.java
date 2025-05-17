public class PlanoSaudeBasico implements PlanoSaude {
    @Override
    public double getPercentualCobertura(double percentualCobertura) {
        return percentualCobertura / 100;
    }
}