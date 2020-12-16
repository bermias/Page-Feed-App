package com.ermias.pagefeedsapp;

import android.net.Uri;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class JSONHelper {


    public  List<Card> getCardList(String url) {
        List<Card> cardList = new ArrayList<>();
        URLHandler urlHandler = new URLHandler();
        String jsonString = urlHandler.getJson(url);
         cardList = getCards(jsonString);
                //"https://private-8ce77c-tmobiletest.apiary-mock.com/test/home");


        return cardList;
    }

    private List<Card> getCards(String jsonString){
             List<Card> cardList = new ArrayList<>();
        try {
            JSONObject parser = new JSONObject(jsonString);
            JSONObject page = parser.getJSONObject("page");
            JSONArray cards = page.getJSONArray("cards");

            for(int i = 0; i < cards.length(); i++){
              JSONObject cardAndType = cards.getJSONObject(i);
              String cardType = cardAndType.getString("card_type");
              JSONObject card = cardAndType.getJSONObject("card");
              Card card1 = new Card();
                if(cardType.equals("text")){
                   List<String> l =  getValueAndSize(card);
                    card1.setCard_type(cardType);
                    card1.setCard_text_value(l.get(0));
                    card1.setCard_text_color(l.get(1));
                    card1.setCard_text_size(Integer.parseInt(l.get(2)));
                }
                else if(cardType.equals("title_description")){
                    JSONArray jsonArrayt = card.names();
                    for(int j = 0; j < jsonArrayt.length(); j++) {
                        Object jsonObjectT = card.get(jsonArrayt.get(j).toString());
                        String a = jsonArrayt.get(j).toString();
                        System.out.println(a);
                        card1.setCard_type(cardType);
                        if(a.equals("title")){
                            JSONObject js = card.getJSONObject("title");
                            System.out.println(getValueAndSize(js));
                            List<String> l1 =  getValueAndSize(js);
                            card1.setCard__title_text(l1.get(0));
                            card1.setCard_title_color(l1.get(1));
                            card1.setCard_title_size(Integer.parseInt(l1.get(2)));
                        }
                        else if(a.equals("description")){
                            JSONObject js = card.getJSONObject("description");
                            System.out.println(getValueAndSize(js));
                            List<String> l2 =  getValueAndSize(js);
                            card1.setCard_description_value(l2.get(0));
                            card1.setCard_description_color(l2.get(1));
                            card1.setCard_description_size(Integer.parseInt(l2.get(2)));
                        }
                    }
                }
                else if(cardType.equals("image_title_description")){
                    JSONArray jsonArrayt = card.names();
                    card1.setCard_type(cardType);
                    for(int j = 0; j < jsonArrayt.length(); j++) {
                        Object jsonObjectT = card.get(jsonArrayt.get(j).toString());
                        String a = jsonArrayt.get(j).toString();
                        System.out.println(a);
                        if(a.equals("title")){
                            JSONObject js = card.getJSONObject("title");
                            System.out.println(getValueAndSize(js));
                            List<String> l1 =  getValueAndSize(js);
                            card1.setCard__title_text(l1.get(0));
                            card1.setCard_title_color(l1.get(1));
                            card1.setCard_title_size(Integer.parseInt(l1.get(2)));
                        }
                        else if(a.equals("description")){
                            JSONObject js = card.getJSONObject("description");
                            System.out.println(getValueAndSize(js));
                            List<String> l2 =  getValueAndSize(js);
                            card1.setCard_description_value(l2.get(0));
                            card1.setCard_description_color(l2.get(1));
                            card1.setCard_description_size(Integer.parseInt(l2.get(2)));
                        }
                        else if(a.equals("image")){
                            JSONObject js = card.getJSONObject("image");
                            System.out.println("hfghgh : image");
                            System.out.println(js.getString("url"));
                            card1.setImage_url(js.getString("url"));

                            JSONObject jsS = js.getJSONObject("size");
                            card1.setImage_height(Integer.parseInt(jsS.getString("height")));
                            card1.setImage_width(Integer.parseInt(jsS.getString("width")));
                            System.out.println(jsS.getString("width"));
                            System.out.println(jsS.getString("height"));
                        }
                    }
                }
                cardList.add(card1);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cardList;
    }

    List<String> getValueAndSize(JSONObject jsonObject) throws JSONException {
        JSONArray jsonArrayT = jsonObject.names();
        List<String> stringList = new ArrayList<>();
        for (int j = 0; j < jsonArrayT.length(); j++) {
            String name = jsonArrayT.get(j).toString();
            Object jsonObjectT = jsonObject.get(name);
            String a = jsonArrayT.get(j).toString();
            System.out.println(a);
            if (a.equals("value")) {
                stringList.add(jsonObjectT.toString());
                System.out.println(jsonObjectT);
            }
            if (a.equals("attributes")) {
                JSONObject js = jsonObject.getJSONObject("attributes");
                String textColor = getJsonString(jsonObject, "attributes","text_color");
                String textSize = "" + getJsonInt(js, "font", "size");
                stringList.add(textColor);
                stringList.add(textSize);
                System.out.println(textColor);
                System.out.println(textSize);
            }
        }
        return stringList;
    }

    String getJsonString(JSONObject jsonObject, String item, String name) throws JSONException {
        JSONObject jsonObject1 = jsonObject.getJSONObject(item);
        return jsonObject1.getString(name);
    }

    int getJsonInt(JSONObject jsonObject, String item, String name) throws JSONException {
        JSONObject jsonObject1 = jsonObject.getJSONObject(item);
        return jsonObject1.getInt(name);
    }

}
