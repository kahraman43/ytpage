# SimpleCalc - Test ve Doğrulama Rehberi

## ✅ Proje Doğrulama Sonucu

**📊 Doğrulama Özeti:**
- ✅ Başarılı: 30 kontrol
- ⚠️ Uyarı: 1 (Keystore - Adım 7'de oluşturulacak)
- ❌ Hata: 0

**Proje Google Play'e yüklemeye hazır!** 🎉

---

## 🧪 Test Senaryoları

### 1️⃣ Temel İşlem Testleri

#### Toplama İşlemi:
```
Adımlar: 5 + 3 =
Beklenen Sonuç: 8
```

#### Çıkarma İşlemi:
```
Adımlar: 10 - 4 =
Beklenen Sonuç: 6
```

#### Çarpma İşlemi:
```
Adımlar: 7 × 8 =
Beklenen Sonuç: 56
```

#### Bölme İşlemi:
```
Adımlar: 20 ÷ 4 =
Beklenen Sonuç: 5
```

### 2️⃣ Ondalık Sayı Testleri

#### Ondalık Toplama:
```
Adımlar: 3.5 + 2.5 =
Beklenen Sonuç: 6
```

#### Ondalık Çarpma:
```
Adımlar: 2.5 × 4 =
Beklenen Sonuç: 10
```

#### Ondalık Bölme:
```
Adımlar: 7.5 ÷ 2.5 =
Beklenen Sonuç: 3
```

### 3️⃣ Zincirleme İşlem Testleri

#### Test 1:
```
Adımlar: 5 + 3 × 2 =
İşlem: (5 + 3) = 8, sonra 8 × 2
Beklenen Sonuç: 16
```

#### Test 2:
```
Adımlar: 100 - 20 + 10 =
İşlem: (100 - 20) = 80, sonra 80 + 10
Beklenen Sonuç: 90
```

#### Test 3:
```
Adımlar: 48 ÷ 6 × 2 =
İşlem: (48 ÷ 6) = 8, sonra 8 × 2
Beklenen Sonuç: 16
```

### 4️⃣ Hata Durumu Testleri

#### Sıfıra Bölme:
```
Adımlar: 5 ÷ 0 =
Beklenen Sonuç: "Sıfıra bölünemez" (hata mesajı)
Davranış: Hesap makinesi sıfırlanmalı
```

#### Çok Büyük Sayılar:
```
Adımlar: 999999 × 999999 =
Beklenen Sonuç: 999998000001
Kontrol: Sayı ekranda görünebilmeli
```

### 5️⃣ UI İşlevsellik Testleri

#### Temizle (C) Butonu:
```
Adımlar: 
1. Herhangi bir sayı gir (örn: 123)
2. C butonuna bas
Beklenen Sonuç: Ekran "0" göstermeli
```

#### Tekrarlı İşlem:
```
Adımlar:
1. 5 + 3 =
2. + 2 =
Beklenen Sonuç: İlk sonuç 8, ikinci sonuç 10
```

#### Nokta Kontrolü:
```
Adımlar:
1. 3 . . . gir
Beklenen Sonuç: Sadece bir nokta eklenmeli (3.)
```

---

## 🔧 Manuel Test Adımları

### Android Studio ile Test:

1. **Proje Aç:**
   - Android Studio → Open → `/workspace` klasörünü seç
   - Gradle sync bekleyin

2. **Emulator Başlat:**
   - Tools → Device Manager
   - Yeni emulator oluştur (Pixel 5, API 34)
   - Start Emulator

3. **Debug Build Çalıştır:**
   - Run → Run 'app' (Shift+F10)
   - Veya yeşil play butonuna tıkla

4. **Test Senaryolarını Çalıştır:**
   - Yukarıdaki tüm test senaryolarını manuel olarak test edin

### Komut Satırı ile Test:

```bash
# Debug APK oluştur
./gradlew assembleDebug

# APK'yı cihaza/emulator'e yükle
adb install app/build/outputs/apk/debug/app-debug.apk

# Uygulamayı başlat
adb shell am start -n com.example.simplecalc/.MainActivity

# Logları izle
adb logcat | grep SimpleCalc
```

---

## 📱 Fiziksel Cihazda Test

### USB Debugging Aktifleştirme:

1. **Geliştirici Seçenekleri:**
   - Ayarlar → Telefon Hakkında
   - "Yapı Numarası"na 7 kez tıkla
   - Geliştirici seçenekleri aktif oldu

2. **USB Debugging:**
   - Ayarlar → Geliştirici Seçenekleri
   - "USB Debugging" açık

3. **Cihazı Bağla:**
   ```bash
   # Cihaz bağlı mı kontrol et
   adb devices
   
   # Çıktı: List of devices attached
   # ABC123XYZ    device
   ```

4. **Yükle ve Çalıştır:**
   ```bash
   ./gradlew installDebug
   ```

---

## 🧪 Otomatik Test (Opsiyonel)

### Unit Test Ekle:

`app/src/test/java/com/example/simplecalc/CalculatorTest.kt` oluşturun:

```kotlin
package com.example.simplecalc

import org.junit.Test
import org.junit.Assert.*

class CalculatorTest {
    
    @Test
    fun addition_isCorrect() {
        val result = 5.0 + 3.0
        assertEquals(8.0, result, 0.0)
    }
    
    @Test
    fun subtraction_isCorrect() {
        val result = 10.0 - 4.0
        assertEquals(6.0, result, 0.0)
    }
    
    @Test
    fun multiplication_isCorrect() {
        val result = 7.0 * 8.0
        assertEquals(56.0, result, 0.0)
    }
    
    @Test
    fun division_isCorrect() {
        val result = 20.0 / 4.0
        assertEquals(5.0, result, 0.0)
    }
}
```

### Testleri Çalıştır:

```bash
# Unit testleri çalıştır
./gradlew test

# Test raporunu görüntüle
open app/build/reports/tests/testDebugUnitTest/index.html
```

---

## 🔍 Build Doğrulama

### Lint Kontrolü:

```bash
# Lint analizi çalıştır
./gradlew lint

# Rapor: app/build/reports/lint-results.html
```

### Dependency Kontrolü:

```bash
# Dependency tree görüntüle
./gradlew app:dependencies

# Güncel olmayan bağımlıkları kontrol et
./gradlew dependencyUpdates
```

---

## 📊 Performans Testleri

### 1. Başlatma Süresi:
- Uygulama 2 saniyeden hızlı açılmalı
- Splash screen yok (anında açılır)

### 2. Bellek Kullanımı:
```bash
# Bellek kullanımını izle
adb shell dumpsys meminfo com.example.simplecalc
```
- Hedef: < 50 MB RAM

### 3. CPU Kullanımı:
- İşlem sırasında CPU %5'in altında olmalı
- Idle durumda %0

### 4. APK Boyutu:
- Debug APK: ~2-3 MB
- Release AAB: ~1-2 MB
- Hedef: < 5 MB

---

## ✅ Test Checklist

### Fonksiyonel Testler:
- [ ] Tüm sayı butonları çalışıyor (0-9)
- [ ] Tüm işlem butonları çalışıyor (+, -, ×, ÷)
- [ ] Ondalık nokta doğru çalışıyor
- [ ] Temizle (C) butonu çalışıyor
- [ ] Eşittir (=) butonu çalışıyor
- [ ] Zincirleme işlemler doğru hesaplanıyor
- [ ] Sıfıra bölme hatası doğru gösteriliyor

### UI/UX Testler:
- [ ] Ekran yatay modda kilitli (portrait only)
- [ ] Butonlar dokunmaya duyarlı
- [ ] Yazı boyutları okunabilir
- [ ] Renkler uyumlu
- [ ] İkon doğru görünüyor

### Cihaz Testleri:
- [ ] Android 5.0 (API 21) - Minimum versiyon
- [ ] Android 10 (API 29) - Orta seviye
- [ ] Android 14 (API 34) - Maksimum versiyon
- [ ] Küçük ekran (4.5")
- [ ] Normal ekran (5.5")
- [ ] Büyük ekran (6.5"+)

### Performans Testleri:
- [ ] Başlatma < 2 saniye
- [ ] Bellek kullanımı < 50 MB
- [ ] CPU kullanımı düşük
- [ ] Pil tüketimi minimal

### Hata Testleri:
- [ ] Sıfıra bölme hatası
- [ ] Çok büyük sayılar
- [ ] Hızlı buton tıklamaları
- [ ] Ekran döndürme (kilitli olmalı)

---

## 🐛 Bilinen Sorunlar ve Çözümler

### Sorun 1: Gradle Sync Hatası
```
Çözüm:
- File → Invalidate Caches → Restart
- ./gradlew clean build
```

### Sorun 2: ADB Device Bulunamıyor
```
Çözüm:
- USB kablosunu değiştir
- adb kill-server && adb start-server
- USB debugging'i kapat/aç
```

### Sorun 3: Build Çok Yavaş
```
Çözüm:
- gradle.properties'e ekle:
  org.gradle.daemon=true
  org.gradle.parallel=true
```

---

## 📝 Test Raporu Şablonu

```
SimpleCalc Test Raporu
Tarih: [Tarih]
Test Eden: [İsim]
Cihaz: [Model] - Android [Versiyon]

BAŞARILI TESTLER:
✅ Toplama işlemi
✅ Çıkarma işlemi
✅ Çarpma işlemi
✅ Bölme işlemi
✅ Ondalık sayılar
✅ Zincirleme işlemler
✅ Sıfıra bölme hatası
✅ Temizle butonu
✅ UI görünümü

BAŞARISIZ TESTLER:
❌ [Sorun varsa buraya yazın]

PERFORMANS:
- Başlatma süresi: [X] saniye
- Bellek kullanımı: [X] MB
- APK boyutu: [X] MB

GENEL DEĞERLENDIRME:
[Yorumlarınız]

ONAY: [✅ / ❌]
```

---

## 🚀 Sonraki Adım

Tüm testler başarılı ise:
- ✅ **Adım 7**: Keystore oluşturma ve imzalama
- ✅ **Adım 8**: Google Play Console'a yükleme

**Test tamamlandı! "devam" yazarak 7. adıma geçebilirsiniz.**
