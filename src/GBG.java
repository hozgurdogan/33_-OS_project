import java.util.Queue;

public class GBG {
    private Queue<Proses> kullaniciKuyrugu_isle1;
    private Queue<Proses> kullaniciKuyrugu_isle2;
    private Queue<Proses> kullaniciKuyrugu_isle3;
    private RR roundRobin;

    public GBG(Queue<Proses> kuyruk1, Queue<Proses> kuyruk2, Queue<Proses> kuyruk3) {
        this.kullaniciKuyrugu_isle1 = kuyruk1;
        this.kullaniciKuyrugu_isle2 = kuyruk2;
        this.kullaniciKuyrugu_isle3 = kuyruk3;
        this.roundRobin = new RR(); // RR örneği oluştur
    }

    public int kuyrukIsle1(int sistemZamani,Queue<Proses> TumProseslerKullanıcı) {
        if (!kullaniciKuyrugu_isle1.isEmpty()) {
            sistemZamani = roundRobin.isle(kullaniciKuyrugu_isle1, sistemZamani, this);
        }
        return sistemZamani;
    }

    public int kuyrukIsle2(int sistemZamani,Queue<Proses> TumProseslerKullanıcı) {
        if (!kullaniciKuyrugu_isle2.isEmpty()) {
            sistemZamani = roundRobin.isle(kullaniciKuyrugu_isle2, sistemZamani, this);
        }
        return sistemZamani;
    }

    public int kuyrukIsle3(int sistemZamani,Queue<Proses> TumProseslerKullanıcı) {
        if (!kullaniciKuyrugu_isle3.isEmpty()) {
            sistemZamani = roundRobin.isle(kullaniciKuyrugu_isle3, sistemZamani, this);
        }
        return sistemZamani;
    }

    // Getter metodları
    public Queue<Proses> getKullaniciKuyrugu_isle1() {
        return kullaniciKuyrugu_isle1;
    }

    public Queue<Proses> getKullaniciKuyrugu_isle2() {
        return kullaniciKuyrugu_isle2;
    }

    public Queue<Proses> getKullaniciKuyrugu_isle3() {
        return kullaniciKuyrugu_isle3;
    }

    // Diğer metodlar...
}
