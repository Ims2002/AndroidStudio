package com.ims.testexamen.parsers;

import android.content.Context;
import android.util.Log;

import com.ims.testexamen.Car;
import com.ims.testexamen.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CarParserXML {
    private static final int MAX_CITIES = 50;
    private static final int MIN_CITIES = 5;

    /** Array que contendrá los objetos Country */
    private Car[] cars;
    /** InputStream para poder leer del archivo countries.xml */
    private final InputStream carsFile;

    /** Al constructor le pasamos el contexto para que pueda tener acceso a los recursos de la aplicación */
    public CarParserXML(Context c) {
        /* Obtenemos una referencia al archivo /res/raw/countries.xml */
        this.carsFile = c.getResources().openRawResource(R.raw.testxml);
    }

    /**
     * Obtiene los datos de los países desde un archivo xml mediante DOM,
     * y los carga en el array countries.
     * @return boolean Devuelve verdadero si ha ido bien. False en caso contrario.
     */
    public boolean parse() {
        /* Parsed controla si se han podido parsear los datos. Inicialmente a false */
        boolean parsed = false;
        /* Inicializamos a null el array de países */
        cars = null;
        try {
            /* Obtenemos una referencia al DocumentBuilderFactory necesaria para parsear mediante DOM */
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            /* Obtenemos una referencia al DocumentBuilder necesaria para parsear mediante DOM */
            DocumentBuilder builder = factory.newDocumentBuilder();
            /* Obtenemos una referencia al Document parseando mediante DOM */
            Document dom = builder.parse(carsFile);
            /* Obtenemos el elemento raíz del documento */
            Element root = dom.getDocumentElement();
            /* Obtenemos la lista de nodos con el tag "country" */
            NodeList items = root.getElementsByTagName("car");
            /* Inicializamos el array de countries con tamaño igual al número de nodos de tipo country */
            cars = new Car[items.getLength()];
            /* Recorremos cada uno de los nodos */
            for (int i = 0; i < items.getLength(); i++) {
                /* Obtenemos el nodo de la posición i */
                Node item = items.item(i);
                /* Obtenemos los atributos necesarios para construir cada objeto Country */
                String carCode = item.getAttributes().getNamedItem("carCode").getNodeValue();
                String carName = item.getAttributes().getNamedItem("carName").getNodeValue();
                String km = item.getAttributes().getNamedItem("km").getNodeValue();
                String fabricadoEn = item.getAttributes().getNamedItem("fabricadoEn").getNodeValue();

                cars[i] = new Car(carCode,carName,km,fabricadoEn);

                /*List<City> cities = addCities(countryCode, new Random().nextInt(MAX_CITIES + MIN_CITIES - 1) + MIN_CITIES);
                 Con los datos obtenidos, creamos el objeto Country en la posición i del array
                countries[i] = new Country(countryCode, countryName, countryPopulation, countryCapital, countryIso3, cities);*/
            }
            /* Si hemos llegado hasta aquí, podemos asegurar que el documento xml ha sido parseado correctamente */
            parsed = true;
        } catch (ParserConfigurationException pce) {
            Log.e("CarParser", "ParserConfigurationException: "+pce.getLocalizedMessage());
        } catch (Exception e) {
            Log.e("CarParser", "Unknown Exception: "+e.getLocalizedMessage());
        }
        return parsed;
    }

    /**
     * Añade ciudades aleatorias al país indicado.
     *
     * @param countryCode Código del país
     * @param numCities Cantidad de ciudades a añadir
     * @return La lista de ciudades que se han creado
     */
    /*private List<City> addCities(String countryCode, int numCities) {
        ArrayList<City> cities = new ArrayList<>();
        for (int i = 1; i <= numCities; i++) {
            String cityId = countryCode + String.format(Locale.US, "%03d", i);
            String cityName = countryCode + "City " + String.format(Locale.US, "%03d", i);
            cities.add(new City(cityId, cityName, new Random().nextInt(5000000)));
        }
        return cities;
    }*/

    /**
     * Devuelve la lista de países
     * @return Country[]
     */
    public Car[] getCars() {
        return this.cars;
    }
}
