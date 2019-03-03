package br.edu.ifpb.academycalendar.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.edu.ifpb.academycalendar.entity.Usuario;

public class UsuarioController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public UsuarioController(Context context){
        this.banco = new CriaBanco(context);
    }

    public boolean inserirUsuario(Usuario usuario){
        long resultado;
        db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.EMAIL, usuario.getEmail());
        valores.put(CriaBanco.SENHA, usuario.getSenha());
        valores.put(CriaBanco.NOME, usuario.getNome());
        valores.put(CriaBanco.TIPO, usuario.getTipo());

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        return resultado > 0 ;
    }



}
