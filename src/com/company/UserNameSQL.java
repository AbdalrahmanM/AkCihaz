package com.company;


import java.sql.*;
public class UserNameSQL  {
    public static UserNameSQL data;

    private UserNameSQL() {
    }

    public static UserNameSQL Nesne() {
        if (data == null) {
            data = new UserNameSQL();
        }
        return data;
    }

    public boolean UserAuthentication(String Username, String Password) {
        try {
            Connection concect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilicihaz", "postgres", "Abdo94MNYA");
            if (concect != null) {
                String KullaniciSql = "SELECT * FROM public.\"kullanci\"";
                Statement stmt = concect.createStatement();
                ResultSet result = stmt.executeQuery(KullaniciSql);
                concect.close();
                String username = "";
                String password = "";
                while (result.next()) {
                    username = result.getString("username");
                    password = result.getString("password");
                }
                if (username.equals(Username) && password.equals(Password)) {
                    System.out.println("Tebrikler Giriş Başarlı || Congratulations Login Successful");
                    return true;
                } else {
                    System.out.println("     Giriş Yanlış Lütfen Tekrar Eden   || Login Failed Please Try Again");
                    return false;
                }
            } else {
                System.out.println("Veritabanina Baglanilaması Başarsız||Database Connect Failed");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
}

