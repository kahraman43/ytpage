# SimpleCalc - Ekran Görüntüsü Oluşturma Rehberi

## 📸 Google Play Store için Ekran Görüntüleri

Google Play Store, uygulamanızın görsel sunumu için ekran görüntülerine ihtiyaç duyar.

---

## 📋 Gereksinimler

### ZORUNLU:
- **Telefon Ekran Görüntüleri:** 2-8 adet
- **Minimum boyut:** 320px
- **Maksimum boyut:** 3840px
- **Format:** PNG veya JPEG
- **Oran:** 16:9 veya 9:16

### OPSİYONEL:
- **7" Tablet:** 1-8 adet
- **10" Tablet:** 1-8 adet
- **Feature Graphic:** 1024x500 (ZORUNLU)
- **Uygulama İkonu:** 512x512 (ZORUNLU)

---

## 🎯 SimpleCalc için Önerilen Ekran Görüntüleri

### Ekran 1: Ana Ekran
```
Görünüm: Temiz başlangıç ekranı
Gösterim: "0"
Amaç: Uygulamanın sade arayüzünü göster
```

### Ekran 2: Toplama İşlemi
```
Görünüm: 5 + 3 = 8
Gösterim: Sonuç ekranda
Amaç: Temel işlem örneği
```

### Ekran 3: Çarpma İşlemi
```
Görünüm: 7 × 8 = 56
Gösterim: Sonuç ekranda
Amaç: Farklı işlem türü
```

### Ekran 4: Ondalık Sayı
```
Görünüm: 3.5 + 2.5 = 6
Gösterim: Ondalık hesaplama
Amaç: Ondalık destek gösterimi
```

---

## 🛠️ Yöntem 1: Android Studio Emulator

### Adımlar:

1. **Android Studio'da Proje Aç:**
   ```bash
   # Workspace'i Android Studio'da aç
   ```

2. **Emulator Oluştur:**
   - Tools → Device Manager
   - Create Device
   - **Cihaz:** Pixel 5 (veya başka bir popüler model)
   - **Sistem:** Android 12 (API 31) veya üzeri
   - Finish

3. **Uygulamayı Çalıştır:**
   - Run → Run 'app' (Shift+F10)
   - Emulator'de uygulama açılır

4. **Ekran Görüntüsü Al:**
   - **Windows/Linux:** Ctrl + Shift + S
   - **macOS:** Cmd + Shift + S
   - Veya sağ taraftaki kamera ikonuna tıkla

5. **Kaydet:**
   - Screenshot otomatik kaydedilir
   - Dosya konumunu not edin

### Önerilen Boyutlar:
- **1080 x 1920** (Full HD - Pixel 5)
- **1440 x 2560** (QHD - Pixel 6)

---

## 📱 Yöntem 2: Fiziksel Cihaz

### Adımlar:

1. **Cihaza Yükle:**
   ```bash
   ./gradlew installDebug
   ```

2. **Uygulamayı Aç:**
   - SimpleCalc ikonuna tıkla

3. **Ekran Görüntüsü Al:**
   - **Android:** Power + Volume Down tuşları
   - Veya ekran kaydırma menüsünden

4. **Bilgisayara Aktar:**
   ```bash
   adb pull /sdcard/Pictures/Screenshots/ screenshots/
   ```

---

## 🎨 Yöntem 3: Online Mockup Araçları

### A. Mockuphone.com (Önerilen)

1. **Web sitesine git:** https://mockuphone.com

2. **Cihaz Seç:**
   - Android → Pixel 5 (veya Samsung Galaxy)

3. **Ekran Görüntüsü Yükle:**
   - Daha önce aldığınız screenshot'u yükle

4. **Mockup İndir:**
   - Cihaz çerçevesi ile birlikte görsel

### B. Figma (Profesyonel)

1. **Figma Aç:** https://figma.com

2. **Frame Oluştur:**
   - Android → Pixel 5 (1080 x 1920)

3. **Screenshot Ekle:**
   - Görüntüyü Figma'ya sürükle

4. **Dekorasyon Ekle (opsiyonel):**
   - Başlık metni
   - Açıklama
   - Renkli arka plan

5. **Export:**
   - PNG olarak indir

---

## 🖼️ Feature Graphic Oluşturma (1024x500)

### Canva ile (Kolay):

1. **Canva'ya Git:** https://canva.com

2. **Boyut Ayarla:**
   - Create a design → Custom size
   - 1024 x 500 pixels

3. **Tasarım Ekle:**
   ```
   Sol taraf:
   - Uygulama ikonu (büyük)
   - SimpleCalc başlığı
   
   Orta:
   - "Basit ve Hızlı Hesaplama" sloganı
   - Özellik ikonları
   
   Sağ taraf:
   - Telefon mockup (screenshot ile)
   ```

4. **Renk Şeması:**
   - Ana: #2196F3 (Mavi)
   - Arka plan: #F5F5F5 (Açık gri) veya gradient
   - Yazı: #212121 (Koyu gri)

5. **İndir:**
   - PNG formatında
   - 1024 x 500 px

### Örnek İçerik:

```
╔══════════════════════════════════════════════════╗
║  [📱İkon]  SimpleCalc                           ║
║                                                  ║
║  Basit ve Hızlı Hesaplama                       ║
║  ✓ Ücretsiz  ✓ Reklamsız  ✓ Hızlı              ║
║                                    [📱Telefon   ║
║                                     Screenshot]  ║
╚══════════════════════════════════════════════════╝
```

---

## 🎯 Uygulama İkonu Export (512x512)

