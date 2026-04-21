package jawaban1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perusahaan perusahaan = new Perusahaan();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");

            // Mengamankan input jika user memasukkan huruf alih-alih angka
            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.next();
                System.out.print("Masukkan pilihan: ");
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membuang sisa baris baru (newline)

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Posisi: ");
                    String posisi = scanner.nextLine();
                    System.out.print("Masukkan Gaji: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Input tidak valid. Harap masukkan nominal angka.");
                        scanner.next();
                        System.out.print("Masukkan Gaji: ");
                    }
                    double gaji = scanner.nextDouble();
                    scanner.nextLine();

                    Karyawan karyawanBaru = new Karyawan(id, nama, posisi, gaji);
                    perusahaan.tambahKaryawan(karyawanBaru);
                    break;
                case 2:
                    System.out.print("Masukkan ID karyawan yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    perusahaan.hapusKaryawan(idHapus);
                    break;
                case 3:
                    System.out.print("Masukkan ID karyawan: ");
                    String idPosisi = scanner.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    String posisiBaru = scanner.nextLine();
                    perusahaan.ubahPosisi(idPosisi, posisiBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID karyawan: ");
                    String idGaji = scanner.nextLine();
                    System.out.print("Masukkan gaji baru: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Input tidak valid. Harap masukkan nominal angka.");
                        scanner.next();
                        System.out.print("Masukkan gaji baru: ");
                    }
                    double gajiBaru = scanner.nextDouble();
                    scanner.nextLine();

                    perusahaan.ubahGaji(idGaji, gajiBaru);
                    break;
                case 5:
                    perusahaan.tampilkanSemuaKaryawan();
                    break;
                case 6:
                    // Keluar dari sistem
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}