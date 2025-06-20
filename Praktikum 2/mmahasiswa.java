/* Program      : mmahasiswa.java */
/* Deskripsi    : berisi atribut dan method dalam sebuah class Kendaraan*/
/* Nama / NIM   : Ananda Bagus Tri Utomo /24060122130091*/
/* Tanggal      : 24 Februari 2025 */

public class mmahasiswa {
    public static void main(String[] args){
        MataKuliah PBO = new MataKuliah("PBO", "Pemrograman Berorientasi Objek",3);
        MataKuliah MBD = new MataKuliah("MBD", "Manajemen Basis Data",3);
        Mahasiswa M1 = new Mahasiswa("234", "Citra", "Informatika");
        Dosen D1 = new Dosen("123", "Andi", "Informatika");
        Kendaraan K1 = new Kendaraan("H1234AB","Motor");
        M1.setDosenWali(D1);
        M1.setKendaraan(K1);
        M1.addMatKul(PBO);
        M1.addMatKul(MBD);
        M1.printDetailMhs();
        System.out.println("Jumlah Mata Kuliah = "+ M1.getJumlahMatKul());
        System.out.println("Jumlah SKS Mata Kuliah = " + M1.getJumlahSKS() );
    }
}