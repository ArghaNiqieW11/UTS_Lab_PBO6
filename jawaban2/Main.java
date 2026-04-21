package jawaban2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lanjut = " ";
        int totalKendaraan = 0;
        double totalSemuaBiaya = 0;

        System.out.println("======== Welcome to ParkArgha ========");

        do {
            System.out.print("Enter vehicle type (Motor/Mobil/Truk): ");
            String jenis = scanner.next();

            // Membuat objek Kendaraan
            Kendaraan kendaraan = new Kendaraan(jenis);

            System.out.print("Enter Duration (Manual/Time): ");
            String tipeDurasi = scanner.next();

            if (tipeDurasi.equalsIgnoreCase("Manual")) {
                System.out.print("Enter Duration (in hour): ");
                int durasi = scanner.nextInt();
                // Memanggil method hitungBiaya() untuk durasi manual
                kendaraan.hitungBiaya(durasi);
            } else if (tipeDurasi.equalsIgnoreCase("Time")) {
                System.out.print("Enter entry time: ");
                int masuk = scanner.nextInt();
                System.out.print("Enter exit time : ");
                int keluar = scanner.nextInt();
                // Memanggil method hitungBiaya() menggunakan overloading jam
                kendaraan.hitungBiaya(masuk, keluar);
            } else {
                System.out.println("Pilihan tidak valid.");
                continue; // Mengulang loop jika input salah
            }

            // Menampilkan ringkasan per kendaraan
            kendaraan.tampilkanRingkasan();

            // Menambahkan data ke rekapitulasi akhir
            totalKendaraan++;
            totalSemuaBiaya += kendaraan.getTotalBiaya();

            System.out.print("Add another vehicle? (y/n): ");
            lanjut = scanner.next();

        } while (lanjut.equalsIgnoreCase("y")); // Perulangan akan terus berjalan jika 'y'

        // Menampilkan hasil akhir
        System.out.println("==== FINAL REPORT ====");
        System.out.println("Total Vehicle Final      : " + totalKendaraan);
        System.out.println("Total Parking Fees Final : " + totalSemuaBiaya);
        System.out.println("Thank You.....");

        scanner.close();
    }
}