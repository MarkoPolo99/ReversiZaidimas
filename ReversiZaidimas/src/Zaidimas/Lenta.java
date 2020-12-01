package Zaidimas;

class Lenta {

    final char[][] Lenta;
    int baltoTaskai, juodoTaskai, likeTaskai;
    final char[] LentaX = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public Lenta() {
        Lenta = new char[][]{
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', 'B', 'J', '_', '_', '_',},
                {'_', '_', '_', 'J', 'B', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
        };
    }

    public void LentosAtvaizdavimas(Lenta LentosAtvaizdavimas) {
        System.out.print("\n  ");
        for (int i = 0; i < 8; ++i) System.out.print(this.LentaX[i] + " ");
        System.out.println();
        for (int i = 0; i < 8; ++i) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; ++j)
                System.out.print(LentosAtvaizdavimas.Lenta[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
