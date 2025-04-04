abstract class Ruang {
    protected String kode;
    protected double panjang;
    protected double lebar;
    protected double tinggi;
    protected int kapasitas;
    protected double biayaKebersihan;

    public Ruang(String kode, double panjang, double lebar, double tinggi, int kapasitas) {
        this.kode = kode;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.kapasitas = kapasitas;
    }

    public double hitungBiayaKebersihan() {
        return panjang * lebar * biayaKebersihan;
    }

    public abstract void tampilkanDetail();

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }
    public double getPanjang() { return panjang; }
    public double getLebar() { return lebar; }
    public double getTinggi() { return tinggi; }
    public int getKapasitas() { return kapasitas; }
}

class RuangKelas extends Ruang {
    private int jumlahKursiTersedia;
    private int jumlahKursiRusak;
    private static final double TARIF_KEBERSIHAN = 5000;

    public RuangKelas(String kode, double panjang, double lebar, double tinggi, 
                      int kapasitas, int jumlahKursiTersedia, int jumlahKursiRusak) {
        super(kode, panjang, lebar, tinggi, kapasitas);
        this.jumlahKursiTersedia = jumlahKursiTersedia;
        this.jumlahKursiRusak = jumlahKursiRusak;
        this.biayaKebersihan = TARIF_KEBERSIHAN;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Detail Ruang Kelas:");
        System.out.println("Kode Ruang: " + kode);
        System.out.println("Ukuran: " + panjang + "m x " + lebar + "m");
        System.out.println("Kapasitas: " + kapasitas);
        System.out.println("Kursi Tersedia: " + jumlahKursiTersedia);
        System.out.println("Kursi Rusak: " + jumlahKursiRusak);
        System.out.println("Biaya Kebersihan: Rp " + hitungBiayaKebersihan());
    }
}

abstract class Laboratorium extends Ruang {
    protected String namaLaboratorium;
    protected double hargaSewa;
    private static final double TARIF_KEBERSIHAN = 5000;

    public Laboratorium(String kode, double panjang, double lebar, double tinggi, 
                        int kapasitas, String namaLaboratorium, double hargaSewa) {
        super(kode, panjang, lebar, tinggi, kapasitas);
        this.namaLaboratorium = namaLaboratorium;
        this.hargaSewa = hargaSewa;
        this.biayaKebersihan = TARIF_KEBERSIHAN;
    }

    public abstract void tampilkanDetailLaboratorium();
}

class LaboratoriumKomputer extends Laboratorium {
    private int jumlahKomputer;

    public LaboratoriumKomputer(String kode, double panjang, double lebar, double tinggi, 
                                 int kapasitas, String namaLaboratorium, 
                                 double hargaSewa, int jumlahKomputer) {
        super(kode, panjang, lebar, tinggi, kapasitas, namaLaboratorium, hargaSewa);
        this.jumlahKomputer = jumlahKomputer;
    }

    @Override
    public void tampilkanDetail() {
        tampilkanDetailLaboratorium();
    }

    @Override
    public void tampilkanDetailLaboratorium() {
        System.out.println("Detail Laboratorium Komputer:");
        System.out.println("Nama Lab: " + namaLaboratorium);
        System.out.println("Kode Ruang: " + kode);
        System.out.println("Ukuran: " + panjang + "m x " + lebar + "m");
        System.out.println("Jumlah Komputer: " + jumlahKomputer);
        System.out.println("Harga Sewa: Rp " + hargaSewa);
        System.out.println("Biaya Kebersihan: Rp " + hitungBiayaKebersihan());
    }
}

class LaboratoriumNonKomputer extends Laboratorium {
    private String[] mataKuliah;

    public LaboratoriumNonKomputer(String kode, double panjang, double lebar, double tinggi, 
                                    int kapasitas, String namaLaboratorium, 
                                    double hargaSewa, String[] mataKuliah) {
        super(kode, panjang, lebar, tinggi, kapasitas, namaLaboratorium, hargaSewa);
        this.mataKuliah = mataKuliah;
    }

    @Override
    public void tampilkanDetail() {
        tampilkanDetailLaboratorium();
    }

    @Override
    public void tampilkanDetailLaboratorium() {
        System.out.println("Detail Laboratorium Non-Komputer:");
        System.out.println("Nama Lab: " + namaLaboratorium);
        System.out.println("Kode Ruang: " + kode);
        System.out.println("Ukuran: " + panjang + "m x " + lebar + "m");
        System.out.println("Mata Kuliah:");
        for (String mk : mataKuliah) {
            System.out.println("- " + mk);
        }
        System.out.println("Harga Sewa: Rp " + hargaSewa);
        System.out.println("Biaya Kebersihan: Rp " + hitungBiayaKebersihan());
    }
}

