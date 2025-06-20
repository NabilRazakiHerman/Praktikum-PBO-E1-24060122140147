class Pengusaha extends Manusia {
    private static int counterPengusaha = 0;
    private String npwp;
    
    public Pengusaha(String nama, String tglMulaiKerja, String alamat, double pendapatan, String npwp) {
        super(nama, tglMulaiKerja, alamat, pendapatan);
        this.npwp = npwp;
        counterPengusaha++;
    }
    
    public static int getCounterPengusaha() {
        return counterPengusaha;
    }
    
    @Override
    public double hitungPajak() {
        return 0.15 * pendapatan;
    }
}    
