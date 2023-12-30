public class KaynakYonetimi {
    private int yazicilar;
    private int tarayicilar;
    private int modemler;
    private int cdsürücüler;
    private int toplamBellek;
    private final int MAX_BELLEK = 1024; // MB olarak maksimum bellek miktarı

    public KaynakYonetimi() {
        this.yazicilar = 2; // Toplam yazıcı sayısı
        this.tarayicilar = 1; // Toplam tarayıcı sayısı
        this.modemler = 1; // Toplam modem sayısı
        this.cdsürücüler = 2; // Toplam CD sürücü sayısı
        this.toplamBellek = MAX_BELLEK; // Başlangıçta kullanılabilir toplam bellek miktarı
    }

    public synchronized boolean yaziciTahsisEt(int sayi) {
        if (this.yazicilar >= sayi) {
            this.yazicilar -= sayi;
            return true;
        }
        return false;
    }

    public synchronized boolean tarayiciTahsisEt(int sayi) {
        if (this.tarayicilar >= sayi) {
            this.tarayicilar -= sayi;
            return true;
        }
        return false;
    }

    public synchronized boolean modemTahsisEt(int sayi) {
        if (this.modemler >= sayi) {
            this.modemler -= sayi;
            return true;
        }
        return false;
    }

    public synchronized boolean cdSürücüTahsisEt(int sayi) {
        if (this.cdsürücüler >= sayi) {
            this.cdsürücüler -= sayi;
            return true;
        }
        return false;
    }

    public synchronized boolean bellekTahsisEt(int miktar) {
        if (this.toplamBellek >= miktar) {
            this.toplamBellek -= miktar;
            return true;
        }
        return false;
    }

    public synchronized void yaziciIadeEt(int sayi) {
        this.yazicilar += sayi;
    }

    public synchronized void tarayiciIadeEt(int sayi) {
        this.tarayicilar += sayi;
    }

    public synchronized void modemIadeEt(int sayi) {
        this.modemler += sayi;
    }

    public synchronized void cdSürücüIadeEt(int sayi) {
        this.cdsürücüler += sayi;
    }

    public synchronized void bellekIadeEt(int miktar) {
        this.toplamBellek += miktar;
    }


    
}