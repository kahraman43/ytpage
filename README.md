# 📱 Android Hesap Makinesi Uygulaması

Modern ve kullanışlı bir Android hesap makinesi uygulaması. Jetpack Compose ile geliştirilmiştir.

## 🎯 Özellikler

- ✅ Temel matematik işlemleri (toplama, çıkarma, çarpma, bölme)
- ✅ Yüzde hesaplama
- ✅ İşaret değiştirme (±)
- ✅ Modern koyu tema tasarımı
- ✅ iOS tarzı şık arayüz
- ✅ Hızlı ve akıcı kullanım
- ✅ %100 Kotlin ve Jetpack Compose
- ✅ Material Design 3

## 🚀 Hızlı Başlangıç

### Gereksinimler

- Android Studio (en güncel versiyon önerilir)
- JDK 8 veya üzeri
- Android SDK 24 veya üzeri

### Kurulum

1. **Projeyi Android Studio'da Açın**
   - Android Studio → Open → Bu klasörü seçin
   - Gradle sync işleminin tamamlanmasını bekleyin

2. **Uygulamayı Çalıştırın**
   - Bir emülatör oluşturun veya fiziksel cihazınızı bağlayın
   - Run (▶️) butonuna tıklayın

## 📦 Proje Yapısı

```
HesapMakinesi/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── kotlin/com/hesapmakinesi/app/
│   │       │   ├── MainActivity.kt          # Ana activity
│   │       │   ├── CalculatorScreen.kt      # UI bileşenleri
│   │       │   ├── CalculatorViewModel.kt   # İş mantığı
│   │       │   └── ui/theme/                # Tema dosyaları
│   │       ├── res/                         # Kaynaklar
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts                     # App level build config
├── build.gradle.kts                          # Project level build
├── settings.gradle.kts
└── PLAY_STORE_YUKLEME_REHBERI.md            # Detaylı yükleme rehberi
```

## 📱 Ekran Görüntüleri

Uygulama modern iOS tarzı hesap makinesi tasarımına sahiptir:
- Koyu arka plan
- Turuncu operatör butonları
- Gri fonksiyon butonları
- Beyaz sayı butonları

## 🛠️ Teknolojiler

- **Kotlin** - Ana programlama dili
- **Jetpack Compose** - Modern UI toolkit
- **Material Design 3** - Tasarım sistemi
- **ViewModel** - State yönetimi
- **StateFlow** - Reaktif veri akışı

## 📝 Google Play Store'a Yükleme

Uygulamanızı Google Play Store'a yüklemek için **PLAY_STORE_YUKLEME_REHBERI.md** dosyasını okuyun.

Bu rehber şunları içerir:
- ✅ Adım adım kurulum talimatları
- ✅ Keystore oluşturma
- ✅ AAB/APK oluşturma
- ✅ Play Console yapılandırması
- ✅ Gerekli görsellerin hazırlanması
- ✅ Yayınlama süreci

## 🔧 Release Build Oluşturma

### 1. Keystore Oluşturma

```bash
keytool -genkey -v -keystore release-keystore.jks -alias hesapmakinesi -keyalg RSA -keysize 2048 -validity 10000
```

### 2. keystore.properties Dosyası Oluşturma

Proje kök dizininde `keystore.properties` dosyası oluşturun:

```properties
storePassword=YOUR_STORE_PASSWORD
keyPassword=YOUR_KEY_PASSWORD
keyAlias=hesapmakinesi
storeFile=KEYSTORE_FILE_PATH
```

### 3. AAB/APK Oluşturma

**Android Studio ile:**
- Build → Generate Signed Bundle / APK
- Android App Bundle seçin
- Keystore bilgilerinizi girin
- Release build oluşturun

**Komut satırı ile:**
```bash
./gradlew bundleRelease
```

Output: `app/build/outputs/bundle/release/app-release.aab`

## 🎨 Özelleştirme

### Renk Değiştirme

`app/src/main/kotlin/com/hesapmakinesi/app/ui/theme/Theme.kt` dosyasında renkleri değiştirebilirsiniz:

```kotlin
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF9500),      // Turuncu
    background = Color(0xFF1E1E1E),   // Koyu arka plan
    // ...
)
```

### Uygulama Adını Değiştirme

`app/src/main/res/values/strings.xml`:
```xml
<string name="app_name">Yeni İsim</string>
```

### İkon Değiştirme

`app/src/main/res/` dizinindeki mipmap klasörlerindeki `ic_launcher` dosyalarını değiştirin.

## 🧪 Test Etme

Emülatör veya gerçek cihazda test edin:

1. Temel işlemler (toplama, çıkarma, çarpma, bölme)
2. Ondalık sayılar
3. İşaret değiştirme
4. Yüzde hesaplama
5. Temizleme (C butonu)

## 🐛 Bilinen Sorunlar

Şu an bilinen bir sorun bulunmamaktadır.

## 📄 Lisans

Bu proje açık kaynaklıdır ve eğitim amaçlıdır. İstediğiniz gibi kullanabilir ve değiştirebilirsiniz.

## 🤝 Katkıda Bulunma

Katkılarınızı bekliyoruz! Pull request göndermekten çekinmeyin.

## 📧 İletişim

Sorularınız için GitHub Issues kullanabilirsiniz.

---

**Geliştirme Tarihi:** 2025-10-16  
**Versiyon:** 1.0  
**Minimum SDK:** 24 (Android 7.0)  
**Target SDK:** 34 (Android 14)

---

## ⚡ Hızlı Komutlar

```bash
# Projeyi temizle
./gradlew clean

# Debug APK oluştur
./gradlew assembleDebug

# Release AAB oluştur
./gradlew bundleRelease

# Testleri çalıştır
./gradlew test

# Linting
./gradlew lint
```

## 🌟 Başarı İle!

Uygulamanızı oluşturdunuz! Play Store'a yükleme için rehberi takip edin.

**Kolay gelsin! 🎉**
