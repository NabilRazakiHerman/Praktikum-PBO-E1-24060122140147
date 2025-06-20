class Petani extends Manusia {
    private static int counterPetani = 0;
    private String daerah;
    
    public Petani(String nama, String tglMulaiKerja, String alamat, double pendapatan, String daerah) {
        super(nama, tglMulaiKerja, alamat, pendapatan);
        this.daerah = daerah;
        counterPetani++;
    }
    
    public static int getCounterPetani() {
        return counterPetani;
    }
    
    @Override
    public double hitungPajak() {
        return 0;
    }
}
