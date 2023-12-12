package com.example.trabalhosub.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.trabalhosub.helper.SQLiteDataHelper;
import com.example.trabalhosub.model.Pais;

import java.util.ArrayList;

public class PaisDao {

    //abrir conexão com BD
    private SQLiteOpenHelper openHelper;

    // Base de Dados
    private SQLiteDatabase bd;

    // nome da tabela e colunas
    private String tableName = "PAIS";
    private String[]colunas = {"CODIGO", "DESCRICAO"};

    private Context context;

    private static PaisDao instancia;

    public static PaisDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new PaisDao(context);
        } else {
            return instancia;
        }
    }

    public PaisDao(Context context) {
        this.context = context;

        //abrindo conexão com banco de dados
        openHelper = new SQLiteDataHelper(this.context, "PAISES", null, 1);

        bd = openHelper.getWritableDatabase();
    }

    public long insert (Pais pais) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], pais.getId());
            valores.put(colunas[1], pais.getDescricao());

            return bd.insert(tableName, null, valores);

        } catch (SQLException e) {
            Log.e("ERRO", "ERRO: PaisDao.insert() " + e.getMessage());
        }
        return 0;
    }

    public long update (Pais pais) {
        try {

            ContentValues valores = new ContentValues();
            valores.put(colunas[1], pais.getDescricao());

            String[]identificador = {String.valueOf(pais.getId())};
            bd.update(tableName, valores, colunas[0]+" = ?", identificador);

        } catch (SQLException e) {
            Log.e("ERRO", "ERRO: PaisDao.update() " + e.getMessage());
        }
        return 0;
    }

    public long delete (Pais pais) {
        try {
            String[] identificador = {String.valueOf(pais.getId())};
            return bd.delete(tableName, colunas[0] + " = ?", identificador);

        } catch (SQLException e) {
            Log.e("ERRO", "ERRO: PaisDao.delete() " + e.getMessage());
        }
        return 0;
    }

    public ArrayList<Pais> getAll() {
        ArrayList<Pais> paises = new ArrayList<>();

        try {
            Cursor cursor = bd.query(tableName, colunas,
                    null, null, null, null,
                    colunas[0]);

            if (cursor.moveToFirst()) {
                do {
                    Pais pais = new Pais();
                    pais.setId(cursor.getInt(0));
                    pais.setDescricao(cursor.getString(1));

                    paises.add(pais);

                } while (cursor.moveToNext());
            }

        } catch (SQLException e) {
            Log.e("ERRO", "ERRO: PaisDao.getAll() " + e.getMessage());
        }

        return paises;
    }

    public Pais getById(int id) {

        try {
            String[] identificador = {String.valueOf(id)};
            Cursor cursor = bd.query(tableName, colunas, colunas[0]+" = ?", identificador,
                    null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    Pais pais = new Pais();
                    pais.setId(cursor.getInt(0));
                    pais.setDescricao(cursor.getString(1));

                    return pais;
                } while (cursor.moveToNext());
            }

        } catch (SQLException e) {
            Log.e("ERRO", "ERRO: PaisDao.getById() " + e.getMessage());
        }

        return null;
    }
}
