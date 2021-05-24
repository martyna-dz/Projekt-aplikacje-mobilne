package com.example.projekt;

import java.util.ArrayList;

public class Content implements ContentInterface {

    @Override
    public ArrayList<String> getCategoriesList() {
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Meble");
        categories.add("Ubrania");
        categories.add("Warzywa");
        categories.add("Owoce");
        categories.add("Części ciała");
        categories.add("Transport");
        return categories;
    }

    @Override
    public ArrayList<String> getPolishWordsList() {
        ArrayList<String> polish = new ArrayList<String>();
        polish.add("kanapa");
        polish.add("fotel");
        polish.add("szafa");
        polish.add("stół");
        polish.add("krzesło");
        polish.add("łóżko");
        polish.add("biurko");
        polish.add("szafka nocna");
        polish.add("szuflada");
        polish.add("lampa");
        polish.add("dywan");
        polish.add("półka");

        polish.add("kurtka");
        polish.add("sweter");
        polish.add("bluza");
        polish.add("koszula");
        polish.add("buty");
        polish.add("sukienka");
        polish.add("bluzka");
        polish.add("spódnica");
        polish.add("spodnie");
        polish.add("szalik");
        polish.add("czapka");
        polish.add("rękawiczki");

        polish.add("pietruszka");
        polish.add("marchewka");
        polish.add("burak");
        polish.add("seler");
        polish.add("por");
        polish.add("sałata");
        polish.add("kapusta");
        polish.add("pomidor");
        polish.add("ziemniak");
        polish.add("cebula");
        polish.add("czosnek");
        polish.add("kalafior");

        polish.add("wiśnia");
        polish.add("malina");
        polish.add("gruszka");
        polish.add("pomarańcza");
        polish.add("jabłko");
        polish.add("truskawka");
        polish.add("brzoskwinia");
        polish.add("śliwka");
        polish.add("cytryna");
        polish.add("jeżyna");
        polish.add("winogrono");
        polish.add("żurawina");

        polish.add("głowa");
        polish.add("ramię");
        polish.add("szyja");
        polish.add("dłoń");
        polish.add("palec");
        polish.add("stopa");
        polish.add("plecy");
        polish.add("noga");
        polish.add("łokieć");
        polish.add("kolano");
        polish.add("nos");
        polish.add("ucho");

        polish.add("samochód");
        polish.add("autobus");
        polish.add("pociąg");
        polish.add("tramwaj");
        polish.add("statek");
        polish.add("tory");
        polish.add("droga");
        polish.add("przystanek");
        polish.add("peron");
        polish.add("stacja");
        polish.add("cel");
        polish.add("podróż");
        return polish;
    }

    @Override
    public ArrayList<String> getEnglishWordsList() {
        ArrayList<String> english = new ArrayList<String>();
        english.add("couch");
        english.add("armchair");
        english.add("wardrobe");
        english.add("table");
        english.add("chair");
        english.add("bed");
        english.add("desk");
        english.add("bedside table");
        english.add("drawer");
        english.add("lamp");
        english.add("carpet");
        english.add("shelf");

        english.add("jacket");
        english.add("sweater");
        english.add("sweatshirt");
        english.add("shirt");
        english.add("shoes");
        english.add("dress");
        english.add("blouse");
        english.add("skirt");
        english.add("trousers");
        english.add("scarf");
        english.add("hat");
        english.add("gloves");

        english.add("parsley");
        english.add("carrot");
        english.add("beetroot");
        english.add("celery");
        english.add("leek");
        english.add("lettuce");
        english.add("cabbage");
        english.add("tomato");
        english.add("potato");
        english.add("onion");
        english.add("garlic");
        english.add("cauliflower");

        english.add("cherry");
        english.add("raspberry");
        english.add("pear");
        english.add("orange");
        english.add("apple");
        english.add("strawberry");
        english.add("peach");
        english.add("plum");
        english.add("lemon");
        english.add("blackberry");
        english.add("grape");
        english.add("cranberry");

        english.add("head");
        english.add("shoulder");
        english.add("neck");
        english.add("hand");
        english.add("finger");
        english.add("foot");
        english.add("back");
        english.add("leg");
        english.add("elbow");
        english.add("knee");
        english.add("nose");
        english.add("ear");

        english.add("car");
        english.add("bus");
        english.add("train");
        english.add("tram");
        english.add("ship");
        english.add("railway");
        english.add("road");
        english.add("stop");
        english.add("platform");
        english.add("station");
        english.add("destination");
        english.add("journey");
        return english;
    }

