package com.company;

public interface IEyleyiciVeAlgilayici {
    public void AirCoundationOpen();
    public void AirCoundationOff();
    public void StandBY();
    public int TemperatureRead();
    public int TemperatureSend();
    public void messageShow(String mes);
}