### Android Studio'dan:

1. **Icon Bulma:**
   ```
   app/src/main/res/drawable/ic_launcher_foreground.xml
   ```

2. **Vector'ü PNG'ye Çevir:**
   - Right click → Convert to PNG
   - Boyut: 512 x 512 px
   - Export

### Online Araç:

1. **Android Asset Studio:** https://romannurik.github.io/AndroidAssetStudio/

2. **Icon Type:** Launcher Icons

3. **Upload:** XML veya PNG yükle

4. **Generate & Download:** 512x512 PNG indir

---

## 📐 Boyut Tablosu

| Öğe | Boyut | Format | Sayı | Zorunlu |
|-----|-------|--------|------|---------|
| **Telefon Ekran** | 320-3840px | PNG/JPG | 2-8 | ✅ |
| **7" Tablet** | 320-3840px | PNG/JPG | 1-8 | ❌ |
| **10" Tablet** | 320-3840px | PNG/JPG | 1-8 | ❌ |
| **Feature Graphic** | 1024x500 | PNG/JPG | 1 | ✅ |
| **Uygulama İkonu** | 512x512 | PNG | 1 | ✅ |
| **TV Banner** | 1280x720 | PNG/JPG | 1 | ❌ |
| **Promo Video** | YouTube | Link | 1 | ❌ |

---

## ✅ Kalite Kontrol Listesi

### Ekran Görüntüleri:

- [ ] Minimum 2 adet (maksimum 8)
- [ ] Doğru boyut ve oran
- [ ] UI temiz ve okunabilir
- [ ] Gerçek içerik (placeholder yok)
- [ ] Çeşitli işlem örnekleri
- [ ] Yüksek çözünürlük
- [ ] Kişisel bilgi yok

### Feature Graphic:

- [ ] 1024 x 500 px tam boyut
- [ ] Uygulama adı görünür
- [ ] Marka renkleri kullanıldı
- [ ] Okunabilir metin
- [ ] Profesyonel görünüm

### Uygulama İkonu:

- [ ] 512 x 512 px
- [ ] PNG formatında
- [ ] Şeffaf veya renkli arka plan
- [ ] Tanınabilir tasarım

---

## 🚀 Hızlı Başlangıç Checklist

SimpleCalc için hızlı ekran görüntüsü oluşturma:

1. **Emulator Başlat:**
   ```bash
   # Android Studio → Run
   ```

2. **4 Ekran Görüntüsü Al:**
   - Ana ekran (0)
   - 5 + 3 = 8
   - 7 × 8 = 56
   - 3.5 + 2.5 = 6

3. **Feature Graphic Oluştur:**
   - Canva → 1024x500
   - İkon + Slogan + Telefon mockup

4. **Uygulama İkonu Export:**
   - 512 x 512 PNG

5. **Play Console'a Yükle:**
   - Store listeleme → Grafik varlıklar
   - Tüm görselleri yükle

**Süre:** ~30-60 dakika

---

## 💡 İpuçları ve En İyi Uygulamalar

### Ekran Görüntüleri:

✅ **YAPIN:**
- Gerçek hesaplama örnekleri gösterin
- Farklı işlem türlerini sergileyın
- Temiz ve net görüntüler kullanın
- Uygulamanın temel özelliklerini vurgulayın

❌ **YAPMAYIN:**
- Kişisel bilgi göstermeyin
- Bulanık görüntü kullanmayın
- Çok fazla metin eklemeyin
- Fake/sahte içerik koymayın

### Feature Graphic:

✅ **YAPIN:**
- Basit ve anlaşılır tutun
- Marka renklerini kullanın
- Okunabilir fontlar seçin
- Mobil görünümü gösterin

❌ **YAPMAYIN:**
- Çok karışık tasarım
- Okunamayan küçük yazılar
- Copyright'lı görseller
- Yanıltıcı içerik

---

## 🎬 Video Tanıtım (Opsiyonel)

### YouTube Video:

1. **Video Kaydı:**
   - Screen recording ile uygulama kullanımı
   - 30-120 saniye
   - Özellik gösterimi

2. **Düzenleme:**
   - Video editör (iMovie, DaVinci Resolve)
   - Müzik ekle (telif hakkı yok)
   - Başlık ve açıklama

3. **YouTube'a Yükle:**
   - Public veya Unlisted
   - Link'i Play Console'a ekle

---

## 📞 Yardım ve Kaynaklar

### Tasarım Araçları:

- **Canva:** https://canva.com (kolay)
- **Figma:** https://figma.com (profesyonel)
- **GIMP:** https://gimp.org (ücretsiz Photoshop alternatifi)
- **Inkscape:** https://inkscape.org (vector grafik)

### Mockup Araçları:

- **Mockuphone:** https://mockuphone.com
- **Smartmockups:** https://smartmockups.com
- **Placeit:** https://placeit.net

### İkon Kaynakları:

- **Material Icons:** https://fonts.google.com/icons
- **Flaticon:** https://flaticon.com
- **Noun Project:** https://thenounproject.com

---

## ✅ Final Checklist

Yüklemeye hazır mısınız?

- [ ] 2-8 telefon ekran görüntüsü
- [ ] 1 feature graphic (1024x500)
- [ ] 1 uygulama ikonu (512x512)
- [ ] Tüm görseller yüksek kalite
- [ ] Kişisel bilgi yok
- [ ] Gerçek uygulama içeriği
- [ ] Doğru boyut ve format

**Hazırsanız Play Console'a yükleyin! 🚀**
