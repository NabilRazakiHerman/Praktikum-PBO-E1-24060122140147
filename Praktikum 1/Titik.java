/* Program      : Titik.java */
/* Deskripsi    : beris atribut dan method dalam sebuah class Titik*/
/* Nama / NIM   : Ananda Bagus Tri Utomo /24060122130091*/
/* Tanggal      : 24 Februari 2025 */

public class Titik {
    private double absis;
    private double ordinat;
    private static int counterTitik = 0;

    // Konstruktor //
    public Titik(double absis, double ordinat) {
        this.absis = absis;
        this.ordinat = ordinat;
        counterTitik++;
    }

    // Getter absis //
    public double getAbsis() {
        return absis;
    }

    // Setter absis //
    public void setAbsis(double absis) {
        this.absis = absis;
    }

    // Getter ordinat //
    public double getOrdinat() {
        return ordinat;
    }

    // Setter ordinat //
    public void setOrdinat(double ordinat) {
        this.ordinat = ordinat;
    }

    // Getter objek Titik//
    public static int getCounterTitik() {
        return counterTitik;
    }
}
