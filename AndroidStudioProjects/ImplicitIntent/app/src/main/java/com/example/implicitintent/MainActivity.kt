package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var browser:Button
    private lateinit var dial:Button
    private lateinit var email:Button
    private lateinit var maps:Button
    private lateinit var contacts:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFunction()
        handleEvents()
    }
    private fun initFunction(){
        browser = findViewById(R.id.button_Browser)
        dial = findViewById(R.id.button_Dail)
        email = findViewById(R.id.button_Email)
        maps = findViewById(R.id.button_Maps)
        contacts = findViewById(R.id.button_Contacts)

    }

    private fun handleEvents(){
        browser.setOnClickListener {
            openWebPage("https://kotlinlang.org/docs/map-operations.html#add-and-update-entries")
        }
        dial.setOnClickListener {
            dialPhoneNumber("9876543210")
        }
        email.setOnClickListener {
            composeEmail(arrayOf("a@a.gmail.com"),"Test Mail",Uri.parse("hello.pdf"))
        }
        maps.setOnClickListener {
            showMap(Uri.parse("geo:47.6,-122.3?z=11"))
        }
        contacts.setOnClickListener {
            insertContact("Loki","loki@gmail.com")
        }
    }

    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun composeEmail(addresses: Array<String>, subject: String, attachment: Uri) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_STREAM, attachment)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun showMap(geoLocation: Uri) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = geoLocation
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun insertContact(name: String, email: String) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, name)
            putExtra(ContactsContract.Intents.Insert.EMAIL, email)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}