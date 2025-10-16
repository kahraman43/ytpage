# SimpleCalc ProGuard kuralları
# Release build için kod gizleme ve optimizasyon kuralları

# Android bileşenleri için standart kurallar
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

# Kotlin için standart kurallar
-keep class kotlin.Metadata { *; }

# AndroidX için kurallar
-keep class androidx.** { *; }
-dontwarn androidx.**

# Uygulama özel sınıfları koru
-keep class com.example.simplecalc.** { *; }
