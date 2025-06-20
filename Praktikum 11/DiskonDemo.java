interface Diskon {
    double hitungDiskon(double totalBelanja);
}

public class DiskonDemo {
    public static void main(String[] args) {
        Diskon diskonLebaran = new Diskon() {
            @Override
            public double hitungDiskon(double totalBelanja) {
                return totalBelanja * 0.3;
            }
        };

        Diskon diskonBiasa = total -> total * 0.1;

        double belanja = 200000;

        System.out.println("Total diskon lebaran: " + diskonLebaran.hitungDiskon(belanja));
        System.out.println("Total diskon biasa  : " + diskonBiasa.hitungDiskon(belanja));
    }
}
