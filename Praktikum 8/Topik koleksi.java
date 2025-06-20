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
    public abstract double getLuas();
    public abstract double getKeliling();
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
    
    @Override
    public double getLuas() {
        return 0.0;
    }
    
    @Override
    public double getKeliling() {
        return 0.0;
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
    
    @Override
    public double getLuas() {
        return 0.0;
    }
    
    @Override
    public double getKeliling() {
        return 0.0;
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
    
    @Override
    public double getLuas() {
        return 0.0;
    }
    
    @Override
    public double getKeliling() {
        return 0.0;
    }
}

abstract class BangunDatarGenerik<T extends BangunDatarGenerik<T>> {
    public abstract double getLuas();
    public abstract double getKeliling();
    public abstract void tampilkanInfo();
}

class Persegi extends BangunDatarGenerik<Persegi> {
    private double sisi;
    
    public Persegi(double sisi) {
        this.sisi = sisi;
    }
    
    @Override
    public double getLuas() {
        return sisi * sisi;
    }
    
    @Override
    public double getKeliling() {
        return 4 * sisi;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Persegi dengan sisi: " + sisi);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
    }
    
    public double getSisi() {
        return sisi;
    }
}

class Persegipanjang extends BangunDatarGenerik<Persegipanjang> {
    private double panjang;
    private double lebar;
    
    public Persegipanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }
    
    @Override
    public double getLuas() {
        return panjang * lebar;
    }
    
    @Override
    public double getKeliling() {
        return 2 * (panjang + lebar);
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Persegi Panjang dengan panjang: " + panjang + ", lebar: " + lebar);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
    }
    
    public double getPanjang() {
        return panjang;
    }
    
    public double getLebar() {
        return lebar;
    }
}

class Segitiga extends BangunDatarGenerik<Segitiga> {
    private double alas;
    private double tinggi;
    private double sisiA, sisiB, sisiC;
    
    public Segitiga(double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }
    
    @Override
    public double getLuas() {
        return 0.5 * alas * tinggi;
    }
    
    @Override
    public double getKeliling() {
        return sisiA + sisiB + sisiC;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Segitiga dengan alas: " + alas + ", tinggi: " + tinggi);
        System.out.println("Sisi-sisi: " + sisiA + ", " + sisiB + ", " + sisiC);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
    }
    
    public double getAlas() {
        return alas;
    }
    
