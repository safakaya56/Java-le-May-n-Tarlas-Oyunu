import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void matrisYazdir(Object[][] matris2, int boyut2) {
        for (int i = 0; i < boyut2; i++) {
            for (int j = 0; j < boyut2; j++) {
                System.out.print(matris2[i][j]);
            }
            System.out.println();
        }
    }

    public void baslangicDurumu(Object[][] matris, int boyut) {
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                matris[i][j] = "-";
            }
        }
    }

    public void oyun(Object[][] newMatris, int newBoyut) {

        Object[][] kontrol = new Object[newBoyut][newBoyut];
        int mayinSayisi = 0;

        baslangicDurumu(newMatris, newBoyut);

        for (int i = 0; i < newBoyut; i++) {
            for (int j = 0; j < newBoyut; j++) {
                if (random.nextInt(2) == 0) {
                    kontrol[i][j] = "*";
                    mayinSayisi++;
                } else {
                    kontrol[i][j] = "-";
                }
            }
        }

        matrisYazdir(newMatris, newBoyut);
        System.out.println();

        int satir, sutun, sayac = 0;
        boolean devam = true;

        while (devam) {
            System.out.print("Lütfen satır girin: ");
            satir = scanner.nextInt();

            System.out.print("Lütfen sütun girin: ");
            sutun = scanner.nextInt();

            if (satir >= 0 && satir < newBoyut && sutun >= 0 && sutun < newBoyut) {
                if (kontrol[satir][sutun].equals("*")) {
                    System.out.println("Oyun Bitti!");
                    devam = false;
                    System.out.println();

                    matrisYazdir(kontrol, newBoyut);
                } else {
                    System.out.println("Kurtuldun.");
                    newMatris[satir][sutun] = "+";
                    matrisYazdir(newMatris, newBoyut);
                    sayac++;
                }
            } else {
                System.out.println("Satır veya sütun sınırları dışında giriş yaptın.");
                devam = false;
            }
            if ((newBoyut * newBoyut - mayinSayisi) == sayac) {
                System.out.println("Kazandiniz");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Dizi boyutunu girin");
        Scanner scanner = new Scanner(System.in);
        int boyut = scanner.nextInt();

        Object[][] matris = new Object[boyut][boyut];

        MineSweeper mayinTarlasi = new MineSweeper();
        mayinTarlasi.oyun(matris, boyut);
    }
}
