package Zaidimas;

import java.util.Set;

public class Taskai {
    int x, y;

    Taskai(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(x + "" + y);
    }

    public static int ZaidimoRezultatas(Lenta lenta, Set<Taskai> baltoZaidejoLokacijos, Set<Taskai> juodoZaidejoLokacijos) {
        TaskuSkaiciavimas(lenta);
        if (lenta.likeTaskai == 0) {
            //Lygiosios
            return Integer.compare(lenta.baltoTaskai, lenta.juodoTaskai);
        }
        if (lenta.baltoTaskai == 0 || lenta.juodoTaskai == 0) {
            if (lenta.baltoTaskai > 0) return 1;
            else if (lenta.juodoTaskai > 0) return -1;
        }
        if (baltoZaidejoLokacijos.isEmpty() && juodoZaidejoLokacijos.isEmpty()) {
            //Lygiosios
            return Integer.compare(lenta.baltoTaskai, lenta.juodoTaskai);
        }
        return -2;
    }

    public static void TaskuSkaiciavimas(Lenta lenta) {
        lenta.baltoTaskai = 0;
        lenta.juodoTaskai = 0;
        lenta.likeTaskai = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (lenta.Lenta[i][j] == 'B') lenta.baltoTaskai++;
                else if (lenta.Lenta[i][j] == 'J') lenta.juodoTaskai++;
                else lenta.likeTaskai++;
            }
        }
    }
}
