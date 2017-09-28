package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by rmeng1 on 1/19/17.
 */

public abstract class First {
    private Date date;
    public  Date getDate(){return date;}

    public void setDate(Date date) {this.date = date;}

    public First (Date date){this.date = date;}

    public abstract Boolean isImportant();
}
