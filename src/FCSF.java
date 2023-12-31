public class FCSF {
    public FCSF() {
        // Constructor içerisinde özel bir işlem gerekmiyorsa boş bırakılabilir.
    }

    public int FCSF_Calistir(int SistemZamani, Proses p1) {
        // Prosesin bilgilerini yazdır
        System.out.printf("%-3d %-3d %-4d %-3d %-5d %-3d %-3d %-3d %-3d RUNNING\n",
            p1.Pid, SistemZamani, p1.getOncelik(), p1.getProsesSuresi(),
            p1.getBellekMiktari(), p1.getYaziciSayisi(), p1.getTarayiciSayisi(),
            p1.getModemSayisi(), p1.getCdSurucuSayisi());

        // Prosesin süresi kadar zaman ekle
        SistemZamani += p1.getProsesSuresi();

        // Prosesin tamamlandığını bildir
        System.out.printf("%-3d %-3d %-4d %-3d %-5d %-3d %-3d %-3d %-3d COMPLETED\n",
            p1.Pid, SistemZamani, p1.getOncelik(), 0,
            p1.getBellekMiktari(), p1.getYaziciSayisi(), p1.getTarayiciSayisi(),
            p1.getModemSayisi(), p1.getCdSurucuSayisi());

        // Güncellenmiş sistem zamanını döndür
        return SistemZamani;
    }
}
