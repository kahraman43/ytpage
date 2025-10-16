# ⚡ Hızlı Başlangıç Rehberi

Bu dosyayı okuyarak 5 dakikada uygulamanızı çalıştırabilirsiniz!

---

## 🎯 Amaç

Android hesap makinesi uygulamasını bilgisayarınızda çalıştırıp test etmek.

---

## 📋 Gereksinimler (Tek Seferlik)

1. **Android Studio** - [İndir](https://developer.android.com/studio)
2. **JDK 8+** - Android Studio ile birlikte gelir
3. **10 GB boş disk alanı** - Android SDK için

---

## 🚀 3 Adımda Başlangıç

### Adım 1: Projeyi İndir

**Seçenek A - IDE'den:**
- Sol panelden tüm dosyaları seç
- Export veya Download

**Seçenek B - Git (varsa):**
```bash
git clone [REPOSITORY_URL]
```

**Seçenek C - Manuel:**
- Her dosyayı kopyala-yapıştır
- Klasör yapısını koru

### Adım 2: Android Studio'da Aç

1. Android Studio'yu başlat
2. "Open an Existing Project"
3. İndirdiğin klasörü seç
4. Gradle sync'i bekle (5-10 dk)

### Adım 3: Çalıştır

1. **Emülatör Oluştur:**
   - Tools → Device Manager → Create Device
   - Pixel 6 seç → Next
   - API 34 seç → Finish

2. **Uygulamayı Başlat:**
   - Yeşil Run (▶️) butonuna tıkla
   - Emülatörde uygulamanın açıldığını gör

---

## ✅ Başarılı!

Uygulamanız çalışıyor! Şimdi ne yapabilirsiniz?

### 🎨 Özelleştirme

**Renk değiştir:**
`app/src/main/kotlin/com/hesapmakinesi/app/ui/theme/Theme.kt`

**İsim değiştir:**
`app/src/main/res/values/strings.xml`

**İkon değiştir:**
`app/src/main/res/mipmap-*/` klasörlerindeki dosyalar

### 📱 Gerçek Telefonda Test

1. Telefonunuzda "Geliştirici Seçenekleri"ni aç
2. "USB Hata Ayıklama"yı aç
3. USB ile bilgisayara bağla
4. Run butonuna tıkla

### 🚀 Play Store'a Yükle

**Detaylı rehber için:**
👉 `PLAY_STORE_YUKLEME_REHBERI.md`

**Kısa özet:**
1. Keystore oluştur
2. Release build al
3. Play Console'da yayınla

---

## 🐛 Sorun mu Yaşıyorsun?

### Gradle Sync Hatası

**Çözüm:**
```bash
./gradlew clean
./gradlew build
```

### SDK Bulunamadı

**Çözüm:**
- Android Studio → Preferences → Android SDK
- SDK'yı kur

### Emülatör Açılmıyor

**Çözüm:**
- Tools → SDK Manager → SDK Tools
- "Intel x86 Emulator Accelerator" kur

---

## 📚 Detaylı Rehberler

Daha fazla bilgi için:

- **📥 Dosya İndirme:** `DOSYALARI_INDIRME.md`
- **🏪 Play Store:** `PLAY_STORE_YUKLEME_REHBERI.md`
- **📖 Proje Detayları:** `README.md`

---

## 💡 İpuçları

1. **İlk sync uzun sürer** - Kahve molası ver ☕
2. **Emülatör yavaş** - Gerçek telefon kullan
3. **Değişiklik yaparsan** - Run butonuna tekrar tıkla

---

## 🎉 Tebrikler!

Uygulamanı başarıyla çalıştırdın!

**Sonraki adım:** Kendi özelliklerini ekle veya Play Store'a yükle!

**Kolay gelsin! 🚀**
