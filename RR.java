import java.util.Queue;

public class RR {
    private int zamanKuantumu = 1; // Round Robin için zaman kuantumu
    private KaynakYonetimi k2 = new KaynakYonetimi();

    public RR() {
        // Constructor içerisinde özel bir işlem gerekmiyorsa boş bırakılabilir.
    }

    public int isle(Queue<Proses> kuyruk, int sistemZamani, GBG gbg) {
        if (!kuyruk.isEmpty()) {
            Proses proses = kuyruk.poll(); // Kuyruğun başındaki prosesi al

            // Proses için kaynak kontrolü yap
            if (!kaynaklariTahsisEt(proses)) {
                // Kaynak tahsis edilemiyorsa hata mesajı yazdır
                System.out.printf(proses.Pid+" HATA - Proses çok sayıda kaynak talep ediyor - proses silindi\n");
                return sistemZamani; // Prosesi atla ve sistem zamanını değiştirmeden dön
            }

            // Prosesin işlem süresini ve sistem zamanını güncelle
            proses.setProsesSuresi(proses.getProsesSuresi() - zamanKuantumu);
            sistemZamani += zamanKuantumu;

            // Prosesin durumu ve öncelik değişikliklerini yazdır
            if (proses.getProsesSuresi() > 0) {
                // Proses hala bitmediyse, önceliğini artır ve uygun kuyruğa ekle
                int yeniOncelik = proses.getOncelik() + 1;
                proses.setOncelik(yeniOncelik);

                System.out.printf("%-3d %-3d %-4d %-3d %-5d %-3d %-3d %-3d %-3d RUNNING\n",
                    proses.Pid, sistemZamani, yeniOncelik, proses.getProsesSuresi(), 
                    proses.getBellekMiktari(), proses.getYaziciSayisi(), proses.getTarayiciSayisi(), 
                    proses.getModemSayisi(), proses.getCdSurucuSayisi());

                if (yeniOncelik == 2) {
                    gbg.getKullaniciKuyrugu_isle2().add(proses);
                } else if (yeniOncelik == 3) {
                    gbg.getKullaniciKuyrugu_isle3().add(proses);
                } else {
                    // Eğer öncelik 3'ten büyükse, en düşük öncelikli kuyrukta kalır
                    gbg.getKullaniciKuyrugu_isle3().add(proses);
                }
            } else {
                // Proses tamamlandıysa, durumunu yazdır ve kaynakları iade et
                System.out.printf("%-3d %-3d %-4d %-3d %-5d %-3d %-3d %-3d %-3d COMPLETED\n",
                    proses.Pid, sistemZamani, proses.getOncelik(), 0, 
                    proses.getBellekMiktari(), proses.getYaziciSayisi(), proses.getTarayiciSayisi(), 
                    proses.getModemSayisi(), proses.getCdSurucuSayisi());
                kaynaklariIadeEt(proses);
            }
        }

        return sistemZamani; // Güncellenmiş sistem zamanını geri döndür
    }

    private boolean kaynaklariTahsisEt(Proses proses) {
        // Prosesin istediği kaynakları kontrol et ve eğer mümkünse tahsis et
        boolean yaziciTahsis = k2.yaziciTahsisEt(proses.getYaziciSayisi());
        boolean tarayiciTahsis = k2.tarayiciTahsisEt(proses.getTarayiciSayisi());
        boolean cdSürücüTahsis = k2.cdSürücüTahsisEt(proses.getCdSurucuSayisi());
        boolean bellekTahsis = k2.bellekTahsisEt(proses.getBellekMiktari());

        // Eğer herhangi bir kaynak için tahsis edilemiyorsa, tahsis edilenleri iade et
        if (!(yaziciTahsis && tarayiciTahsis && cdSürücüTahsis && bellekTahsis)) {
            if (yaziciTahsis) k2.yaziciIadeEt(proses.getYaziciSayisi());
            if (tarayiciTahsis) k2.tarayiciIadeEt(proses.getTarayiciSayisi());
            if (cdSürücüTahsis) k2.cdSürücüIadeEt(proses.getCdSurucuSayisi());
            if (bellekTahsis) k2.bellekIadeEt(proses.getBellekMiktari());
            return false;
        }

        return true;
    }

    private void kaynaklariIadeEt(Proses proses) {
        // Prosesin kullanmış olduğu kaynakları iade et
        k2.yaziciIadeEt(proses.getYaziciSayisi());
        k2.tarayiciIadeEt(proses.getTarayiciSayisi());
        k2.cdSürücüIadeEt(proses.getCdSurucuSayisi());
        k2.bellekIadeEt(proses.getBellekMiktari());
    }
}
