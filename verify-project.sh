#!/bin/bash

# SimpleCalc - Proje Doğrulama Scripti
# Projenin Google Play'e yüklenmeden önce hazır olup olmadığını kontrol eder

echo "======================================"
echo "SimpleCalc - Proje Doğrulama Kontrolü"
echo "======================================"
echo ""

# Renkler
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Kontrol sayaçları
PASSED=0
FAILED=0
WARNING=0

# Fonksiyon: Dosya kontrol et
check_file() {
    if [ -f "$1" ]; then
        echo -e "${GREEN}✓${NC} $1 mevcut"
        ((PASSED++))
        return 0
    else
        echo -e "${RED}✗${NC} $1 BULUNAMADI!"
        ((FAILED++))
        return 1
    fi
}

# Fonksiyon: Klasör kontrol et
check_dir() {
    if [ -d "$1" ]; then
        echo -e "${GREEN}✓${NC} $1/ dizini mevcut"
        ((PASSED++))
        return 0
    else
        echo -e "${RED}✗${NC} $1/ DİZİNİ BULUNAMADI!"
        ((FAILED++))
        return 1
    fi
}

echo "📋 1. TEMEL DOSYA YAPISI KONTROLÜ"
echo "-----------------------------------"
check_file "build.gradle"
check_file "settings.gradle"
check_file "gradle.properties"
check_file "app/build.gradle"
check_file "app/src/main/AndroidManifest.xml"
check_file "app/src/main/java/com/example/simplecalc/MainActivity.kt"
check_file "app/src/main/res/layout/activity_main.xml"
check_file "app/proguard-rules.pro"
echo ""

echo "🎨 2. KAYNAK DOSYALARI KONTROLÜ"
echo "--------------------------------"
check_file "app/src/main/res/values/strings.xml"
check_file "app/src/main/res/values/colors.xml"
check_file "app/src/main/res/values/themes.xml"
check_file "app/src/main/res/drawable/ic_launcher_foreground.xml"
echo ""

echo "🖼️ 3. LAUNCHER İKONLARI KONTROLÜ"
echo "--------------------------------"
check_file "app/src/main/res/mipmap-hdpi/ic_launcher.xml"
check_file "app/src/main/res/mipmap-mdpi/ic_launcher.xml"
check_file "app/src/main/res/mipmap-xhdpi/ic_launcher.xml"
check_file "app/src/main/res/mipmap-xxhdpi/ic_launcher.xml"
check_file "app/src/main/res/mipmap-xxxhdpi/ic_launcher.xml"
echo ""

echo "📄 4. GOOGLE PLAY GEREKLİ DOSYALAR"
echo "-----------------------------------"
check_file "PRIVACY_POLICY.md"
check_file "README.md"
echo ""

echo "🔍 5. BUILD YAPILANDIRMASI KONTROLÜ"
echo "------------------------------------"

# applicationId kontrolü
if grep -q 'applicationId "com.example.simplecalc"' app/build.gradle; then
    echo -e "${GREEN}✓${NC} applicationId doğru ayarlanmış"
    ((PASSED++))
else
    echo -e "${RED}✗${NC} applicationId ayarı bulunamadı!"
    ((FAILED++))
fi

# versionCode kontrolü
if grep -q 'versionCode' app/build.gradle; then
    echo -e "${GREEN}✓${NC} versionCode tanımlı"
    ((PASSED++))
else
    echo -e "${RED}✗${NC} versionCode tanımlı değil!"
    ((FAILED++))
fi

# versionName kontrolü
if grep -q 'versionName' app/build.gradle; then
    echo -e "${GREEN}✓${NC} versionName tanımlı"
    ((PASSED++))
else
    echo -e "${RED}✗${NC} versionName tanımlı değil!"
    ((FAILED++))
fi

# minSdk kontrolü
if grep -q 'minSdk 21' app/build.gradle; then
    echo -e "${GREEN}✓${NC} minSdk 21 (Android 5.0+)"
    ((PASSED++))
else
    echo -e "${YELLOW}⚠${NC} minSdk ayarı kontrol edilmeli"
    ((WARNING++))
fi

# targetSdk kontrolü
if grep -q 'targetSdk 34' app/build.gradle; then
    echo -e "${GREEN}✓${NC} targetSdk 34 (Android 14)"
    ((PASSED++))
else
    echo -e "${YELLOW}⚠${NC} targetSdk ayarı kontrol edilmeli"
    ((WARNING++))
fi

# AAB bundle ayarları
if grep -q 'bundle {' app/build.gradle; then
    echo -e "${GREEN}✓${NC} AAB bundle yapılandırması mevcut"
    ((PASSED++))
else
    echo -e "${RED}✗${NC} AAB bundle yapılandırması yok!"
    ((FAILED++))
fi

echo ""

echo "🔐 6. İMZALAMA KONTROLÜ"
echo "-----------------------"

if [ -f "keystore/simplecalc-release.jks" ]; then
    echo -e "${GREEN}✓${NC} Keystore dosyası mevcut"
    ((PASSED++))
else
    echo -e "${YELLOW}⚠${NC} Keystore henüz oluşturulmamış (Adım 7'de oluşturulacak)"
    ((WARNING++))
fi

if grep -q 'signingConfigs' app/build.gradle; then
    echo -e "${GREEN}✓${NC} signingConfigs tanımlanmış"
    ((PASSED++))
else
    echo -e "${YELLOW}⚠${NC} signingConfigs tanımlanmalı"
    ((WARNING++))
fi

echo ""

echo "📊 7. GRADLE WRAPPER KONTROLÜ"
echo "------------------------------"
check_file "gradlew"
check_dir "gradle/wrapper"
check_file "gradle/wrapper/gradle-wrapper.properties"

# gradlew çalıştırılabilir mi?
if [ -x "gradlew" ]; then
    echo -e "${GREEN}✓${NC} gradlew çalıştırılabilir"
    ((PASSED++))
else
    echo -e "${YELLOW}⚠${NC} gradlew çalıştırma izni yok (chmod +x gradlew)"
    ((WARNING++))
fi

echo ""

echo "======================================"
echo "SONUÇ ÖZETI"
echo "======================================"
echo -e "${GREEN}✓ Başarılı: $PASSED${NC}"
echo -e "${RED}✗ Hata: $FAILED${NC}"
echo -e "${YELLOW}⚠ Uyarı: $WARNING${NC}"
echo ""

if [ $FAILED -eq 0 ]; then
    echo -e "${GREEN}🎉 Proje yapısı TAMAM! Google Play'e yüklemeye hazır.${NC}"
    echo ""
    echo "Sonraki adımlar:"
    echo "1. Keystore oluştur (Adım 7)"
    echo "2. Release AAB oluştur: ./gradlew bundleRelease"
    echo "3. Google Play Console'a yükle (Adım 8)"
    exit 0
else
    echo -e "${RED}❌ Proje yapısında eksiklikler var! Lütfen hataları düzeltin.${NC}"
    exit 1
fi
