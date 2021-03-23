package projeto.lic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import projeto.lic.controller.ControleUsuario;
import projeto.lic.model.Usuario;

public class MainActivity extends AppCompatActivity {
    EditText textNome;
    EditText textCpf;
    EditText textEmail;
    EditText textTelefone;
    public static ControleUsuario usuarios = new ControleUsuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cadastrar(View view){
        Usuario user = new Usuario();
        textNome = findViewById(R.id.textNome);
        textCpf = findViewById(R.id.textCpf);
        textEmail = findViewById(R.id.textEmail);
        textTelefone = findViewById(R.id.textTelefone);
        user.setNome(textNome.getText().toString());
        user.setCpf(textCpf.getText().toString());
        user.setEmail(textEmail.getText().toString());
        user.setTelefone(textTelefone.getText().toString());
        usuarios.salvar(user);
        Toast.makeText(getApplicationContext(), "O usuário foi cadastrado!",Toast.LENGTH_SHORT).show();
        textNome.setText("");
        textCpf.setText("");
        textEmail.setText("");
        textTelefone.setText("");

    }
    public void enviar(View view){
        Intent intent = new Intent(getApplicationContext(),WebActivity.class);
        //intent.putExtra("cpf",user.getCpf());
        Toast.makeText(getApplicationContext(), "As informações foram recebidas!",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}