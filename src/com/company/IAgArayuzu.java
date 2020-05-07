package com.company;

public interface IAgArayuzu {
    public boolean userLogin();
    public int ProcessSelection();
    public void Temperature(IEyleyiciVeAlgilayici sicaklikAlgilayici);
    public void ACoundationOpen(IEyleyiciVeAlgilayici eyleyici);
    public void ACoundationOff(IEyleyiciVeAlgilayici eyleyici);
    public void Exit();
    public void StandBY(IEyleyiciVeAlgilayici eyleyici);
    public void messageShow(String mes);
}

