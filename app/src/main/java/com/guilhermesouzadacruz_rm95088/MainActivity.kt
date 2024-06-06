package com.guilhermesouzadacruz_rm95088

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import com.fiapguilhermesouzadacruz.R

import com.guilhermesouzadacruz_rm95088.adapter.PraiasAdapter
import com.guilhermesouzadacruz_rm95088.model.Praia
import com.guilhermesouzadacruz_rm95088.ui.theme.GuilhermesouzadacruzTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPraia);
        val praiasAdapter = PraiasAdapter()
        recyclerView.adapter = praiasAdapter

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val nome = findViewById<EditText>(R.id.editTextNomePraia)
        val cidade = findViewById<EditText>(R.id.editTextCidade)
        val estado = findViewById<EditText>(R.id.editTextEstado)
        val buttonRemoveAll = findViewById<Button>(R.id.buttonRemoveAll)

        buttonAdd.setOnClickListener {


            val item = Praia(
                nome = nome.text.toString(),
                cidade = cidade.text.toString(),
                estado = estado.text.toString(),
                onRemove = {
                    praiasAdapter.removeItem(it)
                }
            )

            praiasAdapter.addItem(item)

            nome.text.clear()
            cidade.text.clear()
            estado.text.clear()
        }

        buttonRemoveAll.setOnClickListener{
            praiasAdapter.removeAllItens()
        }
    }
}