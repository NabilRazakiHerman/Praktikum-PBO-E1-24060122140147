/* Program      : Mahasiswa.java */
/* Deskripsi    : berisi atribut dan method dalam sebuah class Mahasiswa*/
/* Nama / NIM   : Ananda Bagus Tri Utomo /24060122130091*/
/* Tanggal      : 24 Februari 2025 */
public class Mahasiswa {
    private String nim, nama, prodi;
    private MataKuliah[] listMatKul = new MataKuliah[50];
    private Dosen dosenWali;
    private Kendaraan kendaraan;
    private int jumlahMatkul = 0;

    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public void setDosenWali(Dosen dosen) {
        this.dosenWali = dosen;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public void addMatKul(MataKuliah matkul) {
        if (jumlahMatkul < 50) {
            listMatKul[jumlahMatkul++] = matkul;
        }
    }

    public int getJumlahSKS() {
        int totalSKS = 0;
        for (int i = 0; i < jumlahMatkul; i++) {
            totalSKS += listMatKul[i].getSks();
        }
        return totalSKS;
    }

    public int getJumlahMatKul() {
        return jumlahMatkul;
    }

    public void printMhs() {
        System.out.println("NIM: " + nim + ", Nama: " + nama + ", Prodi: " + prodi);
    }

    public void printDetailMhs() {
        printMhs();
        System.out.println("Dosen Wali  : " + (dosenWali != null ? dosenWali.getNama() : "Tidak Ada"));
        System.out.println("Kendaraan   : " + (kendaraan != null ? kendaraan.getNoPlat() + " - " + kendaraan.getJenis() : "Tidak Ada"));
        System.out.println("Mata Kuliah yang diambil:");
        for (int i = 0; i < jumlahMatkul; i++) {
            System.out.println("  - " + listMatKul[i].getNama() + " (" + listMatKul[i].getSks() + " SKS)");
        }
        System.out.println("Total SKS =  " + getJumlahSKS());
    }
}
