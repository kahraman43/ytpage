# 📥 Proje Dosyalarını Bilgisayarınıza İndirme

Bu rehber, workspace'teki proje dosyalarını bilgisayarınıza nasıl indireceğinizi adım adım anlatır.

---

## Yöntem 1: Cursor/IDE ile İndirme (En Kolay)

### 1. Tüm Dosyaları Seç

1. Cursor veya kullandığınız IDE'nin sol tarafındaki dosya gezginini açın
2. En üstteki klasöre sağ tıklayın
3. "Download" veya "Export" seçeneğini arayın

### 2. Kayıt Yeri Seçin

1. Bilgisayarınızda bir klasör oluşturun:
   - **Windows:** `C:\AndroidProjects\HesapMakinesi`
   - **Mac:** `/Users/[kullaniciadi]/AndroidProjects/HesapMakinesi`
   - **Linux:** `~/AndroidProjects/HesapMakinesi`

2. İndirilen dosyaları bu klasöre çıkarın

---

## Yöntem 2: Git ile İndirme (Eğer Git Kullanıyorsanız)

### 1. Git Kurulumu Kontrolü

Terminal/Command Prompt açın ve:

```bash
git --version
```

Eğer kurulu değilse: https://git-scm.com/downloads

### 2. Projeyi Clone Etme

Eğer proje bir git repository ise:

```bash
cd C:\AndroidProjects  # veya istediğiniz bir klasör
git clone [REPOSITORY_URL]
```

---

## Yöntem 3: Manuel İndirme (En Detaylı Kontrol)

Eğer diğer yöntemler çalışmazsa, dosyaları manuel olarak kopyalayabilirsiniz.

### 1. Klasör Yapısını Oluşturun

Bilgisayarınızda şu klasör yapısını oluşturun:

```
HesapMakinesi/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── kotlin/
│   │       │   └── com/
│   │       │       └── hesapmakinesi/
│   │       │           └── app/
│   │       │               └── ui/
│   │       │                   └── theme/
│   │       ├── res/
│   │       │   ├── values/
│   │       │   ├── values-night/
│   │       │   ├── mipmap-anydpi-v26/
│   │       │   └── drawable/
│   │       └── AndroidManifest.xml
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   ├── keystore-olusturma.sh
│   └── .gitignore
├── gradle/
│   └── wrapper/
│       └── gradle-wrapper.properties
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── local.properties
├── .gitignore
├── gradlew
├── gradlew.bat
├── keystore.properties.example
├── README.md
├── PLAY_STORE_YUKLEME_REHBERI.md
└── DOSYALARI_INDIRME.md
```

### 2. Dosyaları Kopyalayın

Her dosyayı workspace'ten açın ve içeriğini kopyalayıp yapıştırın:

#### Kök Dizin Dosyaları
1. `build.gradle.kts`
2. `settings.gradle.kts`
3. `gradle.properties`
4. `local.properties`
5. `.gitignore`
6. `gradlew`
7. `gradlew.bat`
8. `keystore.properties.example`
9. `README.md`
10. `PLAY_STORE_YUKLEME_REHBERI.md`
11. `DOSYALARI_INDIRME.md` (bu dosya)

#### App Klasörü
1. `app/build.gradle.kts`
2. `app/proguard-rules.pro`
3. `app/.gitignore`
4. `app/keystore-olusturma.sh`

#### Kotlin Kaynak Dosyaları
1. `app/src/main/kotlin/com/hesapmakinesi/app/MainActivity.kt`
2. `app/src/main/kotlin/com/hesapmakinesi/app/CalculatorScreen.kt`
3. `app/src/main/kotlin/com/hesapmakinesi/app/CalculatorViewModel.kt`
4. `app/src/main/kotlin/com/hesapmakinesi/app/ui/theme/Theme.kt`
5. `app/src/main/kotlin/com/hesapmakinesi/app/ui/theme/Type.kt`

#### XML Kaynak Dosyaları
1. `app/src/main/AndroidManifest.xml`
2. `app/src/main/res/values/strings.xml`
3. `app/src/main/res/values/colors.xml`
4. `app/src/main/res/values/themes.xml`
5. `app/src/main/res/values/ic_launcher_background.xml`
6. `app/src/main/res/values-night/themes.xml`
7. `app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml`
8. `app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml`
9. `app/src/main/res/drawable/ic_launcher_foreground.xml`

#### Gradle Wrapper
1. `gradle/wrapper/gradle-wrapper.properties`

---

## Yöntem 4: ZIP Olarak İndirme

Eğer IDE'nizde ZIP export özelliği varsa:

