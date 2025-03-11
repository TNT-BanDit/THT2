package THT2;
import java.util.*;

import Mahasiswa;

class Mahasiswa {
    String nama;
    String nim;
    int usia;
    int jumlahMataKuliah;
    double[] nilai;
    double ipk;
    int nomorAntrian;

    public Mahasiswa(String nama, String nim, int usia, int jumlahMataKuliah) {
        this.nama = nama;
        this.nim = nim;
        this.usia = usia;
        this.jumlahMataKuliah = jumlahMataKuliah;
        this.nilai = new double[jumlahMataKuliah];
    }

    public void inputNilai(Scanner scanner) {
        double total = 0;
        for (int i = 0; i < jumlahMataKuliah; i++) {
            System.out.print("Masukkan nilai untuk mata kuliah " + (i + 1) + ": ");
            nilai[i] = scanner.nextDouble();
            total += nilai[i];
        }
        double rataRata = total / jumlahMataKuliah;
        // Konversi rata-rata nilai (dengan asumsi nilai maksimal 100) ke skala 4.0
        this.ipk = (rataRata / 100.0) * 4.0;
    }

    public void evaluasiAkademik() {
        System.out.println("\nEvaluasi akademik untuk " + nama + ":");
        if (usia > 22) {
            System.out.println("- Mahasiswa berusia lebih dari 22 tahun.");
        }
        if (ipk >= 3.5 && jumlahMataKuliah > 4) {
            System.out.println("- Mahasiswa memiliki IPK >= 3.5 dan mengambil lebih dari 4 mata kuliah.");
        }
        if (ipk < 2.5 || jumlahMataKuliah < 4) {
            System.out.println("- Mahasiswa memiliki IPK < 2.5 atau mengambil kurang dari 4 mata kuliah.");
        }
    }

    public void tampilkanLaporan() {
        System.out.println("\nLaporan Akademik");
        System.out.println("Nama                : " + nama);
        System.out.println("NIM                 : " + nim);
        System.out.println("Usia                : " + usia);
        System.out.println("Jumlah Mata Kuliah  : " + jumlahMataKuliah);
        System.out.println("IPK                 : " + String.format("%.2f", ipk));
        System.out.println("Nomor Antrian       : " + nomorAntrian);
    }
}

public class SistemNilaiMahasiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nMasukkan data mahasiswa " + (i + 1) + ":");
            System.out.print("Nama               : ");
            String nama = scanner.nextLine();
            System.out.print("NIM                : ");
            String nim = scanner.nextLine();
            System.out.print("Usia               : ");
            int usia = scanner.nextInt();
            System.out.print("Jumlah mata kuliah : ");
            int jumlahMataKuliah = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            Mahasiswa mahasiswa = new Mahasiswa(nama, nim, usia, jumlahMataKuliah);
            mahasiswa.inputNilai(scanner);
            mahasiswa.nomorAntrian = random.nextInt(100) + 1;
            daftarMahasiswa.add(mahasiswa);
        }

        for (Mahasiswa mhs : daftarMahasiswa) {
            mhs.evaluasiAkademik();
            mhs.tampilkanLaporan();
        }

        scanner.close();
    }
}