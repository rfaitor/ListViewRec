package com.dam.eva.listviewrec;

public class Bloc {

    private String data,temperatura, fred_calor;

    public Bloc(String data, String temperatura, String fred_calor) {
        this.data = data;
        this.temperatura = temperatura;
        this.fred_calor = fred_calor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getFred_calor() {
        return fred_calor;
    }

    public void setFred_calor(String fred_calor) {
        this.fred_calor = fred_calor;
    }
}