1. Proje klasörüne sağ tık
2. "Export as ZIP" veya "Compress" seçin
3. Bilgisayarınıza kaydedin
4. ZIP dosyasını çıkarın

---

## ✅ İndirme Sonrası Kontrol

Dosyaları indirdikten sonra aşağıdakileri kontrol edin:

### 1. Klasör Yapısı Kontrolü

Terminalde proje klasörüne gidin:

**Windows:**
```cmd
cd C:\AndroidProjects\HesapMakinesi
dir
```

**Mac/Linux:**
```bash
cd ~/AndroidProjects/HesapMakinesi
ls -la
```

Şunları görmelisiniz:
- `app/` klasörü
- `gradle/` klasörü
- `build.gradle.kts`
- `settings.gradle.kts`
- `gradlew` (veya `gradlew.bat`)
- `README.md`

### 2. Dosya İzinleri (Mac/Linux)

Gradlew dosyasına çalıştırma izni verin:

```bash
chmod +x gradlew
```

### 3. Dosya Uzantıları (Windows)

Windows'ta dosya uzantılarının görünür olduğundan emin olun:
- Dosya Gezgini → Görünüm → Dosya adı uzantıları (işaretleyin)

---

## 🔍 Yaygın Sorunlar ve Çözümleri

### Sorun 1: Dosyalar Eksik

**Çözüm:** 
- Yukarıdaki dosya listesini kontrol edin
- Her dosyanın doğru konumda olduğundan emin olun

### Sorun 2: Klasör Yapısı Yanlış

**Çözüm:**
- README.md dosyasındaki "Proje Yapısı" bölümüne bakın
- Klasör yapısını ona göre düzenleyin

### Sorun 3: gradlew Çalışmıyor

**Çözüm (Mac/Linux):**
```bash
chmod +x gradlew
```

**Çözüm (Windows):**
- `gradlew.bat` dosyasını kullanın

### Sorun 4: Kotlin Dosyaları Bulunamıyor

**Çözüm:**
- Kotlin dosyalarının tam yolu: `app/src/main/kotlin/com/hesapmakinesi/app/`
- Her klasörü tek tek oluşturun

---

## 📱 İndirme Sonrası İlk Adımlar

### 1. Android Studio'da Açma

1. Android Studio'yu başlatın
2. "Open an Existing Project" seçin
3. İndirdiğiniz `HesapMakinesi` klasörünü seçin
4. "OK" butonuna tıklayın

### 2. Gradle Sync

İlk açılışta Gradle otomatik olarak sync olacak. Bu işlem:
- İlk kez: 10-15 dakika
- İkinci kez: 2-3 dakika

### 3. İlk Çalıştırma

1. Bir emülatör oluşturun (Tools → Device Manager)
2. Run (▶️) butonuna tıklayın
3. Uygulamanın açıldığını göreceksiniz

---

## 🎯 Sonraki Adım

Dosyaları başarıyla indirdiğinizde, şimdi Play Store'a yükleme için:

👉 **PLAY_STORE_YUKLEME_REHBERI.md** dosyasını okuyun

Bu rehber size şunları gösterecek:
- ✅ Keystore oluşturma
- ✅ Release build oluşturma
- ✅ Play Console'da uygulama oluşturma
- ✅ Yayınlama süreci

---

## 💾 Alternatif: Doğrudan APK İndirme

Eğer sadece uygulamayı test etmek istiyorsanız:

1. Android Studio'da Build → Build Bundle(s) / APK(s) → Build APK(s)
2. APK dosyası `app/build/outputs/apk/debug/` klasöründe oluşacak
3. Bu APK'yı telefonunuza yükleyerek test edebilirsiniz

**NOT:** Play Store'a yüklemek için AAB (Android App Bundle) gerekir, APK değil!

---

## 🆘 Yardım

Eğer dosyaları indirmekte sorun yaşıyorsanız:

1. IDE'nizin dökümanlarına bakın
2. IDE'nin "Export" veya "Download" özelliklerini arayın
3. Gerekirse manuel olarak her dosyayı kopyalayın

---

## ✅ Kontrol Listesi

İndirme tamamlandığında kontrol edin:

- [ ] Tüm klasörler oluşturuldu (app, gradle, etc.)
- [ ] Kotlin dosyaları doğru yerde
- [ ] XML kaynak dosyaları doğru yerde
- [ ] Gradle dosyaları mevcut
- [ ] README.md ve rehberler mevcut
- [ ] gradlew çalıştırılabilir (Mac/Linux için chmod +x)
- [ ] Android Studio projeyi açabiliyor
- [ ] Gradle sync başarılı

---

**Başarılar! 🎉**

Bir sonraki adım için: **PLAY_STORE_YUKLEME_REHBERI.md**
