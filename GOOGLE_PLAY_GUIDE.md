# SimpleCalc - Google Play Console Yükleme Rehberi

## 🚀 Google Play Store'da Uygulama Yayınlama

Bu rehber, SimpleCalc uygulamasını Google Play Store'da yayınlamak için gereken tüm adımları detaylı olarak açıklar.

---

## 📋 Ön Gereksinimler Checklist

Başlamadan önce bunların hazır olduğundan emin olun:

### Teknik Gereksinimler:
- [x] İmzalı AAB dosyası (`app-release.aab`)
- [x] Keystore dosyası ve şifreleri
- [x] SHA256 fingerprint
- [x] Minimum SDK: API 21+
- [x] Target SDK: API 34

### Yasal ve İçerik Gereksinimleri:
- [ ] Gizlilik Politikası (URL gerekli)
- [ ] Uygulama açıklaması (kısa ve uzun)
- [ ] Ekran görüntüleri (minimum 2, maksimum 8)
- [ ] Feature graphic (1024x500 px)
- [ ] Uygulama ikonu (512x512 px - zaten mevcut)
- [ ] Google Play Console hesabı ($25 tek seferlik ücret)

### İsteğe Bağlı:
- [ ] Promo video (YouTube linki)
- [ ] Tanıtım metni
- [ ] Çeviriler (farklı diller)

---

## 💳 1. ADIM: Google Play Console Hesabı Oluşturma

### A. Geliştirici Hesabı Kayıt:

1. **Google Play Console'a Git:**
   - URL: https://play.google.com/console/signup
   - Gmail hesabınızla giriş yapın

2. **Hesap Tipi Seç:**
   - **Bireysel:** Kişisel geliştirici
   - **Organizasyon:** Şirket/Kurum

3. **Geliştirici Bilgileri:**
   - Ad/Soyad veya Şirket adı
   - E-posta adresi
   - Telefon numarası
   - Ülke: Türkiye

4. **Ödeme:**
   - **Tek seferlik kayıt ücreti: $25**
   - Kredi kartı ile ödeme
   - Google Pay desteklenir

5. **Geliştirici Sözleşmesi:**
   - Google Play Developer Distribution Agreement'ı okuyun
   - Kabul edin ve devam edin

**⏱️ Süre:** ~10 dakika  
**💰 Maliyet:** $25 (tek seferlik)

---

## 📱 2. ADIM: Yeni Uygulama Oluşturma

### A. Uygulama Listesi Oluştur:

1. **Console Ana Sayfa:**
   - "Tüm uygulamalar" → **"Uygulama oluştur"**

2. **Uygulama Detayları:**
   ```
   Uygulama adı: SimpleCalc
   Varsayılan dil: Türkçe (veya İngilizce)
   Uygulama veya oyun: Uygulama
   Ücretsiz mi, ücretli mi: Ücretsiz
   ```

3. **Beyanlar:**
   - [x] Google Play geliştirici program politikalarını kabul ediyorum
   - [x] ABD ihracat yasalarına uyuyorum

4. **"Uygulama oluştur"** butonuna tıklayın

### B. Dashboard Görünümü:

Uygulama oluşturulduktan sonra göreceksiniz:
- ✅ Uygulamayı ayarlama görevleri
- ✅ Sürüm yönetimi
- ✅ Store listeleme
- ✅ İçerik derecelendirmesi
- ✅ Fiyatlandırma ve dağıtım

---

## 🎨 3. ADIM: Store Listeleme (Store Listing)

### A. Ana Store Listeleme:

**Dashboard → Store varlığı → Ana Store listeleme**

#### 1. **Uygulama Detayları:**

