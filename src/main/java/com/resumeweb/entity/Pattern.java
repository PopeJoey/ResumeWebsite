package com.resumeweb.entity;

public class Pattern {
    int patternId;
    String patternName;
    String patternPath;
    String patternClass;
    String patternPreviewPic;
    String patternInfo;

    public int getPatternId() {
        return patternId;
    }

    public void setPatternId(int patternId) {
        this.patternId = patternId;
    }

    public String getPatternPath() {
        return patternPath;
    }

    public void setPatternPath(String patternPath) {
        this.patternPath = patternPath;
    }

    public String getPatternClass() {
        return patternClass;
    }

    public void setPatternClass(String patternClass) {
        this.patternClass = patternClass;
    }

    public String getPatternPreviewPic() {
        return patternPreviewPic;
    }

    public void setPatternPreviewPic(String patternPreviewPic) {
        this.patternPreviewPic = patternPreviewPic;
    }

    public String getPatternInfo() {
        return patternInfo;
    }

    public void setPatternInfo(String patternInfo) {
        this.patternInfo = patternInfo;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }
}
