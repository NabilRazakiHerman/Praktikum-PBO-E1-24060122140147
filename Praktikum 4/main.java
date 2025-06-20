 import java.time.LocalDate;

 public class main {
     public static void main(String[] args) {
         // Create sample employees
         DosenTetap dosenTetap = new DosenTetap(
             "9545647548", 
             "78647324", 
             "Andi", 
             LocalDate.of(1990, 5, 5), 
             LocalDate.of(2015, 1, 1), 
             5000000, 
             "Fakultas Sains dan Matematika"
         );
         
         DosenTamu dosenTamu = new DosenTamu(
             "8456345634", 
             "85634567", 
             "Budi", 
             LocalDate.of(1985, 8, 10), 
             LocalDate.of(2020, 7, 1), 
             4500000, 
             "Fakultas Ekonomi dan Bisnis",
             LocalDate.of(2026, 6, 30)
         );
         
         Tendik tendik = new Tendik(
             "7654567456", 
             "Citra", 
             LocalDate.of(1995, 3, 15), 
             LocalDate.of(2018, 4, 1), 
             3500000, 
             "Akademik"
         );
         
         // Print information for each employee
         System.out.println("=== INFORMASI DOSEN TETAP ===");
         dosenTetap.printInfo();
         
         System.out.println("\n=== INFORMASI DOSEN TAMU ===");
         dosenTamu.printInfo();
         
         System.out.println("\n=== INFORMASI TENAGA KEPENDIDIKAN ===");
         tendik.printInfo();
     }
 }