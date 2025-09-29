package com.mentoriaandroid.aulacomponentesinterfaceviewbinding

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
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

        spinnerExibicao()

        with(binding){

            btnEnviar.setOnClickListener { view ->
                //checkbox()
                //radioButton()
                //swithToggle()
                //exibirSnackbar(view)
                //caixaDialogAlerta()
                spinnerSelecionarItem()



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

    private fun spinnerSelecionarItem() {
        val itemSelecionado = binding.spinnerCategorias.selectedItem
        val itemPosicao = binding.spinnerCategorias.selectedItemPosition

        if( itemPosicao == 0 ){
                    binding.textResultado.text = "Selecione um item"
        }else {
            binding.textResultado.text = "selecionado: $itemSelecionado / pos: $itemPosicao"
        }
    }

    private fun spinnerExibicao() {


      /*  val categorias = resources.getStringArray(
            R.array.categorias
        )*/
        /*val categorias = listOf(
            "Selecione uma categoria",
            "Eletrônicos","Roupas", "Móveis", "Roupas"
        )*/

        binding.spinnerCategorias.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.categorias,
            android.R.layout.simple_spinner_dropdown_item
        )

     /*   binding.spinnerCategorias.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            categorias
        )*/

        /*binding.spinnerCategorias.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //val itemSelecionado = parent?.getItemAtPosition(position)
                val itemSelecionado = parent?.selectedItem
                binding.textResultado.text = itemSelecionado.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }*/
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