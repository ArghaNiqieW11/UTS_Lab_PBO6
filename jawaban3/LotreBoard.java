package jawaban3;

import java.util.Random;

public class LotreBoard {
    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;

    // Konstanta ukuran papan sesuai soal
    private final int ROWS = 4;
    private final int COLS = 5;
    private final int TOTAL_BOMBS = 2;
    private final int TOTAL_SAFE = 18;

    public LotreBoard() {
        board = new char[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];
        data = new int[ROWS][COLS];

        // Inisialisasi awal papan
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '*';      // Papan tertutup
                revealed[i][j] = false; // Belum ada yang dibuka
                data[i][j] = 0;         // Default 0 = kotak aman
            }
        }
    }

    // Menghasilkan papan dengan 2 bom di posisi acak
    public void generateBoard() {
        Random rand = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced < TOTAL_BOMBS) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);

            // Jika kotak tersebut belum ada bom, letakkan bom (1 = bom)
            if (data[r][c] == 0) {
                data[r][c] = 1;
                bombsPlaced++;
            }
        }
    }

    // Menampilkan papan saat ini ke layar
    public void displayBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // Pindah baris
        }
    }

    // Memproses tebakan pemain
    public boolean guess(int row, int col) {
        // Validasi jika input di luar jangkauan papan
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Tebakan di luar batas papan!");
            return true; // Return true agar permainan tidak berakhir karena typo
        }

        // Jika kotak sudah pernah dibuka
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            System.out.println("Kotak Aman");
            return true;
        }

        // Tandai kotak sudah dibuka
        revealed[row][col] = true;

        // Cek isi kotak (Bom atau Aman)
        if (data[row][col] == 1) { // 1 adalah bom
            board[row][col] = 'X';
            return false; // Mengembalikan false yang artinya kena bom
        } else {
            board[row][col] = '0'; // Menggunakan angka '0' sesuai contoh di PDF
            System.out.println("Kotak Aman");
            return true;
        }
    }

    // Mengecek apakah permainan selesai
    public boolean isGameOver() {
        int safeRevealedCount = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                // Jika ada bom yang tidak sengaja terbuka
                if (revealed[i][j] && data[i][j] == 1) {
                    return true;
                }
                // Hitung berapa kotak aman yang sudah terbuka
                if (revealed[i][j] && data[i][j] == 0) {
                    safeRevealedCount++;
                }
            }
        }

        // Permainan juga selesai jika semua 18 kotak aman berhasil dibuka
        return safeRevealedCount == TOTAL_SAFE;
    }
}