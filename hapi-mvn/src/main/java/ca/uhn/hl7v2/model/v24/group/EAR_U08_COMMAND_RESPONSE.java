package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the EAR_U08_COMMAND_RESPONSE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ECD (Equipment Command) <b></b><br>
 * 1: SAC (Specimen and container detail) <b>optional </b><br>
 * 2: ECR (Equipment Command Response) <b></b><br>
 */
public class EAR_U08_COMMAND_RESPONSE extends AbstractGroup {

	/** 
	 * Creates a new EAR_U08_COMMAND_RESPONSE Group.
	 */
	public EAR_U08_COMMAND_RESPONSE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ECD.class, true, false);
	      this.add(SAC.class, false, false);
	      this.add(ECR.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating EAR_U08_COMMAND_RESPONSE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ECD (Equipment Command) - creates it if necessary
	 */
	public ECD getECD() { 
	   ECD ret = null;
	   try {
	      ret = (ECD)this.get("ECD");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns SAC (Specimen and container detail) - creates it if necessary
	 */
	public SAC getSAC() { 
	   SAC ret = null;
	   try {
	      ret = (SAC)this.get("SAC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns ECR (Equipment Command Response) - creates it if necessary
	 */
	public ECR getECR() { 
	   ECR ret = null;
	   try {
	      ret = (ECR)this.get("ECR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
