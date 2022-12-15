package datamodel;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import datamodel.Item;
import util.Util_Item;

import org.junit.Assert;

public class ItemTest {
	String exname = "Fan";
    String exdescription = "This is a fan";
    String exprice = "$50.00";
    boolean expickup = false;
    boolean exdelivery = true;
    String exlocations = "Omaha";
    String exrooms = "Office";

	@Test
	public void getNametest() {
		Item myitem = new Item(exname, exdescription, exprice, expickup,
				exdelivery, exlocations, exrooms );
		
		String actualName = myitem.getName();
		
		Assert.assertEquals(exname, actualName);
	}
	
	@Test
	public void getDesctest() {
		Item myitem = new Item(exname, exdescription, exprice, expickup,
				exdelivery, exlocations, exrooms );
		
		String actualDesc = myitem.getDescription();
		
		Assert.assertEquals(exdescription, actualDesc);
	}
	
	@Test
	public void getPricetest() {
		Item myitem = new Item(exname, exdescription, exprice, expickup,
				exdelivery, exlocations, exrooms );
		
		String actualPrice = myitem.getPrice();
		
		Assert.assertEquals(exprice, actualPrice);
	}
	
	@Test
	public void getPickup() {
		Item myitem = new Item(exname, exdescription, exprice, expickup,
				exdelivery, exlocations, exrooms );
		
		Boolean actualPick = myitem.getPickup();
		
		Assert.assertEquals(expickup, actualPick);
	}
	
	@Test
	public void getDel() {
		Item myitem = new Item(exname, exdescription, exprice, expickup,
				exdelivery, exlocations, exrooms );
		
		Boolean actualDel = myitem.getDelivery();
		
		Assert.assertEquals(exdelivery, actualDel);
	}
	
	@Test
	public void getLoc() {
		Item myitem = new Item(exname, exdescription, exprice, expickup,
				exdelivery, exlocations, exrooms );
		
		String actualLoc = myitem.getLocations();
		
		Assert.assertEquals(exlocations, actualLoc);
	}
	
	@Test
	public void getRoom() {
		Item myitem = new Item(exname, exdescription, exprice, expickup,
				exdelivery, exlocations, exrooms );
		
		String actualRoom = myitem.getRooms();
		
		Assert.assertEquals(exrooms, actualRoom);
	}
	
}
