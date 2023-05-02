package com.example.third_assignment_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DeleteActivity extends AppCompatActivity {

    private Spinner spNotes;
    private ArrayAdapter listAdapter;
    private ArrayList<String> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        this.spNotes =findViewById(R.id.spNotes);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.notesList = new ArrayList<String>(sp.getStringSet("notes", new HashSet<String>()));
        this.listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, notesList);
        this.spNotes.setAdapter(this.listAdapter);
    }
     public void btnDeleteClick (View view){
         SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
         SharedPreferences.Editor spEd = sp.edit();
         Set<String> oldSet = sp.getStringSet("notes", new HashSet<String>());
         oldSet.remove (this.spNotes.getSelectedItem());
         //Set<String> newStrSet = new HashSet<String>();
         //newStrSet.add(txtNote.getText().toString());
         //newStrSet.addAll(oldSet);

         spEd.putStringSet("notes",oldSet);
         spEd.apply();

         finish();
     }
}