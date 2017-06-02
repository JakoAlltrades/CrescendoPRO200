package crescendo.com.crescendoapp;

/**
 * Created by jprirm on 6/2/2017.
 */

public class Pitch {
    private int pitchID;
    private String pitchName;
    private String pitchURL;

    public Pitch(int pitchID, String pitchName, String pitchURL)
    {
        this.pitchID = pitchID;
        this.pitchName = pitchName;
        this.pitchURL = pitchURL;
    }

    public void setPitchID(int pitchID) {this.pitchID =pitchID;}
    public void setPitchName(String pitchName) {this.pitchName = pitchName;}
    public void setPitchURL(String pitchURL) {this.pitchURL = pitchURL;}

    public int getPitchID() {return pitchID;}
    public String getPitchName() {return pitchName;}
    public String getPitchURL() {return pitchURL;}
}
