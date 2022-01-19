package com.motion.imagerecycler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  ImageView imageView;
  Uri imageUri;
  EditText editText;
  Button button;
  RecyclerView recyclerView;
  ImageAdapter adapter;
  List<ImageClass> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.image_select);
        editText=findViewById(R.id.et_title);
        button=findViewById(R.id.btn_save);
        recyclerView=findViewById(R.id.recyclerView);
        list=new ArrayList<>();

        imageView.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,1);

        });
        button.setOnClickListener(view -> {
            String title=editText.getText().toString();
            list.add(new ImageClass(title,imageUri));
            adapter=new ImageAdapter(list);
            recyclerView.setAdapter(adapter);
            editText.setText("");
            imageView.setImageResource(R.drawable.ic_launcher_background);
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==RESULT_OK&&data!=null){
            imageUri=data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}