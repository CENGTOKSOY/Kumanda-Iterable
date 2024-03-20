import java.util.ArrayList;
import java.util.Iterator;

// Kumanda sınıfını oluşturuyoruz ve Iterable arayüzünü uyguluyoruz
public class Kumanda implements Iterable<String> {

    private ArrayList<String> kanallar = new ArrayList<String>(); // Kanalları depolamak için bir ArrayList oluşturuyoruz

    // İç içe sınıf olarak KumandaIterator sınıfını tanımlıyoruz ve Iterator arayüzünü uyguluyoruz
    public class KumandaIterator implements Iterator<String> {
        private int index = 0; // İteratörde kullanılacak indeks değerini tutmak için değişken oluşturuyoruz

        @Override
        public boolean hasNext() { // Sonraki elemanın olup olmadığını kontrol eden metod
            if (index >= kanallar.size()) { // İndeks, kanalların boyutundan büyükse, sonraki eleman yok demektir
                return false;
            } else {
                return true; // İndeks, kanalların boyutundan küçükse, sonraki eleman var demektir
            }
        }

        @Override
        public String next() { // Sonraki elemanı döndüren metod
            String kanal = kanallar.get(index); // Şu anki indeksteki kanalı al
            index++; // İndeksi bir sonraki elemana ilerlet
            return kanal; // Kanalı döndür
        }
    }

    // Yeni kanal eklemek için metod
    public void kanalEkle(String kanal) {
        kanallar.add(kanal); // Kanalı ArrayList'e ekle
    }

    // Belirli bir kanalı silmek için metod
    public void kanalSil(String kanal) {
        if (kanallar.contains(kanal)) { // Kanal ArrayList'te varsa
            kanallar.remove(kanal); // Kanalı sil
        } else {
            System.out.println("Böyle bir kanal bulunmuyor..."); // Kanal bulunamazsa kullanıcıyı uyar
        }
    }

    // Toplam kanal sayısını döndüren metod
    public int kanalSayisi() {
        return kanallar.size(); // ArrayList'in boyutunu döndür, yani toplam kanal sayısını ver
    }

    @Override
    public Iterator<String> iterator() { // Iterable arayüzünü uygulayan iterator metodunu override ediyoruz
        return new KumandaIterator(); // Yeni bir KumandaIterator nesnesi oluşturup döndürüyoruz
    }
}
