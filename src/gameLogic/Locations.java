package gameLogic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Locations {

    private HashMap<Point, ShipSection> unguessedSections;
    private HashMap<Point, ShipSection> hitSections;

    private ArrayList<Point> misses;

    public Locations() {
        this.unguessedSections = new HashMap<>();
        this.hitSections = new HashMap<>();

        this.misses = new ArrayList<>();
    }

    public HashMap<Point, ShipSection> getUnguessedSections() {
        return this.unguessedSections;
    }
    
    /**
     * Adds all sections of a ship into unguessedSections
     * 
     * @param ship the ship which all of its sections are added into
     *             unguessedSections
     */
    public void addUnguessedShips(Ship ship) {
        ship.getShipSections()
                .stream()
                .forEach((section) -> unguessedSections.put(section.getCoords(), section));
    }

    /**
     * Adds all sections from an ArrayList of ships into unguessedSections
     * 
     * @param ships ArrayList of ships which all of its sections are added into
     *              unguessedSections
     */
    public void addUnguessedShips(ArrayList<Ship> ships) {
        for (Ship ship: ships) {
            for (ShipSection section: ship.getShipSections()) {
                this.unguessedSections.put(section.getCoords(), section);
            }
        }

        // cursed, unreadable way
        // ships.stream().forEach((ship) -> ship.getShipSections().stream().forEach((section) -> this.unguessedSections.put(section.getCoords(), section)));
    }
    
    /**
     * Clears all unguessedSections, hitSections, and misses
     */
    public void clear() {
        this.unguessedSections.clear();
        this.hitSections.clear();
        this.misses.clear();
    }

    public String toString() {
        return this.unguessedSections.toString();
    }

}
