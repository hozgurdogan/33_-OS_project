public class Proses {
    private int varisZamani;
    private int oncelik;
    private int prosesSuresi;
    private int bellekMiktari;
    private int yaziciSayisi;
    private int tarayiciSayisi;
    private int modemSayisi;
    private int cdSurucuSayisi;
    public int Pid;
    public int HayatSuresi;

    public Proses(int varisZamani, int oncelik, int prosesSuresi, int bellekMiktari, 
                  int yaziciSayisi, int tarayiciSayisi, int modemSayisi, int cdSurucuSayisi) {
        this.varisZamani = varisZamani;
        this.oncelik = oncelik;
        this.prosesSuresi = prosesSuresi;
        this.bellekMiktari = bellekMiktari;
        this.yaziciSayisi = yaziciSayisi;
        this.tarayiciSayisi = tarayiciSayisi;
        this.modemSayisi = modemSayisi;
        this.cdSurucuSayisi = cdSurucuSayisi;
        this.HayatSuresi=0;
    }

    // Getter metodları
    public int getVarisZamani() {
        return varisZamani;
    }

    public int getOncelik() {
        return oncelik;
    }

    public int getProsesSuresi() {
        return prosesSuresi;
    }

    public int getBellekMiktari() {
        return bellekMiktari;
    }

    public int getYaziciSayisi() {
        return yaziciSayisi;
    }

    public int getTarayiciSayisi() {
        return tarayiciSayisi;
    }

    public int getModemSayisi() {
        return modemSayisi;
    }

    public int getCdSurucuSayisi() {
        return cdSurucuSayisi;
    }

    // Setter metodları
    public void setVarisZamani(int varisZamani) {
        this.varisZamani = varisZamani;
    }

    public void setOncelik(int oncelik) {
        this.oncelik = oncelik;
    }

    public void setProsesSuresi(int prosesSuresi) {
        this.prosesSuresi = prosesSuresi;
    }

    public void setBellekMiktari(int bellekMiktari) {
        this.bellekMiktari = bellekMiktari;
    }

    public void setYaziciSayisi(int yaziciSayisi) {
        this.yaziciSayisi = yaziciSayisi;
    }

    public void setTarayiciSayisi(int tarayiciSayisi) {
        this.tarayiciSayisi = tarayiciSayisi;
    }

    public void setModemSayisi(int modemSayisi) {
        this.modemSayisi = modemSayisi;
    }

    public void setCdSurucuSayisi(int cdSurucuSayisi) {
        this.cdSurucuSayisi = cdSurucuSayisi;
    }

    @Override
    public String toString() {
        return "Proses{" +
               "Pid=" + Pid +
               "varisZamani=" + varisZamani +
               ", oncelik=" + oncelik +
               ", prosesSuresi=" + prosesSuresi +
               ", bellekMiktari=" + bellekMiktari +
               ", yaziciSayisi=" + yaziciSayisi +
               ", tarayiciSayisi=" + tarayiciSayisi +
               ", modemSayisi=" + modemSayisi +
               ", cdSurucuSayisi=" + cdSurucuSayisi +
               '}';
    }
}
