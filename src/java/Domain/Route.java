/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author vishnu-pt517
 */
class Route {
    private Long id;
    private Station from;
    private Station to;
    private int distance;
    private Long journeyTime;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the from
     */
    public Station getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(Station from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public Station getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(Station to) {
        this.to = to;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @return the journeyTime
     */
    public Long getJourneyTime() {
        return journeyTime;
    }

    /**
     * @param journeyTime the journeyTime to set
     */
    public void setJourneyTime(Long journeyTime) {
        this.journeyTime = journeyTime;
    }
}
