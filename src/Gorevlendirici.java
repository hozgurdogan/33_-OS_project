import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Gorevlendirici {
    private List<Proses> tumProsesler;
    private Queue<Proses> gercekZamanliKuyrugu;
    private Queue<Proses> kullaniciKuyrugu;
    public Queue<Proses> kullaniciKuyrugu_isle1;
    public Queue<Proses> kullaniciKuyrugu_isle2;
    public Queue<Proses> kullaniciKuyrugu_isle3;

    public KaynakYonetimi k1 = new KaynakYonetimi();
    public int SistemZamani = 0;

    public Gorevlendirici(List<Proses> tumProsesler) {
        this.tumProsesler = tumProsesler;
        this.gercekZamanliKuyrugu = new LinkedList<>();
        this.kullaniciKuyrugu = new LinkedList<>();
        this.kullaniciKuyrugu_isle1 = new LinkedList<>();
        this.kullaniciKuyrugu_isle2 = new LinkedList<>();
        this.kullaniciKuyrugu_isle3 = new LinkedList<>();

        GercekZamanliKuyruk_isleme FCSF_kuyruk = new GercekZamanliKuyruk_isleme(this.gercekZamanliKuyrugu);
    }

    public void prosesleriKuyruklaraAta() {
        while (!tumProsesler.isEmpty() && tumProsesler.get(0).getVarisZamani() <= SistemZamani) {
            Proses proses = tumProsesler.remove(0);
            if (proses.getOncelik() == 0) {
                if (proses.getBellekMiktari() <= 64) {
                    gercekZamanliKuyrugu.add(proses);
                } else {
                    System.out.println("PID=" + proses.Pid + " olan " + proses.getBellekMiktari() + " MB bellek talep eden proses 64 MB'dan fazla yer talep ediyor, proses siliniyor.");
                }
            } else {
                kullaniciKuyrugu.add(proses);
                if(proses.getOncelik() == 1) {
                    kullaniciKuyrugu_isle1.add(proses);
                } else if(proses.getOncelik() == 2) {
                    kullaniciKuyrugu_isle2.add(proses);
                } else if(proses.getOncelik() == 3) {
                    kullaniciKuyrugu_isle3.add(proses);
                }
            }
        }
    }

    public void Sistemicalistir() {
        GercekZamanliKuyruk_isleme FCSF_kuyruk = new GercekZamanliKuyruk_isleme(this.gercekZamanliKuyrugu);
        GBG gbg = new GBG(kullaniciKuyrugu_isle1, kullaniciKuyrugu_isle2, kullaniciKuyrugu_isle3); // GBG nesnesi oluşturuluyor

        while (!tumProsesler.isEmpty() || !gercekZamanliKuyrugu.isEmpty() || !kullaniciKuyrugu.isEmpty()) {
            prosesleriKuyruklaraAta(); // Sistem zamanına göre prosesleri kuyruklara ata

            if (!gercekZamanliKuyrugu.isEmpty()) {
                Proses suankiProses = gercekZamanliKuyrugu.peek();
                if (suankiProses != null && suankiProses.getVarisZamani() <= SistemZamani) {
                    k1.bellekTahsisEt(suankiProses.getBellekMiktari());
                 //   System.out.println("Sistem Anlik zamani: " + SistemZamani);
                    SistemZamani = FCSF_kuyruk.FCSFCagir(SistemZamani);
                    k1.bellekIadeEt(suankiProses.getBellekMiktari());
                   // gercekZamanliKuyrugu.remove();
                    continue;
                }
            }

            // Kullanıcı proseslerini GBG aracılığıyla işle
            if (!kullaniciKuyrugu_isle1.isEmpty()) {
                SistemZamani = gbg.kuyrukIsle1(SistemZamani,kullaniciKuyrugu);
            } else if (!kullaniciKuyrugu_isle2.isEmpty()) {
                SistemZamani = gbg.kuyrukIsle2(SistemZamani,kullaniciKuyrugu);
            } else if (!kullaniciKuyrugu_isle3.isEmpty()) {
                SistemZamani = gbg.kuyrukIsle3(SistemZamani,kullaniciKuyrugu);
            }

            // Sistem zamanını artır
            SistemZamani++;
        }
    }


    public void kuyruklariYazdir() {
        System.out.println("Gerçek Zamanlı Prosesler:");
        for (Proses proses : gercekZamanliKuyrugu) {
            System.out.println(proses);
        }

        System.out.println("\nKullanıcı Kuyruğu Prosesleri:");
        for (Proses proses : kullaniciKuyrugu_isle1) {
            System.out.println(proses);
        }
    }

    // Diğer metodlar ve sınıf içeriği...
}


// GercekZamanliKuyruk_isleme ve diğer ilgili sınıflar...
