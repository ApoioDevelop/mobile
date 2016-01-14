package com.apoio.jokenpo;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class JokenpoActivity extends AppCompatActivity {

    private Random numeroAleatorio;
    private int pontosPC;
    private int pontosPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        pontosPC = 0;
        pontosPlayer = 0;

        numeroAleatorio = new Random();

        Button pedra = (Button)findViewById(R.id.button1);
        pedra.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.imageView1).setBackgroundResource(R.drawable.pedra);
                realizaJogadaPC(1);
            }
        });

        Button papel = (Button)findViewById(R.id.button2);
        papel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.imageView1).setBackgroundResource(R.drawable.papel);
                realizaJogadaPC(2);
            }
        });

        Button tesoura = (Button)findViewById(R.id.button3);
        tesoura.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.imageView1).setBackgroundResource(R.drawable.tesoura);
                realizaJogadaPC(3);
            }
        });
    }

    public void realizaJogadaPC(int jogadaPlayer) {
        int jogadaPC;
        jogadaPC = numeroAleatorio.nextInt(3)+1;

        if (jogadaPC == 1) {
            findViewById(R.id.imageView3).setBackgroundResource(R.drawable.pedra);

            if (jogadaPlayer==1)
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.empatou);
            else if (jogadaPlayer==2) {
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.venceu);
                pontosPlayer += 1;
            }
            else {
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.perdeu);
                pontosPC += 1;
            }
        } else if (jogadaPC==2) {
            findViewById(R.id.imageView3).setBackgroundResource(R.drawable.papel);

            if (jogadaPlayer==1) {
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.perdeu);
                pontosPC += 1;
            }
            else if (jogadaPlayer==2)
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.empatou);
            else {
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.venceu);
                pontosPlayer += 1;
            }
        } else if (jogadaPC==3) {
            findViewById(R.id.imageView3).setBackgroundResource(R.drawable.tesoura);

            if (jogadaPlayer==1) {
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.venceu);
                pontosPlayer += 1;
            }
            else if (jogadaPlayer==2) {
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.perdeu);
                pontosPC += 1;
            }
            else
                findViewById(R.id.imageView2).setBackgroundResource(R.drawable.empatou);
        }

        ((TextView)findViewById(R.id.textView8)).setText(new Integer(pontosPlayer).toString());
        ((TextView)findViewById(R.id.textView9)).setText(new Integer(pontosPC).toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jokenpo, menu);
        return true;
    }

}
