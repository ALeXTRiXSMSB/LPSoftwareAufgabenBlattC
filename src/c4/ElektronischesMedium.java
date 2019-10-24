package c4;

public class ElektronischesMedium extends Medium {

    private String url;

    public ElektronischesMedium(String _titel, String _url) {
        super(_titel);
        this.setUrl(_url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean checkURL(String url){
        return true;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder rueckgabe = new StringBuilder();
        rueckgabe.append(super.calculateRepresentation() + " ")
                .append("URL: " + this.getUrl());
        return rueckgabe.toString();
    }
}
