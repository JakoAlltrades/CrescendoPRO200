package crescendo.com.crescendoapp;

/**
 * Created by jprirm on 6/2/2017.
 */

public class Recording {
    private String recordingTitle;
    private int recordingID;

    public Recording(String recordingTitle, int recordingID)
    {
        this.recordingID = recordingID;
        this.recordingTitle = recordingTitle;
    }

    public String getRecordingTitle() {return recordingTitle;}
    public void setRecordingTitle(String recordingTitle) {this.recordingTitle = recordingTitle;}
    public int getRecordingID() {return recordingID;}
    public void setRecordingID(int recordingID){this.recordingID = recordingID;}
}
