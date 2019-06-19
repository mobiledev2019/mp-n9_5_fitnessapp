package com.example.fitnesssdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Program implements Parcelable {
    private String programName;
    private String Des;
    private String Image;
    private String content;

    protected Program(Parcel in) {
        programName = in.readString();
        Des = in.readString();
        Image = in.readString();
        content = in.readString();
    }

    public static final Creator<Program> CREATOR = new Creator<Program>() {
        @Override
        public Program createFromParcel(Parcel in) {
            return new Program(in);
        }

        @Override
        public Program[] newArray(int size) {
            return new Program[size];
        }
    };

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Program(String programName, String des, String image, String content) {
        this.programName = programName;
        this.Des = des;
        this.Image = image;
        this.content = content;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(programName);
        dest.writeString(content);
        dest.writeString(Des);
        dest.writeString(Image);
    }
}
