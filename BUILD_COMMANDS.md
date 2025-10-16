# SimpleCalc - Build Komutları ve AAB Oluşturma Rehberi

## 📦 Android App Bundle (.aab) Nedir?

Google Play Console artık **APK yerine AAB (Android App Bundle)** formatını tercih eder.

**AAB Avantajları:**
- ✅ Daha küçük indirme boyutu (%35'e kadar)
- ✅ Dinamik modül desteği
- ✅ Google Play otomatik optimizasyon yapar
- ✅ Cihaza özel APK oluşturur

---

## 🛠️ Build Komutları

### 1️⃣ Debug Build (Test için)

```bash
# Debug APK oluştur
./gradlew assembleDebug

# Çıktı: app/build/outputs/apk/debug/app-debug.apk
```

### 2️⃣ Release AAB Oluşturma (Google Play için)

**⚠️ ÖNEMLİ: Önce keystore oluşturmalısınız! (Adım 7'ye bakın)**

```bash
# Release AAB oluştur (İMZALI)
./gradlew bundleRelease

# Çıktı: app/build/outputs/bundle/release/app-release.aab
```

### 3️⃣ Release APK Oluşturma (Opsiyonel)

```bash
# Release APK oluştur (İMZALI)
./gradlew assembleRelease

# Çıktı: app/build/outputs/apk/release/app-release.apk
```

---

## 📋 Build Öncesi Kontrol Listesi

### ✅ Gerekli Ayarlar:

1. **Keystore Oluşturuldu mu?** → Adım 7
2. **build.gradle'da signingConfig ayarlandı mı?** → Yorumları kaldırın
3. **gradle.properties'de şifreler eklendi mi?** → Keystore şifreleri
4. **Version code/name güncel mi?** → build.gradle kontrol et

### ✅ Build Öncesi:

```bash
# Temizlik yap
./gradlew clean

# Dependency güncelle
./gradlew --refresh-dependencies
```

---

## 🔍 Build Çıktılarını Kontrol Etme

### AAB Dosyasını İnceleme:

```bash
# AAB içeriğini listele
unzip -l app/build/outputs/bundle/release/app-release.aab

# AAB boyutunu kontrol et
ls -lh app/build/outputs/bundle/release/app-release.aab
```

### Bundletool ile Test (Opsiyonel):

```bash
# Bundletool indir (bir kez)
wget https://github.com/google/bundletool/releases/latest/download/bundletool-all.jar

# AAB'den test APK'ları oluştur
java -jar bundletool-all.jar build-apks \
  --bundle=app/build/outputs/bundle/release/app-release.aab \
  --output=simplecalc.apks \
  --ks=keystore/simplecalc-release.jks \
  --ks-pass=pass:KEYSTORE_PASSWORD \
  --ks-key-alias=simplecalc \
  --key-pass=pass:KEY_PASSWORD

# Cihaza yükle
java -jar bundletool-all.jar install-apks --apks=simplecalc.apks
```

---

## 📊 Build Varyantları

| Varyant | Komut | Çıktı | Kullanım |
|---------|-------|-------|----------|
| **Debug** | `assembleDebug` | APK | Geliştirme/Test |
| **Release APK** | `assembleRelease` | APK (imzalı) | Doğrudan dağıtım |
| **Release AAB** | `bundleRelease` | AAB (imzalı) | Google Play |

---

## 🔐 İmzalama Kontrolü

### AAB/APK İmzalandı mı Kontrol:

```bash
# APK imza kontrolü
jarsigner -verify -verbose -certs app/build/outputs/apk/release/app-release.apk

# AAB imza kontrolü
jarsigner -verify -verbose -certs app/build/outputs/bundle/release/app-release.aab
```

Başarılı ise göreceksiniz:
```
jar verified.
```

---

## 🚀 Android Studio'da Build

### GUI ile AAB Oluşturma:

1. **Build** → **Generate Signed Bundle / APK**
2. **Android App Bundle** seçin
3. **Next** → Keystore dosyanızı seçin
4. Şifreleri girin
5. **release** build variant seçin
6. **Finish**

Çıktı: `app/release/app-release.aab`

---

## 📈 Versiyon Yönetimi

Her yeni sürümde **build.gradle** dosyasında:

```gradle
versionCode 2      // +1 artır (integer)
versionName "1.1"  // Semantic versioning
```

**Örnekler:**
- 1.0 → 1.1 (minor güncelleme)
- 1.1 → 2.0 (major güncelleme)
- 1.0 → 1.0.1 (patch/bugfix)

---

## 🐛 Sorun Giderme

### Hata: "Failed to read key from keystore"
```bash
# Keystore'u doğrula
keytool -list -v -keystore keystore/simplecalc-release.jks
```

### Hata: "Execution failed for task ':app:lintVitalRelease'"
```bash
# Lint'i atla (geçici)
./gradlew bundleRelease -x lintVitalRelease
```

### Hata: "Unresolved reference: BuildConfig"
```bash
# Clean ve rebuild
./gradlew clean build
```

### Build çok yavaş:
```bash
# Gradle daemon'ı başlat
./gradlew --daemon

# Parallel build
./gradlew bundleRelease --parallel
```

---

## 📱 Test Cihazında Çalıştırma

```bash
# Debug sürümünü yükle ve çalıştır
./gradlew installDebug

# Logları izle
adb logcat | grep SimpleCalc
```

---

## ✅ Final Checklist (Google Play'e Yüklemeden Önce)

- [ ] AAB dosyası oluşturuldu
- [ ] AAB dosyası imzalandı (jarsigner ile kontrol edildi)
- [ ] Test cihazında çalıştırıldı
- [ ] Crash/hata yok
- [ ] Version code/name doğru
- [ ] ProGuard mapping dosyası kaydedildi (app/build/outputs/mapping/release/)
- [ ] Gizlilik politikası hazır
- [ ] Ekran görüntüleri hazır

---

## 📤 Sonraki Adım: Google Play Console'a Yükleme

AAB dosyanız hazır olduğunda → **Adım 8**'e geçin!
