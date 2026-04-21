package jawaban3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard game = new LotreBoard();

        System.out.println("Welcome to E-Lottery Gosok");
        game.generateBoard();
        game.displayBoard();

        boolean isSafe = true;

        // Loop berjalan terus selama status game belum over
        while (!game.isGameOver()) {
            System.out.print("\nMasukkan tebakan anda (baris dan kolom) : ");

            // Validasi sederhana memastikan input berupa angka
            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.next();
            }
            int row = scanner.nextInt();

            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.next();
            }
            int col = scanner.nextInt();

            // Panggil method guess dan simpan kembaliannya (true jika aman, false jika bom)
            isSafe = game.guess(row, col);

            if (!isSafe) {
                // Kondisi jika terkena bom
                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                game.displayBoard();
                break; // Hentikan loop
            } else {
                // Kondisi jika tebakan aman
                if (game.isGameOver()) {
                    // Jika game over tanpa terkena bom, berarti pemain menang
                    System.out.println("Selamat anda menang");
                    game.displayBoard();
                    break;
                } else {
                    // Permainan masih berlanjut
                    game.displayBoard();
                }
            }
        }

        scanner.close();
    }
}