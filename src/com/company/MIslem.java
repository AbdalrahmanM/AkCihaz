package com.company;

public class MIslem implements IMIslem {
    IAgArayuzu agArayuzu = new AgArayuzu();
    IEyleyiciVeAlgilayici sAlgilayici = new EyleyiciVeAlgilayici();
    IEyleyiciVeAlgilayici eyleyici = new EyleyiciVeAlgilayici();

    @Override
    public int SistemOperation() {
        return agArayuzu.ProcessSelection();
    }
    private static final int temperature = 1;
    private static final int openAc = 2;
    private static final int Standby = 3;
    private static final int closeAc = 4;
    private static final int Exit = 5;
    @Override
    public boolean SistemLogin() {
        return agArayuzu.userLogin();
    }
    @Override
    public void Operation() {
        if (SistemLogin()){
            int operation=0;
            while(operation!=5) {
                operation = SistemOperation();
                switch (operation) {
                    case temperature:
                        TempRead();
                        break;
                    case openAc:
                        AConditionOpen();
                        break;
                    case Standby:
                        StandByAcondition();
                        break;
                    case closeAc:
                        AConditionClose();
                        break;
                    case Exit:
                        Exit();
                        break;
                    default:
                        messageShow("Yanlış Bilgi Lütfen Tekrrar Eden | Please Repeat Wrong Information");
                        break;
                }
            }
        }else {
            messageShow("             Erişim Iptal Edildi       ||      Access Cancelled");
        }
    }

    @Override
    public void messageShow(String mes) {
        System.out.println(mes);
    }

    @Override
    public void TempRead() {
        agArayuzu.Temperature(sAlgilayici);
    }

    @Override
    public void AConditionOpen() {
        agArayuzu.ACoundationOpen(eyleyici);

    }

    @Override
    public void AConditionClose() {
        agArayuzu.ACoundationOff(eyleyici);
    }

    @Override
    public void StandByAcondition() {
        agArayuzu.StandBY(eyleyici);
    }

    @Override
    public void Exit() {
        agArayuzu.Exit();
    }

}