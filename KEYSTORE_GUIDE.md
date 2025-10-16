# SimpleCalc - Keystore Oluşturma ve İmzalama Rehberi

## 🔐 Keystore Nedir?

**Keystore (Anahtar Deposu)**, Android uygulamanızı dijital olarak imzalamak için kullanılan şifreli bir dosyadır. 

### Neden Gerekli?
- ✅ Google Play Console uygulamanızın size ait olduğunu doğrular
- ✅ Uygulama güncellemelerini güvenli hale getirir
- ✅ Kullanıcılar uygulamanın orijinal olduğundan emin olur

### ⚠️ ÇOK ÖNEMLİ UYARILAR:

> 🚨 **KEYSTORE DOSYASINI VE ŞİFRELERİ ASLA KAYBETMEYİN!**
> 
> - Kaybolursa uygulamanızı GÜNCELLEYEMEZSİNİZ!
> - Yeni keystore = yeni uygulama (eski kullanıcılar güncelleme alamaz)
> - Google Play bu durumda yardımcı OLAMAZ!

**Güvenli Saklama:**
1. ✅ Keystore dosyasını 3 farklı yere yedekleyin
2. ✅ Şifreleri güvenli bir şifre yöneticisine kaydedin
3. ✅ Bulut depolama (Google Drive, Dropbox) kullanın
4. ✅ Fiziksel USB'ye kopyalayın
5. ❌ Asla Git repository'ye eklemeyin!

---

## 📋 1. ADIM: Keystore Oluşturma

### Gereksinimler:
- JDK (Java Development Kit) yüklü olmalı
- Terminal/Command Prompt erişimi

### Keystore Oluşturma Komutu:

```bash
keytool -genkey -v \
  -keystore keystore/simplecalc-release.jks \
  -alias simplecalc \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000 \
  -storepass KEYSTORE_ŞIFRENIZ \
  -keypass KEY_ŞIFRENIZ \
  -dname "CN=SimpleCalc, OU=Mobile, O=YourCompany, L=Istanbul, ST=Istanbul, C=TR"
```

### Parametre Açıklamaları:

| Parametre | Açıklama | Örnek Değer |
|-----------|----------|-------------|
| `-keystore` | Keystore dosya yolu | `keystore/simplecalc-release.jks` |
| `-alias` | Anahtar takma adı | `simplecalc` |
| `-keyalg` | Şifreleme algoritması | `RSA` (önerilen) |
| `-keysize` | Anahtar boyutu (bit) | `2048` (minimum) |
| `-validity` | Geçerlilik süresi (gün) | `10000` (~27 yıl) |
| `-storepass` | Keystore şifresi | `YourStrongPassword123!` |
| `-keypass` | Key şifresi | `YourKeyPassword456!` |
| `-dname` | Sertifika bilgileri | DN formatında |

### DN (Distinguished Name) Bilgileri:

```
CN = Common Name (İsim)         → "SimpleCalc" veya "Your Name"
OU = Organizational Unit        → "Mobile Development"
O  = Organization              → "Your Company"
L  = Locality (Şehir)          → "Istanbul"
ST = State (Eyalet/İl)         → "Istanbul"
C  = Country (Ülke kodu)       → "TR" (Türkiye)
```

---

## 📝 2. ADIM: İnteraktif Keystore Oluşturma

Eğer komutu basitleştirmek isterseniz, interaktif mod kullanın:

```bash
keytool -genkey -v \
  -keystore keystore/simplecalc-release.jks \
  -alias simplecalc \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000
```

Terminal size şunları soracak:
```
Enter keystore password: [KEYSTORE ŞİFRESİ]
Re-enter new password: [TEKRAR ŞİFRE]

What is your first and last name?
  [Unknown]:  SimpleCalc Developer

What is the name of your organizational unit?
  [Unknown]:  Mobile Development

What is the name of your organization?
  [Unknown]:  YourCompany

What is the name of your City or Locality?
  [Unknown]:  Istanbul

What is the name of your State or Province?
  [Unknown]:  Istanbul

What is the two-letter country code for this unit?
  [Unknown]:  TR

Is CN=SimpleCalc Developer, OU=Mobile Development, O=YourCompany,
L=Istanbul, ST=Istanbul, C=TR correct?
  [no]:  yes

Enter key password for <simplecalc>
  (RETURN if same as keystore password): [KEY ŞİFRESİ]
```

---

## 🔍 3. ADIM: Keystore Doğrulama

Keystore'un başarıyla oluşturulduğunu kontrol edin:

```bash
# Keystore bilgilerini listele
keytool -list -v -keystore keystore/simplecalc-release.jks

# Şifre istenecek, keystore şifrenizi girin
```

### Beklenen Çıktı:

```
Keystore type: jks
Keystore provider: SUN

Your keystore contains 1 entry

Alias name: simplecalc
Creation date: Oct 16, 2025
Entry type: PrivateKeyEntry
Certificate chain length: 1
Certificate[1]:
Owner: CN=SimpleCalc, OU=Mobile, O=YourCompany, L=Istanbul, ST=Istanbul, C=TR
Issuer: CN=SimpleCalc, OU=Mobile, O=YourCompany, L=Istanbul, ST=Istanbul, C=TR
Serial number: 1a2b3c4d
Valid from: ... until: ...
Certificate fingerprints:
  SHA1: XX:XX:XX:...
  SHA256: YY:YY:YY:...
```

---

## 🔐 4. ADIM: Şifreleri Güvenli Saklama

### key.properties Dosyası Oluşturun:

```bash
# Bu dosyayı Git'e ASLA eklemeyin!
cat > key.properties << EOF
storePassword=KEYSTORE_ŞİFRENİZ
keyPassword=KEY_ŞİFRENİZ
keyAlias=simplecalc
storeFile=../keystore/simplecalc-release.jks
EOF
```

### .gitignore Kontrolü:

`.gitignore` dosyasında şunlar olmalı:
```
*.jks
*.keystore
keystore/
key.properties
signing.properties
```

✅ **Zaten eklenmiş durumda!**

---

## ⚙️ 5. ADIM: build.gradle Yapılandırması

### app/build.gradle'ı güncelleyin:

```gradle
android {
    ...
    
    signingConfigs {
        release {
            // Yöntem 1: Doğrudan yazma (GÜVENLİ DEĞİL!)
            storeFile file("../keystore/simplecalc-release.jks")
            storePassword "KEYSTORE_ŞİFRENİZ"
            keyAlias "simplecalc"
            keyPassword "KEY_ŞİFRENİZ"
            
            // Yöntem 2: key.properties'den okuma (ÖNERİLEN!)
            // def keystorePropertiesFile = rootProject.file("key.properties")
            // def keystoreProperties = new Properties()
            // keystoreProperties.load(new FileInputStream(keystorePropertiesFile))
            // 
            // storeFile file(keystoreProperties['storeFile'])
            // storePassword keystoreProperties['storePassword']
            // keyAlias keystoreProperties['keyAlias']
            // keyPassword keystoreProperties['keyPassword']
        }
    }

    buildTypes {
        release {
            signingConfig signingConfigs.release  // İmzalamayı aktifleştir
            minifyEnabled true
            shrinkResources true
            ...
        }
    }
}
```

---

## 📦 6. ADIM: İmzalı AAB Oluşturma

### Komut Satırı ile:

```bash
# Önce temizlik
./gradlew clean

# İmzalı AAB oluştur
./gradlew bundleRelease

# Çıktı: app/build/outputs/bundle/release/app-release.aab
```

### Android Studio ile:

1. **Build** → **Generate Signed Bundle / APK**
2. **Android App Bundle** seçin
3. **Next**
4. **Create new...** (ilk kez) veya mevcut keystore'u seçin
5. Keystore bilgilerini girin:
   - Key store path: `keystore/simplecalc-release.jks`
   - Key store password: [Keystore şifreniz]
   - Key alias: `simplecalc`
   - Key password: [Key şifreniz]
6. **Next**
7. **release** build variant seçin
8. ✅ **Finish**

Çıktı: `app/release/app-release.aab`

---

## ✅ 7. ADIM: İmza Doğrulama

AAB/APK dosyasının imzalandığını doğrulayın:

```bash
# AAB imza kontrolü
jarsigner -verify -verbose -certs app/build/outputs/bundle/release/app-release.aab

# Başarılı ise:
# jar verified.
```

### SHA256 Fingerprint Alma (Google Play için):

```bash
keytool -list -v -keystore keystore/simplecalc-release.jks -alias simplecalc

# SHA256 satırını not edin:
# SHA256: XX:XX:XX:XX:... (Google Play Console'da kullanılacak)
```

---

## 🎯 8. ADIM: Play App Signing (Google Tarafından)

Google Play artık **Play App Signing** kullanır. Bu ne demek?

### Eski Yöntem:
- Siz keystore'u yönetirsiniz
- Siz uygulamayı imzalarsınız
- Keystore kaybı = felaket

### Yeni Yöntem (Play App Signing):
- Google uygulamayı yeniden imzalar
- Google keystore'u yönetir
- Sizin keystore'unuz sadece yükleme için

### Nasıl Aktifleştirilir?

1. Google Play Console'da uygulama oluşturun
2. **Release** → **Setup** → **App Integrity**
3. **Use Google-generated key** seçin
4. İlk AAB'yi yükleyin
5. ✅ Google otomatik aktifleştirir

