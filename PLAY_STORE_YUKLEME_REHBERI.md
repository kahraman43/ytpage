# 🚀 Android Hesap Makinesi - Google Play Store Yükleme Rehberi

Bu rehber, Android hesap makinesi uygulamanızı sıfırdan Google Play Store'a yüklemeniz için gereken TÜM adımları içerir.

---

## 📋 İçindekiler

1. [Gerekli Programlar](#1-gerekli-programlar)
2. [Projeyi İndirme ve Açma](#2-projeyi-i̇ndirme-ve-açma)
3. [Keystore Oluşturma](#3-keystore-oluşturma)
4. [APK/AAB Dosyası Oluşturma](#4-apkaab-dosyası-oluşturma)
5. [Google Play Console Hesabı](#5-google-play-console-hesabı)
6. [Uygulama Kaynaklarını Hazırlama](#6-uygulama-kaynaklarını-hazırlama)
7. [Play Console'a Yükleme](#7-play-consolea-yükleme)
8. [Test ve Yayınlama](#8-test-ve-yayınlama)

---

## 1. Gerekli Programlar

### 1.1 Android Studio Kurulumu

**İndirme Linki:** https://developer.android.com/studio

1. Yukarıdaki linkten Android Studio'yu indirin
2. İndirilen dosyayı çalıştırın
3. Kurulum sırasında "Standard" kurulum seçeneğini seçin
4. Android SDK'nın kurulmasını bekleyin (yaklaşık 5-10 dakika)

### 1.2 JDK (Java Development Kit) Kontrolü

Android Studio ile birlikte JDK otomatik olarak gelir. Kontrol etmek için:

**Windows:**
```
java -version
```

**Mac/Linux:**
```bash
java -version
```

Eğer kurulu değilse, Android Studio içinden File → Project Structure → SDK Location → JDK location kısmından kurabilirsiniz.

---

## 2. Projeyi İndirme ve Açma

### 2.1 Proje Dosyalarını İndirme

Bu workspace'deki tüm dosyaları bilgisayarınıza indirin. İndirme işlemi için:

**Seçenek A - Cursor/IDE'den indirme:**
1. Workspace'deki tüm dosyaları seçin
2. Sağ tık → "Download" veya "Export"
3. Bilgisayarınızda bir klasör oluşturun (örn: `C:\AndroidProjects\HesapMakinesi`)
4. Dosyaları bu klasöre çıkarın

**Seçenek B - Manuel indirme:**
1. Her dosyayı tek tek açıp içeriğini kopyalayın
2. Aynı klasör yapısında bilgisayarınızda oluşturun

### 2.2 Projeyi Android Studio'da Açma

1. Android Studio'yu açın
2. "Open an Existing Project" seçeneğine tıklayın
3. İndirdiğiniz proje klasörünü seçin (HesapMakinesi klasörü)
4. "OK" butonuna tıklayın
5. Gradle sync işleminin tamamlanmasını bekleyin (ilk açılışta 5-10 dakika sürebilir)

### 2.3 İlk Çalıştırma ve Test

1. Android Studio'da yukarıda yeşil bir "Run" (▶️) butonu göreceksiniz
2. Bu butona tıklamadan önce bir emülatör oluşturun:
   - Tools → Device Manager
   - "Create Device" butonuna tıklayın
   - "Pixel 6" veya "Pixel 7" seçin → Next
   - "UpsideDownCake" (API 34) veya en güncel Android versiyonunu seçin → Next
   - "Finish" butonuna tıklayın

3. Emülatör hazır olduğunda "Run" (▶️) butonuna tıklayın
4. Uygulamanızın emülatörde çalıştığını göreceksiniz

---

## 3. Keystore Oluşturma

Keystore, uygulamanızın dijital imzasıdır. Bu dosyayı oluşturduktan sonra **ASLA KAYBETMEYİN!**

### 3.1 Otomatik Yöntem (Kolay)

Proje klasöründe `app/keystore-olusturma.sh` dosyası hazır. Ancak bu basit bir örnek. Gerçek uygulama için aşağıdaki manuel yöntemi kullanın.

### 3.2 Manuel Yöntem (Önerilen)

**Windows için:**

1. Command Prompt'u açın (Win+R → cmd → Enter)
2. Şu komutu çalıştırın:

```cmd
"%JAVA_HOME%\bin\keytool" -genkey -v -keystore "C:\Users\KULLANICI_ADI\hesapmakinesi-release.jks" -alias hesapmakinesi -keyalg RSA -keysize 2048 -validity 10000
```

**Mac/Linux için:**

```bash
keytool -genkey -v -keystore ~/hesapmakinesi-release.jks -alias hesapmakinesi -keyalg RSA -keysize 2048 -validity 10000
```

### 3.3 Bilgileri Doldurma

Komut çalıştırıldıktan sonra size bazı sorular soracak:

```
Enter keystore password: [güçlü bir şifre girin, örn: MyApp2024!@#]
Re-enter new password: [aynı şifreyi tekrar girin]
What is your first and last name?: [Adınız Soyadınız]
What is the name of your organizational unit?: [Developer veya boş bırakın]
What is the name of your organization?: [Şirket adı veya kişisel isminiz]
What is the name of your City or Locality?: [İstanbul]
What is the name of your State or Province?: [İstanbul]
What is the two-letter country code?: [TR]
Is CN=..., correct?: [yes yazın]
Enter key password: [Enter basın - keystore şifresi ile aynı olacak]
```

### 3.4 ÖNEMLİ NOTLAR

**🔴 ÇOK ÖNEMLİ - MUTLAKA OKUYUN:**

1. **Keystore dosyasını (`hesapmakinesi-release.jks`) bir flash belleğe veya cloud'a yedekleyin!**
2. **Şifrenizi bir yere not edin ve güvenli bir yerde saklayın!**
3. **Bu bilgileri kaybederseniz, uygulamanızı asla güncelleyemezsiniz!**
4. **Her güncellemede aynı keystore ile imzalamanız gerekir!**

---

## 4. APK/AAB Dosyası Oluşturma

Google Play Store, artık AAB (Android App Bundle) formatını tercih ediyor.

### 4.1 Keystore Bilgilerini Projeye Ekleme

1. Proje klasöründe `keystore.properties` dosyası oluşturun:

```properties
storePassword=BURAYA_KEYSTORE_ŞİFRENİZ
keyPassword=BURAYA_KEY_ŞİFRENİZ
keyAlias=hesapmakinesi
storeFile=BURAYA_KEYSTORE_DOSYA_YOLU
```

**Örnek:**
```properties
storePassword=MyApp2024!@#
keyPassword=MyApp2024!@#
keyAlias=hesapmakinesi
storeFile=C:\\Users\\Ahmet\\hesapmakinesi-release.jks
```

2. `app/build.gradle.kts` dosyasını güncelleyin:

Bu dosyayı açın ve `android` bloğunun en başına şunu ekleyin:

```kotlin
android {
    namespace = "com.hesapmakinesi.app"
    compileSdk = 34

    // Bu satırları ekleyin
    val keystorePropertiesFile = rootProject.file("keystore.properties")
    val keystoreProperties = java.util.Properties()
    if (keystorePropertiesFile.exists()) {
        keystoreProperties.load(java.io.FileInputStream(keystorePropertiesFile))
    }

    defaultConfig {
        applicationId = "com.hesapmakinesi.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        // ... rest of config
    }

    // Bu bloğu da ekleyin (buildTypes'dan ÖNCE)
    signingConfigs {
        create("release") {
            if (keystorePropertiesFile.exists()) {
                storeFile = file(keystoreProperties["storeFile"] as String)
                storePassword = keystoreProperties["storePassword"] as String
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release") // Bu satırı ekleyin
        }
    }
    // ... rest of file
}
```

### 4.2 AAB Dosyası Oluşturma (Play Store için)

1. Android Studio'da üst menüden **Build → Generate Signed Bundle / APK**
2. **Android App Bundle** seçeneğini seçin → Next
3. Keystore bilgilerinizi girin:
   - Key store path: keystore dosyanızın yolu
   - Key store password: keystore şifreniz
   - Key alias: hesapmakinesi
   - Key password: key şifreniz
4. **Remember passwords** kutusunu işaretleyin
5. Next → **release** seçeneğini seçin
6. **Finish** butonuna tıklayın

**Alternatif - Terminal/CMD ile:**

Proje klasöründe şu komutu çalıştırın:

**Windows:**
```cmd
gradlew.bat bundleRelease
```

**Mac/Linux:**
```bash
./gradlew bundleRelease
```

### 4.3 Dosyayı Bulma

AAB dosyası şu konumda oluşacak:
```
app/build/outputs/bundle/release/app-release.aab
```

Bu dosyayı masaüstüne veya kolay bulabileceğiniz bir yere kopyalayın.

---

## 5. Google Play Console Hesabı

### 5.1 Hesap Oluşturma

1. https://play.google.com/console adresine gidin
2. "Sign up" veya "Kayıt Ol" butonuna tıklayın
3. Google hesabınız ile giriş yapın
4. **$25 (bir kerelik ücret)** ödeme yapın - kredi kartı gerekli

### 5.2 Geliştirici Bilgilerini Doldurma

1. İsim/Şirket adı
2. E-posta adresi (support için)
3. Web sitesi (yoksa sosyal medya linki de olabilir)
4. Şartlar ve koşulları kabul edin

### 5.3 Hesabın Onaylanması

Google hesabınızı onaylaması 1-2 gün sürebilir. Onaylandığında e-posta alacaksınız.

---

## 6. Uygulama Kaynaklarını Hazırlama

Play Store'da yayınlamak için şu görsellere ihtiyacınız var:

### 6.1 Uygulama İkonu

- **Boyut:** 512x512 piksel
- **Format:** PNG (şeffaf arkaplan)
- **Online araçlar:** 
  - https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html
  - https://www.canva.com (ücretsiz tasarım aracı)

**İpucu:** Basit bir hesap makinesi ikonu kullanın - sayılar, matematik işaretleri içeren modern bir tasarım.

### 6.2 Ekran Görüntüleri

Play Store için minimum 2, maksimum 8 ekran görüntüsü gerekli.

**Nasıl alınır:**

1. Android Studio'da emülatörü çalıştırın
2. Uygulamanızı açın
3. Emülatörün sağ tarafındaki araç çubuğundan kamera ikonuna tıklayın
4. "Save" butonuna tıklayın

**Gerekli görüntüler:**
- Ana hesap makinesi ekranı (sayılar ve butonlar görünür şekilde)
- Bir hesaplama işlemi gösterilen ekran (örn: 125 + 389 = 514)
- Sonuç gösterilen ekran

**Boyutlar:**
- **Telefon:** En az 320px genişlik, en az 16:9 aspect ratio
- Önerilen: 1080x1920 (Full HD dikey)

### 6.3 Feature Graphic (Öne Çıkan Grafik)

- **Boyut:** 1024x500 piksel
- **Format:** PNG veya JPG
- **İçerik:** Uygulama adı ve ikonu içeren çekici bir görsel

**Canva şablonu:**
1. https://www.canva.com adresine gidin
2. "Custom size" seçin: 1024 x 500 px
3. Ortaya uygulama ikonunu koyun
4. "Hesap Makinesi" yazısı ekleyin
5. Modern bir arka plan rengi seçin (turuncu veya koyu gri önerilir)

---

## 7. Play Console'a Yükleme

### 7.1 Yeni Uygulama Oluşturma

1. https://play.google.com/console adresine gidin
2. "Create app" veya "Uygulama oluştur" butonuna tıklayın
3. Bilgileri doldurun:
   - **App name:** Hesap Makinesi
   - **Default language:** Türkçe (Türkiye)
   - **App or game:** App
   - **Free or paid:** Free
4. Şartları kabul edin → "Create app"

### 7.2 Store Listeleme (Store Listing)

Sol menüden **Store presence → Main store listing**:

#### 7.2.1 Temel Bilgiler

**App name:**
```
Hesap Makinesi
```

**Short description (80 karakter max):**
```
Basit ve kullanışlı hesap makinesi uygulaması
```

**Full description:**
```
Modern ve kullanımı kolay hesap makinesi uygulaması!

ÖZELLİKLER:
✓ Temel matematik işlemleri (toplama, çıkarma, çarpma, bölme)
✓ Yüzde hesaplama
✓ İşaret değiştirme
✓ Modern ve şık tasarım
✓ Koyu tema
✓ Hızlı ve akıcı kullanım

Günlük hesaplamalarınız için mükemmel bir araç!

TAM ÜCRETSİZ - Reklam yok!
```

#### 7.2.2 Görseller

1. **App icon:** 512x512 PNG dosyanızı yükleyin
2. **Phone screenshots:** En az 2 tane yükleyin
3. **Feature graphic:** 1024x500 PNG/JPG dosyasını yükleyin

#### 7.2.3 Uygulama Detayları

**App category:** Tools (Araçlar)

**Contact details:**
- Email: kendi email adresiniz
- (Opsiyonel) Telefon
- (Opsiyonel) Website

**Save draft** butonuna tıklayın

### 7.3 App Content (Uygulama İçeriği)

Sol menüden **Policy → App content**:

#### 7.3.1 Privacy Policy

Eğer veri toplamıyorsanız:
1. "Start" butonuna tıklayın
2. "This app does not collect any user data" seçeneğini işaretleyin
3. Save

#### 7.3.2 App Access

1. "Start" → "All features are available to all users" seçin → Save

#### 7.3.3 Ads

1. "Start" → "No, my app does not contain ads" → Save

#### 7.3.4 Content Rating

1. "Start questionnaire" butonuna tıklayın
2. **Email address:** email adresiniz
3. **Category:** Utility, Productivity, Communication, or Other (Araçlar seçin)
4. Sorulara cevap verin (hepsi "No" olabilir)
5. "Save questionnaire"
6. "Submit" butonuna tıklayın
7. "Apply rating" butonuna tıklayın

#### 7.3.5 Target Audience

1. "Start" butonuna tıklayın
2. **Age groups:** 18 and over seçin (18 yaş üzeri)
3. "Store listing appeal": No seçin
4. Save

#### 7.3.6 News Apps

"This is not a news app" seçin → Save

#### 7.3.7 COVID-19 Contact Tracing & Status Apps

"Not applicable" seçin → Save

#### 7.3.8 Data Safety

1. "Start" butonuna tıklayın
2. **"Does your app collect or share any user data?"** → No seçin
3. Next → Submit

### 7.4 Release (Sürüm) Oluşturma

#### 7.4.1 İç Test (Internal Testing) - Önerilen İlk Adım

1. Sol menüden **Testing → Internal testing**
2. "Create new release" butonuna tıklayın
3. **App bundles:** "Upload" butonuna tıklayın
4. `app-release.aab` dosyanızı seçin
5. **Release name:** 1 (otomatik gelecek)
6. **Release notes:** 
   ```
   İlk sürüm
   - Temel hesap makinesi fonksiyonları
   - Modern tasarım
   ```
7. "Save" → "Review release"
8. "Start rollout to Internal testing" butonuna tıklayın

**Test için:**
- "Testers" sekmesine gidin
- Email listesi oluşturun (kendi mailinizi ekleyin)
- Testers'a gönderilen link ile uygulamayı test edin

#### 7.4.2 Production (Yayınlama)

**Internal test başarılıysa:**

1. Sol menüden **Production**
2. "Create new release" butonuna tıklayın
3. **App bundles:** Daha önce yüklediğiniz AAB otomatik gelecek
4. **Release notes:** Aynı notları girin
5. "Save" → "Review release"
6. "Start rollout to Production" butonuna tıklayın

---

## 8. Test ve Yayınlama

### 8.1 İnceleme Süresi

Google, uygulamanızı inceleyecek. Bu süreç:
- **İç test:** Genellikle birkaç saat
- **Production:** 1-3 gün

### 8.2 İnceleme Durumu

Play Console'da **Dashboard** sayfasından durumu takip edebilirsiniz.

### 8.3 Yayınlanma

Onaylandıktan sonra:
- Uygulamanız Play Store'da görünecek
- Play Store'da "Hesap Makinesi" diye aratarak bulabilirsiniz
- Link şu formatta olacak: `https://play.google.com/store/apps/details?id=com.hesapmakinesi.app`

### 8.4 İlk Kullanıcılara Ulaşma

Uygulamanız yayınlandıktan sonra:
1. Sosyal medyada paylaşın
2. Arkadaşlarınıza gönderin
3. Play Store linkini web sitenize ekleyin

---

## 9. Güncelleme Nasıl Yapılır?

### 9.1 Versiyon Güncelleme

`app/build.gradle.kts` dosyasında:

```kotlin
defaultConfig {
    versionCode = 2      // Her güncellemede +1 artırın
    versionName = "1.1"  // Kullanıcıya gösterilen versiyon
}
```

### 9.2 Yeni AAB Oluşturma

1. Değişiklikleri yapın
2. Yeni AAB oluşturun (Build → Generate Signed Bundle)
3. Play Console → Production → "Create new release"
4. Yeni AAB'yi yükleyin
5. Release notes'a değişiklikleri yazın
6. "Review release" → "Start rollout to Production"

---

## 10. Sık Karşılaşılan Sorunlar

### 10.1 "Invalid Keystore Format" Hatası

**Çözüm:** Keystore oluştururken `-keystore` parametresinden sonra tam dosya yolunu `.jks` uzantısı ile verin.

### 10.2 "Upload Failed" Hatası

**Çözüm:** 
- İnternet bağlantınızı kontrol edin
- AAB dosyasının boyutunu kontrol edin (max 150MB)
- Tarayıcı cache'ini temizleyin

### 10.3 "You uploaded an APK that is not signed with the upload certificate" Hatası

**Çözüm:** Her zaman aynı keystore ile imzalayın. Farklı keystore kullanırsanız güncelleme yapamazsınız.

### 10.4 "Need to complete App Content section"

**Çözüm:** Policy → App content altındaki tüm bölümleri doldurun ve yeşil onay işareti alın.

---

## 11. Ekstra Kaynaklar

### 11.1 Resmi Dökümanlar

- **Android Developers:** https://developer.android.com
- **Play Console Yardım:** https://support.google.com/googleplay/android-developer
- **App Bundle Rehberi:** https://developer.android.com/guide/app-bundle

### 11.2 Tasarım Araçları

- **Canva (Ücretsiz):** https://www.canva.com
- **Figma (Ücretsiz):** https://www.figma.com
- **Android Asset Studio:** https://romannurik.github.io/AndroidAssetStudio/

### 11.3 İkon Kaynakları

- **Material Icons:** https://fonts.google.com/icons
- **Flaticon:** https://www.flaticon.com
- **Icons8:** https://icons8.com

---

## 12. İletişim ve Destek

Herhangi bir sorunuz olursa:

1. **Android Developers Forum:** https://developer.android.com/community
2. **Stack Overflow:** https://stackoverflow.com/questions/tagged/android
3. **Reddit r/androiddev:** https://reddit.com/r/androiddev

---

## ✅ Kontrol Listesi

Yayınlamadan önce kontrol edin:

- [ ] Android Studio kuruldu
- [ ] Proje dosyaları indirildi ve açıldı
- [ ] Uygulama emülatörde test edildi
- [ ] Keystore dosyası oluşturuldu ve yedeklendi
- [ ] keystore.properties dosyası oluşturuldu
- [ ] app/build.gradle.kts güncellendi (signing config eklendi)
- [ ] AAB dosyası oluşturuldu
- [ ] Google Play Console hesabı açıldı ($25 ödendi)
- [ ] Uygulama ikonu hazır (512x512)
- [ ] Ekran görüntüleri hazır (en az 2 adet)
- [ ] Feature graphic hazır (1024x500)
- [ ] Store listing dolduruldu
- [ ] App content bölümleri tamamlandı
- [ ] AAB yüklendi
- [ ] Internal test yapıldı (opsiyonel ama önerilir)
- [ ] Production'a gönderildi

---

## 🎉 Tebrikler!

Bu rehberi takip ederek uygulamanızı başarıyla Google Play Store'a yükleyebilirsiniz!

**İyi şanslar! 🚀**

---

**Son Güncelleme:** 2025-10-16
**Versiyon:** 1.0
