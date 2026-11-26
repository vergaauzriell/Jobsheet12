public class PengunjungKafe28 {
    
    public static void main(String[] args) {
        String[] tamu = {"Ali", "Budi", "Citra"};
        daftarPengunjung(tamu);
        System.out.println("Total 1 item: Rp" + hitungTotalBelanja(15000));
        System.out.println("Total 3 item: Rp" + hitungTotalBelanja(15000, 20000, 22000));
        System.out.println("Total 5 item: Rp" + hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));
    }

    static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar nama pengunjung: ");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }
}