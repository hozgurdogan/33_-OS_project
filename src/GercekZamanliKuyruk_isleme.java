import java.util.Queue;

public class GercekZamanliKuyruk_isleme {
    private Queue<Proses> gercekZamanliKuyrugu;
    FCSF fifo = new FCSF();

    public GercekZamanliKuyruk_isleme(Queue<Proses> gercekZamanliKuyrugu) {
        this.gercekZamanliKuyrugu = gercekZamanliKuyrugu;
    }
    
    public int FCSFCagir(int SistemZamani) {
        // FIFO algoritması ile kuyruktaki prosesi işle
        fifo.FCSF_Calistir(SistemZamani,gercekZamanliKuyrugu.poll()); // Kuyruğun başındaki prosesi çıkar ve işle

        // Sistem zamanını güncelle ve geri dön
        return SistemZamani; // Sistem zamanı güncellemesi burada yapılabilir
    }
    // Bu sınıfın diğer metodları ve işlevleri burada yer alabilir
}