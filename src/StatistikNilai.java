import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {
    // Ketentuan 2: Menggunakan sentinel static final
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Ketentuan 1 & 9: Menggunakan ArrayList<Integer>
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        // Perbaikan 4: Variabel diganti menjadi nilaiDiketik agar tidak
        // membingungkan/rancu dengan fungsi scanner sebagai penginput
        int nilaiDiketik;

        // Ketentuan 2: Menggunakan do-while
        do {
            // Ketentuan 1: Nomor diambil dari size() + 1
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilaiDiketik = scanner.nextInt();

            if (nilaiDiketik == SELESAI) {
                break;
            }

            // Ketentuan 3: Nilai di luar 0-100 ditolak dengan continue
            if (nilaiDiketik < 0 || nilaiDiketik > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue; // Melewati tahap .add dan kembali ke awal loop
            }

            daftar.add(nilaiDiketik);

        } while (nilaiDiketik != SELESAI);

        System.out.println();

        // Ketentuan 8: Jaga kasus tidak ada nilai sah (jika langsung ketik -1)
        if (daftar.isEmpty()) {
            System.out.println("Tidak ada data nilai yang dimasukkan.");
            return; // Hentikan program agar tidak terjadi error / Exception
        }

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        // Hitung total untuk rata-rata
        double total = 0;

        // Ketentuan 4: Tertinggi dan terendah dicari dengan loop sendiri
        // Perbaikan 3: Keduanya dimulai dari elemen pertama (index 0), yang pada contoh nilainya adalah 85.
        // Alasan: Memastikan nilai awal adalah data riil dari dalam daftar itu sendiri,
        // bukan angka asumsi seperti 0 atau 100 yang berpotensi tidak pernah tergantikan.
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);

        for (int nilai : daftar) {
            total += nilai;
            if (nilai > tertinggi) {
                tertinggi = nilai;
            }
            if (nilai < terendah) {
                terendah = nilai;
            }
        }

        double rataRata = total / daftar.size();

        // Ketentuan 10 & Perbaikan 1: printf memakai locale bawaan sistem laptop.
        // Karena laptop ber-locale Indonesia, format %.2f otomatis menggunakan koma.
        // Perbaikan 2: Menggunakan %n alih-alih \n agar baris baru aman (cross-platform).
        System.out.printf("Rata-rata       : %.2f%n", rataRata);
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);

        // Ketentuan 5: Jumlah di atas rata-rata dihitung di putaran kedua
        // Alasan: Karena rata-rata keseluruhan (total kelas) belum bisa
        // diketahui jika nilai belum selesai dimasukkan semua.
        int diAtasRata = 0;
        for (int nilai : daftar) {
            if (nilai > rataRata) {
                diAtasRata++;
            }
        }
        System.out.println("Di atas rata2   : " + diAtasRata + " orang");

        // Ketentuan 6: Distribusi grade
        // Index: 0 untuk A(90-100), 1 untuk B(80-89), 2 untuk C(70-79), 3 untuk D(60-69), 4 untuk E(<60)
        int[] jumlahGrade = new int[5];
        for (int nilai : daftar) {
            if (nilai >= 90) jumlahGrade[0]++;
            else if (nilai >= 80) jumlahGrade[1]++;
            else if (nilai >= 70) jumlahGrade[2]++;
            else if (nilai >= 60) jumlahGrade[3]++;
            else jumlahGrade[4]++;
        }

        System.out.print("Distribusi      : ");
        // Ketentuan 6 & 8: Cetak dengan loop & batas loop i < panjang
        char namaGrade = 'A';
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print((char)(namaGrade + i) + "=" + jumlahGrade[i] + " ");
        }
        System.out.println();

        // Ketentuan 7: Daftar terurut dibuat dari salinan
        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);
        System.out.println("Terurut         : " + terurut);
        System.out.println("Urutan asli     : " + daftar);
    }
}