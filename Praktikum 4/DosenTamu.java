 import java.time.LocalDate;
 import java.time.Period;
 
 public class DosenTamu extends Dosen {
     private String nidk;
     private LocalDate tanggalBerakhirKontrak;
     private static final double PERSENTASE_TUNJANGAN = 0.025; // 2.5%
     
     public DosenTamu(String nip, String nidk, String nama, LocalDate tanggalLahir, 
                      LocalDate tmt, double gajiPokok, String fakultas, LocalDate tanggalBerakhirKontrak) {
         super(nip, nama, tanggalLahir, tmt, gajiPokok, fakultas);
         this.nidk = nidk;
         this.tanggalBerakhirKontrak = tanggalBerakhirKontrak;
     }
     
     // Menghitung sisa masa kontrak
     private Period hitungSisaMasaKontrak() {
         return Period.between(LocalDate.now(), tanggalBerakhirKontrak);
     }
     
     // Menampilkan sisa masa kontrak dalam format ... tahun ... bulan
     private String getSisaMasaKontrakString() {
         Period sisaMasaKontrak = hitungSisaMasaKontrak();
         return sisaMasaKontrak.getYears() + " tahun " + sisaMasaKontrak.getMonths() + " bulan";
     }
     
     @Override
     public void printInfo() {
         printInfoDasar();
         System.out.println("NIDK           : " + nidk);
         System.out.println("Jabatan            : Dosen Tamu");
         System.out.println("Fakultas           : " + fakultas);
         System.out.println("Masa Kerja         : " + getMasaKerjaString());
         System.out.println("Kontrak Berakhir   : " + formatTanggal(tanggalBerakhirKontrak));
         System.out.println("Sisa Masa Kontrak  : " + getSisaMasaKontrakString());
         System.out.println("Gaji Pokok         : Rp " + String.format("%,.2f", gajiPokok));
         
         double tunjangan = PERSENTASE_TUNJANGAN * gajiPokok;
         System.out.println("Tunjangan          : " + String.format("%.1f%%", PERSENTASE_TUNJANGAN * 100) + 
                            " x Rp " + String.format("%,.2f", gajiPokok) + 
                            " = Rp. " + String.format("%,.2f", tunjangan));
     }
 }