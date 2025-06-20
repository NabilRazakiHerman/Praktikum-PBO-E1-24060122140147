import java.util.*;

public class MapLambdaDemo {
    public static void main(String[] args) {
        Map<String, String> dataMahasiswa = new HashMap<>();

        dataMahasiswa.put("24060121140147", "Nabil Razaki");
        dataMahasiswa.put("24060121140123", "Budi Santoso");
        dataMahasiswa.put("24060121140199", "Riefky Adiata");

        dataMahasiswa.forEach((nim, nama) -> {
            System.out.println("NIM: " + nim + " - Nama: " + nama);
        });
    }
}
