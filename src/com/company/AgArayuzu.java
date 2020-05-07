package com.company;

import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu, observer {
    Scanner input = new Scanner(System.in);
    @Override
    public boolean userLogin() {
        int count = 0;
        messageShow("       Sisteme Hoş Geldiniz       ||      Wellcome İn The Sistem");
        messageShow("Lütfen Aşağıdaki Bilgileri Girin  ||  Please Enter The Information Below");
        while(count!=3)
        {
            UserNameSQL User = UserNameSQL.Nesne();
            String UsernameId = "";
            String Password = "";
            messageShow("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
            messageShow("Lütfen Kullancı Adı Girin || Please Enter The User Name ");
            messageShow("Username: ");
            UsernameId = input.next();
            messageShow("Lütfen Şifre Girin || Please Enter The Password");
            messageShow("Password: ");
            Password = input.next();
            boolean result = User.UserAuthentication(UsernameId, Password);
            if (result) {
                return true;

            }
            count++;
        }
        return false;
    }

    @Override
    public void messageShow(String mes) {
        System.out.println(mes);
    }

    @Override
    public int ProcessSelection() {
        int operation = 0;
        messageShow("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        messageShow("[             (  Menü  )                |           (  Menu  )               ]");
        messageShow("[  Sıcaklık Göstermek İcin 1 Basın      |  Show The Temperature Press 1      ]");
        messageShow("[  Soğutucu Çalıştırmak İçin 2 Basın    |  Open The Aircondition Press 2     ]");
        messageShow("[  Soğutucu Beklme Durumda İçin 3 Basın |  StandBy The Aircondition Press 3  ]");
        messageShow("[  Soğutucu Kapatmak İçin 4 Basın       |  Close The Aircondition Press 4    ]");
        messageShow("[  Çıkış Yapmak İçin 5 Basın            |  Exit Press 5                      ]");
        messageShow("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        operation = input.nextInt();
        if (operation == 0) {
            messageShow("Seçilen İşler Yok || No Operation Selected");
        }
        return operation;
    }

    @Override
    public void Temperature(IEyleyiciVeAlgilayici sicaklikAlgilayici) {
        sicaklikAlgilayici.TemperatureSend();
    }

    @Override
    public void ACoundationOpen(IEyleyiciVeAlgilayici eyleyici) {
        eyleyici.AirCoundationOpen();
    }

    @Override
    public void ACoundationOff(IEyleyiciVeAlgilayici eyleyici) {
        eyleyici.AirCoundationOff();
    }

    @Override
    public void StandBY(IEyleyiciVeAlgilayici eyleyici) {
        eyleyici.StandBY();
    }

    @Override
    public void Exit() {
        messageShow("Sistemi kapattı || System ShutDown");
        messageShow("Güle Güle :)    || Good Bye  :)");
    }

    @Override
    public void update(int sicaklik) {
        messageShow("Sicaklik Guncellendi || Temperature Updated");
    }
}
