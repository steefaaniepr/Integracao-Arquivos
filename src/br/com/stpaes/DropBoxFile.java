package br.com.stpaes;

public class DropBoxFile {

    private final String localPath;

    public DropBoxFile(String localPath) {
        this.localPath = localPath;
    }

    public String getLocalPath() {
        return localPath;
    }
}
