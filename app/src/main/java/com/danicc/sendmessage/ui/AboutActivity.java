package com.danicc.sendmessage.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.danicc.sendmessage.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                .setCover(R.mipmap.ic_launcher)
                .setName("Dani Casado")
                .setSubTitle("Desarrollador Android")
                .setBrief("Hacedor de ideas, curioso y amante de la naturaleza.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("https://github.com/DaniCasado13")
                .addFacebookLink("Link de Facebook")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        setContentView(view);
    }
}