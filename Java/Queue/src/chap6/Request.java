package chap6;

public class Request {
    private int AT, ST, FT, WT;

    public Request(int AT, int ST) {
        this.AT = AT;
        this.ST = ST;
    }

    public void setFT(int FT) {
        this.FT = FT;
    }

    public int getAT() {
        return AT;
    }

    public int getST() {
        return ST;
    }

    public int getFT() {
        return FT;
    }

    public int getWT() {
        return FT-AT-ST;
    }    
}