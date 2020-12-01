package Zaidimas;

import java.util.HashSet;
import java.util.Scanner;

class ReversiZaidimas {

    public static void Zaidejai(Lenta b) {
        Scanner skanavimas = new Scanner(System.in);
        Taskai eiti = new Taskai(-1, -1);
        System.out.println("Juodas pradeda ejima");

        int rezltatas;
        boolean praleistiEjima;
        String ivestis;

        while (true) {
            praleistiEjima = false;

            HashSet<Taskai> juodoZaidejoLokacijos = TinkamosLokacijos.gautiTinkamasLokacijas(b.Lenta, 'J', 'B');
            HashSet<Taskai> baltoZaidejoLokacijos = TinkamosLokacijos.gautiTinkamasLokacijas(b.Lenta, 'B', 'J');

            TinkamosLokacijos.rodytiTinkamasLokacijas(b, juodoZaidejoLokacijos);
            rezltatas = Taskai.ZaidimoRezultatas(b, baltoZaidejoLokacijos, juodoZaidejoLokacijos);

            if (rezltatas == 0) {
                System.out.println("Lygiosios.");
                break;
            } else if (rezltatas == 1) {
                System.out.println("Laimejo juodi: " + b.baltoTaskai + ":" + b.juodoTaskai);
                break;
            } else if (rezltatas == -1) {
                System.out.println("Laimejo balti: " + b.juodoTaskai + ":" + b.baltoTaskai);
                break;
            }

            if (juodoZaidejoLokacijos.isEmpty()) {
                System.out.println("Juodas praleidzia ejima... Eina baltas");
                praleistiEjima = true;
            }

            if (!praleistiEjima) {
                System.out.println("Eina juodi ");
                ivestis = skanavimas.next();
                eiti.y = Ejimas.Koordinates(b.LentaX, ivestis.charAt(0));
                eiti.x = (Integer.parseInt(ivestis.charAt(1) + "") - 1);

                while (!juodoZaidejoLokacijos.contains(eiti)) {
                    System.out.println("Negalimas ejimas!\nEina juodi: ");
                    ivestis = skanavimas.next();
                    eiti.y = Ejimas.Koordinates(b.LentaX, ivestis.charAt(0));
                    eiti.x = Integer.parseInt((ivestis.charAt(1) + "")) - 1;
                }
                Ejimas.Ejimas(b.Lenta, 'J', 'B', eiti);
                Taskai.TaskuSkaiciavimas(b);
                System.out.println("\nJuodi: " + b.juodoTaskai + " Balti: " + b.baltoTaskai);
            }
            praleistiEjima = false;

            baltoZaidejoLokacijos = TinkamosLokacijos.gautiTinkamasLokacijas(b.Lenta, 'B', 'J');
            juodoZaidejoLokacijos = TinkamosLokacijos.gautiTinkamasLokacijas(b.Lenta, 'J', 'B');

            TinkamosLokacijos.rodytiTinkamasLokacijas(b, baltoZaidejoLokacijos);
            rezltatas = Taskai.ZaidimoRezultatas(b, baltoZaidejoLokacijos, juodoZaidejoLokacijos);

            if (rezltatas == 0) {
                System.out.println("Lygiosios");
                break;
            } else if (rezltatas == 1) {
                System.out.println("Balti laimejo " + b.baltoTaskai + ":" + b.juodoTaskai);
                break;
            } else if (rezltatas == -1) {
                System.out.println("Juodi laimejo " + b.juodoTaskai + ":" + b.baltoTaskai);
                break;
            }

            if (baltoZaidejoLokacijos.isEmpty()) {
                System.out.println("Balti praleidzia ejima... Eina juodi");
                praleistiEjima = true;
            }

            if (!praleistiEjima) {
                System.out.println("Eina balti: ");
                ivestis = skanavimas.next();
                eiti.y = Ejimas.Koordinates(b.LentaX, ivestis.charAt(0));
                eiti.x = (Integer.parseInt(ivestis.charAt(1) + "") - 1);

                while (!baltoZaidejoLokacijos.contains(eiti)) {
                    System.out.println("Negalimas ejimas!\nEina balti: ");
                    ivestis = skanavimas.next();
                    eiti.y = Ejimas.Koordinates(b.LentaX, ivestis.charAt(0));
                    eiti.x = (Integer.parseInt(ivestis.charAt(1) + "") - 1);
                }
                Ejimas.Ejimas(b.Lenta, 'B', 'J', eiti);
                Taskai.TaskuSkaiciavimas(b);
                System.out.println("\nBaltas: " + b.baltoTaskai + " Juodas: " + b.juodoTaskai);
            }
        }
    }

    public static void main(String[] args) {
        Lenta b = new Lenta();
        Zaidejai(b);
    }
}

