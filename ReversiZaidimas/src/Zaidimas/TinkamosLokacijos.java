package Zaidimas;
import java.util.HashSet;

public class TinkamosLokacijos {

    static void rastiTinkamasLokacijas(char[][] lenta, char zaidejas, char priesininkas, HashSet<Taskai> tinkamosLokacijos) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (lenta[i][j] == priesininkas) {
                    int I = i, J = j;
                    if (i - 1 >= 0 && j - 1 >= 0 && lenta[i - 1][j - 1] == '_') {
                        i = i + 1;
                        j = j + 1;
                        while (i < 7 && j < 7 && lenta[i][j] == priesininkas) {
                            i++;
                            j++;
                        }
                        if (i <= 7 && j <= 7 && lenta[i][j] == zaidejas)
                            tinkamosLokacijos.add(new Taskai(I - 1, J - 1));
                    }
                    i = I;
                    j = J;
                    if (i - 1 >= 0 && lenta[i - 1][j] == '_') {
                        i = i + 1;
                        while (i < 7 && lenta[i][j] == priesininkas) i++;
                        if (i <= 7 && lenta[i][j] == zaidejas) tinkamosLokacijos.add(new Taskai(I - 1, J));
                    }
                    i = I;
                    if (i - 1 >= 0 && j + 1 <= 7 && lenta[i - 1][j + 1] == '_') {
                        i = i + 1;
                        j = j - 1;
                        while (i < 7 && j > 0 && lenta[i][j] == priesininkas) {
                            i++;
                            j--;
                        }
                        if (i <= 7 && j >= 0 && lenta[i][j] == zaidejas)
                            tinkamosLokacijos.add(new Taskai(I - 1, J + 1));
                    }
                    i = I;
                    j = J;
                    if (j - 1 >= 0 && lenta[i][j - 1] == '_') {
                        j = j + 1;
                        while (j < 7 && lenta[i][j] == priesininkas) j++;
                        if (j <= 7 && lenta[i][j] == zaidejas) tinkamosLokacijos.add(new Taskai(I, J - 1));
                    }
                    j = J;
                    if (j + 1 <= 7 && lenta[i][j + 1] == '_') {
                        j = j - 1;
                        while (j > 0 && lenta[i][j] == priesininkas) j--;
                        if (j >= 0 && lenta[i][j] == zaidejas) tinkamosLokacijos.add(new Taskai(I, J + 1));
                    }
                    j = J;
                    if (i + 1 <= 7 && j - 1 >= 0 && lenta[i + 1][j - 1] == '_') {
                        i = i - 1;
                        j = j + 1;
                        while (i > 0 && j < 7 && lenta[i][j] == priesininkas) {
                            i--;
                            j++;
                        }
                        if (i >= 0 && j <= 7 && lenta[i][j] == zaidejas)
                            tinkamosLokacijos.add(new Taskai(I + 1, J - 1));
                    }
                    i = I;
                    j = J;
                    if (i + 1 <= 7 && lenta[i + 1][j] == '_') {
                        i = i - 1;
                        while (i > 0 && lenta[i][j] == priesininkas) i--;
                        if (i >= 0 && lenta[i][j] == zaidejas) tinkamosLokacijos.add(new Taskai(I + 1, J));
                    }
                    i = I;
                    if (i + 1 <= 7 && j + 1 <= 7 && lenta[i + 1][j + 1] == '_') {
                        i = i - 1;
                        j = j - 1;
                        while (i > 0 && j > 0 && lenta[i][j] == priesininkas) {
                            i--;
                            j--;
                        }
                        if (i >= 0 && j >= 0 && lenta[i][j] == zaidejas)
                            tinkamosLokacijos.add(new Taskai(I + 1, J + 1));
                    }
                    i = I;
                    j = J;
                }
            }
        }
    }

    public static HashSet<Taskai> gautiTinkamasLokacijas(char[][] lenta, char zaidejas, char priesininkas) {
        HashSet<Taskai> tinkamosLokacijos = new HashSet<>();
        rastiTinkamasLokacijas(lenta, zaidejas, priesininkas, tinkamosLokacijos);
        return tinkamosLokacijos;
    }

    public static void rodytiTinkamasLokacijas(Lenta lenta, HashSet<Taskai> lokacijos) {
        for (Taskai p : lokacijos)
            lenta.Lenta[p.x][p.y] = '*';
        lenta.LentosAtvaizdavimas(lenta);
        for (Taskai p : lokacijos)
            lenta.Lenta[p.x][p.y] = '_';
    }
}
