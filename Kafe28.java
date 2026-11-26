import java.util.Scanner;

public class Kafe28 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String nama = sc.nextLine();

        System.out.print("Apakah " + nama + " adalah member (y/n)?  ");
        String member = sc .nextLine();
        
        System.out.print("Masukkan jam kunjung " + nama + " : ");
        int jam = sc.nextInt();

        boolean memberr = false;
        if (member.equalsIgnoreCase("y")) {
            memberr = true;
        } 

        Menu(nama, memberr, jam);

        String lagi;
        int pilihan, banyak, totalBayar = 0;
        do {
            do {
                System.out.print("Masukkan pilihan menu dalam angka (1-6): ");
                pilihan = sc.nextInt(); sc.nextLine();
                
                if (pilihan < 1 || pilihan > 6) {
                    System.out.println("Menu tidak tersedia.");
                }
            } while (pilihan < 1 || pilihan >6);
            
            System.out.print("Masukkan banyak dari item tersebut: ");
            banyak = sc.nextInt(); sc.nextLine();

            totalBayar += hitungTotalHarga28(pilihan, banyak);
            
            System.out.print("Pesan menu lain (y/n)? ");
            lagi = sc.nextLine();

        } while (lagi.equalsIgnoreCase("y"));

        System.out.print("Masukkan kode promo: ");
        String kodePromo = sc.nextLine();

        int diskon =hitungDiskon(totalBayar, kodePromo, memberr);
        int totalAkhir = totalBayar - diskon;

        int hargaTotal = hitungTotalHarga28(pilihan, banyak);

        System.out.println("Total harga untuk pesanan anda adalah Rp. " + totalBayar);
        System.out.println("Total diskon yang diperoleh adalah Rp. " + diskon);
        System.out.println("Total yang harus dibayarkan adalah Rp. " + totalAkhir);
    }

    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung ) {
        System.out.println("Selamat datang, " + namaPelanggan + " !");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian.");
        }

        if (jamKunjung >=14 && jamKunjung <= 16) {
            System.out.println("Happy hour! Diskon 20% untuk semua minuman");
        }

        System.out.println("==== MENU RESTO KAFE ====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappucino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("==========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan.");   
    }

    public static int hitungTotalHarga28(int pilihanMenu, int banyakItem) {
        int[] hargaItem = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal  = hargaItem[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        
        int diskon = 0;
        if (kodePromo.equals("DISKON50")) {
            diskon = total * 50 / 100;
        } else if (kodePromo.equals("DISKON30"))  {
            diskon = total * 30 / 100;
        } else {
            System.out.println("Kode promo invalid.");
        }

        if (isMember == true) {
            int hargaPromo  = total - diskon;
            diskon += hargaPromo * (10/100);
        }
        return diskon;
    }
}