package com.hllbr.suspendfunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //myFunction bu alanda çalıştırılamaz
        Func()
        main()
    }
    fun main(){
        /*
        Suspend Fonksiyon nedir ? == İçerisinde Coroutines çalıştırılabilen fonksiyonlardır.
        En büyük özellikleri istediğimiz zaman durdurup devam edebildiğimiz işlemlerdir.
         */
        GlobalScope.launch {
            //myFunction bu alanda çalıştırılabilir.
            myFunction()

        }
        //myFunction bu alanda çalıştırılamaz
    }
    /*
    fun myFunction(){
        coroutineScope {

        }
        */
     suspend fun myFunction(){
         coroutineScope {
             delay(4000)
             println("suspend Scope")
         }
    }
    fun Func(){
        runBlocking {
            delay(5000)
            myFunction()        //myFunction bu alanda çalıştırılabilir.

        }
    }
}