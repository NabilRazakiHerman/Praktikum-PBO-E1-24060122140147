/* Program      : Dosen.java */
/* Deskripsi    : berisi atribut dan method dalam sebuah class Dosen*/
/* Nama / NIM   : Ananda Bagus Tri Utomo /24060122130091*/
/* Tanggal      : 24 Februari 2025 */

public class Dosen {
    private String nip, nama, prodi;

    public Dosen() {}
    public Dosen(String nip, String nama, String prodi) {
        this.nip = nip;
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNip() { return nip; }
    public void setNip(String nip) { this.nip = nip; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }
}
