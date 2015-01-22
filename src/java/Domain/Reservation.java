/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Date;

/**
 *
 * @author vishnu-pt517
 */
public class Reservation {
    public Long userID;
    public Long pnr;
    public Long trainID;
    public Date reservationDate;
    public int status;
    public Long timestamp;
}