class Departemen {
    private String namaDepartemen;
    private String ketuaDepartemen;
    private double tarifBiayaKebersihan;
    private RuangDepartemen ruangDepartemen;
    private RuangDosen[] ruangDosen;

    public Departemen(String namaDepartemen, String ketuaDepartemen, 
                      double tarifBiayaKebersihan) {
        this.namaDepartemen = namaDepartemen;
        this.ketuaDepartemen = ketuaDepartemen;
        this.tarifBiayaKebersihan = tarifBiayaKebersihan;
    }

    public void setRuangDepartemen(RuangDepartemen ruang) {
        this.ruangDepartemen = ruang;
        ruang.setBiayaKebersihan(tarifBiayaKebersihan);
    }

    public void setRuangDosen(RuangDosen[] ruangDosen) {
        this.ruangDosen = ruangDosen;
        for (RuangDosen rd : ruangDosen) {
            rd.setBiayaKebersihan(tarifBiayaKebersihan);
        }
    }
}

class RuangDepartemen extends Ruang {
    private int jumlahMeja;
    private int jumlahKursi;
    private int jumlahLemari;

    public RuangDepartemen(String kode, double panjang, double lebar, double tinggi, 
                            int kapasitas, int jumlahMeja, int jumlahKursi, int jumlahLemari) {
        super(kode, panjang, lebar, tinggi, kapasitas);
        this.jumlahMeja = jumlahMeja;
        this.jumlahKursi = jumlahKursi;
        this.jumlahLemari = jumlahLemari;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Detail Ruang Departemen:");
        System.out.println("Kode Ruang: " + kode);
        System.out.println("Ukuran: " + panjang + "m x " + lebar + "m");
        System.out.println("Jumlah Meja: " + jumlahMeja);
        System.out.println("Jumlah Kursi: " + jumlahKursi);
        System.out.println("Jumlah Lemari: " + jumlahLemari);
        System.out.println("Biaya Kebersihan: Rp " + hitungBiayaKebersihan());
    }

    public void setBiayaKebersihan(double tarif) {
        this.biayaKebersihan = tarif;
    }
}

class RuangDosen extends Ruang {
    private String namaDosen;
    private int jumlahKursi;
    private int jumlahMeja;

    public RuangDosen(String kode, double panjang, double lebar, double tinggi, 
                      int kapasitas, String namaDosen, int jumlahKursi, int jumlahMeja) {
        super(kode, panjang, lebar, tinggi, kapasitas);
        this.namaDosen = namaDosen;
        this.jumlahKursi = jumlahKursi;
        this.jumlahMeja = jumlahMeja;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Detail Ruang Dosen:");
        System.out.println("Nama Dosen: " + namaDosen);
        System.out.println("Kode Ruang: " + kode);
        System.out.println("Ukuran: " + panjang + "m x " + lebar + "m");
        System.out.println("Jumlah Kursi: " + jumlahKursi);
        System.out.println("Jumlah Meja: " + jumlahMeja);
        System.out.println("Biaya Kebersihan: Rp " + hitungBiayaKebersihan());
    }

    public void setBiayaKebersihan(double tarif) {
        this.biayaKebersihan = tarif;
    }
}

public class ManajemenRuangFSM {
    public static void main(String[] args) {
        RuangKelas ruangKelas1 = new RuangKelas("RK001", 8, 6, 3, 40, 40, 2);
        ruangKelas1.tampilkanDetail();
        System.out.println();

        LaboratoriumKomputer labKomputer = new LaboratoriumKomputer(
            "LK001", 10, 8, 3, 30, "Lab Komputer Utama", 500000, 25
        );
        labKomputer.tampilkanDetail();
        System.out.println();

        String[] mataKuliahBiologi = {"Mikrobiologi", "Genetika", "Ekologi"};
        LaboratoriumNonKomputer labBiologi = new LaboratoriumNonKomputer(
            "LB001", 12, 10, 4, 25, "Lab Biologi", 750000, mataKuliahBiologi
        );
        labBiologi.tampilkanDetail();
        System.out.println();

        RuangDepartemen ruangDept = new RuangDepartemen("RD001", 15, 12, 3, 20, 10, 15, 5);
        RuangDosen[] ruangDosenArray = {
            new RuangDosen("RDS001", 6, 4, 3, 2, "Dr. Budi Setiawan", 2, 1),
            new RuangDosen("RDS002", 6, 4, 3, 2, "Dr. Sri Wahyuni", 2, 1)
        };

        Departemen informatika = new Departemen("Informatika", "Prof. Dr. Ahmad Rozi", 6000);
        informatika.setRuangDepartemen(ruangDept);
        informatika.setRuangDosen(ruangDosenArray);

        ruangDept.tampilkanDetail();
        System.out.println();
        
        for (RuangDosen rd : ruangDosenArray) {
            rd.tampilkanDetail();
            System.out.println();
        }
    }
}