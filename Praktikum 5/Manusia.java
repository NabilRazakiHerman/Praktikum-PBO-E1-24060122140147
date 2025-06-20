import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Manusia {
    protected String nama;
    protected LocalDate tglMulaiKerja;
    protected String alamat;
    protected double pendapatan;
    protected static int counterMns = 0;
    
    public Manusia(String nama, String tglMulaiKerja, String alamat, double pendapatan) {
        this.nama = nama;
        this.tglMulaiKerja = LocalDate.parse(tglMulaiKerja);
        this.alamat = alamat;
        this.pendapatan = pendapatan;
        counterMns++;
    }

    public static int getCounterMns() {
        return counterMns;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public abstract double hitungPajak();

    public long hitungMasaKerja() {
        return ChronoUnit.YEARS.between(tglMulaiKerja, LocalDate.now());
    }

    public void cetakInfo() {
        System.out.println("Nama        : " + nama);
        System.out.println("Alamat      : " + alamat);
        System.out.println("Pendapatan  : " + pendapatan);
        System.out.println("Masa Kerja  : " + hitungMasaKerja());
    }
}

