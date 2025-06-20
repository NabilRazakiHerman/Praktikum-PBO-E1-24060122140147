/* Program      : MGaris.java */
/* Deskripsi    : Membuat objek Garis dan memanggil method yang telah dibuat dalam class Garis*/
/* Nama / NIM   : Ananda Bagus Tri Utomo /24060122130091*/
/* Tanggal      : 24 Februari 2025 */

public class MGaris {
    public static void main(String[] args) {
        Titik t1 = new Titik(1.0, 2.0);
        Titik t2 = new Titik(3.0, 4.0);

        Garis g = new Garis(t1, t2);
        
        System.out.println("Titik Awal: (" + g.getTitikAwal().getAbsis() + ", " + g.getTitikAwal().getOrdinat() + ")");
        System.out.println("Titik Akhir: (" + g.getTitikAkhir().getAbsis() + ", " + g.getTitikAkhir().getOrdinat() + ")");
    }
}

