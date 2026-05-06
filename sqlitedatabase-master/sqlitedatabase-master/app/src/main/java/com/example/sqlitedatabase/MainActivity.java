package com.example.sqlitedatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etId, etName;
    Button btnInsert, btnView, btnUpdate, btnDelete;
    TextView tvResult;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        tvResult = findViewById(R.id.tvResult);

        db = new DBHelper(this);

        // INSERT
        btnInsert.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            String name = etName.getText().toString();

            if (db.insertData(id, name)) {
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();

                // ✅ Clear fields
                etId.setText("");
                etName.setText("");
                etId.requestFocus();

            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        // VIEW
        btnView.setOnClickListener(v -> {
            Cursor c = db.getData();
            StringBuilder data = new StringBuilder();

            while (c.moveToNext()) {
                data.append("ID: ").append(c.getInt(0))
                        .append(" Name: ").append(c.getString(1)).append("\n");
            }

            tvResult.setText(data.toString());
        });

        // UPDATE
        btnUpdate.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            String name = etName.getText().toString();

            if (db.updateData(id, name)) {
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
            }
        });

        // DELETE
        btnDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());

            if (db.deleteData(id)) {
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}