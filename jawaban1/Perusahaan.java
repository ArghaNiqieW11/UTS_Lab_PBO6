package jawaban1;

import java.util.ArrayList;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan;

    public Perusahaan() {
        daftarKaryawan = new ArrayList<>();
    }

    // Metode pembantu (helper) untuk mencari karyawan berdasarkan ID
    private Karyawan cariKaryawan(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                return k; // Karyawan ditemukan
            }
        }
        return null; // Karyawan tidak ditemukan
    }

    // 1. Menambahkan Karyawan
    public void tambahKaryawan(Karyawan karyawanBaru) {
        // Validasi ID duplikat
        if (cariKaryawan(karyawanBaru.getId()) != null) {
            System.out.println("Gagal: ID Karyawan sudah terdaftar.");
            return;
        }
        // Validasi gaji negatif
        if (karyawanBaru.getGaji() < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif.");
            return;
        }

        daftarKaryawan.add(karyawanBaru);
        System.out.println("Karyawan berhasil ditambahkan.");
    }

    // 2. Menghapus Karyawan
    public void hapusKaryawan(String id) {
        Karyawan k = cariKaryawan(id);
        // Validasi ID harus ada di daftar
        if (k != null) {
            daftarKaryawan.remove(k);
            System.out.println("Karyawan berhasil dihapus.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    // 3. Mengubah Posisi Karyawan
    public void ubahPosisi(String id, String posisiBaru) {
        Karyawan k = cariKaryawan(id);
        if (k != null) {
            k.setPosisi(posisiBaru);
            System.out.println("Posisi berhasil diubah.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    // 4. Mengubah Gaji Karyawan
    public void ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif.");
            return;
        }

        Karyawan k = cariKaryawan(id);
        if (k != null) {
            k.setGaji(gajiBaru);
            System.out.println("Gaji berhasil diubah.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    // 5. Menampilkan Semua Karyawan
    public void tampilkanSemuaKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Daftar karyawan saat ini kosong.");
        } else {
            for (Karyawan k : daftarKaryawan) {
                System.out.println(k.toString());
            }
        }
    }
}