#!/bin/bash

# SimpleCalc - Keystore Oluşturma Script
# Bu script keystore oluşturma işlemini kolaylaştırır

echo "======================================"
echo "SimpleCalc - Keystore Oluşturma"
echo "======================================"
echo ""

# Renkler
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Keystore dizini kontrolü
if [ ! -d "keystore" ]; then
    echo -e "${YELLOW}⚠ keystore/ dizini bulunamadı. Oluşturuluyor...${NC}"
    mkdir -p keystore
    echo -e "${GREEN}✓ keystore/ dizini oluşturuldu${NC}"
fi

echo ""
echo -e "${BLUE}📋 Keystore Bilgileri:${NC}"
echo "-----------------------------------"
echo "Alias: simplecalc"
echo "Algorithm: RSA"
echo "Key Size: 2048 bit"
echo "Validity: 10000 days (~27 years)"
echo "Output: keystore/simplecalc-release.jks"
echo ""

echo -e "${YELLOW}⚠️  ÖNEMLİ UYARILAR:${NC}"
echo "1. Keystore şifresini ASLA unutmayın!"
echo "2. Key şifresini ASLA kaybetmeyin!"
echo "3. Bu dosyayı 3 farklı yere yedekleyin!"
echo "4. Git'e ASLA eklemeyin!"
echo ""

# Kullanıcıdan onay al
read -p "Keystore oluşturmaya devam etmek istiyor musunuz? (y/n): " -n 1 -r
echo ""

if [[ ! $REPLY =~ ^[Yy]$ ]]; then
    echo -e "${RED}❌ İşlem iptal edildi.${NC}"
    exit 1
fi

echo ""
echo -e "${BLUE}📝 Lütfen bilgileri girin:${NC}"
echo "-----------------------------------"

# Keystore şifresi
read -sp "Keystore şifresi: " STORE_PASS
echo ""
read -sp "Keystore şifresi (tekrar): " STORE_PASS2
echo ""

if [ "$STORE_PASS" != "$STORE_PASS2" ]; then
    echo -e "${RED}❌ Şifreler eşleşmiyor!${NC}"
    exit 1
fi

# Key şifresi
read -sp "Key şifresi: " KEY_PASS
echo ""
read -sp "Key şifresi (tekrar): " KEY_PASS2
echo ""

if [ "$KEY_PASS" != "$KEY_PASS2" ]; then
    echo -e "${RED}❌ Şifreler eşleşmiyor!${NC}"
    exit 1
fi

# DN bilgileri
read -p "İsim (CN) [SimpleCalc]: " CN
CN=${CN:-SimpleCalc}

read -p "Organizasyon Birimi (OU) [Mobile Development]: " OU
OU=${OU:-Mobile Development}

read -p "Organizasyon (O) [YourCompany]: " ORG
ORG=${ORG:-YourCompany}

read -p "Şehir (L) [Istanbul]: " CITY
CITY=${CITY:-Istanbul}

read -p "Eyalet/İl (ST) [Istanbul]: " STATE
STATE=${STATE:-Istanbul}

read -p "Ülke Kodu (C) [TR]: " COUNTRY
COUNTRY=${COUNTRY:-TR}

echo ""
echo -e "${BLUE}🔧 Keystore oluşturuluyor...${NC}"
echo ""

# Keystore oluştur
keytool -genkey -v \
  -keystore keystore/simplecalc-release.jks \
  -alias simplecalc \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000 \
  -storepass "$STORE_PASS" \
  -keypass "$KEY_PASS" \
  -dname "CN=$CN, OU=$OU, O=$ORG, L=$CITY, ST=$STATE, C=$COUNTRY"

# Sonuç kontrolü
if [ $? -eq 0 ]; then
    echo ""
    echo -e "${GREEN}✅ Keystore başarıyla oluşturuldu!${NC}"
    echo ""
    echo "Dosya: keystore/simplecalc-release.jks"
    echo ""
    
    # key.properties oluştur
    echo -e "${BLUE}📝 key.properties dosyası oluşturuluyor...${NC}"
    cat > key.properties << EOF
storePassword=$STORE_PASS
keyPassword=$KEY_PASS
keyAlias=simplecalc
storeFile=../keystore/simplecalc-release.jks
EOF
    echo -e "${GREEN}✓ key.properties oluşturuldu${NC}"
    echo ""
    
    # Doğrulama
    echo -e "${BLUE}🔍 Keystore doğrulanıyor...${NC}"
    echo ""
    keytool -list -v -keystore keystore/simplecalc-release.jks -storepass "$STORE_PASS"
    echo ""
    
    # Yedekleme hatırlatması
    echo -e "${YELLOW}⚠️  ŞİMDİ YAPMANIZ GEREKENLER:${NC}"
    echo "-----------------------------------"
    echo "1. ✅ Keystore dosyasını yedekleyin:"
    echo "   cp keystore/simplecalc-release.jks ~/Backup/"
    echo ""
    echo "2. ✅ Şifreleri güvenli yere kaydedin:"
    echo "   Keystore: $STORE_PASS"
    echo "   Key: $KEY_PASS"
    echo ""
    echo "3. ✅ SHA256 fingerprint'i kaydedin:"
    echo "   (Yukarıdaki çıktıda SHA256 satırını kopyalayın)"
    echo ""
    echo "4. ✅ build.gradle'da signing config'i aktifleştirin"
    echo ""
    echo "5. ✅ İmzalı AAB oluşturun:"
    echo "   ./gradlew bundleRelease"
    echo ""
    
    # Şifreleri dosyaya kaydet (opsiyonel)
    read -p "Şifreleri KEYSTORE_INFO.txt dosyasına kaydetmek ister misiniz? (y/n): " -n 1 -r
    echo ""
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        cat > KEYSTORE_INFO.txt << EOF
SimpleCalc - Keystore Information
==================================

⚠️  BU DOSYAYI GÜVENLİ TUTUN!
⚠️  GIT'E ASLA EKLEMEYİN!

Keystore File: keystore/simplecalc-release.jks
Key Alias: simplecalc
Keystore Password: $STORE_PASS
Key Password: $KEY_PASS

DN Information:
CN: $CN
OU: $OU
O: $ORG
L: $CITY
ST: $STATE
C: $COUNTRY

Created: $(date)

SHA256 Fingerprint:
(keytool -list -v -keystore keystore/simplecalc-release.jks komutu ile alın)
EOF
        echo -e "${GREEN}✓ Şifreler KEYSTORE_INFO.txt'ye kaydedildi${NC}"
        echo -e "${YELLOW}⚠️  Bu dosyayı güvenli tutun ve Git'e eklemeyin!${NC}"
    fi
    
    echo ""
    echo -e "${GREEN}🎉 Keystore hazır! Adım 8'e geçebilirsiniz.${NC}"
    
else
    echo ""
    echo -e "${RED}❌ Keystore oluşturulamadı! Lütfen hataları kontrol edin.${NC}"
    exit 1
fi
