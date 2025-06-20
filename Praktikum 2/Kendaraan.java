/* Program      : Kendaraan.java */
/* Deskripsi    : berisi atribut dan method dalam sebuah class Kendaraan*/
/* Nama / NIM   : Ananda Bagus Tri Utomo /24060122130091*/
/* Tanggal      : 24 Februari 2025 */

public class Kendaraan {
    private String noPlat, jenis;

    public Kendaraan() {}
    public Kendaraan(String noPlat, String jenis) {
        this.noPlat = noPlat;
        this.jenis = jenis;
    }

    public String getNoPlat() { return noPlat; }
    public void setNoPlat(String noPlat) { this.noPlat = noPlat; }
    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }
}
