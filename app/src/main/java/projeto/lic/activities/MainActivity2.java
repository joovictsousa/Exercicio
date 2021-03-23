package projeto.lic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import projeto.lic.controller.ControleUsuario;
import projeto.lic.model.Usuario;

import static projeto.lic.activities.MainActivity.usuarios;

public class MainActivity2 extends AppCompatActivity {
    TextView informacoes;
    EditText consultaCpf;
    Usuario busca = new Usuario();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*if(getIntent().getExtras() != null){
            usuarios = (ControleUsuario) getIntent().getSerializableExtra("usuarios");
        }*/
    }
    public void consultar(View view){
        consultaCpf = findViewById(R.id.textConsulta);
        informacoes = findViewById(R.id.informacoes);
        busca = usuarios.procuraCpf(consultaCpf.getText().toString());
        if(busca!= null){
            Toast.makeText(getApplicationContext(), "Usuário encontrado!",Toast.LENGTH_SHORT).show();
            informacoes.setText("Olá! "+busca.getNome()+"\n"+busca.getCpf()+"\n"+busca.getEmail()+"\n"+busca.getTelefone());
            consultaCpf.setText("");
        }
        else{
            informacoes.setText("Informações não encontradas!");
        }

    }
    public void voltar(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}