**Avantajlar:**
- ✅ Keystore kaybı sorun olmaz (Google yedeğe alır)
- ✅ APK optimizasyonu (daha küçük indirme)
- ✅ Güvenlik güncellemeleri

---

## 🗂️ 9. ADIM: Keystore Yedekleme

### Yedekleme Checklist:

```bash
# 1. Keystore dosyasını kopyalayın
cp keystore/simplecalc-release.jks ~/Documents/SimpleCalc-Backup/

# 2. Şifreleri kaydedin (güvenli not defteri)
echo "KEYSTORE PASSWORD: your_password" >> KEYSTORE_INFO.txt
echo "KEY PASSWORD: your_key_password" >> KEYSTORE_INFO.txt
echo "KEY ALIAS: simplecalc" >> KEYSTORE_INFO.txt

# 3. Bulut yedekleme
# Google Drive, Dropbox veya OneDrive'a yükleyin

# 4. USB/External disk yedek
# Fiziksel medyaya kopyalayın
```

### ⚠️ Yedekleme Kontrol Listesi:

- [ ] Keystore dosyası 3 farklı yerde
- [ ] Şifreler güvenli şifre yöneticisinde
- [ ] Bulut depolama yedeklendi
- [ ] USB/external disk yedeklendi
- [ ] SHA256 fingerprint kaydedildi
- [ ] key.properties yedeklendi (Git dışında)

---

## 🔑 Şifre Önerileri

### Güçlü Şifre Oluşturma:

```
❌ Zayıf: password123
❌ Zayıf: simplecalc2024
✅ Güçlü: Sc!2K24#mB@xP9q
✅ Güçlü: Y7$nM3@kL9pQ#2w
```

### Özellikler:
- En az 16 karakter
- Büyük/küçük harf
- Sayılar
- Özel karakterler (!@#$%^&*)
- Tahmin edilemez

### Şifre Yöneticileri:
- **1Password** (önerilen)
- **LastPass**
- **Bitwarden**
- **Google Password Manager**

---

## 📊 Özet Komutlar

### Hızlı Başlangıç:

```bash
# 1. Keystore dizini oluştur
mkdir -p keystore

# 2. Keystore oluştur (interaktif)
keytool -genkey -v -keystore keystore/simplecalc-release.jks \
  -alias simplecalc -keyalg RSA -keysize 2048 -validity 10000

# 3. Keystore doğrula
keytool -list -v -keystore keystore/simplecalc-release.jks

# 4. build.gradle'da signing config aktifleştir

# 5. İmzalı AAB oluştur
./gradlew clean bundleRelease

# 6. İmza doğrula
jarsigner -verify -verbose app/build/outputs/bundle/release/app-release.aab

# 7. Yedekle!
cp keystore/simplecalc-release.jks ~/Backup/
```

---

## 🐛 Sorun Giderme

### Hata: "keytool: command not found"
```bash
# Java JDK yüklü mü kontrol et
java -version

# JDK yolu ekle (macOS/Linux)
export PATH=$PATH:/usr/libexec/java_home/bin

# Windows için JDK path'i sistem değişkenlerine ekleyin
```

### Hata: "Failed to read key"
```bash
# Şifreleri kontrol edin
# Keystore ve key şifresi doğru mu?
```

### Hata: "Keystore was tampered with"
```bash
# Keystore dosyası bozulmuş
# Yedekten geri yükleyin veya yeni keystore oluşturun
# ⚠️ Yeni keystore = yeni uygulama!
```

---

## ✅ Final Checklist

Keystore oluşturma tamamlandı mı?

- [ ] Keystore dosyası oluşturuldu (`simplecalc-release.jks`)
- [ ] Keystore doğrulandı (`keytool -list`)
- [ ] Şifreler güvenli yerde saklandı
- [ ] `build.gradle`'da signing config yapılandırıldı
- [ ] İmzalı AAB başarıyla oluşturuldu
- [ ] İmza doğrulandı (`jarsigner -verify`)
- [ ] SHA256 fingerprint kaydedildi
- [ ] Keystore 3 farklı yere yedeklendi
- [ ] `.gitignore` keystore'u kapsıyor

✅ **Hepsi tamam ise Adım 8'e geçin!**

---

## 📞 Önemli Notlar

**Keystore kaybı durumunda:**
- ❌ Mevcut uygulamayı güncelleyemezsiniz
- ❌ Google Play yardımcı olamaz
- ✅ Yeni paket adı ile yeni uygulama yükleyebilirsiniz
- ✅ Play App Signing kullanıyorsanız Google yönetir

**Play App Signing avantajı:**
- Google keystore'u yedekler
- Upload keystore kaybedilirse yenisi oluşturulabilir
- %100 güvenli güncelleme

---

**Sonraki Adım: Google Play Console'a yükleme (Adım 8)**
