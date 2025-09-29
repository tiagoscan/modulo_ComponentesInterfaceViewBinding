package com.mentoriaandroid.aulacomponentesinterfaceviewbinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.mentoriaandroid.aulacomponentesinterfaceviewbinding.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding){

            btnEnviar.setOnClickListener { view ->
                //checkbox()
                //radioButton()
                //swithToggle()
                exibirSnackbar(view)
                //Toast.makeText(this, "Mensagem", Toast.LENGTH_SHORT).show()

            }

            rbMasculino.setOnCheckedChangeListener { buttonView, isChecked ->

            }

           /* cbConfirmacao.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if( isChecked ) "Sim" else "Não"
                binding.textResultado.text = "Valor selecionado $resultado"
            }*/

            /*cbConfirmacao.setOnClickListener{
                val selecionado = cbConfirmacao.isChecked
                val resultado = if( selecionado ) "Sim" else "Não"
                binding.textResultado.text = "Valor selecionado $selecionado"
            }*/

        }
    }

    private fun exibirSnackbar(view: View) {

        val snackBar = Snackbar.make(
            view,
            "Alteração feita com sucesso",
            Snackbar.LENGTH_LONG
        )
        snackBar.setAction("desfazer"){
            Toast.makeText(this, "Desfeito", Toast.LENGTH_SHORT).show()
        }
        /*snackBar.setTextColor(
            //resources.getColor()
            ContextCompat.getColor(
                this,
                R.color.darkBlue
            )
        )

        snackBar.setActionTextColor(
            ContextCompat.getColor(
                this,
                R.color.lightBlue
            )
        )

        snackBar.setBackgroundTint(
            ContextCompat.getColor(
                this,
                R.color.grey
            )
        )*/

        snackBar.show()


    }

    private fun swithToggle() {

        val switchMarcado = binding.switchNotificacoes.isChecked
        val toggleMarcado = binding.toggleAtivo.isChecked

        val texto = "Switch: $switchMarcado Toggle: $toggleMarcado"
        binding.textResultado.text = texto
    }

    private fun radioButton() {

        val masculino = binding.rbMasculino.isChecked
        //binding.textResultado.text = if(masculino) "Masculino" else "Feminino"

        val idItemSelecionado = binding.rgSexo.checkedRadioButtonId
        binding.textResultado.text = when( idItemSelecionado ){
            R.id.rbMasculino -> "Masculino"
            R.id.rbFeminino -> "Feminino"
            else -> "Nada selecionado"
        }

        //limpar itens selecionados
        binding.rgSexo.clearCheck()


    }

    /* private fun checkbox() {
         val selecionado = binding.cbConfirmacao.isChecked
         val resultado = if( selecionado ) "Sim" else "Não"
         binding.textResultado.text = "Valor selecionado $selecionado"
     }*/
}