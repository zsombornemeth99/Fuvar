package com.zsombornemeth.fuvar;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Fuvarok
{
    private List<Fuvar> fuvarokLista;

    public Fuvarok(String fajlnev)
    {
        this.fuvarokLista = new LinkedList<>();
        try
        {
            FileReader r = new FileReader(fajlnev);
            BufferedReader br = new BufferedReader(r);
            br.readLine();
            String sor = br.readLine();
            while (sor != null)
            {
                this.fuvarokLista.add(new Fuvar(sor));
                sor = br.readLine();
            }
            br.close();
            r.close();
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public int feladat3()
    {
        return this.fuvarokLista.size();
    }

    public void feladat4()
    {
        double viteldij=0;
        int db=0;
        for (Fuvar f : fuvarokLista)
        {
            if (f.getAzonosito()==6185)
            {
                viteldij+=f.getViteldij();
                db++;
            }
        }
        System.out.printf("%d fuvar alatt: %.2f$", db, viteldij);
    }

    public void feladat5()
    {
        HashMap<String, Integer> stat = new HashMap<String, Integer>();
        for (Fuvar f : fuvarokLista)
        {
            if (!stat.containsKey(f.getFizetesMod()))
            {
                stat.put(f.getFizetesMod(), 1);
            }
            else
            {
                stat.put(f.getFizetesMod(),stat.get(f.getFizetesMod())+1);
            }
        }
        for(String key : stat.keySet())
        {
            System.out.printf("\n\t%s: %d fuvar",key,stat.get(key));
        }
    }

    public double feladat6()
    {
        double osszTavolsag = 0;
        for(Fuvar f : fuvarokLista)
        {
            osszTavolsag+=f.getTavolsag();
        }
        return osszTavolsag*1.6;
    }

    public void feladat7()
    {
        int maxIndex = 0;
        for (int i=0;i<fuvarokLista.size();i++)
        {
            if (fuvarokLista.get(i).getTavolsag()>fuvarokLista.get(maxIndex).getTavolsag())
            {
                maxIndex=i;
            }
        }
        System.out.printf("\n\tFuvar hossza: %d mp", fuvarokLista.get(maxIndex).getIdotartam());
        System.out.print("\n\tTaxi azonosító:"+ fuvarokLista.get(maxIndex).getAzonosito());
        System.out.printf("\n\tMegtett távolság: %.1f km", fuvarokLista.get(maxIndex).getTavolsag());
        System.out.printf("\n\tViteldíj: %.2f$", fuvarokLista.get(maxIndex).getViteldij());
    }

    public void feladat8()
    {
        try
        {
            FileWriter fw = new FileWriter("hibak.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("taxi_id;indulás;időtartam;távolság;viteldíj;borravaló; fizetés módja");
            for (Fuvar f:fuvarokLista)
            {
                if (f.getIdotartam()>0 && f.getViteldij()>0 && f.getTavolsag()==0)
                {
                    bw.write("\n"+f.getAzonosito()+";"+f.getIndulas().toString()+";"+f.getIdotartam()+";"+
                            f.getTavolsag()+";"+f.getViteldij()+";"+f.getBorravalo()+";"+
                            f.getFizetesMod());
                }
            }
            bw.close();
            fw.close();
        }
        catch (Exception e)
        {
            e.getMessage();
        }

    }
}
