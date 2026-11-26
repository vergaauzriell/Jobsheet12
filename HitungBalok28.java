import java.util.Scanner;

public class HitungBalok28 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Balok ke-" + i);
            System.out.print("Masukkan panjang: ");
            int p = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            int l = sc.nextInt();
            System.out.print("Masukkan tinggi: ");
            int t = sc.nextInt();
            System.out.println("Luas permukaan balok adalah " + hitungLuasPermukaanBalok(p, l, t));
            System.out.println("Volume balok adalah " + hitungVolume(t, p, l));
        }
        sc.close();
    }

    public static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    public static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }
}
