package cn.edu.zjut.po;

public class DecodeResult {
    private String phoneNumber;
    private String purePhoneNumber;
    private String countryCode;

    public DecodeResult() {
    }

    public DecodeResult(String phoneNumber, String purePhoneNumber, String countryCode) {
        this.phoneNumber = phoneNumber;
        this.purePhoneNumber = purePhoneNumber;
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPurePhoneNumber() {
        return purePhoneNumber;
    }

    public void setPurePhoneNumber(String purePhoneNumber) {
        this.purePhoneNumber = purePhoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
