package sn.unchk.pharmaplus

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import sn.unchk.pharmaplus.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var etPassword: EditText
    private lateinit var etIdentifiant: EditText
    private lateinit var btnLogin: Button
    private lateinit var ivTogglePasswordVisibility: ImageView
    private var isPasswordVisible = false
    val email = "zocod3r@gmail.com"
    val password = "Zo@pharma+24"
    //Auth with firebase
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etPassword = findViewById(R.id.etPassword)
        etIdentifiant = findViewById(R.id.etIdentifiant)
        ivTogglePasswordVisibility = findViewById(R.id.ivTogglePasswordVisibility)
        btnLogin = findViewById(R.id.btnLogin)

        ivTogglePasswordVisibility.setOnClickListener {
            togglePasswordVisibility()
        }

        // ...
// Initialize Firebase Auth
        auth = Firebase.auth
        //Bouton login
        btnLogin.setOnClickListener {

            signIn()
        }

        //Créez un nouveau compte en transmettant l'adresse e-mail et le mot de passe du nouvel utilisateur à

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success")
                val user = auth.currentUser
                updateUI(user)
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(
                    baseContext,
                    "Authentication failed.",
                    Toast.LENGTH_SHORT,
                ).show()
                updateUI(null)
            }
        }
    }

    //Function Login
    fun signIn() {
        val email = etIdentifiant.text.toString().trim()
        val password = etPassword.text.toString().trim()
        // Validation des champs d'identifiant et de mot de passe
        if (email.isEmpty()) {
            etIdentifiant.error = "L'email est requis"
            etIdentifiant.requestFocus()
            return
        }

        if (password.isEmpty()) {
            etPassword.error = "Le mot de passe est requis"
            etPassword.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Connexion réussie
                    val user = auth.currentUser
                    updateUI(user)
                }

                else {
                    // Échec de la connexion
                    Toast.makeText(this, "Échec de l'authentification.", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    //Function updateUI
    fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            // Naviguer vers l'activité principale
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Rester sur l'écran de connexion
            Toast.makeText(this, "Veuillez vous connecter.", Toast.LENGTH_SHORT).show()
        }
    }

// the function to show or hiten password

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Cacher le mot de passe
            etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            ivTogglePasswordVisibility.setImageResource(R.drawable.ic_visibility)
        } else {
            // Afficher le mot de passe
            etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            ivTogglePasswordVisibility.setImageResource(R.drawable.ic_visibility)
        }
        // Place le curseur à la fin du texte
        etPassword.setSelection(etPassword.text.length)
        isPasswordVisible = !isPasswordVisible
    }

    //Lors de l'initialisation de votre activité, vérifiez si l'utilisateur est actuellement connecté :
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            Toast.makeText(this, "Vous n'êtes pas connecté", Toast.LENGTH_SHORT).show()
        }
    }






}