
 import java.time.LocalDate;

 public class DosenTetap extends Dosen {
     private String nidn;
     private static final int BUP = 65; // Batas Usia Pensiun
     private static final double PERSENTASE_TUNJANGAN = 0.02; // 2%
     
     public DosenTetap(String nip, String nidn, String nama, LocalDate tanggalLahir, 
                       LocalDate tmt, double gajiPokok, String fakultas) {
         super(nip, nama, tanggalLahir, tmt, gajiPokok, fakultas);
         this.nidn = nidn;
     }
     
     @Override
     public void printInfo() {
         printInfoDasar();
         System.out.println("NIDN           : " + nidn);
         System.out.println("Jabatan        : Dosen Tetap");
         System.out.println("Fakultas       : " + fakultas);
         System.out.println("Masa Kerja     : " + getMasaKerjaString());
         System.out.println("BUP            : " + formatTanggal(hitungBUP(BUP)));
         System.out.println("Gaji Pokok     : Rp " + String.format("%,.2f", gajiPokok));
         
         double tunjangan = hitungTunjangan(PERSENTASE_TUNJANGAN);
         System.out.println("Tunjangan      : " + String.format("%.0f%%", PERSENTASE_TUNJANGAN * 100) + 
                            " x " + hitungMasaKerja().getYears() + " x Rp " + 
                            String.format("%,.2f", gajiPokok) + " = Rp. " + 
                            String.format("%,.2f", tunjangan));
     }
 }