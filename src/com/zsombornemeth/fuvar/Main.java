package com.zsombornemeth.fuvar;

public class Main {

    public static void main(String[] args)
    {
        Fuvarok f = new Fuvarok("fuvar.csv");

        System.out.printf("3. feladat: %d fuvar", f.feladat3());

        System.out.print("\n4. feladat: ");
        f.feladat4();

        System.out.print("\n5. feladat: ");
        f.feladat5();

        System.out.printf("\n6. feladat: %.2fkm",f.feladat6());

        System.out.print("\n7. feladat: Leghosszabb fuvar:");
        f.feladat7();


    }
}
