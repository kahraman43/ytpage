#!/bin/bash

# Bu script, Android uygulamanız için keystore dosyası oluşturur.
# Google Play Store'a yüklemek için bu dosya GEREKLİDİR!

echo "====================================="
echo "Android Keystore Oluşturma Scripti"
echo "====================================="
echo ""
echo "Bu script size keystore oluşturmanızda yardımcı olacak."
echo "Aşağıdaki bilgileri girerken NOTUNUZU ALIN - bunlara sonra ihtiyacınız olacak!"
echo ""
echo "Keystore oluşturuluyor..."
echo ""

keytool -genkey -v -keystore release-keystore.jks \
  -alias hesapmakinesi-key \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -storepass android123 \
  -keypass android123 \
  -dname "CN=Hesap Makinesi, OU=Development, O=MyCompany, L=Istanbul, ST=Istanbul, C=TR"

echo ""
echo "====================================="
echo "✓ Keystore başarıyla oluşturuldu!"
echo "====================================="
echo ""
echo "Dosya: release-keystore.jks"
echo "Alias: hesapmakinesi-key"
echo "Password: android123"
echo ""
echo "ÖNEMLİ NOTLAR:"
echo "1. Bu keystore dosyasını GÜVENLİ BİR YERDE SAKLAYIN!"
echo "2. Şifrenizi UNUTMAYIN!"
echo "3. Bu dosyayı kaybederseniz, uygulamanızı güncelleyemezsiniz!"
echo "4. Google Play'e ilk yüklemeden sonra aynı keystore ile imzalamalısınız!"
echo ""
