package beans;

import java.util.ArrayList;

public class PhotoAlbom {

    private ArrayList<byte[]> photoAlbom = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    public void addPhoto(byte[] photo, String title) {
        photoAlbom.add(photo);
        titles.add(title);
    }

    public void remove(int index) {
        photoAlbom.remove(index);
        titles.remove(index);
    }

    public int getPhotoAmount() {
        return photoAlbom.size();
    }

    public ArrayList<byte[]> getPhotoAlbom() {
        return photoAlbom;
    }

    public void setPhotoAlbom(ArrayList<byte[]> photoAlbom) {
        this.photoAlbom = photoAlbom;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public static PhotoAlbom getInstanse() {
        return new PhotoAlbom();
    }
}