    public double getTinggi() {
        return tinggi;
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

class Koleksi<T> {
    private Object[] wadah;
    private int nbelm;
    private int maxSize;
    
    public Koleksi(int maxSize) {
        this.maxSize = maxSize;
        this.wadah = new Object[maxSize];
        this.nbelm = 0;
    }
    
    @SuppressWarnings("unchecked")
    public T getIsi(int index) {
        if (index >= 0 && index < nbelm) {
            return (T) wadah[index];
        }
        return null;
    }
    
    public void setIsi(int index, T nilai) {
        if (index >= 0 && index < nbelm) {
            wadah[index] = nilai;
        }
    }
    
    public int getSize() {
        return nbelm;
    }
    
    public void setSize(int size) {
        if (size >= 0 && size <= maxSize) {
            this.nbelm = size;
        }
    }
    
    public void add(T elemen) {
        if (nbelm < maxSize) {
            wadah[nbelm] = elemen;
            nbelm++;
        } else {
            System.out.println("Koleksi penuh!");
        }
    }
    
    public void delete(int index) {
        if (index >= 0 && index < nbelm) {
            for (int i = index; i < nbelm - 1; i++) {
                wadah[i] = wadah[i + 1];
            }
            wadah[nbelm - 1] = null;
            nbelm--;
        }
    }
    
    public void showAll() {
        System.out.println("=== Menampilkan Semua Elemen Koleksi ===");
        System.out.println("Jumlah elemen: " + nbelm);
        for (int i = 0; i < nbelm; i++) {
            System.out.println("Elemen ke-" + (i + 1) + ":");
            @SuppressWarnings("unchecked")
            T elemen = (T) wadah[i];
            if (elemen instanceof Anabul) {
                Anabul anabul = (Anabul) elemen;
                System.out.println("Nama: " + anabul.getNama());
                anabul.bersuara();
                anabul.gerak();
            } else {
                System.out.println(elemen.toString());
            }
            System.out.println();
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
        System.out.println("=== TUGAS PRAKTIKUM PBO - COLLECTION & GENERIC ===\n");
        
        System.out.println("1. DEMONSTRASI KELAS ANABUL");
        System.out.println("============================");
        Kucing kucing = new Kucing("Kitty");
        Anjing anjing = new Anjing("Buddy");
        Burung burung = new Burung("Tweety");
        
        kucing.bersuara();
        kucing.gerak();
        System.out.println();
        
        anjing.bersuara();
        anjing.gerak();
        System.out.println();
        
        burung.bersuara();
        burung.gerak();
        System.out.println();
        
        System.out.println("2. DEMONSTRASI BANGUN DATAR GENERIK");
        System.out.println("====================================");
        
        Persegi persegi = new Persegi(5.0);
        Persegipanjang persegipanjang = new Persegipanjang(8.0, 6.0);
        Segitiga segitiga = new Segitiga(10.0, 8.0, 10.0, 8.0, 6.0);
        
        persegi.tampilkanInfo();
        System.out.println();
        
        persegipanjang.tampilkanInfo();
        System.out.println();
        
        segitiga.tampilkanInfo();
        System.out.println();
        
        System.out.println("3. DEMONSTRASI KELAS KOLEKSI GENERIK");
        System.out.println("====================================");
        
        Koleksi<Character> koleksiKarakter = new Koleksi<>(10);
        char[] karakter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        
        System.out.println("Menambahkan 10 karakter ke koleksi:");
        for (char c : karakter) {
            koleksiKarakter.add(c);
            System.out.print(c + " ");
        }
        System.out.println("\n");
        
        koleksiKarakter.showAll();
        
        System.out.println("4. DEMONSTRASI KOLEKSI ANABUL");
        System.out.println("==============================");
        
        Koleksi<Anabul> koleksiAnabul = new Koleksi<>(10);
        
        String[] namaKucing = {"Garfield", "Tom", "Kitty"};
        String[] namaAnjing = {"Buddy", "Max", "Rocky"};
        String[] namaBurung = {"Tweety", "Polly", "Charlie", "Sunny"};
        
        System.out.println("Menambahkan 10 elemen anabul secara acak:");
        
        for (String nama : namaKucing) {
            koleksiAnabul.add(new Kucing(nama));
        }
        
        for (String nama : namaAnjing) {
            koleksiAnabul.add(new Anjing(nama));
        }
        
        for (String nama : namaBurung) {
            koleksiAnabul.add(new Burung(nama));
        }
        
        koleksiAnabul.showAll();
        
        System.out.println("5. DEMONSTRASI OPERASI KOLEKSI");
        System.out.println("==============================");
        
        System.out.println("Menghapus elemen ke-3:");
        koleksiAnabul.delete(2);
        System.out.println("Setelah penghapusan:");
        koleksiAnabul.showAll();
        
        System.out.println("6. DEMONSTRASI KELAS DATUM");
        System.out.println("==========================");
        
        Datum<Kucing> datumKucing = new Datum<>(new Kucing("Whiskers"));
        Datum<Anjing> datumAnjing = new Datum<>(new Anjing("Rex"));
        Datum<Burung> datumBurung = new Datum<>(new Burung("Canary"));
        
        ContohMetodeGenerik.tampilkanDatum(datumKucing);
        ContohMetodeGenerik.tampilkanDatum(datumAnjing);
        ContohMetodeGenerik.tampilkanDatum(datumBurung);
        
        ContohMetodeGenerik.bandingkanDatum(datumKucing, datumAnjing);
        
        ContohMetodeGenerik.lakukanAksiAnabul(datumKucing);
        ContohMetodeGenerik.lakukanAksiAnabul(datumBurung);
        
        System.out.println("7. DEMONSTRASI PEMINDAHAN DATUM");
        System.out.println("===============================");
        
        Datum<Kucing> datumKosong = new Datum<>();
        ContohMetodeGenerik.pindahkanDatum(datumKucing, datumKosong);
        
        System.out.println("=== PROGRAM SELESAI ===");
    }
}