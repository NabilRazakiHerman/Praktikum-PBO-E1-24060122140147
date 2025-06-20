class PNS extends Manusia {
    private static int counterPNS = 0;
    private String nip;
    
    public PNS(String nama, String tglMulaiKerja, String alamat, double pendapatan, String nip) {
        super(nama, tglMulaiKerja, alamat, pendapatan);
        this.nip = nip;
        counterPNS++;
    }
    
    public static int getCounterPNS() {
        return counterPNS;
    }
    
    @Override
    public double hitungPajak() {
        return 0.10 * pendapatan;
    }
}


