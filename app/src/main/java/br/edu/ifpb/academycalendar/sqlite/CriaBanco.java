package br.edu.ifpb.academycalendar.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    protected static final String NOME_BANCO = "banco.db";
    protected static final int VERSAO = 1;

    // tabela
    protected static final String TABELA = "Usuario";
    // colunas
    protected static final String ID = "id";
    protected static final String EMAIL = "email";
    protected static final String SENHA = "senha";
    protected static final String NOME = "nome";
    protected static final String TIPO = "tipo";

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                +ID+" integer PRIMARY KEY AUTOINCREMENT, "
                +EMAIL+" text UNIQUE, "
                +SENHA+" text, "
                +NOME+" text, "
                +TIPO+" text"
                +");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABELA);
        onCreate(db);
    }
}