```
Uygulama adı: SimpleCalc

Kısa açıklama (80 karakter):
Basit ve kullanışlı hesap makinesi. Toplama, çıkarma, çarpma, bölme işlemleri.

Tam açıklama (4000 karakter):
SimpleCalc, günlük hesaplamalarınız için tasarlanmış modern ve sade bir hesap makinesi uygulamasıdır.

✨ ÖZELLİKLER:
• Toplama, çıkarma, çarpma, bölme işlemleri
• Ondalık sayı desteği
• Zincirleme hesaplama özelliği
• Modern ve kullanıcı dostu arayüz
• Tamamen ücretsiz, reklamsız
• İnternet bağlantısı gerektirmez
• Hafif ve hızlı (sadece 1-2 MB)

🔒 GİZLİLİK:
• Hiçbir kişisel veri toplanmaz
• İnternet izni gerektirmez
• Tamamen offline çalışır
• Reklam ve takip sistemi yok

🎯 KİMLER İÇİN:
• Öğrenciler
• Profesyoneller
• Günlük kullanıcılar
• Hızlı hesaplama yapanlar

📱 TEKNİK ÖZELLİKLER:
• Android 5.0 ve üzeri
• Modern Material Design
• Dikey ekran modu
• Basit ve anlaşılır

SimpleCalc ile hesaplamalarınızı hızlı ve kolay yapın!
```

#### 2. **Grafik Varlıklar:**

**Uygulama İkonu (512x512):**
- PNG formatında
- Şeffaf arka plan veya renkli
- Zaten mevcut ikondan export edin

**Feature Graphic (1024x500):**
- Öne çıkan görsel
- Play Store'da banner olarak görünür
- Uygulama adı ve kısa açıklama içerebilir

**Telefon Ekran Görüntüleri (2-8 adet):**
- Minimum: 2 ekran görüntüsü
- Maksimum: 8 ekran görüntüsü
- Boyut: 16:9 veya 9:16 oran
- Minimum: 320px
- Maksimum: 3840px

**Örnek Ekran Görüntüleri:**
1. Ana ekran (0 gösterimi)
2. Toplama işlemi örneği (5 + 3 = 8)
3. Çarpma işlemi örneği (7 × 8 = 56)
4. Ondalık sayı örneği (3.5 + 2.5 = 6)

**7" Tablet Ekran Görüntüleri (opsiyonel):**
- Tablet desteği varsa ekleyin

**10" Tablet Ekran Görüntüleri (opsiyonel):**
- Daha büyük tabletler için

#### 3. **Kategori ve İletişim:**

```
Kategori: Araçlar (Tools)
Kategori tipi: Uygulamalar

E-posta: your-email@example.com
Telefon (opsiyonel): +90 XXX XXX XX XX
Web sitesi (opsiyonel): https://yourwebsite.com

Gizlilik Politikası URL: 
https://yourwebsite.com/privacy-policy.html
(PRIVACY_POLICY.md içeriğini web sitenize yükleyin)
```

**⚠️ Gizlilik Politikası Zorunlu!**
- GitHub Pages kullanabilirsiniz (ücretsiz)
- Kendi web siteniz varsa oraya yükleyin
- Google Sites kullanabilirsiniz

---

## 📊 4. ADIM: İçerik Derecelendirmesi

**Dashboard → İlke → Uygulama içeriği → İçerik derecelendirmesi**

### Anket Doldurma:

1. **E-posta Adresi:** Onay e-postası alacaksınız

2. **Kategori Seçimi:**
   - ✅ **Araçlar (Utility, Productivity)**

3. **Sorular (SimpleCalc için):**
   
   **Şiddet:**
   - Uygulamanızda şiddet var mı? → **HAYIR**
   
   **Cinsellik:**
   - Uygulamanızda cinsel içerik var mı? → **HAYIR**
   
   **Uyuşturucu:**
   - Uyuşturucu referansı var mı? → **HAYIR**
   
   **Sosyal Özellikler:**
   - Kullanıcılar etkileşime girebilir mi? → **HAYIR**
   - Kişisel bilgi paylaşımı var mı? → **HAYIR**
   
   **Konum:**
   - Konum bilgisi kullanıyor mu? → **HAYIR**

4. **Özet:**
   - Tüm cevaplar HAYIR ise:
   - **Derecelendirme: 3+ (Herkes)**
   - En düşük yaş sınırı

5. **"Derecelendirmeyi hesapla"** → **Kaydet**

---

## 🌍 5. ADIM: Hedef Kitle ve İçerik

**Dashboard → İlke → Uygulama içeriği**

