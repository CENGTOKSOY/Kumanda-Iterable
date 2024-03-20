import java.util.Scanner;

// Ana sınıfımızı oluşturuyoruz
public class Main {
    public static void main(String[] args) {
        System.out.println("Kumanda Programına Hoşgeldiniz..."); // Hoşgeldin mesajını yazdır
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için bir tarama nesnesi oluştur

        // Kullanıcıya gösterilecek işlemleri tanımla
        String islemler = "İşlemler...\n"
                + "1. Kanalları Göster\n"
                + "2. Kanal Ekle\n"
                + "3. Kanal Sil\n"
                + "4. Kanal Sayısı Öğren\n"
                + "Çıkış için q'ya basın...";

        Kumanda kumanda = new Kumanda(); // Kumanda nesnesi oluştur

        while (true) {
            System.out.println(islemler); // Kullanıcıya işlemleri göster
            System.out.print("İşlemi Giriniz :"); // Kullanıcıdan işlem girmesini iste
            String islem = scanner.nextLine(); // Kullanıcının girdiği işlemi oku

            if (islem.equals("q")) { // Kullanıcı çıkmak istediğinde programı sonlandır
                System.out.println("Programdan Çıkılıyor...");
                break;
            } else if (islem.equals("1")) { // Kullanıcı "1" girerse kanalları göster fonksiyonunu çağır
                kanallariGoster(kumanda);
            } else if (islem.equals("2")) { // Kullanıcı "2" girerse yeni kanal eklemesini iste
                System.out.print("Eklenecek Kanal : ");
                String kanal_ismi = scanner.nextLine();
                kumanda.kanalEkle(kanal_ismi);

            } else if (islem.equals("3")) { // Kullanıcı "3" girerse kanal silmesini iste
                System.out.print("Silinecek Kanal : ");
                String kanal_ismi = scanner.nextLine();

                kumanda.kanalSil(kanal_ismi);

            } else if (islem.equals("4")) { // Kullanıcı "4" girerse kanal sayısını göster
                System.out.println("Kanal Sayısı : " + kumanda.kanalSayisi());

            } else { // Geçersiz bir işlem girilirse kullanıcıyı uyar
                System.out.println("Geçersiz İşlem...");
            }
        }

    }

    // Kanalları gösterme işlevi
    public static void kanallariGoster(Kumanda kumanda) {

        if (kumanda.kanalSayisi() == 0) { // Eğer hiç kanal yoksa kullanıcıya bilgi ver
            System.out.println("Şu anda hiçbir kanal bulunmuyor...");
        } else { // Kanal varsa tüm kanalları göster
            for (String kanal : kumanda) {
                System.out.println("Kanal : " + kanal);

            }

        }

    }
}
