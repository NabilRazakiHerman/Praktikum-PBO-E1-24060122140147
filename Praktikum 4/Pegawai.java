 import java.time.LocalDate;
 import java.time.Period;
 import java.time.format.DateTimeFormatter;
 
 public abstract class Pegawai {
     protected String nip;
     protected String nama;
     protected LocalDate tanggalLahir;
     protected LocalDate tmt; // Terhitung Mulai Tanggal
     protected double gajiPokok;
     
     public Pegawai(String nip, String nama, LocalDate tanggalLahir, LocalDate tmt, double gajiPokok) {
         this.nip = nip;
         this.nama = nama;
         this.tanggalLahir = tanggalLahir;
         this.tmt = tmt;
         this.gajiPokok = gajiPokok;
     }
     
     // Format tanggal menjadi format yang diinginkan: 5 Mei 1990
     protected String formatTanggal(LocalDate tanggal) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
         return tanggal.format(formatter);
     }
     
     // Menghitung masa kerja dari TMT hingga sekarang
     protected Period hitungMasaKerja() {
         return Period.between(tmt, LocalDate.now());
     }
     
     // Menampilkan masa kerja dalam format ... tahun ... bulan
     protected String getMasaKerjaString() {
         Period masaKerja = hitungMasaKerja();
         return masaKerja.getYears() + " tahun " + masaKerja.getMonths() + " bulan";
     }
     
     // Menghitung BUP (tanggal 1 bulan berikutnya dari tanggal lahir ditambah usia BUP)
     protected LocalDate hitungBUP(int usiaBUP) {
         LocalDate bupDate = tanggalLahir.plusYears(usiaBUP);
         return LocalDate.of(bupDate.getYear(), bupDate.getMonth().plus(1), 1);
     }
     
     // Menghitung tunjangan berdasarkan persentase dan masa kerja
     protected double hitungTunjangan(double persentase) {
         return persentase * hitungMasaKerja().getYears() * gajiPokok;
     }
     
     // Method yang akan di-override oleh subclass
     public abstract void printInfo();
     
     // Method umum untuk print data dasar
     protected void printInfoDasar() {
         System.out.println("NIP            : " + nip);
         System.out.println("Nama           : " + nama);
         System.out.println("TTL            : " + formatTanggal(tanggalLahir));
         System.out.println("TMT            : " + formatTanggal(tmt));
     }
 }