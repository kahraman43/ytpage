package com.example.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * SimpleCalc - Ana Activity
 * 
 * Modern ve sade bir hesap makinesi uygulaması
 * Toplama, çıkarma, çarpma ve bölme işlemlerini destekler
 * 
 * @author SimpleCalc Team
 * @version 1.0
 */
class MainActivity : AppCompatActivity() {
    
    // UI Bileşenleri
    private lateinit var tvDisplay: TextView
    
    // Hesaplama değişkenleri
    private var currentNumber = ""           // Şu anki girilen sayı
    private var firstNumber = 0.0            // İlk sayı (işlem için)
    private var currentOperator = ""         // Seçili işlem (+, -, ×, ÷)
    private var isNewOperation = true        // Yeni işlem mi başlıyor?
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // UI bileşenlerini bağla
        initializeViews()
        
        // Buton tıklama olaylarını ayarla
        setupNumberButtons()
        setupOperatorButtons()
        setupControlButtons()
    }
    
    /**
     * UI bileşenlerini başlat
     */
    private fun initializeViews() {
        tvDisplay = findViewById(R.id.tvDisplay)
        updateDisplay("0")
    }
    
    /**
     * Sayı butonlarının tıklama olaylarını ayarla
     * 0-9 ve ondalık nokta butonları
     */
    private fun setupNumberButtons() {
        // Sayı butonları ID listesi
        val numberButtonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )
        
        // Her sayı butonu için tıklama olayı ekle
        numberButtonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener { view ->
                onNumberClick((view as Button).text.toString())
            }
        }
        
        // Ondalık nokta butonu
        findViewById<Button>(R.id.btnDot).setOnClickListener {
            onDotClick()
        }
    }
    
    /**
     * İşlem butonlarının tıklama olaylarını ayarla
     * +, -, ×, ÷ butonları
     */
    private fun setupOperatorButtons() {
        // Toplama butonu
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            onOperatorClick("+")
        }
        
        // Çıkarma butonu
        findViewById<Button>(R.id.btnSubtract).setOnClickListener {
            onOperatorClick("-")
        }
        
        // Çarpma butonu
        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            onOperatorClick("×")
        }
        
        // Bölme butonu
        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            onOperatorClick("÷")
        }
    }
    
    /**
     * Kontrol butonlarının tıklama olaylarını ayarla
     * C (Clear) ve = (Equals) butonları
     */
    private fun setupControlButtons() {
        // Temizle butonu
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            onClearClick()
        }
        
        // Eşittir butonu
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            onEqualsClick()
        }
    }
    
    /**
     * Sayı butonuna tıklandığında çağrılır
     * @param number Tıklanan sayı (String olarak)
     */
    private fun onNumberClick(number: String) {
        if (isNewOperation) {
            // Yeni işlem başlıyorsa, mevcut sayıyı temizle
            currentNumber = number
            isNewOperation = false
        } else {
            // Mevcut sayıya ekle
            currentNumber += number
        }
        
        updateDisplay(currentNumber)
    }
    
    /**
     * Ondalık nokta butonuna tıklandığında çağrılır
     * Bir sayıda sadece bir nokta olmasını sağlar
     */
    private fun onDotClick() {
        if (isNewOperation) {
            // Yeni işlem başlıyorsa "0." ile başla
            currentNumber = "0."
            isNewOperation = false
        } else if (!currentNumber.contains(".")) {
            // Eğer nokta yoksa ekle
            currentNumber += "."
        }
        
        updateDisplay(currentNumber)
    }
    
    /**
     * İşlem butonuna tıklandığında çağrılır
     * @param operator Seçilen işlem (+, -, ×, ÷)
     */
    private fun onOperatorClick(operator: String) {
        if (currentNumber.isNotEmpty()) {
            if (currentOperator.isNotEmpty() && !isNewOperation) {
                // Önceki işlem varsa önce onu hesapla
                calculate()
            } else {
                // İlk sayıyı kaydet
                firstNumber = currentNumber.toDoubleOrNull() ?: 0.0
            }
            
            // Yeni işlemi ayarla
            currentOperator = operator
            isNewOperation = true
        }
    }
    
    /**
     * Eşittir butonuna tıklandığında çağrılır
     * Mevcut işlemi hesaplar ve sonucu gösterir
     */
    private fun onEqualsClick() {
        if (currentOperator.isNotEmpty() && currentNumber.isNotEmpty() && !isNewOperation) {
            calculate()
            currentOperator = ""  // İşlemi temizle
        }
    }
    
    /**
     * Temizle butonuna tıklandığında çağrılır
     * Tüm değerleri sıfırlar
     */
    private fun onClearClick() {
        currentNumber = ""
        firstNumber = 0.0
        currentOperator = ""
        isNewOperation = true
        updateDisplay("0")
    }
    
    /**
     * Hesaplama işlemini gerçekleştirir
     * Seçili işleme göre (+, -, ×, ÷) sonucu hesaplar
     */
    private fun calculate() {
        val secondNumber = currentNumber.toDoubleOrNull() ?: 0.0
        var result = 0.0
        
        // İşlem türüne göre hesapla
        when (currentOperator) {
            "+" -> result = firstNumber + secondNumber
            "-" -> result = firstNumber - secondNumber
            "×" -> result = firstNumber * secondNumber
            "÷" -> {
                if (secondNumber != 0.0) {
                    result = firstNumber / secondNumber
                } else {
                    // Sıfıra bölme hatası
                    updateDisplay(getString(R.string.error_divide_zero))
                    resetCalculator()
                    return
                }
            }
        }
        
        // Sonucu formatla ve göster
        currentNumber = formatResult(result)
        firstNumber = result
        updateDisplay(currentNumber)
        isNewOperation = true
    }
    
    /**
     * Hesap makinesini sıfırlar (hata durumunda)
     */
    private fun resetCalculator() {
        currentNumber = ""
        firstNumber = 0.0
        currentOperator = ""
        isNewOperation = true
    }
    
    /**
     * Sonucu formatlar
     * Eğer sonuç tam sayıysa .0 kısmını kaldırır
     * @param result Formatlanacak sayı
     * @return Formatlanmış string
     */
    private fun formatResult(result: Double): String {
        return if (result % 1.0 == 0.0) {
            // Tam sayı ise ondalık kısmı gösterme
            result.toInt().toString()
        } else {
            // Ondalıklı sayı ise, gereksiz sıfırları kaldır
            String.format("%.8f", result).trimEnd('0').trimEnd('.')
        }
    }
    
    /**
     * Ekranı günceller
     * @param text Gösterilecek metin
     */
    private fun updateDisplay(text: String) {
        tvDisplay.text = text
    }
}
