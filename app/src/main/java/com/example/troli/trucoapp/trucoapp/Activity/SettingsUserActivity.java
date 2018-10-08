package com.example.troli.trucoapp.trucoapp.Activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.troli.trucoapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class SettingsUserActivity extends AppCompatActivity {

    private TextView txtUsuarioNome;
    private ImageView imgViewSettings;
    private FirebaseAuth mAuth;
    private FirebaseStorage  mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_user);

        mAuth = FirebaseAuth.getInstance();
        mStorage = FirebaseStorage.getInstance();
        txtUsuarioNome = (TextView) findViewById(R.id.txtUsuarioNome);
        imgViewSettings = (ImageView) findViewById(R.id.imgUserViewSettings);

        txtUsuarioNome.setText(mAuth.getCurrentUser().getDisplayName());
    }


    private String uploadImagem()
    {
        StorageReference imagesRef = mStorage.getReference().child("images");

        String retorno = "";
        imgViewSettings.setDrawingCacheEnabled(true);
        imgViewSettings.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) imgViewSettings.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = imagesRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Toast.makeText(SettingsUserActivity.this, "Falha ao enviar imagem", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
                Toast.makeText(SettingsUserActivity.this, "Imagem gravada com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
        return retorno;
    }
    public void saveUserDisplayName(View v)
    {
        StorageReference storageRef = mStorage.getReference();



        FirebaseUser user = mAuth.getCurrentUser();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(txtUsuarioNome.getText().toString())
                //.setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SettingsUserActivity.this, "Dados atualizados", Toast.LENGTH_SHORT).show();
                            Log.d("", "User profile updated.");
                        }
                    }
                });
        
    }


}
