abstract class Anabul {
    protected String nama;
    
    public Anabul(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public abstract void gerak();
    public abstract void bersuara();
}
class Kucing extends Anabul {
    public Kucing(String nama) {
        super(nama);
    }
    
    @Override
    public void gerak() {
        System.out.println(nama + " bergerak dengan melata");
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " berbunyi: Meong!");
    }
}

class Anjing extends Anabul {
    public Anjing(String nama) {
        super(nama);
    }
    
    @Override
    public void gerak() {
        System.out.println(nama + " bergerak dengan melata");
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " berbunyi: Guk-guk!");
    }
}

class Burung extends Anabul {
    public Burung(String nama) {
        super(nama);
    }
    
    @Override
    public void gerak() {
        System.out.println(nama + " bergerak dengan terbang");
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " berbunyi: Cuit!");
    }
}

class Datum<T> {
    private T isi;
    
    public Datum() {
        this.isi = null;
    }
    
    public Datum(T isi) {
        this.isi = isi;
    }
    
    public T getIsi() {
        return isi;
    }
    
    public void setIsi(T isi) {
        this.isi = isi;
    }
    
    public void tampilkanInfo() {
        if (isi != null) {
            System.out.println("Datum berisi: " + isi.toString());
            if (isi instanceof Anabul) {
                Anabul anabul = (Anabul) isi;
                anabul.bersuara();
                anabul.gerak();
            }
        } else {
            System.out.println("Datum kosong");
        }
    }
}

class ContohMetodeGenerik {
    
    public static <T> void tampilkanDatum(Datum<T> datum) {
        System.out.println("=== Menampilkan Datum ===");
        datum.tampilkanInfo();
        System.out.println();
    }
    
    public static <T> void pindahkanDatum(Datum<T> sumber, Datum<T> tujuan) {
        System.out.println("=== Memindahkan Datum ===");
        System.out.println("Sebelum pemindahan:");
        System.out.print("Sumber: ");
        sumber.tampilkanInfo();
        System.out.print("Tujuan: ");
        tujuan.tampilkanInfo();
        
        tujuan.setIsi(sumber.getIsi());
        sumber.setIsi(null);
        
        System.out.println("Setelah pemindahan:");
        System.out.print("Sumber: ");
        sumber.tampilkanInfo();
        System.out.print("Tujuan: ");
        tujuan.tampilkanInfo();
        System.out.println();
    }
    
    public static <T> void bandingkanDatum(Datum<T> datum1, Datum<T> datum2) {
        System.out.println("=== Membandingkan Datum ===");
        T isi1 = datum1.getIsi();
        T isi2 = datum2.getIsi();
        
        if (isi1 == null && isi2 == null) {
            System.out.println("Kedua datum kosong");
        } else if (isi1 == null) {
            System.out.println("Datum pertama kosong, datum kedua berisi");
        } else if (isi2 == null) {
            System.out.println("Datum kedua kosong, datum pertama berisi");
        } else {
            System.out.println("Kedua datum berisi");
            if (isi1.getClass().equals(isi2.getClass())) {
                System.out.println("Kedua datum memiliki tipe yang sama: " + isi1.getClass().getSimpleName());
            } else {
                System.out.println("Kedua datum memiliki tipe yang berbeda");
            }
        }
        System.out.println();
    }
    
    public static <T extends Anabul> void lakukanAksiAnabul(Datum<T> datum) {
        System.out.println("=== Melakukan Aksi Anabul ===");
        T anabul = datum.getIsi();
        if (anabul != null) {
            System.out.println("Mengaktifkan " + anabul.getNama() + ":");
            anabul.bersuara();
            anabul.gerak();
        } else {
            System.out.println("Tidak ada anabul dalam datum");
        }
        System.out.println();
    }
}

public class MainProgram {
    public static void main(String[] args) {
        System.out.println("=== TUGAS PRAKTIKUM PBO TOPIK GENERIK ===\n");
        
        Kucing kucing = new Kucing("Kitty");
        Anjing anjing = new Anjing("Buddy");
        Burung burung = new Burung("Tweety");
        
        System.out.println("1. DEMONSTRASI KELAS DASAR ANABUL");
        System.out.println("==================================");
        kucing.bersuara();
        kucing.gerak();
        System.out.println();
        
        anjing.bersuara();
        anjing.gerak();
        System.out.println();
        
        burung.bersuara();
        burung.gerak();
        System.out.println();
        
        System.out.println("2. DEMONSTRASI KELAS GENERIK DATUM");
        System.out.println("==================================");
        
        Datum<Kucing> datumKucing = new Datum<>(kucing);
        Datum<Anjing> datumAnjing = new Datum<>(anjing);
        Datum<Burung> datumBurung = new Datum<>(burung);
        Datum<String> datumString = new Datum<>("Hello World");
        Datum<Integer> datumInteger = new Datum<>(42);
        
        datumKucing.tampilkanInfo();
        System.out.println();
        
        datumAnjing.tampilkanInfo();
        System.out.println();
        
        datumBurung.tampilkanInfo();
        System.out.println();
        
        datumString.tampilkanInfo();
        System.out.println();
        
        datumInteger.tampilkanInfo();
        System.out.println();
        
        System.out.println("3. DEMONSTRASI KELAS CONTOHMETODEGENERIK");
        System.out.println("========================================");
        
        ContohMetodeGenerik.tampilkanDatum(datumKucing);
        ContohMetodeGenerik.tampilkanDatum(datumAnjing);
        
        Datum<Kucing> datumKosong = new Datum<>();
        ContohMetodeGenerik.pindahkanDatum(datumKucing, datumKosong);
        
        ContohMetodeGenerik.bandingkanDatum(datumAnjing, datumBurung);
        ContohMetodeGenerik.bandingkanDatum(datumString, datumInteger);
        
        ContohMetodeGenerik.lakukanAksiAnabul(datumAnjing);
        ContohMetodeGenerik.lakukanAksiAnabul(datumBurung);
        
        System.out.println("4. DEMONSTRASI PENGGUNAAN LANJUTAN");
        System.out.println("==================================");
        
        Datum<Anabul> datumAnabul = new Datum<>();
        System.out.println("Datum anabul awal:");
        datumAnabul.tampilkanInfo();
        System.out.println();
        
        datumAnabul.setIsi(new Kucing("Garfield"));
        System.out.println("Setelah diisi dengan kucing:");
        datumAnabul.tampilkanInfo();
        System.out.println();
        
        datumAnabul.setIsi(new Anjing("Snoopy"));
        System.out.println("Setelah diisi dengan anjing:");
        datumAnabul.tampilkanInfo();
        System.out.println();
        
        datumAnabul.setIsi(new Burung("Polly"));
        System.out.println("Setelah diisi dengan burung:");
        datumAnabul.tampilkanInfo();
        
        System.out.println("=== PROGRAM SELESAI ===");
    }
}