### A. Hedef Kitle:

1. **Yaş Grubu:**
   - ✅ **13+ veya Tüm yaşlar**
   
2. **Uygulama Bilgileri:**
   - ✅ Çocuklara yönelik mi? → **HAYIR** (veya EVET - zararsız)
   - ✅ Reklam var mı? → **HAYIR**
   - ✅ Uygulama içi satın alma var mı? → **HAYIR**

### B. Gizlilik Politikası:

```
Gizlilik Politikası URL'si:
https://yourwebsite.com/privacy-policy.html

✅ PRIVACY_POLICY.md dosyasını web sitenize yükleyin
```

### C. Veri Güvenliği:

1. **Veri Toplama:**
   - ✅ **Hiçbir veri toplanmıyor** → Seçin
   
2. **Veri Paylaşımı:**
   - ✅ **Hiçbir veri paylaşılmıyor**
   
3. **Şifreleme:**
   - ✅ **Veri şifrelemesi: YOK** (veri olmadığı için)

### D. Reklam:

- ✅ **Reklam içeriyor mu? → HAYIR**
- ✅ **Reklam ID'si topluyor mu? → HAYIR**

### E. Google Play Aileleri:

- Çocuklara yönelik ise katılabilirsiniz
- SimpleCalc için opsiyonel

---

## 💰 6. ADIM: Fiyatlandırma ve Dağıtım

**Dashboard → Büyüme → Fiyatlandırma ve dağıtım**

### A. Ülkeler:

```
✅ Tüm ülkeler (varsayılan)

veya belirli ülkeler:
✅ Türkiye
✅ ABD
✅ Almanya
✅ İngiltere
vb.
```

### B. Fiyatlandırma:

```
Uygulama türü: Ücretsiz
Fiyat: $0.00

⚠️ Ücretsiz uygulama asla ücretli yapılamaz!
   Ücretliden ücretsiz yapılabilir.
```

### C. Dağıtım Seçenekleri:

- [x] Google Play'de mevcut
- [x] Android Auto (opsiyonel)
- [ ] Android TV (hesap makinesi için gerek yok)
- [ ] Wear OS (hesap makinesi için gerek yok)
- [ ] Chromebook (opsiyonel, çalışır)

### D. Program Seçenekleri:

- [ ] Google Play for Education (eğitim uygulamaları için)
- [ ] Designed for Families (aile dostu uygulamalar)

---

## 📦 7. ADIM: AAB Yükleme (Release)

### A. Production Track (Üretim):

**Dashboard → Sürüm → Üretim → Yeni sürüm oluştur**

#### 1. **App Signing:**

İlk kez yüklüyorsanız:
- ✅ **"Let Google manage my app signing key"** seçin
- Google otomatik olarak app signing'i yönetir
- Upload keystore ile imzalayın, Google yeniden imzalar

#### 2. **AAB Yükleme:**

```bash
# AAB dosyasını hazırlayın
./gradlew bundleRelease

# Dosya: app/build/outputs/bundle/release/app-release.aab
```

**Play Console'da:**
1. **"App bundles"** bölümüne gidin
2. **AAB dosyasını sürükle-bırak** veya "Browse files"
3. Yükleme tamamlanacak
4. Otomatik analiz başlar

#### 3. **Sürüm Detayları:**

```
Sürüm adı: 1.0
Sürüm kodu: 1 (build.gradle'dan otomatik)

Sürüm notları (Ne yeni?):
🎉 SimpleCalc'in ilk sürümü!

✨ Özellikler:
• Toplama, çıkarma, çarpma, bölme
• Ondalık sayı desteği
• Modern tasarım
• Tamamen ücretsiz
• Reklamsız
```

#### 4. **Kaydet ve İncelemeye Gönder:**

- **"Kaydet"** → **"İnceleye gönder"**
- Google inceleme süreci başlar

---

## ⏱️ 8. ADIM: İnceleme Süreci

### İnceleme Aşamaları:

1. **Yükleme:** AAB dosyası yüklendi ✅

2. **Otomatik Kontroller:**
   - APK analizi
   - Güvenlik taraması
   - Politika kontrolü
   - Kötü amaçlı yazılım taraması
   - ⏱️ Süre: 1-2 saat

