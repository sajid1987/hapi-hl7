package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RGV_O01_ORDER_DETAIL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RXO (Pharmacy prescription order segment) <b></b><br>
 * 1: RGV_O01_ORDER_DETAIL_SUPPLEMENT (a Group object) <b>optional </b><br>
 */
public class RGV_O01_ORDER_DETAIL extends AbstractGroup {

	/** 
	 * Creates a new RGV_O01_ORDER_DETAIL Group.
	 */
	public RGV_O01_ORDER_DETAIL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RXO.class, true, false);
	      this.add(RGV_O01_ORDER_DETAIL_SUPPLEMENT.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RGV_O01_ORDER_DETAIL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RXO (Pharmacy prescription order segment) - creates it if necessary
	 */
	public RXO getRXO() { 
	   RXO ret = null;
	   try {
	      ret = (RXO)this.get("RXO");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RGV_O01_ORDER_DETAIL_SUPPLEMENT (a Group object) - creates it if necessary
	 */
	public RGV_O01_ORDER_DETAIL_SUPPLEMENT getORDER_DETAIL_SUPPLEMENT() { 
	   RGV_O01_ORDER_DETAIL_SUPPLEMENT ret = null;
	   try {
	      ret = (RGV_O01_ORDER_DETAIL_SUPPLEMENT)this.get("ORDER_DETAIL_SUPPLEMENT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
