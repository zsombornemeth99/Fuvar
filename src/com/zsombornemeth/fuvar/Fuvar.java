package com.zsombornemeth.fuvar;

import java.time.LocalDateTime;

public class Fuvar
{
    private int azonosito;
    private LocalDateTime indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetesMod;

    public Fuvar(String sor)
    {
        String[] adatok = sor.split(";");
        this.azonosito = Integer.parseInt(adatok[0]);
        this.indulas = LocalDateTime.parse((adatok[1]).replace(" ","T"));
        this.idotartam = Integer.parseInt(adatok[2]);
        this.tavolsag = Double.parseDouble(adatok[3].replace(",","."));
        this.viteldij = Double.parseDouble(adatok[4].replace(",","."));
        this.borravalo = Double.parseDouble(adatok[5].replace(",","."));
        this.fizetesMod = adatok[6];
    }

    public int getAzonosito()
    {
        return azonosito;
    }

    public double getViteldij()
    {
        return viteldij;
    }

    public String getFizetesMod()
    {
        return fizetesMod;
    }

    public double getTavolsag()
    {
        return tavolsag;
    }

    public LocalDateTime getIndulas()
    {
        return indulas;
    }

    public int getIdotartam()
    {
        return idotartam;
    }

    public double getBorravalo()
    {
        return borravalo;
    }
}
