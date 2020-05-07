package com.company;

import java.util.ArrayList;
import java.util.Random;
public class EyleyiciVeAlgilayici implements IEyleyiciVeAlgilayici, update {
    private ArrayList List = new ArrayList();
    @Override
    public void AirCoundationOpen() {
        messageShow(" Soğutucu Açıldı  || Air Coundation On");
    }

    @Override
    public void AirCoundationOff() {
        messageShow("Soğutucu kapatıldı || Air Coundation Off");
    }

    @Override
    public int TemperatureRead() {
        Random rand = new Random();
        int sayi = rand.nextInt(100);
        return sayi;
    }
    @Override
    public void StandBY() {
        sicaklik=TemperatureRead();
        messageShow("Soğutucunu Sistemi Bekleme Durumda || Air Condation System StandBy");
    }
    int sicaklik;
    @Override
    public int TemperatureSend() {
        sicaklik=TemperatureRead();
        messageShow("Sicaklik    : "+ sicaklik+"C");
        messageShow("Temperature : "+ sicaklik+"C");
        return TemperatureRead();
    }

    @Override
    public void messageShow(String mes) {
        System.out.println(mes);
    }

    public void regObserver(observer i) {
        List.add(i);
    }

    public void deleteObserver(observer i) {
        int j = List.indexOf(i);
        if (j >= 0) {
            List.remove(i);
        }
    }

    public void notObservers() {
        for (int j = 0; j < List.size(); j++) {
            observer observer = (com.company.observer) List.get(j);
            observer.update(TemperatureSend());
        }
    }
}
