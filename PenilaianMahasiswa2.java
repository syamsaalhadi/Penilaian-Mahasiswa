import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String NIM;
    String nama;
    String namaMK;
    int tugas;
    int UTS;
    int UAS;
    double nilaiAkhir;
    String nilaiHuruf;

    void hitungNilaiAkhir() {
        this.nilaiAkhir = 0.4 * tugas + 0.3 * UTS + 0.3 * UAS;
        this.nilaiHuruf = hitungNilaiHuruf(nilaiAkhir);
    }

    String hitungNilaiHuruf(double nilai) {
        if (nilai >= 80) {
            return "A";
        } else if (nilai >= 75) {
            return "AB";
        } else if (nilai >= 65) {
            return "B";
        } else if (nilai >= 60) {
            return "BC";
        } else if (nilai >= 56) {
            return "C";
        } else if (nilai >= 45) {
            return "D";
        } else {
            return "E";
        }
    }
}

public class PenilaianMahasiswa2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("======================");
            System.out.println("Program Penilaian Mahasiswa");
            System.out.println("======================");
            System.out.println("1. Input Data Nilai Mahasiswa");
            System.out.println("2. Data Nilai Akhir dan Huruf Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan no pilihan menu anda (1-3): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    System.out.println("======================");
                    System.out.println("Input Data Nilai Mahasiswa");
                    System.out.println("======================");
                    while (true) {
                        Mahasiswa mhs = new Mahasiswa();
                        System.out.print("NIM: ");
                        mhs.NIM = scanner.nextLine();
                        System.out.print("Nama: ");
                        mhs.nama = scanner.nextLine();
                        System.out.print("Nama MK: ");
                        mhs.namaMK = scanner.nextLine();
                        System.out.print("Tugas: ");
                        mhs.tugas = scanner.nextInt();
                        System.out.print("UTS: ");
                        mhs.UTS = scanner.nextInt();
                        System.out.print("UAS: ");
                        mhs.UAS = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        mhs.hitungNilaiAkhir();
                        daftarMahasiswa.add(mhs);

                        System.out.print("Apakah Anda ingin menambahkan data lagi? (y/n): ");
                        String tambahLagi = scanner.nextLine();
                        if (tambahLagi.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("=================");
                    System.out.println("Data Nilai Mahasiswa");
                    System.out.println("=================");
                    for (int i = 0; i < daftarMahasiswa.size(); i++) {
                        Mahasiswa mhs = daftarMahasiswa.get(i);
                        System.out.println((i + 1) + ".");
                        System.out.println("NIM: " + mhs.NIM);
                        System.out.println("Nama: " + mhs.nama);
                        System.out.println("Nama MK: " + mhs.namaMK);
                        System.out.println("Nilai Akhir: " + mhs.nilaiAkhir);
                        System.out.println("Nilai Huruf: " + mhs.nilaiHuruf);
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 3);

        scanner.close();
    }
}
