package edu.fsu.cs.cen4021.armory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Chris
 */
class WebRitualArrow extends BasicWeapon implements Weapon {

    WebRitualArrow() {
        super(0);

        String url = "http://ww2.cs.fsu.edu/~escobara/courses/cen4021.html";
        try {
            String html = getHTML(url);
            int startIndex = html.indexOf("<h1>") + 4;
            int endIndex = html.indexOf("</h1>");
            String damageStr = html.substring(startIndex, endIndex);
            this.DAMAGE = Integer.parseInt(damageStr);
        } catch (Exception e) {
            System.err.println("Couldn't read damage from url: " + url);
            e.printStackTrace();
        }
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        armor = Math.max(0, armor - 10);
        int damage = DAMAGE - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

    /* from http://stackoverflow.com/questions/1485708/how-do-i-do-a-http-get-in-java */
    private static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

}
