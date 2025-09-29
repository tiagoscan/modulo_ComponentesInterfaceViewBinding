package com.mentoriaandroid.aulacomponentesinterfaceviewbinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
                //exibirSnackbar(view)
                caixaDialogAlerta()


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

    private fun caixaDialogAlerta() {

        AlertDialog.Builder(this)
            .setTitle("Confirmação exlusão do item")
            .setMessage("Tem certeza que quer remover?")
            .setNegativeButton("Cancelar"){dialog, posicao ->
                Toast.makeText(this, "cancelar ($posicao)", Toast.LENGTH_SHORT).show()}
            .setPositiveButton("Remover"){dialog, posicao ->
                Toast.makeText(this, "Remover ($posicao)", Toast.LENGTH_SHORT).show()}
            .setCancelable(false)
            .create()
            .show()


        /*val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Confirmação exlusão do item")
        alertBuilder.setMessage("Tem certeza que quer remover?")
        alertBuilder.setNegativeButton("Cancelar"){dialog, posicao ->
            Toast.makeText(this, "cancelar ($posicao)", Toast.LENGTH_SHORT).show()

        //dialog.dismiss()
        }

        alertBuilder.setPositiveButton("Remover"){dialog, posicao ->
            Toast.makeText(this, "Remover ($posicao)", Toast.LENGTH_SHORT).show()
        }

        alertBuilder.setCancelable(false)
        alertBuilder.setNeutralButton("Ajuda"){dialog, posicao ->
            Toast.makeText(this, "Ajuda ($posicao)", Toast.LENGTH_SHORT).show()
        }

        alertBuilder.setIcon(R.drawable.ic_alerta_24)

        val alertDialog = alertBuilder.create()
        alertDialog.show()*/
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