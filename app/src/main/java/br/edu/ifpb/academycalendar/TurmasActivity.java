package br.edu.ifpb.academycalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TurmasActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private MyListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turmas);

        listView = (ExpandableListView) findViewById(R.id.expList);
        initData();
        listAdapter = new MyListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData(){
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Turma1");
        listDataHeader.add("Truma2");

        List<String> turma1 = new ArrayList<>();
        turma1.add("Aluno A");
        turma1.add("Aluno B");
        turma1.add("Aluno C");

        List<String> turma2 = new ArrayList<>();
        turma2.add("Aluno D");
        turma2.add("Aluno E");

        listHash.put(listDataHeader.get(0), turma1);
        listHash.put(listDataHeader.get(1), turma2);
    }

}
