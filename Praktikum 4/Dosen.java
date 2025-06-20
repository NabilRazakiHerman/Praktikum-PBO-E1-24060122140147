import java.time.LocalDate;

 public abstract class Dosen extends Pegawai {
     protected String fakultas;
     
     public Dosen(String nip, String nama, LocalDate tanggalLahir, LocalDate tmt, double gajiPokok, String fakultas) {
         super(nip, nama, tanggalLahir, tmt, gajiPokok);
         this.fakultas = fakultas;
     }
     
     // Method yang akan di-override oleh subclass
     @Override
     public abstract void printInfo();
 }