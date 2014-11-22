package com.ata.bean;

/**
 * This class is used to declare two type of methods for ATA_TBL_route table : Get and Set
 * The Get methods are used to retrieve the values.
 * The Set methods are used to set the values.
 * @author Abhinav , Abhilash
 * @version 1.0
 */

public class RouteBean 
{
private String routeID;
private String source;
private String destination;
private double distance;
private double travelDuration;

/** 
 * @return routeID
 */
public String getRouteID() {
	return routeID;
}

/**
 * @param routeID Sets RouteID
 */
public void setRouteID(String routeID) {
	this.routeID = routeID;
}

/**
 * @return source
 */
public String getSource() {
	return source;
}

/**
 * @param source Sets Source
 */
public void setSource(String source) {
	this.source = source;
}

/**
 * @return destination
 */
public String getDestination() {
	return destination;
}

/**
 * @param destination Sets Destination
 */
public void setDestination(String destination) {
	this.destination = destination;
}

/**
 * @return distance
 */
public double getDistance() {
	return distance;
}

/**
 * @param distance Sets Distance
 */
public void setDistance(double distance) {
	this.distance = distance;
}

/**
 * @return travelDuration
 */
public double getTravelDuration() {
	return travelDuration;
}

/**
 * @param travelDuration Sets Travel Duration
 */
public void setTravelDuration(double travelDuration) {
	this.travelDuration = travelDuration;
}


}
