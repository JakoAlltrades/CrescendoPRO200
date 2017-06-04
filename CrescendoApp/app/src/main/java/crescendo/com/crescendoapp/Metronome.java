package crescendo.com.crescendoapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Brandon on 5/18/2017.
 */

public class Metronome  extends AppCompatActivity {

    private Timer T;
    int beatsPerMin = 60;
    private final int maxTempo = 218;
    MediaPlayer player = new MediaPlayer();
    public static final int RequestPermissionCode = 1;
    private int permissionCode;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metronome);
        player = MediaPlayer.create(this, R.raw.fastclick);


        SeekBar seekBar = (SeekBar)findViewById(R.id.MetSeekBar);
        seekBar.setMax(maxTempo - 40);
        seekBar.setProgress(beatsPerMin - 40);
        final TextView metValueView = (TextView)findViewById(R.id.MetValue);
        metValueView.setText("" + beatsPerMin);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                metValueView.setText("" + (progress + 40));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void MetronomeStartClick(View view) {
        if (CheckPermission()) {
            SeekBar seekBar = (SeekBar) findViewById(R.id.MetSeekBar);
            if (T != null) {
                T.cancel();
            }
            T = new Timer();
            beatsPerMin = seekBar.getProgress() + 40;
            int interval = (60000 / beatsPerMin);
//        timerCount = Integer.parseInt(currentTimerView.getText().toString());
            T.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            player.seekTo(0);
                            player.start();
//                            if (player != null)
//                            {
//                                player.stop();
//                                player.release();
//                            }
//                            player = MediaPlayer.create(getApplicationContext(), R.raw.click);
//                            player.start();
                        }
                    });
                }
            }, 1000, interval);
        }
        else {
            requestPermission();
        }
    }
    public void MetronomeStopClick(View view) {
        if (T != null) {
            T.cancel();
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_NETWORK_STATE},
                RequestPermissionCode);
    }

    public boolean CheckPermission()
    {
        permissionCode = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_NETWORK_STATE);
        return permissionCode == PackageManager.PERMISSION_GRANTED;
    }
}
