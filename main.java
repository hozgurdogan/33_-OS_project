import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class main {
	
	

    private static List<Proses> dosyadanProsesleriOku(String dosyaYolu) {
    	int Pid=0;
        List<Proses> prosesler = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
            	
                String[] degerler = satir.split(",");
                Proses proses = new Proses(
                        Integer.parseInt(degerler[0].trim()), // Varış Zamanı
                        Integer.parseInt(degerler[1].trim()), // Öncelik
                        Integer.parseInt(degerler[2].trim()), // Proses Süresi
                        Integer.parseInt(degerler[3].trim()), // Bellek Miktarı
                        Integer.parseInt(degerler[4].trim()), // Yazıcı Sayısı
                        Integer.parseInt(degerler[5].trim()), // Tarayıcı Sayısı
                        Integer.parseInt(degerler[6].trim()), // Modem Sayısı
                        Integer.parseInt(degerler[7].trim())  // CD Sürücü Sayısı
                        
                );
                proses.Pid=Pid;

                prosesler.add(proses);
                Pid++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prosesler;
    }
    
    public static void main(String[] args) {

        String dosyaYolu = "./text/giris.txt"; // Dosya yolu, gerçek dosya yolunuz olmalıdır.
        List<Proses> tumProsesler = dosyadanProsesleriOku(dosyaYolu);
        for (Proses proses : tumProsesler) {
       //     System.out.println(proses.toString());
        }
        Gorevlendirici SistemGorevlendiricisi=new Gorevlendirici(tumProsesler);
        SistemGorevlendiricisi.kuyruklariYazdir();
        SistemGorevlendiricisi.Sistemicalistir();
      

        // tumProsesler listesini kullanarak işlemlerinizi burada gerçekleştirebilirsiniz
    }

}