    @Override
    public ArrayList<String> getSpanishWordsList() {
        ArrayList<String> spanish = new ArrayList<String>();
        spanish.add("sofá");
        spanish.add("sillón");
        spanish.add("guardarropa");
        spanish.add("mesa");
        spanish.add("silla");
        spanish.add("cama");
        spanish.add("escritorio");
        spanish.add("mesa de noche");
        spanish.add("cajón");
        spanish.add("lámpara");
        spanish.add("alfombra");
        spanish.add("estante");

        spanish.add("chaqueta");
        spanish.add("suéter");
        spanish.add("sudadera");
        spanish.add("camisa");
        spanish.add("botas");
        spanish.add("vestir");
        spanish.add("cima");
        spanish.add("falda");
        spanish.add("pantalones");
        spanish.add("bufanda");
        spanish.add("gorra");
        spanish.add("guantes");

        spanish.add("perejil");
        spanish.add("zanahoria");
        spanish.add("remolacha");
        spanish.add("apio");
        spanish.add("puerro");
        spanish.add("lechuga");
        spanish.add("repollo");
        spanish.add("tomate");
        spanish.add("papa");
        spanish.add("cebolla");
        spanish.add("ajo");
        spanish.add("coliflor");

        spanish.add("cereza");
        spanish.add("frambuesa");
        spanish.add("pera");
        spanish.add("naranja");
        spanish.add("manzana");
        spanish.add("fresa");
        spanish.add("durazno");
        spanish.add("ciruela");
        spanish.add("limón");
        spanish.add("mora");
        spanish.add("uva");
        spanish.add("arándano");

        spanish.add("cabeza");
        spanish.add("brazo");
        spanish.add("cuello");
        spanish.add("mano");
        spanish.add("dedo");
        spanish.add("pie");
        spanish.add("espalda");
        spanish.add("pierna");
        spanish.add("codo");
        spanish.add("rodilla");
        spanish.add("nariz");
        spanish.add("oído");

        spanish.add("carro");
        spanish.add("autobús");
        spanish.add("carril");
        spanish.add("tranvía");
        spanish.add("embarcacion");
        spanish.add("vías del tren");
        spanish.add("camino");
        spanish.add("parada");
        spanish.add("plataforma");
        spanish.add("estación");
        spanish.add("destino");
        spanish.add("viaje");
        return spanish;
    }

    @Override
    public ArrayList<String> getGermanWordsList() {

        ArrayList<String> german = new ArrayList<String>();
        german.add("Sofa");
        german.add("Sessel");
        german.add("Kleiderschrank");
        german.add("Tabelle");
        german.add("Stuhl");
        german.add("Bett");
        german.add("Schreibtisch");
        german.add("Nachttisch");
        german.add("Schublade");
        german.add("Lampe");
        german.add("Teppich");
        german.add("Regal");

        german.add("Jacke");
        german.add("Jersey");
        german.add("Bluse");
        german.add("Hemd");
        german.add("Stiefel");
        german.add("Kleid");
        german.add("Bluse");
        german.add("Rock");
        german.add("Hose");
        german.add("Schal");
        german.add("Kappel");
        german.add("Handschuhe");

        german.add("Petersilie");
        german.add("Karotte");
        german.add("Bete");
        german.add("Sellerie");
        german.add("Lauch");
        german.add("Salat");
        german.add("Kohl");
        german.add("Tomate");
        german.add("Kartoffel");
        german.add("Zwiebel");
        german.add("Knoblauch");
        german.add("Blumenkohl");

        german.add("Kirsche");
        german.add("Himbeere");
        german.add("Birne");
        german.add("Orange");
        german.add("Apfel");
        german.add("Erdbeere");
        german.add("Pfirsich");
        german.add("Pflaume");
        german.add("Zitrone");
        german.add("Blaubeere");
        german.add("Traube");
        german.add("Preiselbeere");

        german.add("Kopf");
        german.add("Schulter");
        german.add("Hals");
        german.add("Hand");
        german.add("Finger");
        german.add("Fuß");
        german.add("Rücken");
        german.add("Bein");
        german.add("Ellbogen");
        german.add("Knie");
        german.add("Nase");
        german.add("Ohr");

        german.add("Wagen");
        german.add("Bus");
        german.add("Zug");
        german.add("Straßenbahn");
        german.add("Schiff");
        german.add("Eisenbahn");
        german.add("Straße");
        german.add("Bushaltestelle");
        german.add("Bahnsteig");
        german.add("Bahnhof");
        german.add("Ziel");
        german.add("Reise");
        return german;
    }
}
