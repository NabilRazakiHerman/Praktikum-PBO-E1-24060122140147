/* Program      : Garis.java */
/* Deskripsi    : beris atribut dan method dalam sebuah class Titik dan cl*/
/* Nama / NIM   : Ananda Bagus Tri Utomo /24060122130091*/
/* Tanggal      : 24 Februari 2025 */

public class Garis {
    private Titik titikAwal;
    private Titik titikAkhir;

    public Garis(Titik titikAwal, Titik titikAkhir) {
        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;
    }

    public Titik getTitikAwal() {
        return titikAwal;
    }

    public void setTitikAwal(Titik titikAwal) {
        this.titikAwal = titikAwal;
    }

    public Titik getTitikAkhir() {
        return titikAkhir; 
    }

    public void setTitikAkhir(Titik titikAkhir) {
        this.titikAkhir = titikAkhir; 
    }
}
