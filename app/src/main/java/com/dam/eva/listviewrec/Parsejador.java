package com.dam.eva.listviewrec;

import android.support.v7.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Parsejador extends AppCompatActivity{

    public List<Bloc> parseja(String xml) {
        String time = null;
        String temperatue = null;
        String fred_calor = null;
        Bloc bloc;

        List<Bloc> llista = new ArrayList<Bloc>();

        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            //New JSONObject() new JSONArray()

            xpp.setInput(new StringReader(xml));
            int eventType = xpp.getEventType();

            while (eventType!=XmlPullParser.END_DOCUMENT){
                if (eventType==XmlPullParser.START_TAG){
                    if (xpp.getName().equals("time")){
                        time=xpp.getAttributeValue(null,"from");
                    }
                    if (xpp.getName().equals("temperature")){
                        temperatue=xpp.getAttributeValue(null,"value");
                    }
                    if (temperatue!=null) {
                        if (Double.parseDouble(temperatue) >= 20) {
                            fred_calor = "calor";
                        } else  {
                            fred_calor = "fred";
                        }
                    }
                    bloc = new Bloc(time,temperatue,fred_calor);
                    llista.add(bloc);

                }
                eventType=xpp.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return llista;
    }

}
