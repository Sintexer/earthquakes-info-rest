package com.ilyabuglakov.earthquakes.service;

import com.ilyabuglakov.earthquakes.model.Earthquake;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.*;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

@Service
public class EarthquakesParser{

    private final String POINT_TAG = "georss:point";
    private final String TITLE_TAG = "title";
    private final String ELEV_TAG = "georss:elev";
    private final String NO_INFO_TITLE = "NO INFORMATION";

    public List<Earthquake> parseRecent(){
        return read("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.atom");
    }

        public List<Earthquake> read(String source) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = null;

                if (source.startsWith("http")) {
                    document = builder.parse(source);
                } else {
                    document = builder.parse(new File(source));
                }

                NodeList nodeList = document.getDocumentElement().getChildNodes();
                List<Earthquake> earthquakeList = new LinkedList<Earthquake>();

                for (int k = 0; k < nodeList.getLength(); ++k) {
                    Node node = nodeList.item(k);
                    if (node.getNodeName().equals("entry")) {
                        Element elem = (Element) node;
                        NodeList t1 = elem.getElementsByTagName(POINT_TAG);
                        NodeList t2 = elem.getElementsByTagName(TITLE_TAG);
                        NodeList t3 = elem.getElementsByTagName(ELEV_TAG);
                        double lat = 0.0, lon = 0.0, depth = 0.0;
                        String title = NO_INFO_TITLE;
                        double mag = 0.0;

                        if (t1 != null) {
                            String s2 = t1.item(0).getChildNodes().item(0).getNodeValue();
                            String[] args = s2.split(" ");
                            lat = Double.parseDouble(args[0]);
                            lon = Double.parseDouble(args[1]);
                        }
                        if (t2 != null) {
                            String s2 = t2.item(0).getChildNodes().item(0).getNodeValue();

                            String mags = s2.substring(2, s2.indexOf(" ", 2));
                            if (mags.contains("?")) {
                                mag = 0.0;
                                System.err.println("unknown magnitude in data");
                            } else {
                                mag = Double.parseDouble(mags);
                                //System.out.println("mag= "+mag);
                            }
                            int sp = s2.indexOf(" ", 5);
                            title = s2.substring(sp + 1);
                            if (title.startsWith("-")) {
                                int pos = title.indexOf(" ");
                                title = title.substring(pos + 1);
                            }
                        }
                        if (t3 != null) {
                            String s2 = t3.item(0).getChildNodes().item(0).getNodeValue();
                            depth = Double.parseDouble(s2);
                        }
                        Earthquake earthquake = new Earthquake(lat, lon, title, depth, mag);
                        earthquakeList.add(earthquake);
                    }

                }
                return earthquakeList;
            } catch (ParserConfigurationException pce) {
                System.err.println("parser configuration exception");
            } catch (SAXException se) {
                System.err.println("sax exception");
            } catch (IOException ioe) {
                System.err.println("ioexception");
            }
            return null;
        }

}