3. **Manuel İnceleme:**
   - Google ekibi incelemesi
   - İçerik kontrolü
   - Politika uygunluğu
   - ⏱️ Süre: 1-3 gün (bazen 1 hafta)

4. **Onay/Red:**
   - ✅ **Onay:** Uygulama yayınlanır
   - ❌ **Red:** E-posta ile sebep bildirilir

### İnceleme Sonrası:

**Onaylandı ise:**
- 🎉 Uygulama Play Store'da yayında!
- Play Store'da görünür: 2-4 saat içinde
- Arama sonuçlarında: 24-48 saat

**Reddedildi ise:**
- E-postayı okuyun
- Sorunu düzeltin
- Yeni sürüm yükleyin

---

## 🔄 9. ADIM: Güncelleme Yayınlama

### Uygulama Güncellemesi:

#### A. Kod Güncellemeleri:

1. **build.gradle güncelleyin:**
   ```gradle
   versionCode 2      // +1 artırın
   versionName "1.1"  // Güncelleme numarası
   ```

2. **Değişiklikleri yapın** (bug fix, yeni özellik)

3. **Yeni AAB oluşturun:**
   ```bash
   ./gradlew clean bundleRelease
   ```

#### B. Play Console'da:

1. **Production → Yeni sürüm**
2. **Yeni AAB yükle**
3. **Sürüm notları:**
   ```
   Sürüm 1.1 - Güncellemeler:
   
   🐛 Hata Düzeltmeleri:
   • [Sorun açıklaması]
   
   ✨ Yeni Özellikler:
   • [Yeni özellik]
   
   ⚡ İyileştirmeler:
   • Performans artışı
   • UI iyileştirmeleri
   ```

4. **İncelemeye gönder**

### Güncelleme Stratejisi:

- **Patch (1.0.1):** Bug fix
- **Minor (1.1):** Küçük özellikler
- **Major (2.0):** Büyük değişiklikler

---

## 📊 10. ADIM: İstatistikler ve Yönetim

### A. İstatistikler:

**Dashboard → İstatistikler**

Görebilecekleriniz:
- 📥 Yüklemeler
- 🗑️ Kaldırmalar
- 👥 Aktif kullanıcılar
- ⭐ Puanlar ve yorumlar
- 🌍 Ülke dağılımı
- 📱 Cihaz dağılımı
- 📈 Trendler

### B. Kullanıcı Yorumları:

**Dashboard → Kullanıcı geri bildirimi → İncelemeler**

- Yorumlara cevap verin
- Sorunları çözün
- Geri bildirim toplayın

### C. Crash Raporları:

**Dashboard → Kalite → Android vitals**

- Crash raporları
- ANR (App Not Responding)
- Pil kullanımı
- Render süresi

---

## 📝 Ekran Görüntüsü Oluşturma

### Önerilen Araçlar:

#### 1. Android Studio (Önerilen):
```bash
# Emulator başlat
# Uygulamayı çalıştır
# Screenshot al: Ctrl+Shift+S (Windows/Linux) veya Cmd+Shift+S (Mac)
```

#### 2. Gerçek Cihaz:
- Uygulamayı çalıştır
- Ekran görüntüsü al
- Bilgisayara aktar

#### 3. Online Araçlar:
- **Figma:** Mockup oluşturma
- **Canva:** Banner tasarım
- **Mockuphone.com:** Cihaz mockup

### Ekran Görüntüsü Önerileri:

**Telefon (ZORUNLU - 2-8 adet):**
1. Ana ekran (temiz görünüm)
2. İşlem örneği 1 (5 + 3 = 8)
3. İşlem örneği 2 (7 × 8 = 56)
4. Ondalık sayı (3.5 + 2.5 = 6)

**7" Tablet (opsiyonel):**
- Tablet layout'u

**10" Tablet (opsiyonel):**
- Büyük tablet görünümü

### Feature Graphic (1024x500):

