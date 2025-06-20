import java.util.*;

public class LambdaCollectionDemo {
    public static void main(String[] args) {
        List<String> daftarNama = Arrays.asList("Andi", "Budi", "Cici", "Deni");

        daftarNama.forEach(nama -> System.out.println("Nama: " + nama));

        daftarNama.sort((a, b) -> a.length() - b.length());

        System.out.println("\nSetelah sorting berdasarkan panjang:");
        daftarNama.forEach(System.out::println);
    }
}
