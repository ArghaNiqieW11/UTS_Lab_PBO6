package jawaban2;

public class Kendaraan {
    private String jenisKendaraan;
    private int durasiParkir;
    private double totalBiaya;

    // Constructor menerima parameter jenis kendaraan
    public Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    // Method Overloading 1: Menghitung biaya jika durasi diinput manual
    public void hitungBiaya(int durasi) {
        this.durasiParkir = durasi;
        kalkulasiTotal();
    }

    // Method Overloading 2: Menghitung biaya berdasarkan jam masuk dan jam keluar
    public void hitungBiaya(int jamMasuk, int jamKeluar) {
        if (jamKeluar >= jamMasuk) {
            this.durasiParkir = jamKeluar - jamMasuk;
        } else {
            // Jika jam keluar melewati tengah malam (opsional untuk keamanan logika)
            this.durasiParkir = (24 - jamMasuk) + jamKeluar;
        }
        kalkulasiTotal();
    }

    // Method private untuk menghitung total biaya dan diskon
    private void kalkulasiTotal() {
        double tarifPerJam = 0;

        if (jenisKendaraan.equalsIgnoreCase("Motor")) {
            tarifPerJam = 2000;
        } else if (jenisKendaraan.equalsIgnoreCase("Mobil")) {
            tarifPerJam = 5000;
        } else if (jenisKendaraan.equalsIgnoreCase("Truk")) {
            tarifPerJam = 10000;
        }

        double biayaAwal = durasiParkir * tarifPerJam;

        // Diskon 10% jika durasi parkir > 5 jam
        if (durasiParkir > 5) {
            biayaAwal = biayaAwal - (biayaAwal * 0.10);
        }

        this.totalBiaya = biayaAwal;
    }

    // Menampilkan ringkasan data kendaraan
    public void tampilkanRingkasan() {
        System.out.println("---- PARKING SUMMARY ----");
        System.out.println("Vehicle Type   : " + jenisKendaraan);
        System.out.println("Parking Time   : " + durasiParkir + " hour(s)");
        System.out.println("Total Fee      : Rp" + totalBiaya);
    }

    // Getter untuk total biaya (digunakan untuk report final)
    public double getTotalBiaya() {
        return totalBiaya;
    }
}