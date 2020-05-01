package module4;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// Drawing a centered square for Ocean earthquakes
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		
		// TODO: Implement this method
		if(this.getMagnitude() < THRESHOLD_LIGHT) {
			pg.rect(x, y, 5, 5);
			if(this.getProperty("age").toString().equals("Past Hour")) {
				pg.line(x-7.5f, y-7.5f, x+12.5f, y+12.5f);
				pg.line(x+12.5f, y-7.5f, x-7.5f, y+12.5f);
			}
	    } else if(this.getMagnitude() < THRESHOLD_MODERATE && this.getMagnitude() >= THRESHOLD_LIGHT) {
			pg.rect(x, y, 10, 10);
			if(this.getProperty("age").toString().equals("Past Hour")) {
				pg.line(x-5, y-5, x+15, y+15);
				pg.line(x+15, y-5, x-5, y+15);
			}
	    } else {
			pg.rect(x, y, 20, 20);
			if(this.getProperty("age").toString().equals("Past Hour")) {
				pg.line(x, y, x+20, y+20);
				pg.line(x+20, y, x, y+20);
			}
	    }

	}
	


	

}
