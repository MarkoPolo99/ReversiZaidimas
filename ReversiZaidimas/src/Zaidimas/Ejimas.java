package Zaidimas;

public class Ejimas {

    public static void Ejimas(char[][] lenta, char zaidejas, char priesininkas, Taskai taskai) {
        int i = taskai.x, j = taskai.y;
        lenta[i][j] = zaidejas;
        int I = i, J = j;

        if (i - 1 >= 0 && j - 1 >= 0 && lenta[i - 1][j - 1] == priesininkas) {
            i = i - 1;
            j = j - 1;
            while (i > 0 && j > 0 && lenta[i][j] == priesininkas) {
                i--;
                j--;
            }
            if (i >= 0 && j >= 0 && lenta[i][j] == zaidejas) {
                while (i != I - 1 && j != J - 1) lenta[++i][++j] = zaidejas;
            }
        }
        i = I;
        j = J;
        if (i - 1 >= 0 && lenta[i - 1][j] == priesininkas) {
            i = i - 1;
            while (i > 0 && lenta[i][j] == priesininkas) i--;
            if (i >= 0 && lenta[i][j] == zaidejas) {
                while (i != I - 1) lenta[++i][j] = zaidejas;
            }
        }
        i = I;
        if (i - 1 >= 0 && j + 1 <= 7 && lenta[i - 1][j + 1] == priesininkas) {
            i = i - 1;
            j = j + 1;
            while (i > 0 && j < 7 && lenta[i][j] == priesininkas) {
                i--;
                j++;
            }
            if (i >= 0 && j <= 7 && lenta[i][j] == zaidejas) {
                while (i != I - 1 && j != J + 1) lenta[++i][--j] = zaidejas;
            }
        }
        i = I;
        j = J;
        if (j - 1 >= 0 && lenta[i][j - 1] == priesininkas) {
            j = j - 1;
            while (j > 0 && lenta[i][j] == priesininkas) j--;
            if (j >= 0 && lenta[i][j] == zaidejas) {
                while (j != J - 1) lenta[i][++j] = zaidejas;
            }
        }
        j = J;
        if (j + 1 <= 7 && lenta[i][j + 1] == priesininkas) {
            j = j + 1;
            while (j < 7 && lenta[i][j] == priesininkas) j++;
            if (j <= 7 && lenta[i][j] == zaidejas) {
                while (j != J + 1) lenta[i][--j] = zaidejas;
            }
        }
        j = J;
        if (i + 1 <= 7 && j - 1 >= 0 && lenta[i + 1][j - 1] == priesininkas) {
            i = i + 1;
            j = j - 1;
            while (i < 7 && j > 0 && lenta[i][j] == priesininkas) {
                i++;
                j--;
            }
            if (i <= 7 && j >= 0 && lenta[i][j] == zaidejas) {
                while (i != I + 1 && j != J - 1) lenta[--i][++j] = zaidejas;
            }
        }
        i = I;
        j = J;
        if (i + 1 <= 7 && lenta[i + 1][j] == priesininkas) {
            i = i + 1;
            while (i < 7 && lenta[i][j] == priesininkas) i++;
            if (i <= 7 && lenta[i][j] == zaidejas) {
                while (i != I + 1) lenta[--i][j] = zaidejas;
            }
        }
        i = I;

        if (i + 1 <= 7 && j + 1 <= 7 && lenta[i + 1][j + 1] == priesininkas) {
            i = i + 1;
            j = j + 1;
            while (i < 7 && j < 7 && lenta[i][j] == priesininkas) {
                i++;
                j++;
            }
            if (i <= 7 && j <= 7 && lenta[i][j] == zaidejas)
                while (i != I + 1 && j != J + 1) lenta[--i][--j] = zaidejas;
        }
    }

    public static int Koordinates(char[] lentaX, char x) {
        for (int i = 0; i < 8; ++i)
            if (lentaX[i] == Character.toLowerCase(x) || lentaX[i] == Character.toUpperCase(x)) return i;
        return -1; // negalimas ejimas
    }
}
