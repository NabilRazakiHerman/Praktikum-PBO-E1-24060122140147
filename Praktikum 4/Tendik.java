/**
 * File: Tendik.java
 * Description: Class for administrative staff, derived from Pegawai
 * Date: March 14, 2025
 */

 import java.time.LocalDate;

 public class Tendik extends Pegawai {
     private String bidang; // Akademik, Kemahasiswaan, atau Sumber Daya
     private static final int BUP = 55; // Batas Usia Pensiun
     private static final double PERSENTASE_TUNJANGAN = 0.01; // 1%
     
     public Tendik(String nip, String nama, LocalDate tanggalLahir, 
                   LocalDate tmt, double gajiPokok, String bidang) {
         super(nip, nama, tanggalLahir, tmt, gajiPokok);
         this.bidang = bidang;
     }
     
     @Override
     public void printInfo() {
         printInfoDasar();
         System.out.println("Jabatan    : Tenaga Kependidikan");
         System.out.println("Bidang     : " + bidang);
         System.out.println("Masa Kerja : " + getMasaKerjaString());
         System.out.println("BUP        : " + formatTanggal(hitungBUP(BUP)));
         System.out.println("Gaji Pokok : Rp " + String.format("%,.2f", gajiPokok));
         
         double tunjangan = hitungTunjangan(PERSENTASE_TUNJANGAN);
         System.out.println("Tunjangan : " + String.format("%.0f%%", PERSENTASE_TUNJANGAN * 100) + 
                            " x " + hitungMasaKerja().getYears() + " x Rp " + 
                            String.format("%,.2f", gajiPokok) + " = Rp. " + 
                            String.format("%,.2f", tunjangan));
     }
 }