**İçerik Önerileri:**
```
- Uygulama adı: SimpleCalc
- Slogan: "Basit ve Hızlı Hesaplama"
- Uygulama ikonu
- Anahtar özellikler (ikonlar ile)
- Renkler: Mavi tonları (branding)
```

**Tasarım Araçları:**
- Canva (ücretsiz şablonlar)
- Figma
- Photoshop
- GIMP (ücretsiz)

---

## 🔐 Gizlilik Politikası Yayınlama

### GitHub Pages (Ücretsiz):

1. **Yeni Repository Oluştur:**
   - GitHub'da `simplecalc-privacy` adlı repo

2. **PRIVACY_POLICY.md Yükle:**
   ```bash
   git clone https://github.com/yourusername/simplecalc-privacy
   cd simplecalc-privacy
   cp /workspace/PRIVACY_POLICY.md index.md
   git add .
   git commit -m "Add privacy policy"
   git push
   ```

3. **GitHub Pages Aktifleştir:**
   - Settings → Pages
   - Source: main branch
   - Save

4. **URL Al:**
   ```
   https://yourusername.github.io/simplecalc-privacy/
   ```

5. **Play Console'da Kullan:**
   - Bu URL'yi gizlilik politikası alanına yapıştırın

### Alternatif (Google Sites):

1. **Google Sites'a Git:** https://sites.google.com
2. **Yeni site oluştur**
3. **PRIVACY_POLICY.md içeriğini yapıştır**
4. **Yayınla**
5. **URL'yi kopyala**

---

## ✅ Son Kontrol Listesi

### Yayından Önce:

- [ ] AAB dosyası oluşturuldu ve imzalandı
- [ ] Uygulama adı doğru (SimpleCalc)
- [ ] Kısa ve uzun açıklama yazıldı
- [ ] Minimum 2 ekran görüntüsü yüklendi
- [ ] Feature graphic (1024x500) yüklendi
- [ ] Uygulama ikonu (512x512) yüklendi
- [ ] Gizlilik politikası URL'si eklendi
- [ ] Kategori seçildi (Araçlar)
- [ ] İçerik derecelendirmesi tamamlandı
- [ ] Hedef kitle belirlendi
- [ ] Fiyatlandırma ayarlandı (Ücretsiz)
- [ ] Ülkeler seçildi
- [ ] Sürüm notları yazıldı
- [ ] E-posta adresi doğru
- [ ] Tüm zorunlu alanlar dolduruldu

### Yayından Sonra:

- [ ] İnceleme durumunu takip et
- [ ] E-postaları kontrol et
- [ ] İlk yorumları/puanları takip et
- [ ] Crash raporlarını izle
- [ ] Kullanıcı geri bildirimlerine cevap ver
- [ ] Keystore'u güvenli yerde sakla
- [ ] İlk güncellemeleri planla

---

## 📞 Destek ve İletişim

### Google Play Console Desteği:

- **Yardım Merkezi:** https://support.google.com/googleplay/android-developer
- **Developer Forum:** https://support.google.com/googleplay/android-developer/community
- **Politika Rehberi:** https://play.google.com/about/developer-content-policy/

### Sık Karşılaşılan Sorunlar:

**1. "Gizlilik politikası URL'si geçersiz"**
- URL'nin erişilebilir olduğundan emin olun
- HTTPS kullanın
- 404 hatası olmamalı

**2. "AAB yüklenemedi"**
- İmza kontrolü yapın
- Version code doğru mu?
- Manifest hatalı olabilir

**3. "İnceleme reddedildi"**
- E-postadaki sebebi okuyun
- Gerekli değişiklikleri yapın
- Yeni sürüm yükleyin

---

## 🎉 Tebrikler!

SimpleCalc uygulamanız Google Play Store'da yayınlanmaya hazır!

### Sonraki Adımlar:

1. ✅ AAB yükleyin
2. ✅ İncelemeyi bekleyin (1-3 gün)
3. ✅ Onaylanınca Store'da görünecek
4. 📱 Kullanıcılarla paylaşın
5. 📊 İstatistikleri takip edin
6. 🔄 Düzenli güncellemeler yapın
7. ⭐ Yorumlara cevap verin

**Başarılar! 🚀**
